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
 * DAO for table "CITAS".
*/
public class CitasDao extends AbstractDao<Citas, Void> {

    public static final String TABLENAME = "CITAS";

    /**
     * Properties of entity Citas.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
    }


    public CitasDao(DaoConfig config) {
        super(config);
    }
    
    public CitasDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"CITAS\" (" + //
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"CITAS\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Citas entity) {
        stmt.clearBindings();
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Citas entity) {
        stmt.clearBindings();
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public Citas readEntity(Cursor cursor, int offset) {
        Citas entity = new Citas( //
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Citas entity, int offset) {
     }
    
    @Override
    protected final Void updateKeyAfterInsert(Citas entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(Citas entity) {
        return null;
    }

    @Override
    public boolean hasKey(Citas entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}