package com.wlg.bookstore.dao;

import java.util.List;

import com.wlg.bookstore.vo.Book;

public interface IBookDAO {
	//�����������
	public List getBookbyCatalogid(Integer catalogid);
	//�õ��ܵļ�¼��
	public int getTotalbyCatalog(Integer catalogid);
	//����id��ҳ��ʾͼ��
	public List getBookbyCatalogidPaging(Integer catalogid, int currentPage, int pageSize);
	//����ͼ�鹦��
	public List getRequriedBookbyHql(String hql);
	//�������id���ҵ�Ҫ�������
	public Book getBookbyId(Integer bookid);
	
}
