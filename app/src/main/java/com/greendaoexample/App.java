package com.greendaoexample;

import android.app.Application;

import com.greendaoexample.database.DaoMaster;
import com.greendaoexample.database.DaoSession;

import org.greenrobot.greendao.database.Database;

/**
 * Created by Gurpreet on 12/17/2016.
 */

public class App extends Application{

    /** A flag to show how easily you can switch from standard SQLite to the encrypted SQLCipher. */
    public static final boolean ENCRYPTED = true;

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, ENCRYPTED ? "notes-db-encrypted" : "notes-db");
        Database db = ENCRYPTED ? helper.getEncryptedWritableDb("super-secret") : helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

}