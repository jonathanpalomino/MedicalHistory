package com.palominocia.medicalhistory.dao;

import org.greenrobot.greendao.annotation.*;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END

/**
 * Entity mapped to table "SEDES".
 */
@Entity
public class Sedes {

    @Id(autoincrement = true)
    private long codigoSede;
    private String NombreSede;
    private String DireccionSede;
    private String TelefonoSede;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    @Generated(hash = 1134944000)
    public Sedes() {
    }

    public Sedes(long codigoSede) {
        this.codigoSede = codigoSede;
    }

    @Generated(hash = 921042795)
    public Sedes(long codigoSede, String NombreSede, String DireccionSede, String TelefonoSede) {
        this.codigoSede = codigoSede;
        this.NombreSede = NombreSede;
        this.DireccionSede = DireccionSede;
        this.TelefonoSede = TelefonoSede;
    }

    public long getCodigoSede() {
        return codigoSede;
    }

    public void setCodigoSede(long codigoSede) {
        this.codigoSede = codigoSede;
    }

    public String getNombreSede() {
        return NombreSede;
    }

    public void setNombreSede(String NombreSede) {
        this.NombreSede = NombreSede;
    }

    public String getDireccionSede() {
        return DireccionSede;
    }

    public void setDireccionSede(String DireccionSede) {
        this.DireccionSede = DireccionSede;
    }

    public String getTelefonoSede() {
        return TelefonoSede;
    }

    public void setTelefonoSede(String TelefonoSede) {
        this.TelefonoSede = TelefonoSede;
    }

    // KEEP METHODS - put your custom methods here
    // KEEP METHODS END

}
