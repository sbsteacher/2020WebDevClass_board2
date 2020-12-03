package com.koreait.board2.db;

import java.util.ArrayList;
import java.util.List;

import com.koreait.board2.model.BoardVO;

public class BoardDAO {
	public static List<BoardVO> selBoardList(BoardVO vo) {
		List<BoardVO> list = new ArrayList();
		
		String sql = " SELECT i_board, title, ctnt, r_dt "
				+ " FROM t_board_? ";
		
		
		ps.setInt(1, vo.getTyp());
		
		return list;
	}
}
