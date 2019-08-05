package com.palominocia.medicalhistory.beans;

import java.io.Serializable;
import java.util.ArrayList;

public class MedicoBean implements Serializable {
    private String nombre;
    private String hospital;
    private String sedeHospital;
    private String horarios;
    private ArrayList<String> colegiatura;
    private String especialidad;
    private int thumbnail;
    private String urlImage;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getSedeHospital() {
        return sedeHospital;
    }

    public void setSedeHospital(String sedeHospital) {
        this.sedeHospital = sedeHospital;
    }

    public String getHorarios() {
        return horarios;
    }

    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }

    public ArrayList<String> getColegiatura() {
        return colegiatura;
    }

    public void setColegiatura(ArrayList<String> colegiatura) {
        this.colegiatura = colegiatura;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    /**
     * @return the urlImage
     */
    public String getUrlImage() {
        return urlImage;
    }

    /**
     * @param urlImage the urlImage to set
     */
    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}