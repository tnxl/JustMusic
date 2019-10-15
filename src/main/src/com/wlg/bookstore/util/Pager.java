package com.wlg.bookstore.util;

public class Pager {
	private int currentPage; //当前页数
	private int pageSize=6; //每页放置六条记录
	private int totalSize; //总记录数，需要访问数据库来获得
	private int totalPage; //总的页数， 总的记录数/每页记录数 判断余数是否为0，不为0则页数要加1
	
	private boolean hasFirst; //是否有第一页
	private boolean hasPrevious;	//是否有上一页
	private boolean hasNext;	//是否有下一页
	private boolean hasLast;	//是否有最后一页
	
	//构造方法 初始化相关参事
	public Pager(int currentPage,int totalSize){
		this.currentPage = currentPage;
		this.totalSize = totalSize;
		
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}
	// 修改  算法前面讲了 100/3 33 100%3 1 99/3 33 余数为0 33
	public int getTotalPage() {
		totalPage = totalSize/pageSize;
		if (totalSize%pageSize!=0) {
			totalPage++;
		}
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	//判断当前页是否是1 如果是则没有首页 返回 false
	public boolean isHasFirst() {
		if (currentPage==1) {
			return false;
		}
		return true;
	}
	public void setHasFirst(boolean hasFirst) {
		this.hasFirst = hasFirst;
	}
	//判断是否有上一页 如果首页存在就一定有上一页
	public boolean isHasPrevious() {
		if (isHasFirst()) {
			return true;
		}else{
			return false;
		}
	}
	public void setHasPrevious(boolean hasPrevious) {
		this.hasPrevious = hasPrevious;
	}
	//判断是否有尾页 有尾页就有下一页
	public boolean isHasNext() {
		if (isHasLast()) {
			return true;
		}else {
			return false;
		}
	}
	public void setHasNext(boolean hasNext) {
		this.hasNext = hasNext;
	}
	//判断是否有 尾页
	public boolean isHasLast() {
		if (currentPage==getTotalPage()) {
			return false;
		}else {
			return true;
		}
	}
	public void setHasLast(boolean hasLast) {
		this.hasLast = hasLast;
	}
	
	
}
