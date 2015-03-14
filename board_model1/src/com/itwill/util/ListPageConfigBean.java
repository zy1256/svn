package com.itwill.util;

// ����Ʈ ������ ���� ����� ������ ���� ��
public class ListPageConfigBean{
	
	private int rowCount;          // ���̺�(����Ʈ)�� ��� ���
	private int pagingCount;       // ���������� �������� ������ ��
	private String selectPage;     // ������ ���� ������ ��ȣ
	private String searchType;     // ����� ���� �˻�Ÿ��
	private String searchContent;  // ����� �Է� �˻�����
	public ListPageConfigBean() {}
	public ListPageConfigBean(int rowCount, int pagingCount, String selectPage, String searchType, String searchContent) {
		this.rowCount = rowCount;
		this.pagingCount = pagingCount;
		this.selectPage = selectPage;
		this.searchType = searchType;
		this.searchContent = searchContent;
	}
	public int getPagingCount() {
		return pagingCount;
	}
	public void setPagingCount(int pagingCount) {
		this.pagingCount = pagingCount;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public String getSearchContent() {
		return searchContent;
	}
	public void setSearchContent(String searchContent) {
		this.searchContent = searchContent;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getSelectPage() {
		return selectPage;
	}
	public void setSelectPage(String selectPage) {
		this.selectPage = selectPage;
	}
			
}