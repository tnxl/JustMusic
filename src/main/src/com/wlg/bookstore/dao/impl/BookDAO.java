package com.wlg.bookstore.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.wlg.bookstore.dao.BaseDAO;
import com.wlg.bookstore.dao.IBookDAO;
import com.wlg.bookstore.vo.Book;

public class BookDAO extends BaseDAO implements IBookDAO{
	
	@Override
	public List getBookbyCatalogid(Integer catalogid) {
		Session session = getSession();
		String hql ="from Book b where b.catalog.catalogid=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", catalogid);
		List books =query.list();
		session.close();		
		return books;
	}

	@Override
	public int getTotalbyCatalog(Integer catalogid) {
		// ����catalogid�ҷ��������ļ�¼ �ŵ������� ���ϴ�С�����ܵļ�¼��
		Session session = getSession();
		Query query = session.createQuery("from Book b where b.catalog.catalogid=:id");
		query.setParameter("id", catalogid);
		List books = query.list();
		int totalSize = books.size();
		session.close();
		return totalSize;
	}
	//�ѵ� ��ҳ��ʵ�� ��Ҫ��ס�������� hibernate��ҳ�ķ��� 
	@Override
	public List getBookbyCatalogidPaging(Integer catalogid, int currentPage, int pageSize) {
		Session session = getSession();
		Query query = session.createQuery("from Book b where b.catalog.catalogid=:id");
		query.setParameter("id", catalogid);
		
		//hibernate ����
		//�����ǰҳ��1�Ļ� 1-1 0 
		int startRow = (currentPage-1)*pageSize;
		query.setFirstResult(startRow);
		query.setMaxResults(pageSize);
		
		List books = query.list();
		session.close();
		
		return books;
	}

	@Override
	public List getRequriedBookbyHql(String hql) {
		Session session = getSession();
		Query query = session.createQuery(hql);
		List books = query.list();
		
		return books;
	}
	
	
	@Override
	public Book getBookbyId(Integer bookid) {
		Session session = getSession();
		Book book = (Book) session.get(Book.class, bookid);
		session.close();
		return book;
	}
}
