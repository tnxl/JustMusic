package com.wlg.bookstore.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wlg.bookstore.dao.BaseDAO;
import com.wlg.bookstore.service.IBookService;
import com.wlg.bookstore.vo.Book;
import com.wlg.bookstore.vo.Orderitem;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManagerAction extends ActionSupport {

    protected Map<Integer, Orderitem> items;
    @Autowired
    private BaseDAO baseDAO;
    private IBookService bookService;
    private Integer bookid;
    private int quantity;

    @Override
    public String execute() throws Exception {

        Map session = ActionContext.getContext().getSession();

        searchAllBooks();

        session.put("items",items);

        return SUCCESS;

    }

    public String jump() throws Exception{

        execute();
        return SUCCESS;
    }

    public IBookService getBookService() {
        return bookService;
    }

    public void setBookService(IBookService bookService) {
        this.bookService = bookService;
    }

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ManagerAction(){
        if (items==null){
            items = new HashMap<Integer,Orderitem>();
        }
    }

    public void searchAllBooks(){
        String hql = "from Book b";
        Session session = baseDAO.getSession();
        Query query = session.createQuery(hql);
        List books = query.list();
        items = new HashMap<Integer,Orderitem>();
        for (int i=0;i<books.size();i++){
            Orderitem orderitem = new Orderitem();
            orderitem.setBook((Book)books.get(i));
            orderitem.setQuantity(((Book)books.get(i)).getPrice());
            items.put(((Book) books.get(i)).getBookid(),orderitem);
        }
    }

    public Map<Integer, Orderitem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, Orderitem> items) {
        this.items = items;

    }

    public BaseDAO getBaseDAO() {
        return baseDAO;
    }

    public void setBaseDAO(BaseDAO baseDAO) {
        this.baseDAO = baseDAO;
    }
}
