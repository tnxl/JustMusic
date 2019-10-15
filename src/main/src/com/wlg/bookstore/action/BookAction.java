package com.wlg.bookstore.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wlg.bookstore.service.IBookService;
import com.wlg.bookstore.service.impl.CatalogService;
import com.wlg.bookstore.util.Pager;

public class BookAction extends ActionSupport{
	private CatalogService catalogService;
	protected Integer catalogid;
	protected IBookService bookService;
	
	private Integer currentPage=1;
	private String bookname;
	
	//����ͼ��
	public String searchBook(){
		//����Ҫ�ж�һ�� ������������Ƿ�Ϊ�� Ϊ�վ���ʾ���е�ͼ��
		//�����Ϊ�� ���������� �漰��hql����ƴ��
		StringBuffer hql = new StringBuffer("from Book b  ");
		if (bookname!=null&&bookname.length()!=0) {
			hql.append("where b.bookname like '%"+bookname+"%'");
		}
		List books = bookService.getRequriedBookbyHql(hql.toString());
		
		Map request = (Map)ActionContext.getContext().get("request");
		request.put("books",books);
		return SUCCESS;
	}
	public String browseBookPaging(){
		int totalSize = bookService.getTotalbyCatalog(catalogid);
		Pager pager = new Pager(currentPage, totalSize);
		List books = bookService.getBookbyCatalogidPaging(catalogid, currentPage, pager.getPageSize());
		
		Map request = (Map)ActionContext.getContext().get("request");
		request.put("books",books);
		request.put("pager",pager);
		return SUCCESS;
	}
	//���ͼ��
	public String browseBook(){
		List books = bookService.getBookbyCatalogid(catalogid);
		Map request = (Map)ActionContext.getContext().get("request");
		request.put("books",books);
		return SUCCESS;
	}
	
	
	//���ͼʱ����Ĺ��ܹ��� ����
	//�ҵ����� ���ؽ����Struts ͬʱ���ҵ��ķ��෵�ظ�ǰ̨����

	public String browseCatalog()  {
		// TODO Auto-generated method stub
		List catlogs = catalogService.getAllCataLogs();
		Map request = (Map)ActionContext.getContext().get("request");
		request.put("catalogs",catlogs);
		return SUCCESS;
	}
	
	public CatalogService getCatalogService() {
		return catalogService;
	}
	public void setCatalogService(CatalogService catalogService) {
		this.catalogService = catalogService;
	}
	public Integer getCatalogid() {
		return catalogid;
	}
	public void setCatalogid(Integer catalogid) {
		this.catalogid = catalogid;
	}

	public IBookService getBookService() {
		return bookService;
	}

	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}


	public Integer getCurrentPage() {
		return currentPage;
	}


	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	
}
