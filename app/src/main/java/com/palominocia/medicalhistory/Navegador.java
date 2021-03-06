package com.palominocia.medicalhistory;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.palominocia.medicalhistory.beans.ClinicaBean;
import com.palominocia.medicalhistory.beans.MedicoBean;
import com.palominocia.medicalhistory.dao.DaoSession;
import com.palominocia.medicalhistory.dao.Medicos;
import com.palominocia.medicalhistory.dao.MedicosDao;
import com.palominocia.medicalhistory.fragments.ClinicasFragment;
import com.palominocia.medicalhistory.fragments.MedicosFragment;
import com.palominocia.medicalhistory.searcher.SeachEngine;

import java.util.ArrayList;

public class Navegador extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, MedicosFragment.OnFragmentInteractionListener
    ,ClinicasFragment.OnFragmentInteractionListener
{

    private ArrayList<MedicoBean> listamedicos;
    private ArrayList<ClinicaBean> listaclinicas;

    ObtenerMedicosTask obtenerMedicosTask;
    ObtenerClinicasTask obtenerClinicasTask;

    DaoSession daoSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navegador);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        /**/
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);



        View headerView = navigationView.getHeaderView(0);
        TextView navUsername =  headerView.findViewById(R.id.txtNombreNav);
        navUsername.setText(getIntent().getStringExtra("Nombre"));
        TextView navEmail =  headerView.findViewById(R.id.txtEmailNav);
        navEmail.setText(getIntent().getStringExtra("Email"));

        daoSession = ((AppController) getApplication()).getDaoSession();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navegador, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_citas_medicas) {
            // Handle the camera action
        } else if (id == R.id.nav_medicos) {
            listamedicos =new ArrayList<MedicoBean>();
            invokeDynamicFragment("MEDICOS",listamedicos);
        } else if (id == R.id.nav_recetas) {

        } else if (id == R.id.nav_diagnosticos) {

        } else if (id == R.id.nav_medicinas) {

        } else if (id == R.id.nav_medicinas_alergia) {

        }
        else if (id == R.id.nav_clinicas) {
            listaclinicas =  new ArrayList<ClinicaBean>();
            invokeDynamicFragment("CLINICAS",listaclinicas);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void obtenerMedicos() {
        obtenerMedicosTask = new ObtenerMedicosTask("");
        obtenerMedicosTask.execute((Void) null);
    }

    private void invokeDynamicFragment(String tituloItem, ArrayList listaMensajes) {
        Fragment fragment = null;
        Class fragmentClass = null;
        Bundle args = new Bundle();
        args.putString("ID_ITEM",tituloItem);
        args.putSerializable("LISTA_VIEWS",listaMensajes);

        if (tituloItem.equals("MEDICOS")){
            fragmentClass = MedicosFragment.class;
        }
        if (tituloItem.equals("CLINICAS")){
            fragmentClass = ClinicasFragment.class;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
            fragment.setArguments(args);//Asigno argumentos
        } catch (Exception e) {
            e.printStackTrace();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        //fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.flContent, fragment);
        transaction.addToBackStack(null);
        // Commit the transaction
        transaction.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        Toast.makeText(this,"onFragmentInteraction Invoca un Uri", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRefrescarClinicas() {
        obtenerClinicas();
    }

    private void obtenerClinicas() {
        obtenerClinicasTask = new ObtenerClinicasTask("");
        obtenerClinicasTask.execute((Void) null);
    }

    @Override
    public void onRefrescarMedicos() {
        obtenerMedicos();
    }


    class ObtenerMedicosTask extends AsyncTask<Void, Void, Boolean> {

        String nombreFolder;
        ObtenerMedicosTask(String nombreFolder){
            this.nombreFolder=nombreFolder;
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            boolean retorno=true;
            Log.i("ObtenerMedicosTask","Inicio doInBackground");
            listamedicos.clear();

            listamedicos = obtenerMedicosRemoto();
            Log.i("ObtenerEmailTask","Fin doInBackground");
            return retorno;
        }

        private ArrayList<MedicoBean> obtenerMedicosRemoto() {
            Log.i("ObtenerMedicosTask","obtenerMedicosRemoto 1");
            MedicosDao med = daoSession.getMedicosDao();
            if (med.count()>0){
                for(Medicos data : med.loadAll()){
                    MedicoBean bean = new MedicoBean();
                    bean.setNombre(data.getNombreMedico());
                    bean.setUrlImage(data.getUrlMedico());
                    listamedicos.add(bean);
                }
            }
            else{
                SeachEngine f1 = new SeachEngine<MedicoBean>();
                listamedicos = f1.seachElements(MedicoBean.class,"LIMATAMBO",true);
                for(MedicoBean data: listamedicos){
                    //med = daoSession.getMedicosDao();
                    Medicos mm = new Medicos();
                    mm.setNombreMedico(data.getNombre());
                    mm.setUrlMedico(data.getUrlImage());
                    med.insert(mm);
                }
            }

            return listamedicos;
        }

        @Override
        protected void onPostExecute(Boolean sucess) {
            if(sucess){
                Log.i("ObtenerEmailTask","Inicio onPostExecute");
                if(getSupportFragmentManager().findFragmentById(R.id.flContent) instanceof MedicosFragment){
                    MedicosFragment articleFrag = (MedicosFragment)getSupportFragmentManager().findFragmentById(R.id.flContent);
                    articleFrag.addAllMedicos(listamedicos);
                }

                Log.i("ObtenerEmailTask","Fin onPostExecute");

            }
        }
    }

    private class ObtenerClinicasTask  extends AsyncTask<Void, Void, Boolean>{

        public ObtenerClinicasTask(String s) {
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            Log.i("ObtenerClinicasTask","Inicio doInBackground");
            listaclinicas.add(new ClinicaBean());
            Log.i("ObtenerClinicasTask","Fin doInBackground");
            return true;
        }
        protected void onPostExecute(Boolean sucess) {
            if(sucess){
                Log.i("ObtenerClinicasTask","Inicio onPostExecute");
                if(getSupportFragmentManager().findFragmentById(R.id.flContent) instanceof ClinicasFragment){
                    ClinicasFragment articleFrag = (ClinicasFragment)getSupportFragmentManager().findFragmentById(R.id.flContent);
                    articleFrag.addAllClinicas(listaclinicas);
                }
                Log.i("ObtenerClinicasTask","Fin onPostExecute");
            }
        }
    }
}
