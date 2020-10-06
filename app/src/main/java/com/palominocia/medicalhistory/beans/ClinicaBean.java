package com.palominocia.medicalhistory.beans;

import android.widget.ProgressBar;

public class ClinicaBean {
    private String nombreClinica;
    private ProgressBar progresoCarga;

    public String getNombreClinica() {
        return nombreClinica;
    }

    public void setNombreClinica(String nombreClinica) {
        this.nombreClinica = nombreClinica;
    }

    public ProgressBar getProgresoCarga() {
        return progresoCarga;
    }

    public void setProgresoCarga(ProgressBar progresoCarga) {
        this.progresoCarga = progresoCarga;
    }
}
