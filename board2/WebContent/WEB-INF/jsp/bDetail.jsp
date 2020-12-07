<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div>
	<a href="/bList?typ=${data.typ}">돌아가기</a>
	<div>
		<div>번호 : ${data.i_board}</div>
		<div>제목 : ${data.title}</div>
		<div>작성일 : ${data.r_dt}</div>
		<div>
			${data.ctnt}
		</div>
	</div>
</div>