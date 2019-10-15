package com.wlg.bookstore.service.impl;

import java.util.List;

import com.wlg.bookstore.dao.impl.BookDAO;
import com.wlg.bookstore.service.IBookService;
import com.wlg.bookstore.vo.Book;

public class BookService implements IBookService{
	private BookDAO bookDAO;
	@Override
	public List getBookbyCatalogid(Integer catalogid) {
		return bookDAO.getBookbyCatalogid(catalogid);
	}
	public BookDAO getBookDAO() {
		return bookDAO;
	}
	public void setBookDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}
	@Override
	public int getTotalbyCatalog(Integer catalogid) {
		
		return bookDAO.getTotalbyCatalog(catalogid);
	}
	@Override
	public List getBookbyCatalogidPaging(Integer catalogid, int currentPage, int pageSize) {
		
		return bookDAO.getBookbyCatalogidPaging(catalogid, currentPage, pageSize);
	}
	@Override
	public List getRequriedBookbyHql(String hql) {
		
		return bookDAO.getRequriedBookbyHql(hql);
	}
	@Override
	public Book getBookbyId(Integer bookid) {
		// TODO Auto-generated method stub
		return bookDAO.getBookbyId(bookid);
	}
	
}
