package com.palominocia.dao;

import org.greenrobot.greendao.annotation.*;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit.

/**
 * Entity mapped to table "RECETA_MEDICINA".
 */
@Entity
public class RecetaMedicina {

    @Id(autoincrement = true)
    private long codigoPaciente;
    private String nombrePaciente;
    private java.util.Date fecNacimientoPaciente;

    @Generated
    public RecetaMedicina() {
    }

    public RecetaMedicina(long codigoPaciente) {
        this.codigoPaciente = codigoPaciente;
    }

    @Generated
    public RecetaMedicina(long codigoPaciente, String nombrePaciente, java.util.Date fecNacimientoPaciente) {
        this.codigoPaciente = codigoPaciente;
        this.nombrePaciente = nombrePaciente;
        this.fecNacimientoPaciente = fecNacimientoPaciente;
    }

    public long getCodigoPaciente() {
        return codigoPaciente;
    }

    public void setCodigoPaciente(long codigoPaciente) {
        this.codigoPaciente = codigoPaciente;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public java.util.Date getFecNacimientoPaciente() {
        return fecNacimientoPaciente;
    }

    public void setFecNacimientoPaciente(java.util.Date fecNacimientoPaciente) {
        this.fecNacimientoPaciente = fecNacimientoPaciente;
    }

}
