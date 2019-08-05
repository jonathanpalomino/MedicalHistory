package com.palominocia.medicalhistory;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.palominocia.medicalhistory.beans.MedicoBean;
import com.palominocia.medicalhistory.fragments.MedicosFragment;

import java.util.ArrayList;
import java.util.List;

public class MedicosAdapter extends RecyclerView.Adapter<MedicosAdapter.MyViewHolder>{
    private Context mContext;
    private List<MedicoBean> medicosList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nombreMedico, especialidadMedico,colegiaturaMedico,sedeMedico,horariosMedico;
        public ImageView thumbnail, overflow;

        public MyViewHolder(View view) {
            super(view);
            nombreMedico = (TextView) view.findViewById(R.id.nombreMedico);
            especialidadMedico = (TextView) view.findViewById(R.id.especialidadMedico);
            colegiaturaMedico = (TextView) view.findViewById(R.id.colegiaturaMedico);
            sedeMedico = (TextView) view.findViewById(R.id.sedeMedico);
            horariosMedico = (TextView) view.findViewById(R.id.horariosMedico);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        }
    }

    public MedicosAdapter(Context mContext, List<MedicoBean> medicosList, MedicosFragment medicosFragment) {
        this.mContext = mContext;
        this.medicosList = medicosList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_medicos, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        MedicoBean album = medicosList.get(position);
        holder.nombreMedico.setText(album.getNombre());
        holder.especialidadMedico.setText("Especialidad: "+album.getEspecialidad());
        holder.sedeMedico.setText("Sede: "+album.getSedeHospital()+"/ Hospital: "+album.getHospital());

        String colegiaturas="";
        if(album.getColegiatura() instanceof ArrayList){
            for(String ff:album.getColegiatura()){
                colegiaturas = colegiaturas + ff;
            }
        }
        holder.horariosMedico.setText(album.getHorarios());
        holder.colegiaturaMedico.setText(colegiaturas);

        // loading album cover using Glide library
        // Load the image into image view
        Glide.with(mContext)
                .load(album.getUrlImage()) // Image URL
                .centerCrop() // Image scale type
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                //.crossFade()
                //.override(800,500) // Resize image
                //.placeholder(R.drawable.ic_ima)
                //.error(R.drawable.ic_error_black_36dp) // On error image
                .into(holder.thumbnail); // ImageView to display image
    }

    @Override
    public int getItemCount() {
        return medicosList.size();
    }
}
