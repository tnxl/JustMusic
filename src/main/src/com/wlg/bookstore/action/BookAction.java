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
	
	//搜索图书
	public String searchBook(){
		//首先要判断一下 你输入的内容是否为空 为空就显示所有的图书
		//如果不为空 把条件加上 涉及到hql语句的拼接
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
	//浏览图书
	public String browseBook(){
		List books = bookService.getBookbyCatalogid(catalogid);
		Map request = (Map)ActionContext.getContext().get("request");
		request.put("books",books);
		return SUCCESS;
	}
	
	
	//浏览图时分类的功能功能 方法
	//找到分类 返回结果给Struts 同时把找到的分类返回给前台界面

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
