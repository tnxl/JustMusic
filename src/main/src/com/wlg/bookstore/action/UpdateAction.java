package com.wlg.bookstore.action;

import com.opensymphony.xwork2.ActionSupport;
import com.wlg.bookstore.dao.BaseDAO;
import com.wlg.bookstore.vo.Book;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;


public class UpdateAction extends ActionSupport {
    private BaseDAO baseDAO;
    private Integer bookid;
    private String bookname;
    private Integer price;

    @Override
    public String execute() throws Exception {

        updateBookInfo();
        return SUCCESS;
    }

    public void updateBookInfo() {
        Session session = baseDAO.getSession();
        Transaction tx = session.beginTransaction();
        String hql = "update Book b set b.bookname = :name,b.price = :price where b.bookid = :id";
        Query query = session.createQuery(hql);
        query.setParameter("name", bookname);
        query.setParameter("price", price);
        query.setParameter("id", bookid);
        query.executeUpdate();
        tx.commit();

//        String hql = "from Book b where b.bookname = :id";
//        Query query = session.createQuery(hql);
//        query.setParameter("id",bookname);
//        List temp = query.list();
//        Integer id = ((Book)temp.get(0)).getBookid();
//        Book book = session.get(Book.class,id);
//        book.setBookname(bookname);
//        book.setPrice(price);
//        Transaction tx = session.beginTransaction();
//        session.update(book);
//        tx.commit();
    }

    public BaseDAO getBaseDAO() {
        return baseDAO;
    }

    public void setBaseDAO(BaseDAO baseDAO) {
        this.baseDAO = baseDAO;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }
}
