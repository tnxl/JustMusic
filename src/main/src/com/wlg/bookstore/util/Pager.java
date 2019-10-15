package com.wlg.bookstore.util;

public class Pager {
	private int currentPage; //��ǰҳ��
	private int pageSize=6; //ÿҳ����������¼
	private int totalSize; //�ܼ�¼������Ҫ�������ݿ������
	private int totalPage; //�ܵ�ҳ���� �ܵļ�¼��/ÿҳ��¼�� �ж������Ƿ�Ϊ0����Ϊ0��ҳ��Ҫ��1
	
	private boolean hasFirst; //�Ƿ��е�һҳ
	private boolean hasPrevious;	//�Ƿ�����һҳ
	private boolean hasNext;	//�Ƿ�����һҳ
	private boolean hasLast;	//�Ƿ������һҳ
	
	//���췽�� ��ʼ����ز���
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
	// �޸�  �㷨ǰ�潲�� 100/3 33 100%3 1 99/3 33 ����Ϊ0 33
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
	//�жϵ�ǰҳ�Ƿ���1 �������û����ҳ ���� false
	public boolean isHasFirst() {
		if (currentPage==1) {
			return false;
		}
		return true;
	}
	public void setHasFirst(boolean hasFirst) {
		this.hasFirst = hasFirst;
	}
	//�ж��Ƿ�����һҳ �����ҳ���ھ�һ������һҳ
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
	//�ж��Ƿ���βҳ ��βҳ������һҳ
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
	//�ж��Ƿ��� βҳ
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
