package com.palominocia.medicalhistory.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.palominocia.medicalhistory.FullScreenDialog;
import com.palominocia.medicalhistory.MedicosAdapter;
import com.palominocia.medicalhistory.R;
import com.palominocia.medicalhistory.beans.MedicoBean;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MedicosFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MedicosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MedicosFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "ID_ITEM";
    private static final String ARG_PARAM2 = "LISTA_VIEWS";

    // TODO: Rename and change types of parameters
    //private String mParam1;
    //private String mParam2;
    private String idItem;
    private ArrayList<MedicoBean> listaItems;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    MedicosAdapter mAdaptador;

    private OnFragmentInteractionListener mListener;

    public MedicosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MedicosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MedicosFragment newInstance(String param1, String param2) {
        MedicosFragment fragment = new MedicosFragment();
        Bundle args = new Bundle();
        //args.putString(ARG_PARAM1, param1);
        //args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            idItem = getArguments().getString(ARG_PARAM1);
            listaItems = (ArrayList<MedicoBean>) getArguments().getSerializable(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.i("onCreateView","Inicio");
        View rootView = inflater.inflate(R.layout.fragment_medicos, container, false);

        FloatingActionButton fab = rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                //startActivity(new Intent(getActivity(), MedicalForm.class));
                crearFullScreenDialog();
            }
        });

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());

        swipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipe_refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(this);
        mAdaptador = new MedicosAdapter(getContext(), listaItems, this);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(rootView.getContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdaptador);

        // show loader and fetch messages
        swipeRefreshLayout.post(
                new Runnable() {
                    @Override
                    public void run() {
                        Log.i("swipeRefreshLayout","Inicio");
                        swipeRefreshLayout.setRefreshing(true);
                        onRefresh();
                        Log.i("swipeRefreshLayout","Fin");
                    }
                }
        );
        Log.i("onCreateView","Fin");
        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onRefresh() {
        reloadElements();
    }

    private void reloadElements() {
        Log.i("reloadElements","Inicio");
        mListener.onRefrescarMedicos();
        Log.i("reloadElements","Fin");
    }

    public void addAllMedicos(ArrayList<MedicoBean> listamedicos) {
        Log.i("addAllMessages","Inicio");
        //listaItems = new ArrayList<>();
        listaItems.clear();
        listaItems.addAll(listamedicos);
        mAdaptador.notifyDataSetChanged();
        swipeRefreshLayout.setRefreshing(false);
        Log.i("addAllMessages","Fin");
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
        void onRefrescarMedicos();
    }

    private void crearFullScreenDialog() {
        FragmentManager fragmentManager = getFragmentManager();
        FullScreenDialog newFragment = new FullScreenDialog();

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.add(android.R.id.content, newFragment, "FullScreenFragment")
                //.addToBackStack(null)
                .commit();

        //newFragment .show(getFragmentManager(), "example");
    }
}
