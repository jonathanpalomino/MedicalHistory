package com.palominocia.medicalhistory.dao;

import org.greenrobot.greendao.annotation.*;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END

/**
 * Entity mapped to table "SEDE_CLINICA".
 */
@Entity
public class SedeClinica {
    private String ddd;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    @Generated(hash = 1757763250)
    public SedeClinica() {
    }

    @Generated(hash = 705692554)
    public SedeClinica(String ddd) {
        this.ddd = ddd;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    // KEEP METHODS - put your custom methods here
    // KEEP METHODS END

}