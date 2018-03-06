package info.blogbasbas.logintesting.db.facade;

import java.util.List;

import info.blogbasbas.logintesting.db.model.UserTbl;
import info.blogbasbas.logintesting.db.model.UserTblDao;


/**
 * Created by User on 28/02/2018.
 */

public class ManageUserTbl {

    Facade facade;
    UserTblDao dao;

    public ManageUserTbl( Facade facade) {
      this.dao= facade.session.getUserTblDao();
        this.facade = facade;
    }
    public long add(UserTbl object) {
        return dao.insertOrReplace(object);
    }

    public void add(List<UserTbl> object) {
        dao.insertOrReplaceInTx(object);
    }

    public List<UserTbl> getAll() {
        return dao.queryBuilder().list();
    }
    public UserTbl get(long id) {
        return dao.queryBuilder().where(UserTblDao.Properties.UserId.eq(id)).unique();
    }
    public void removeAll() {
        dao.deleteAll();
    }

    public void remove(UserTbl object) {
        dao.delete(object);
    }

    public long size(){
        return dao.count();
    }



}
