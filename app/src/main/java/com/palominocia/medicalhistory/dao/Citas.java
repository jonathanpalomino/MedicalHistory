package com.palominocia.medicalhistory.dao;

import org.greenrobot.greendao.annotation.*;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END

/**
 * Entity mapped to table "CITAS".
 */
@Entity
public class Citas {
    private Long codigoCita;
    private java.util.Date fechaCita;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    @Generated(hash = 278543856)
    public Citas() {
    }

    @Generated(hash = 1887959881)
    public Citas(Long codigoCita, java.util.Date fechaCita) {
        this.codigoCita = codigoCita;
        this.fechaCita = fechaCita;
    }

    public Long getCodigoCita() {
        return codigoCita;
    }

    public void setCodigoCita(Long codigoCita) {
        this.codigoCita = codigoCita;
    }

    public java.util.Date getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(java.util.Date fechaCita) {
        this.fechaCita = fechaCita;
    }

    // KEEP METHODS - put your custom methods here
    // KEEP METHODS END

}