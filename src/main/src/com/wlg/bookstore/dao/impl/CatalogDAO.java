package com.wlg.bookstore.dao.impl;

import com.wlg.bookstore.dao.BaseDAO;
import com.wlg.bookstore.dao.ICatalogDAO;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CatalogDAO extends BaseDAO implements ICatalogDAO{

	@Override
	public List getAllCataLogs() {
		//µ÷ÓÃhibernateµÄAPI
		Session session = getSession();
		Query query = session.createQuery("from Catalog c");
		List catalogs = query.list();
		session.close();
		return catalogs;
	}
	
}
