package com.wlg.bookstore.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wlg.bookstore.dao.BaseDAO;
import com.wlg.bookstore.vo.Book;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModifyAction extends ActionSupport {

    private Integer bookid;
    private BaseDAO baseDAO;
    private Map<String, Book> item;

    @Override
    public String execute() throws Exception {

        modifyBook();
        return SUCCESS;
    }

//    public void deleteBook(){
//        String hql = "delete Book b where b.bookid = :id";
//        Session session = baseDAO.getSession();
//        Query query = session.createQuery(hql);
//        query.setParameter("id",bookid);
//        query.executeUpdate();
//        session.beginTransaction().commit();
//    }
    public void modifyBook(){
        Map mapsession = ActionContext.getContext().getSession();
        String hql = "from Book b where b.bookid = :id";
        Session session = baseDAO.getSession();
        Query query = session.createQuery(hql);
        query.setParameter("id",bookid);
        List book = query.list();
        item = new HashMap<>();
        item.put("book", ((Book) book.get(0)));
        mapsession.put("gequ",item);
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

    public Map<String, Book> getItem() {
        return item;
    }

    public void setItem(Map<String, Book> item) {
        this.item = item;
    }
}
