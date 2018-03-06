package info.blogbasbas.logintesting.db.facade;

import java.util.List;

import info.blogbasbas.logintesting.db.model.LibraryTblItem;
import info.blogbasbas.logintesting.db.model.LibraryTblItemDao;


/**
 * Created by User on 28/02/2018.
 */

public class ManageLibraryTbl {

    Facade facade;
    LibraryTblItemDao dao;

    public ManageLibraryTbl(Facade facade) {
      this.dao= facade.session.getLibraryTblItemDao();
        this.facade = facade;
    }
    public long add(LibraryTblItem object) {
        return dao.insertOrReplace(object);
    }

    public void add(List<LibraryTblItem> object) {
        dao.insertOrReplaceInTx(object);
    }

    public List<LibraryTblItem> getAll() {
        return dao.queryBuilder().list();
    }
    public LibraryTblItem get(long id) {
        return dao.queryBuilder().where(LibraryTblItemDao.Properties.LibraryId.eq(id)).unique();
    }
    public void removeAll() {
        dao.deleteAll();
    }

    public void remove(LibraryTblItem object) {
        dao.delete(object);
    }

    public long size(){
        return dao.count();
    }



}
