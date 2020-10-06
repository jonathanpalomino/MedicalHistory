package com.palominocia.medicalhistory.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.palominocia.medicalhistory.ClinicasAdapter;
import com.palominocia.medicalhistory.R;
import com.palominocia.medicalhistory.beans.ClinicaBean;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ClinicasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ClinicasFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "ID_ITEM";
    private static final String ARG_PARAM2 = "LISTA_VIEWS";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String idItem;
    private ArrayList<ClinicaBean> listaItems;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    ClinicasAdapter mAdaptador;

    private OnFragmentInteractionListener mListener;

    public ClinicasFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ClinicasFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ClinicasFragment newInstance(String param1, String param2) {
        ClinicasFragment fragment = new ClinicasFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            idItem = getArguments().getString(ARG_PARAM1);
            listaItems = (ArrayList<ClinicaBean>) getArguments().getSerializable(ARG_PARAM2);
        }

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.i("onCreateView","Inicio");
        View rootView = inflater.inflate(R.layout.fragment_clinicas, container, false);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());

        swipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipe_refresh_layout_clinicas);
        swipeRefreshLayout.setOnRefreshListener(this);
        mAdaptador = new ClinicasAdapter(getContext(), listaItems, this);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view_clinicas);
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
        Log.i("reloadElements","Inicio");
        mListener.onRefrescarClinicas();
        Log.i("reloadElements","Fin");
    }

    public void addAllClinicas(ArrayList<ClinicaBean> listaclinicas) {
        Log.i("addAllMessages","Inicio");
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
        void onRefrescarClinicas();
    }
}
