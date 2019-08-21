package com.palominocia.dao;

import org.greenrobot.greendao.annotation.*;

import java.util.List;
import com.palominocia.dao.DaoSession;
import org.greenrobot.greendao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit.

/**
 * Entity mapped to table "MEDICOS".
 */
@Entity(active = true)
public class Medicos {

    @Id(autoincrement = true)
    private long codigoMedico;
    private String nombreMedico;
    private String urlMedico;

    /** Used to resolve relations */
    @Generated
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated
    private transient MedicosDao myDao;

    @ToMany(joinProperties = {
        @JoinProperty(name = "codigoMedico", referencedName = "codigoMedico")
    })
    private List<sedeClinica> sedeClinicaList;

    @ToMany(joinProperties = {
        @JoinProperty(name = "codigoMedico", referencedName = "codigoMedico")
    })
    private List<MedicoEspecialidad> medicoEspecialidadList;

    @Generated
    public Medicos() {
    }

    public Medicos(long codigoMedico) {
        this.codigoMedico = codigoMedico;
    }

    @Generated
    public Medicos(long codigoMedico, String nombreMedico, String urlMedico) {
        this.codigoMedico = codigoMedico;
        this.nombreMedico = nombreMedico;
        this.urlMedico = urlMedico;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getMedicosDao() : null;
    }

    public long getCodigoMedico() {
        return codigoMedico;
    }

    public void setCodigoMedico(long codigoMedico) {
        this.codigoMedico = codigoMedico;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    public String getUrlMedico() {
        return urlMedico;
    }

    public void setUrlMedico(String urlMedico) {
        this.urlMedico = urlMedico;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    @Generated
    public List<sedeClinica> getSedeClinicaList() {
        if (sedeClinicaList == null) {
            __throwIfDetached();
            sedeClinicaDao targetDao = daoSession.getSedeClinicaDao();
            List<sedeClinica> sedeClinicaListNew = targetDao._queryMedicos_SedeClinicaList(codigoMedico);
            synchronized (this) {
                if(sedeClinicaList == null) {
                    sedeClinicaList = sedeClinicaListNew;
                }
            }
        }
        return sedeClinicaList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated
    public synchronized void resetSedeClinicaList() {
        sedeClinicaList = null;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    @Generated
    public List<MedicoEspecialidad> getMedicoEspecialidadList() {
        if (medicoEspecialidadList == null) {
            __throwIfDetached();
            MedicoEspecialidadDao targetDao = daoSession.getMedicoEspecialidadDao();
            List<MedicoEspecialidad> medicoEspecialidadListNew = targetDao._queryMedicos_MedicoEspecialidadList(codigoMedico);
            synchronized (this) {
                if(medicoEspecialidadList == null) {
                    medicoEspecialidadList = medicoEspecialidadListNew;
                }
            }
        }
        return medicoEspecialidadList;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated
    public synchronized void resetMedicoEspecialidadList() {
        medicoEspecialidadList = null;
    }

    /**
    * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
    * Entity must attached to an entity context.
    */
    @Generated
    public void delete() {
        __throwIfDetached();
        myDao.delete(this);
    }

    /**
    * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
    * Entity must attached to an entity context.
    */
    @Generated
    public void update() {
        __throwIfDetached();
        myDao.update(this);
    }

    /**
    * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
    * Entity must attached to an entity context.
    */
    @Generated
    public void refresh() {
        __throwIfDetached();
        myDao.refresh(this);
    }

    @Generated
    private void __throwIfDetached() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
    }

}
