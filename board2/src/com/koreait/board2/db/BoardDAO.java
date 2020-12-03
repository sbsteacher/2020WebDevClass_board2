package com.koreait.board2.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board2.model.BoardVO;

public class BoardDAO {
	public static List<BoardVO> selBoardList(final BoardVO param) {
		List<BoardVO> list = new ArrayList();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT i_board, title, ctnt, r_dt "
				+ " FROM t_board_? ";
		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);			
			ps.setInt(1, param.getTyp());
			rs = ps.executeQuery();
			
			BoardVO vo = null;
			while(rs.next()) {
				vo = new BoardVO();				
				list.add(vo);
				
				vo.setI_board(rs.getInt("i_board"));
				vo.setTitle(rs.getNString("title"));
				vo.setCtnt(rs.getNString("ctnt"));
				vo.setR_dt(rs.getString("r_dt"));
			}			
			
		} catch (Exception e) {		
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps, rs);
		}		
		return list;
	}
}
