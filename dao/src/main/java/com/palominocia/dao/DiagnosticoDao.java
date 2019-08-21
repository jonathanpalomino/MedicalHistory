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
 * DAO for table "DIAGNOSTICO".
*/
public class DiagnosticoDao extends AbstractDao<Diagnostico, Void> {

    public static final String TABLENAME = "DIAGNOSTICO";

    /**
     * Properties of entity Diagnostico.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property CodigoDiagnostico = new Property(0, Long.class, "codigoDiagnostico", false, "CODIGO_DIAGNOSTICO");
        public final static Property Indicaciones = new Property(1, String.class, "indicaciones", false, "INDICACIONES");
        public final static Property FechaDiagnostico = new Property(2, java.util.Date.class, "fechaDiagnostico", false, "FECHA_DIAGNOSTICO");
    }


    public DiagnosticoDao(DaoConfig config) {
        super(config);
    }
    
    public DiagnosticoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DIAGNOSTICO\" (" + //
                "\"CODIGO_DIAGNOSTICO\" INTEGER," + // 0: codigoDiagnostico
                "\"INDICACIONES\" TEXT," + // 1: indicaciones
                "\"FECHA_DIAGNOSTICO\" INTEGER);"); // 2: fechaDiagnostico
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DIAGNOSTICO\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Diagnostico entity) {
        stmt.clearBindings();
 
        Long codigoDiagnostico = entity.getCodigoDiagnostico();
        if (codigoDiagnostico != null) {
            stmt.bindLong(1, codigoDiagnostico);
        }
 
        String indicaciones = entity.getIndicaciones();
        if (indicaciones != null) {
            stmt.bindString(2, indicaciones);
        }
 
        java.util.Date fechaDiagnostico = entity.getFechaDiagnostico();
        if (fechaDiagnostico != null) {
            stmt.bindLong(3, fechaDiagnostico.getTime());
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Diagnostico entity) {
        stmt.clearBindings();
 
        Long codigoDiagnostico = entity.getCodigoDiagnostico();
        if (codigoDiagnostico != null) {
            stmt.bindLong(1, codigoDiagnostico);
        }
 
        String indicaciones = entity.getIndicaciones();
        if (indicaciones != null) {
            stmt.bindString(2, indicaciones);
        }
 
        java.util.Date fechaDiagnostico = entity.getFechaDiagnostico();
        if (fechaDiagnostico != null) {
            stmt.bindLong(3, fechaDiagnostico.getTime());
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public Diagnostico readEntity(Cursor cursor, int offset) {
        Diagnostico entity = new Diagnostico( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // codigoDiagnostico
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // indicaciones
            cursor.isNull(offset + 2) ? null : new java.util.Date(cursor.getLong(offset + 2)) // fechaDiagnostico
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Diagnostico entity, int offset) {
        entity.setCodigoDiagnostico(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setIndicaciones(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setFechaDiagnostico(cursor.isNull(offset + 2) ? null : new java.util.Date(cursor.getLong(offset + 2)));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(Diagnostico entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(Diagnostico entity) {
        return null;
    }

    @Override
    public boolean hasKey(Diagnostico entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
