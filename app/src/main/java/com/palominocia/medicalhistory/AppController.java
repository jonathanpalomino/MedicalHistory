package com.palominocia.medicalhistory;

import android.app.Application;
import android.util.Log;

import com.palominocia.medicalhistory.dao.DaoMaster;
import com.palominocia.medicalhistory.dao.DaoSession;

import org.greenrobot.greendao.database.Database;

public class AppController extends Application {

    public static final boolean ENCRYPTED = true;
    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this,"medical_data.db"); //The users-db here is the name of our database.
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();

        ///// Using the below lines of code we can toggle ENCRYPTED to true or false in other to use either an encrypted database or not.
//      DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, ENCRYPTED ? "users-db-encrypted" : "users-db");
//      Database db = ENCRYPTED ? helper.getEncryptedWritableDb("super-secret") : helper.getWritableDb();
//      daoSession = new DaoMaster(db).newSession();
        Log.i("APP_CONTROLLER", "onCreate: ");
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

}
