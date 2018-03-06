package info.blogbasbas.logintesting.db.facade;

import java.util.List;

import info.blogbasbas.logintesting.db.model.SubscriptionTbl;
import info.blogbasbas.logintesting.db.model.SubscriptionTblDao;


/**
 * Created by User on 28/02/2018.
 */

public class ManageSubcriptionTbl {

    Facade facade;
    SubscriptionTblDao dao;

    public ManageSubcriptionTbl(Facade facade) {
      this.dao= facade.session.getSubscriptionTblDao();
        this.facade = facade;
    }
    public long add(SubscriptionTbl object) {
        return dao.insertOrReplace(object);
    }

    public void add(List<SubscriptionTbl> object) {
        dao.insertOrReplaceInTx(object);
    }

    public List<SubscriptionTbl> getAll() {
        return dao.queryBuilder().list();
    }
    public SubscriptionTbl get(long id) {
        return dao.queryBuilder().where(SubscriptionTblDao.Properties.SubscriptionId.eq(id)).unique();
    }
    public void removeAll() {
        dao.deleteAll();
    }

    public void remove(SubscriptionTbl object) {
        dao.delete(object);
    }

    public long size(){
        return dao.count();
    }



}
