package com.greendaoexample;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Gurpreet on 12/17/2016.
 */

public class App extends Application{

    /** A flag to show how easily you can switch from standard SQLite to the encrypted SQLCipher. */
    public static final boolean ENCRYPTED = true;

    private DaoSession daoSession;
    private static App mInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "test-db");
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }


    public static App getmInstance() {
        return mInstance;
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }

}
