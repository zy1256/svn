package com.itwill.util;
//페이징 처리에  필요한 정보 계산 유틸 클래스
public class PageCounter{	
	public static ListResultBean getPagingInfo(int sPage, int rCount, int pCount, int recordCount){
		ListResultBean resultBean = new ListResultBean();
		int totalPageCount = 1;    // 전체페이지수
		int startPageNo = 1;        // 시작페이지 번호
		int endPageNo = 1;         // 한 화면(그룹)에서 끝페이지 번호
		int selectPageNo = 1;      // 선택된 페이지 번호
		int previousStartNo = 1;  // 이전 그룹의 시작페이지 번호
		int nextStartNo = 1;        // 다음 그룹의 시작페이지
		int groupNo = 0;           // 페이지별 그룹넘버
		
		// DB Query 성능향상을 위해..
		int startRow = 0; // 몇번째 레코드부터..
		int endRow   = 0; // 몇번째 레코드까지..
		
		
		//**********  DB 레코드수에 따른 계산  *********************
		// 전체 페이지수 계산
		int modula = 0;
		if (recordCount > 1){ //1개 이상의 레코드가 존재하면...
			modula = (recordCount) % rCount;
			if (modula != 0){//나머지가 2, 3, 4, 5,...., 9이면
				modula = 1;
			}else{// 나머지가 0이면(딱 떨어지면)
				modula = 0;
			}		
			totalPageCount = (recordCount)/rCount + modula;
		}else{
			totalPageCount = 1;
		}		

		
		// 한 화면(그룹)에서 시작페이지와 끝페이지 그리고 이전 그룹의 시작페이지와 끝페이지, 그룹넘버
		// 사용자가 페이지번호를 선택할 때마다 각각의 결과값 다르다.
		selectPageNo = sPage;		
		groupNo = (selectPageNo-1)/pCount;
		// 만일 pCount를 10으로 설정하였을 경우
		/* 1 ~10 --> 0
		   11~20 --> 1
		   21~30 --> 2
		   .....
		 */		
		startPageNo = groupNo*pCount + 1;
		endPageNo   = groupNo*pCount+pCount;
		previousStartNo = startPageNo - pCount;		
		if(previousStartNo < 0){// groupNo이 0인 경우(페이지 인덱스가 0~10사이)
			previousStartNo = 0;
		}
		
		nextStartNo     = startPageNo + pCount;
		
		if (startPageNo > totalPageCount)   startPageNo = startPageNo - pCount + 1;
		if (endPageNo > totalPageCount)     endPageNo = totalPageCount;
	  
		
		if (selectPageNo == 1 && selectPageNo == totalPageCount){// 1페이지인경우..
			startRow=1;
			endRow = recordCount;
		}else if (selectPageNo < totalPageCount){
			startRow=rCount*selectPageNo-rCount + 1;
			endRow = rCount*selectPageNo-rCount + rCount;
		}else if ( selectPageNo == totalPageCount){ // 끝페이지인경우..
			startRow=rCount * selectPageNo - rCount + 1;
			endRow = recordCount;
		}
		// 페이징처리에 필요한 정보를 ListResultBean에 세팅
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
	// 페이지에 [이전페이지] 출력여부를 판단하는 메소드
	  public static boolean isShowPreviousIcon(int sPage){
		boolean isShow = false;	
		if (sPage > 1) isShow = true;
		return isShow;

	  }

	  // 페이지에 [다음페이지] 출력여부를 판단하는 메소드
	  public static boolean isShowNextIcon(int sPage,int pCount){
		  boolean isShow = false;
		  if (sPage < pCount) isShow = true;
		  return isShow;
	  }	  

	  // 페이지에 [이전 그룹] 출력여부를 판단하는 메소드
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
	  

	  // 페이지에 [다음 그룹] 출력여부를 판단하는 메소드
	  public  static boolean isShowNextMoreIcon(int ePage,int pCount) {
			if (ePage < pCount) 
				return true;
			else 
				return false;
	  }
	  
//	 페이지에 [처음으로] 아이콘 출력여부를 판단하는 메소드
	  public  static boolean isShowFirstIcon(int sPage,int pCount){
			int modula = 0;
			modula = sPage % pCount;
			if (modula!=0) modula = 1;
			if ((sPage / pCount + modula) > 0) 
				return true;
			else 
				return false;
			  
	  }  

	  // 페이지에 [마지막으로] 아이콘 출력여부를 판단하는 메소드
	  public  static boolean isShowLastIcon(int ePage,int pCount) {
			if (ePage < pCount) 
				return true;
			else 
				return false;
	  } 
	  // 테스트 메인
	  public static void main(String[] args) {
		  ListResultBean bean = PageCounter.getPagingInfo(15, 10, 10, 301);
		  System.out.println(bean.getPageCount());
		  System.out.println(bean.getNextGroupStartPageNo());
		  System.out.println(bean.isShowPrevious());
		  System.out.println(bean.isShowNext());
	}
	  
	  
 }