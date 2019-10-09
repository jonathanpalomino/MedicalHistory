package com.palominocia.medicalhistory.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "SEDE_CLINICA".
*/
public class SedeClinicaDao extends AbstractDao<SedeClinica, Void> {

    public static final String TABLENAME = "SEDE_CLINICA";

    /**
     * Properties of entity SedeClinica.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Ddd = new Property(0, String.class, "ddd", false, "DDD");
    }


    public SedeClinicaDao(DaoConfig config) {
        super(config);
    }
    
    public SedeClinicaDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"SEDE_CLINICA\" (" + //
                "\"DDD\" TEXT);"); // 0: ddd
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"SEDE_CLINICA\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, SedeClinica entity) {
        stmt.clearBindings();
 
        String ddd = entity.getDdd();
        if (ddd != null) {
            stmt.bindString(1, ddd);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, SedeClinica entity) {
        stmt.clearBindings();
 
        String ddd = entity.getDdd();
        if (ddd != null) {
            stmt.bindString(1, ddd);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public SedeClinica readEntity(Cursor cursor, int offset) {
        SedeClinica entity = new SedeClinica( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0) // ddd
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, SedeClinica entity, int offset) {
        entity.setDdd(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(SedeClinica entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(SedeClinica entity) {
        return null;
    }

    @Override
    public boolean hasKey(SedeClinica entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}