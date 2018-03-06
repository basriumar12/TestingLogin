package info.blogbasbas.logintesting;

import android.app.Application;

import org.greenrobot.greendao.database.Database;

import info.blogbasbas.logintesting.db.facade.Facade;
import info.blogbasbas.logintesting.db.facade.FacadeOpenHelper;
import info.blogbasbas.logintesting.db.model.DaoMaster;
import info.blogbasbas.logintesting.db.model.DaoSession;
import timber.log.Timber;

/**
 * Created by User on 01/03/2018.
 */

public class BaseApplication extends Application {
    private static final boolean ENCRYPTED = false;
    private static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());


        String databaseName = "cobatesting-db";
        FacadeOpenHelper helper = new FacadeOpenHelper(this, databaseName);

        String password = "++cc";
        Timber.e("database name : %s", databaseName);
        Database db = ENCRYPTED ? helper.getEncryptedWritableDb(password)
                : helper.getWritableDb();



        daoSession = new DaoMaster(db).newSession();

        Facade.init(daoSession);

//
        //
    }
    public static DaoSession getDaoSession() {
        return daoSession;
    }


}
