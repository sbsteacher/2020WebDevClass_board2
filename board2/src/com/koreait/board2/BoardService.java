package com.koreait.board2;

import java.util.List;

import com.koreait.board2.db.BoardDAO;
import com.koreait.board2.model.BoardVO;

public class BoardService {	
	public static List<BoardVO> selBoardList(BoardVO param) {
		return BoardDAO.selBoardList(param);
	}
}
