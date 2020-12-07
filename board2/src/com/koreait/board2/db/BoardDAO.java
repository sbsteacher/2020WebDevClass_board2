package com.koreait.board2.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board2.model.BoardVO;

public class BoardDAO {
	public static BoardVO selBoard(final BoardVO param) {
		BoardVO vo = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT i_board, title, ctnt, r_dt "
				+ " FROM t_board_? "
				+ " WHERE i_board = ? ";		
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getTyp());
			ps.setInt(2, param.getI_board());
			
			rs = ps.executeQuery();
			if(rs.next()) {
				vo = new BoardVO();
				vo.setI_board(param.getI_board());
				vo.setTyp(param.getTyp());
				vo.setTitle(rs.getNString("title"));
				vo.setCtnt(rs.getNString("ctnt"));
				vo.setR_dt(rs.getString("r_dt"));
			}
			
		} catch (Exception e) {			
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps, rs);
		}
		
		
		
		return vo;
	}
	
	
	public static List<BoardVO> selBoardList(final BoardVO param) {
		List<BoardVO> list = new ArrayList();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT i_board, title, r_dt "
				+ " FROM t_board_? "
				+ " ORDER BY i_board DESC ";
		
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
				//vo.setCtnt(rs.getNString("ctnt"));
				vo.setR_dt(rs.getString("r_dt"));
			}			
			
		} catch (Exception e) {		
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps, rs);
		}		
		return list;
	}
	
	public static int insBoard(final BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = " INSERT INTO t_board_? "
				+ " (title, ctnt) "
				+ " VALUES "
				+ " (?, ?) ";
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getTyp());
			ps.setNString(2, param.getTitle());
			ps.setNString(3, param.getCtnt());
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps);
		}
		return 0;
	}
	
	public static int delBoard(final BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = " DELETE FROM t_board_? "
				+ " WHERE i_board = ? ";
		try {
			con = DbUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getTyp());
			ps.setInt(2, param.getI_board());			
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtils.close(con, ps);
		}
		return 0;
	}
	
}
