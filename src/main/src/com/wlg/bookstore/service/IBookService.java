package com.wlg.bookstore.service;

import java.util.List;

import com.wlg.bookstore.vo.Book;

public interface IBookService {
	public List getBookbyCatalogid(Integer catalogid);
	public int getTotalbyCatalog(Integer catalogid);
	//����id��ҳ��ʾͼ��
	public List getBookbyCatalogidPaging(Integer catalogid, int currentPage, int pageSize);
	public List getRequriedBookbyHql(String hql);
	//�������id���ҵ�Ҫ�������
	public Book getBookbyId(Integer bookid);
}
