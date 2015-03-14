package com.itwill.board;

import java.sql.SQLException;
import java.util.ArrayList;

import com.itwill.util.ListPageConfigBean;
import com.itwill.util.ListResultBean;
import com.itwill.util.PageCounter;

public class BoardManager {
	private static BoardManager _instance;
	private BoardManager() {
		System.out.println("BoardManager생성자");
	}

	public static BoardManager instance() {
		if(_instance==null){
			_instance=new BoardManager();
		}
		return _instance;
	}

	public int create(Board board) throws SQLException {
		return getBoardDAO().create(board);
	}

	public int createReply(Board board) throws SQLException {
		return getBoardDAO().createReply(board);
	}

	public int update(Board board) throws SQLException {
		return getBoardDAO().update(board);
		
	}

	public int remove(int boardNo) throws SQLException {
		boolean isExist=getBoardDAO().countReplay(getBoardDAO().findBoard(boardNo));
		System.out.println(isExist+":답글~~~~~~~~~~~~~~~~~");
		return getBoardDAO().remove(boardNo);
		
	}

	public Board findBoard(int boardNo) throws SQLException {

		return getBoardDAO().findBoard(boardNo);
	}

	public ListResultBean findBoardList(ListPageConfigBean pageConfig)
			throws SQLException {
		// 전체 글의 갯수
		int recordCount = getBoardDAO().getBoardCount();
		// 페이징 처리 관련 정보 설정
		ListResultBean listResultBean = null;
		listResultBean = PageCounter.getPagingInfo(
				Integer.parseInt(pageConfig.getSelectPage()),
				pageConfig.getRowCount(), pageConfig.getPagingCount(),
				recordCount);

		ArrayList<Board> boardList = getBoardDAO().findBoardList(
				listResultBean.getStartRowNum(), listResultBean.getEndRowNum());
		listResultBean.setList(boardList);
		//System.out.println(listResultBean.getList().size());
		return listResultBean;
	}

	public void updateHitCount(int boardNo) throws SQLException {
		getBoardDAO().increaseReadCount(boardNo);
	}

	public int getTotalNo() throws SQLException {
		return getBoardDAO().getBoardCount();
		
	}

	private BoardDao getBoardDAO() {
		return BoardDao.instance();
	}
}
