package com.palominocia.medicalhistory;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class FullScreenDialog extends DialogFragment {

    private TextView textFecha;
    private TextView textTiempo;
    public FullScreenDialog() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        // Obtener instancia de la action bar
        ActionBar actionBar = ((AppCompatActivity) getActivity())
                .getSupportActionBar();

        if (actionBar != null) {
            // Habilitar el Up Button
            actionBar.setDisplayHomeAsUpEnabled(true);
            // Cambiar icono del Up Button
            actionBar.setHomeAsUpIndicator(R.drawable.ic_close);
        }
        setStyle(DialogFragment.STYLE_NORMAL, R.style.AppTheme);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fullscreen_dialog, container, false);
        //iniciarHora(view);// Setear hora inicial
        //iniciarFecha(view);// Setear fecha inicial
        return view;
    }

    /*private void iniciarHora(View view) {
        textTiempo = (TextView) view.findViewById(R.id.hora_text);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm a");
        textTiempo.setText(format.format(c.getTime()));

        textTiempo.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        new TimeDialog().show(getFragmentManager(), "TimePickerInFull");
                    }
                }
        );
    }

    private void iniciarFecha(View view) {
        textFecha = (TextView) view.findViewById(R.id.fecha_text);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("E MMM d yyyy");
        textFecha.setText(format.format(c.getTime()));

        textFecha.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        new DateDialog().show(getFragmentManager(), "DatePickerInFull");
                    }
                }
        );
    }*/

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.fullscreen_dialog, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:
                // procesarDescartar()
                break;
            case R.id.action_save:
                // procesarGuardar()
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Actualiza la fecha del view {@code fecha_text}
     * @param year Nuevo Año
     * @param monthOfYear Nuevo Mes
     * @param dayOfMonth Nuevo día
     */
    public void setDateView(int year, int monthOfYear, int dayOfMonth) {
        Calendar c = Calendar.getInstance();
        c.set(year, monthOfYear, dayOfMonth);
        SimpleDateFormat format = new SimpleDateFormat("E MMM d yyyy");
        textFecha.setText(format.format(c.getTime()));
    }

    /**
     * Actualiza la hora del view {@code hora_text}
     * @param hourOfDay Nueva Hora
     * @param minute Nuevos Minutos
     */
    public void setTimeView(int hourOfDay, int minute) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR, hourOfDay);
        c.set(Calendar.MINUTE, minute);
        SimpleDateFormat format = new SimpleDateFormat("HH:mm a");
        textTiempo.setText(format.format(c.getTime()));
    }
}