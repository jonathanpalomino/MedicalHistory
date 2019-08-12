package com.palominocia.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "ESPECIALIDAD".
*/
public class EspecialidadDao extends AbstractDao<Especialidad, Void> {

    public static final String TABLENAME = "ESPECIALIDAD";

    /**
     * Properties of entity Especialidad.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
    }


    public EspecialidadDao(DaoConfig config) {
        super(config);
    }
    
    public EspecialidadDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"ESPECIALIDAD\" (" + //
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"ESPECIALIDAD\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Especialidad entity) {
        stmt.clearBindings();
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Especialidad entity) {
        stmt.clearBindings();
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public Especialidad readEntity(Cursor cursor, int offset) {
        Especialidad entity = new Especialidad( //
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Especialidad entity, int offset) {
     }
    
    @Override
    protected final Void updateKeyAfterInsert(Especialidad entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(Especialidad entity) {
        return null;
    }

    @Override
    public boolean hasKey(Especialidad entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
