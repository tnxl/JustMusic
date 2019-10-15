package com.wlg.bookstore.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.wlg.bookstore.vo.Book;
import com.wlg.bookstore.vo.Orderitem;

public class Cart {
	protected Map<Integer, Orderitem> items;
	
	public Cart(){
		if (items==null) {
			items = new HashMap<Integer, Orderitem>();
		}
	}
	
	//添加功能
	public void addBook(Integer bookid,Orderitem orderitem){
		if (items.containsKey(bookid)) {
			Orderitem _orderitem = items.get(bookid);
			orderitem.setQuantity(_orderitem.getQuantity()+orderitem.getQuantity());
		}
		items.put(bookid, orderitem);
	}

	//删除功能
	public void delBook(Integer bookid){
		items.remove(bookid);
	}
	
	//修改购物车
	public void updateCart(Integer bookid,int quantity){
		Orderitem orderitem = items.get(bookid);//因为购物车是个map集合
		orderitem.setQuantity(quantity);
		items.put(bookid, orderitem);	
	}
	
	//计算总价格
	public int getTotalPrice(){
		int totalprice = 0;
		for(Iterator it = items.values().iterator();it.hasNext();){
			Orderitem orderitem = (Orderitem) it.next();
			Book book = orderitem.getBook();
			int quantity = orderitem.getQuantity();
			totalprice += book.getPrice()*quantity;
			
		}
		return totalprice;
	}

	public Map<Integer, Orderitem> getItems() {
		return items;
	}

	public void setItems(Map<Integer, Orderitem> items) {
		this.items = items;
	}
	
}
