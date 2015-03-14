package com.itwill.util;
//����¡ ó����  �ʿ��� ���� ��� ��ƿ Ŭ����
public class PageCounter{	
	public static ListResultBean getPagingInfo(int sPage, int rCount, int pCount, int recordCount){
		ListResultBean resultBean = new ListResultBean();
		int totalPageCount = 1;    // ��ü��������
		int startPageNo = 1;        // ���������� ��ȣ
		int endPageNo = 1;         // �� ȭ��(�׷�)���� �������� ��ȣ
		int selectPageNo = 1;      // ���õ� ������ ��ȣ
		int previousStartNo = 1;  // ���� �׷��� ���������� ��ȣ
		int nextStartNo = 1;        // ���� �׷��� ����������
		int groupNo = 0;           // �������� �׷�ѹ�
		
		// DB Query ��������� ����..
		int startRow = 0; // ���° ���ڵ����..
		int endRow   = 0; // ���° ���ڵ����..
		
		
		//**********  DB ���ڵ���� ���� ���  *********************
		// ��ü �������� ���
		int modula = 0;
		if (recordCount > 1){ //1�� �̻��� ���ڵ尡 �����ϸ�...
			modula = (recordCount) % rCount;
			if (modula != 0){//�������� 2, 3, 4, 5,...., 9�̸�
				modula = 1;
			}else{// �������� 0�̸�(�� ��������)
				modula = 0;
			}		
			totalPageCount = (recordCount)/rCount + modula;
		}else{
			totalPageCount = 1;
		}		

		
		// �� ȭ��(�׷�)���� ������������ �������� �׸��� ���� �׷��� ������������ ��������, �׷�ѹ�
		// ����ڰ� ��������ȣ�� ������ ������ ������ ����� �ٸ���.
		selectPageNo = sPage;		
		groupNo = (selectPageNo-1)/pCount;
		// ���� pCount�� 10���� �����Ͽ��� ���
		/* 1 ~10 --> 0
		   11~20 --> 1
		   21~30 --> 2
		   .....
		 */		
		startPageNo = groupNo*pCount + 1;
		endPageNo   = groupNo*pCount+pCount;
		previousStartNo = startPageNo - pCount;		
		if(previousStartNo < 0){// groupNo�� 0�� ���(������ �ε����� 0~10����)
			previousStartNo = 0;
		}
		
		nextStartNo     = startPageNo + pCount;
		
		if (startPageNo > totalPageCount)   startPageNo = startPageNo - pCount + 1;
		if (endPageNo > totalPageCount)     endPageNo = totalPageCount;
	  
		
		if (selectPageNo == 1 && selectPageNo == totalPageCount){// 1�������ΰ��..
			startRow=1;
			endRow = recordCount;
		}else if (selectPageNo < totalPageCount){
			startRow=rCount*selectPageNo-rCount + 1;
			endRow = rCount*selectPageNo-rCount + rCount;
		}else if ( selectPageNo == totalPageCount){ // ���������ΰ��..
			startRow=rCount * selectPageNo - rCount + 1;
			endRow = recordCount;
		}
		// ����¡ó���� �ʿ��� ������ ListResultBean�� ����
		resultBean.setStartPageNo(startPageNo);
		resultBean.setEndPageNo(endPageNo);
		resultBean.setSelectPageNo(selectPageNo);
		resultBean.setRowCount(recordCount);
		resultBean.setPageCount(totalPageCount);
		resultBean.setPreviousGroupStartPageNo(previousStartNo);
		resultBean.setNextGroupStartPageNo(nextStartNo);
		resultBean.setStartRowNum(startRow);
		resultBean.setEndRowNum(endRow);
		resultBean.setShowPrevious(isShowPreviousIcon(selectPageNo));
		resultBean.setShowNext(isShowNextIcon(selectPageNo, totalPageCount));
		resultBean.setShowPreviousGroup(isShowPreviousMoreIcon(groupNo,totalPageCount));
		resultBean.setShowNextGroup(isShowNextMoreIcon(endPageNo,totalPageCount));
		resultBean.setShowFirst(isShowFirstIcon(groupNo,totalPageCount));
		resultBean.setShowLast(isShowLastIcon(endPageNo,totalPageCount));
		return resultBean;				
	}
	// �������� [����������] ��¿��θ� �Ǵ��ϴ� �޼ҵ�
	  public static boolean isShowPreviousIcon(int sPage){
		boolean isShow = false;	
		if (sPage > 1) isShow = true;
		return isShow;

	  }

	  // �������� [����������] ��¿��θ� �Ǵ��ϴ� �޼ҵ�
	  public static boolean isShowNextIcon(int sPage,int pCount){
		  boolean isShow = false;
		  if (sPage < pCount) isShow = true;
		  return isShow;
	  }	  

	  // �������� [���� �׷�] ��¿��θ� �Ǵ��ϴ� �޼ҵ�
	  public  static boolean isShowPreviousMoreIcon(int sPage,int pCount) {
		  // 3, 14
		  boolean isShow = false;
		  int modula = 0;
		  modula = sPage % pCount;
		  if (modula !=0 ) modula = 1;		  
		  if ((sPage / pCount + modula) >0) {
			  isShow =true;
		  }else{
			  isShow = false;
		  }
		 		  
		  return isShow;
	  }
	  

	  // �������� [���� �׷�] ��¿��θ� �Ǵ��ϴ� �޼ҵ�
	  public  static boolean isShowNextMoreIcon(int ePage,int pCount) {
			if (ePage < pCount) 
				return true;
			else 
				return false;
	  }
	  
//	 �������� [ó������] ������ ��¿��θ� �Ǵ��ϴ� �޼ҵ�
	  public  static boolean isShowFirstIcon(int sPage,int pCount){
			int modula = 0;
			modula = sPage % pCount;
			if (modula!=0) modula = 1;
			if ((sPage / pCount + modula) > 0) 
				return true;
			else 
				return false;
			  
	  }  

	  // �������� [����������] ������ ��¿��θ� �Ǵ��ϴ� �޼ҵ�
	  public  static boolean isShowLastIcon(int ePage,int pCount) {
			if (ePage < pCount) 
				return true;
			else 
				return false;
	  } 
	  // �׽�Ʈ ����
	  public static void main(String[] args) {
		  ListResultBean bean = PageCounter.getPagingInfo(15, 10, 10, 301);
		  System.out.println(bean.getPageCount());
		  System.out.println(bean.getNextGroupStartPageNo());
		  System.out.println(bean.isShowPrevious());
		  System.out.println(bean.isShowNext());
	}
	  
	  
 }