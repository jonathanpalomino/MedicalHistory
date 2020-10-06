package com.palominocia.medicalhistory;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.palominocia.medicalhistory.beans.ClinicaBean;
import com.palominocia.medicalhistory.fragments.ClinicasFragment;

import java.util.List;

public class ClinicasAdapter  extends RecyclerView.Adapter<ClinicasAdapter.MyViewHolder>{
    private Context mContext;
    private List<ClinicaBean> clinicasList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nombreclinica;
        public ImageView thumbnail;
        public ProgressBar progreso;

        public MyViewHolder(View view) {
            super(view);
            nombreclinica = (TextView) view.findViewById(R.id.nombreClinica);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            progreso = view.findViewById(R.id.barraProgreso);
        }
    }
    public ClinicasAdapter(Context mContext, List<ClinicaBean> clinicasList, ClinicasFragment medicosFragment) {
        this.mContext = mContext;
        this.clinicasList = clinicasList;
    }
    @NonNull
    @Override
    public ClinicasAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_clinicas, parent, false);
        return new ClinicasAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ClinicasAdapter.MyViewHolder holder, int position) {
        ClinicaBean bean =clinicasList.get(position);
        holder.nombreclinica.setText(bean.getNombreClinica());
        holder.progreso = bean.getProgresoCarga();
    }

    @Override
    public int getItemCount() {
        return clinicasList.size();
    }
}
