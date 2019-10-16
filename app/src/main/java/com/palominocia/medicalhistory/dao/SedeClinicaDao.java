package com.palominocia.medicalhistory.dao;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.SqlUtils;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

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
        public final static Property CodigoSede = new Property(0, Long.class, "codigoSede", false, "CODIGO_SEDE");
        public final static Property CodigoClinica = new Property(1, Long.class, "codigoClinica", false, "CODIGO_CLINICA");
        public final static Property CodigoMedico = new Property(2, Long.class, "codigoMedico", false, "CODIGO_MEDICO");
    }

    private DaoSession daoSession;

    private Query<SedeClinica> sedes_SedeClinicaListQuery;
    private Query<SedeClinica> medicos_SedeClinicaListQuery;

    public SedeClinicaDao(DaoConfig config) {
        super(config);
    }
    
    public SedeClinicaDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"SEDE_CLINICA\" (" + //
                "\"CODIGO_SEDE\" INTEGER," + // 0: codigoSede
                "\"CODIGO_CLINICA\" INTEGER," + // 1: codigoClinica
                "\"CODIGO_MEDICO\" INTEGER);"); // 2: codigoMedico
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"SEDE_CLINICA\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, SedeClinica entity) {
        stmt.clearBindings();
 
        Long codigoSede = entity.getCodigoSede();
        if (codigoSede != null) {
            stmt.bindLong(1, codigoSede);
        }
 
        Long codigoClinica = entity.getCodigoClinica();
        if (codigoClinica != null) {
            stmt.bindLong(2, codigoClinica);
        }
 
        Long codigoMedico = entity.getCodigoMedico();
        if (codigoMedico != null) {
            stmt.bindLong(3, codigoMedico);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, SedeClinica entity) {
        stmt.clearBindings();
 
        Long codigoSede = entity.getCodigoSede();
        if (codigoSede != null) {
            stmt.bindLong(1, codigoSede);
        }
 
        Long codigoClinica = entity.getCodigoClinica();
        if (codigoClinica != null) {
            stmt.bindLong(2, codigoClinica);
        }
 
        Long codigoMedico = entity.getCodigoMedico();
        if (codigoMedico != null) {
            stmt.bindLong(3, codigoMedico);
        }
    }

    @Override
    protected final void attachEntity(SedeClinica entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public SedeClinica readEntity(Cursor cursor, int offset) {
        SedeClinica entity = new SedeClinica( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // codigoSede
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // codigoClinica
            cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2) // codigoMedico
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, SedeClinica entity, int offset) {
        entity.setCodigoSede(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setCodigoClinica(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setCodigoMedico(cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2));
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
    
    /** Internal query to resolve the "sedeClinicaList" to-many relationship of Sedes. */
    public List<SedeClinica> _querySedes_SedeClinicaList(Long codigoSede, Long codigoClinica) {
        synchronized (this) {
            if (sedes_SedeClinicaListQuery == null) {
                QueryBuilder<SedeClinica> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.CodigoSede.eq(null));
                queryBuilder.where(Properties.CodigoClinica.eq(null));
                sedes_SedeClinicaListQuery = queryBuilder.build();
            }
        }
        Query<SedeClinica> query = sedes_SedeClinicaListQuery.forCurrentThread();
        query.setParameter(0, codigoSede);
        query.setParameter(1, codigoClinica);
        return query.list();
    }

    /** Internal query to resolve the "sedeClinicaList" to-many relationship of Medicos. */
    public List<SedeClinica> _queryMedicos_SedeClinicaList(Long codigoMedico) {
        synchronized (this) {
            if (medicos_SedeClinicaListQuery == null) {
                QueryBuilder<SedeClinica> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.CodigoMedico.eq(null));
                medicos_SedeClinicaListQuery = queryBuilder.build();
            }
        }
        Query<SedeClinica> query = medicos_SedeClinicaListQuery.forCurrentThread();
        query.setParameter(0, codigoMedico);
        return query.list();
    }

    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getSedesDao().getAllColumns());
            builder.append(" FROM SEDE_CLINICA T");
            builder.append(" LEFT JOIN SEDES T0 ON T.\"CODIGO_CLINICA\"=T0.\"_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected SedeClinica loadCurrentDeep(Cursor cursor, boolean lock) {
        SedeClinica entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Sedes sedes = loadCurrentOther(daoSession.getSedesDao(), cursor, offset);
        entity.setSedes(sedes);

        return entity;    
    }

    public SedeClinica loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<SedeClinica> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<SedeClinica> list = new ArrayList<SedeClinica>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<SedeClinica> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<SedeClinica> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
