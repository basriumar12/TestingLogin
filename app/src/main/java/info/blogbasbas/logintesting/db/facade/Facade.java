package info.blogbasbas.logintesting.db.facade;


import info.blogbasbas.logintesting.db.model.DaoSession;

/**
 * Created by User on 28/02/2018.
 */

public class Facade {
    private static Facade instance;
    final DaoSession session;

    final ManageUserTbl manageUserTbl;
    final ManageLibraryTbl manageLibraryTbl;
    final ManageSubcriptionTbl manageSubcriptionTbl;



    public static void init(DaoSession daoSession) {
        instance = new Facade(daoSession);
    }


    public static Facade getInstance() {
        return instance;
    }

    Facade(DaoSession daoSession) {
        this.session = daoSession;
        manageUserTbl = new ManageUserTbl(this);
        manageLibraryTbl = new ManageLibraryTbl(this);
        manageSubcriptionTbl = new ManageSubcriptionTbl(this);


    }
    public ManageLibraryTbl getManageLibraryTbl() {
        return manageLibraryTbl;
    }

    public ManageSubcriptionTbl getManageSubcriptionTbl() {
        return manageSubcriptionTbl;
    }
    public DaoSession getSession() {
        return session;
    }

    public ManageUserTbl getManageUserTbl() {
        return manageUserTbl;
    }
}
