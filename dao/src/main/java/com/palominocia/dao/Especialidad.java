package com.palominocia.dao;

import org.greenrobot.greendao.annotation.*;

import java.util.List;
import com.palominocia.dao.DaoSession;
import org.greenrobot.greendao.DaoException;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit.

/**
 * Entity mapped to table "ESPECIALIDAD".
 */
@Entity(active = true)
public class Especialidad {

    @Id(autoincrement = true)
    private long codigoEspecialidad;
    private String nombreEspecialidad;

    /** Used to resolve relations */
    @Generated
    private transient DaoSession daoSession;

    /** Used for active entity operations. */
    @Generated
    private transient EspecialidadDao myDao;

    @ToMany(joinProperties = {
        @JoinProperty(name = "codigoEspecialidad", referencedName = "codigoEspecialidad")
    })
    private List<MedicoEspecialidad> medicoEspecialidadList;

    @Generated
    public Especialidad() {
    }

    public Especialidad(long codigoEspecialidad) {
        this.codigoEspecialidad = codigoEspecialidad;
    }

    @Generated
    public Especialidad(long codigoEspecialidad, String nombreEspecialidad) {
        this.codigoEspecialidad = codigoEspecialidad;
        this.nombreEspecialidad = nombreEspecialidad;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getEspecialidadDao() : null;
    }

    public long getCodigoEspecialidad() {
        return codigoEspecialidad;
    }

    public void setCodigoEspecialidad(long codigoEspecialidad) {
        this.codigoEspecialidad = codigoEspecialidad;
    }

    public String getNombreEspecialidad() {
        return nombreEspecialidad;
    }

    public void setNombreEspecialidad(String nombreEspecialidad) {
        this.nombreEspecialidad = nombreEspecialidad;
    }

    /** To-many relationship, resolved on first access (and after reset). Changes to to-many relations are not persisted, make changes to the target entity. */
    @Generated
    public List<MedicoEspecialidad> getMedicoEspecialidadList() {
        if (medicoEspecialidadList == null) {
            __throwIfDetached();
            MedicoEspecialidadDao targetDao = daoSession.getMedicoEspecialidadDao();
            List<MedicoEspecialidad> medicoEspecialidadListNew = targetDao._queryEspecialidad_MedicoEspecialidadList(codigoEspecialidad);
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
