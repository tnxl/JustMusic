package com.wlg.bookstore.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wlg.bookstore.model.Cart;
import com.wlg.bookstore.service.IBookService;
import com.wlg.bookstore.service.impl.BookService;
import com.wlg.bookstore.vo.Book;
import com.wlg.bookstore.vo.Orderitem;

public class ShoppingAction extends ActionSupport{
	//购物车内有书有订单详细列表
	private IBookService bookService;
	private Integer bookid;
	private int quantity;
	
	public String updateCart(){
		Map session = ActionContext.getContext().getSession();
		Cart cart = (Cart) session.get("cart");
		cart.updateCart(bookid, quantity);
		session.put("cart", cart);
		return SUCCESS;
	}
	
	public String addToCart() {
		Book book = bookService.getBookbyId(bookid);
		Orderitem orderitem = new Orderitem();
		orderitem.setBook(book);
		orderitem.setQuantity(quantity);
		Map session = ActionContext.getContext().getSession();
		Cart cart = (Cart) session.get("cart");
		if (cart==null) {
			cart = new Cart();
		}
		cart.addBook(bookid, orderitem);
		session.put("cart", cart);
		return SUCCESS;
	}

	public String delToCart(){
		Map session = ActionContext.getContext().getSession();
		Cart cart = (Cart) session.get("cart");
		cart.delBook(bookid);
		session.put("cart",cart);
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
	
}
