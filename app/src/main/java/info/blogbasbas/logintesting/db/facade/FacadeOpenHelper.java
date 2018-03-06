package info.blogbasbas.logintesting.db.facade;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import info.blogbasbas.logintesting.db.model.DaoMaster;


public class FacadeOpenHelper extends DaoMaster.OpenHelper{

    public FacadeOpenHelper(Context context, String name) {
        super(context, name);
    }

    public FacadeOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }
}
