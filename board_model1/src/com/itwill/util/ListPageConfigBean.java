package com.itwill.util;

// 리스트 페이지 관련 사용자 설정을 위한 빈
public class ListPageConfigBean{
	
	private int rowCount;          // 테이블(리스트)당 출력 행수
	private int pagingCount;       // 한페이지에 보여지는 페이지 수
	private String selectPage;     // 선택한 현재 페이지 번호
	private String searchType;     // 사용자 선택 검색타입
	private String searchContent;  // 사용자 입력 검색내용
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