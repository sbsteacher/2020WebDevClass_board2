package com.koreait.board2;

import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.koreait.board2.db.BoardDAO;
import com.koreait.board2.model.BoardVO;

public class BoardService {
	
	public static int selPageCnt(BoardVO param) {
		return BoardDAO.selPageCnt(param);
	}
	
	public static BoardVO detail(BoardVO param, HttpServletRequest request) {
		
		System.out.println(request.getClass().getName());
		String ip = request.getRemoteAddr();
		System.out.println("ip : " + ip);
		
		String key = String.format("b_%d_%d", param.getTyp(), param.getI_board());
		
		ServletContext application = request.getServletContext();
		String savedIp = (String)application.getAttribute(key);
		
		if(!ip.equals(savedIp)) {
			application.setAttribute(key, ip);
			BoardDAO.addHits(param);
		}
		
		Enumeration<String> strArr = application.getAttributeNames();
		while(strArr.hasMoreElements()) {
			String str = strArr.nextElement();			
			if(str.startsWith("b_")) {
				System.out.println("key : " + str);	
				System.out.println("value : " + application.getAttribute(str));
			}
		}
		
		
		return selBoard(param);
	}
	
	public static BoardVO selBoard(BoardVO param) {
		return BoardDAO.selBoard(param);
	}
	
	public static List<BoardVO> selBoardList(BoardVO param) {		
		return BoardDAO.selBoardList(param);
	}
	
	public static int regmod(BoardVO param) {
		if(param.getI_board() > 0) { //수정			
			return BoardDAO.updBoard(param);
		} 
		return BoardDAO.insBoard(param);		
	}
	
	public static int delBoard(BoardVO param) {
		return BoardDAO.delBoard(param);
	}
}
