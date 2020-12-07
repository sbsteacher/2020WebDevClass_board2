package com.koreait.board2;

import java.util.List;

import com.koreait.board2.db.BoardDAO;
import com.koreait.board2.model.BoardVO;

public class BoardService {
	public static BoardVO selBoard(BoardVO param) {
		return BoardDAO.selBoard(param);
	}
	
	public static List<BoardVO> selBoardList(BoardVO param) {		
		return BoardDAO.selBoardList(param);
	}
	
	public static int regmod(BoardVO param) {
		if(param.getI_board() > 0) { //수정
			//TODO 수정 처리
			return 0;
		} 
		return BoardDAO.insBoard(param);		
	}
	
	public static int delBoard(BoardVO param) {
		return BoardDAO.delBoard(param);
	}
}
