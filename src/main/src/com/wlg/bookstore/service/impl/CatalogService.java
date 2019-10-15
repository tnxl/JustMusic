package com.wlg.bookstore.service.impl;

import java.util.List;

import com.wlg.bookstore.dao.ICatalogDAO;
import com.wlg.bookstore.service.ICatalogService;

public class CatalogService implements ICatalogService{
	private ICatalogDAO catalogDAO;
	@Override
	public List getAllCataLogs() {
		// TODO Auto-generated method stub
		return catalogDAO.getAllCataLogs();
	}
	public ICatalogDAO getCatalogDAO() {
		return catalogDAO;
	}
	public void setCatalogDAO(ICatalogDAO catalogDAO) {
		this.catalogDAO = catalogDAO;
	}
}
