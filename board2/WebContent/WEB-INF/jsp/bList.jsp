<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<div>
	<div>
		<a href="/bRegmod?typ=${typ}"><button>글쓰기</button></a>
	</div>
	<table>
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성일</td>
		</tr>		
		<c:forEach items="${list}" var="item">
			<tr>
				<td>${item.i_board}</td>
				<td>
					<a href="/bDetail?i_board=${item.i_board}">
						${item.title}
					</a>
				</td>
				<td>${item.r_dt}</td>
			</tr>
		</c:forEach>
	</table>
</div>