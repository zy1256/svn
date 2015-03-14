package com.itwill.util;

import java.util.*;

import com.itwill.board.Board;

// ����Ʈ ���������� ��¿� �ʿ��� ���̺� ������ �� ����¡ ó���� �ʿ��� ������
public class ListResultBean {
	private List<Board> list; // ����Ʈ ������ �ݷ���
	private int startPageNo; // ������������ȣ
	private int endPageNo; // ����������ȣ
	private int selectPageNo; // ������������ȣ
	private int rowCount; // ��ü ���
	private int pageCount; // ��ü ��������
	private int previousGroupStartPageNo; // �����׷��� ������������ȣ
	private int nextGroupStartPageNo; // �����׷��� ������������ȣ

	private boolean showPrevious; // ���������� ���̱� ����
	private boolean showNext; // ���������� ���̱� ����
	private boolean showPreviousGroup; // �����׷� ���̱� ����
	private boolean showNextGroup; // �����׷� ���̱� ����
	private boolean showFirst; // ó������ ���̱� ����
	private boolean showLast; // ���������� ���̱� ����

	// DB ���� ����� ���� ����
	private int startRowNum;
	private int endRowNum;

	public ListResultBean() {
	}

	public ListResultBean(List<Board> list, int startPageNo, int endPageNo,
			int selectPageNo, int rowCount, int pageCount,
			int previousGroupStartPageNo, int nextGroupStartPageNo,
			boolean showPrevious, boolean showNext, boolean showPreviousGroup,
			boolean showNextGroup, boolean showFirst, boolean showLast,
			int startRowNum, int endRowNum) {
		this.list = list;
		this.startPageNo = startPageNo;
		this.endPageNo = endPageNo;
		this.selectPageNo = selectPageNo;
		this.rowCount = rowCount;
		this.pageCount = pageCount;
		this.previousGroupStartPageNo = previousGroupStartPageNo;
		this.nextGroupStartPageNo = nextGroupStartPageNo;
		this.showPrevious = showPrevious;
		this.showNext = showNext;
		this.showPreviousGroup = showPreviousGroup;
		this.showNextGroup = showNextGroup;
		this.showFirst = showFirst;
		this.showLast = showLast;
		this.startRowNum = startRowNum;
		this.endRowNum = endRowNum;
	}

	public int getEndPageNo() {
		return endPageNo;
	}

	public void setEndPageNo(int endPageNo) {
		this.endPageNo = endPageNo;
	}

	public List<Board> getList() {
		return list;
	}

	public void setList(List<Board> list) {
		this.list = list;
	}

	public int getNextGroupStartPageNo() {
		return nextGroupStartPageNo;
	}

	public void setNextGroupStartPageNo(int nextGroupStartPageNo) {
		this.nextGroupStartPageNo = nextGroupStartPageNo;
	}

	public int getPageCount() {
		System.out.println("get>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
				+ pageCount);
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		System.out.println("set>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"
				+ pageCount);
		this.pageCount = pageCount;
	}

	public int getPreviousGroupStartPageNo() {
		return previousGroupStartPageNo;
	}

	public void setPreviousGroupStartPageNo(int previousGroupStartPageNo) {
		this.previousGroupStartPageNo = previousGroupStartPageNo;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public int getSelectPageNo() {
		return selectPageNo;
	}

	public void setSelectPageNo(int selectPageNo) {
		this.selectPageNo = selectPageNo;
	}

	public boolean isShowFirst() {
		return showFirst;
	}

	public void setShowFirst(boolean showFirst) {
		this.showFirst = showFirst;
	}

	public boolean isShowLast() {
		return showLast;
	}

	public void setShowLast(boolean showLast) {
		this.showLast = showLast;
	}

	public boolean isShowNext() {
		return showNext;
	}

	public void setShowNext(boolean showNext) {
		this.showNext = showNext;
	}

	public boolean isShowNextGroup() {
		return showNextGroup;
	}

	public void setShowNextGroup(boolean showNextGroup) {
		this.showNextGroup = showNextGroup;
	}

	public boolean isShowPrevious() {
		return showPrevious;
	}

	public void setShowPrevious(boolean showPrevious) {
		this.showPrevious = showPrevious;
	}

	public boolean isShowPreviousGroup() {
		return showPreviousGroup;
	}

	public void setShowPreviousGroup(boolean showPreviousGroup) {
		this.showPreviousGroup = showPreviousGroup;
	}

	public int getStartPageNo() {
		return startPageNo;
	}

	public void setStartPageNo(int startPageNo) {
		this.startPageNo = startPageNo;
	}

	public int getEndRowNum() {
		return endRowNum;
	}

	public void setEndRowNum(int endRowNum) {
		this.endRowNum = endRowNum;
	}

	public int getStartRowNum() {
		return startRowNum;
	}

	public void setStartRowNum(int startRowNum) {
		this.startRowNum = startRowNum;
	}

}
