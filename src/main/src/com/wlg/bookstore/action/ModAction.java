package com.wlg.bookstore.action;

import com.opensymphony.xwork2.ActionSupport;
import com.wlg.bookstore.dao.BaseDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class ModAction extends ActionSupport {

    private Integer bookid;
    private BaseDAO baseDAO;
    @Override
    public String execute() throws Exception {
        deleteBook();
        return SUCCESS;
    }

    public void deleteBook(){
        String hql = "delete Book b where b.bookid = :id";
        Session session = baseDAO.getSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery(hql);
        query.setParameter("id",bookid);
        query.executeUpdate();
        tx.commit();
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public BaseDAO getBaseDAO() {
        return baseDAO;
    }

    public void setBaseDAO(BaseDAO baseDAO) {
        this.baseDAO = baseDAO;
    }
}
