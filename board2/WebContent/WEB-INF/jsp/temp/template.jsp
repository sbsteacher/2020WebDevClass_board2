<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title}</title>
<link rel="stylesheet" href="/res/css/common.css">
</head>
<body>
	<div id="container">
		<header>
			<ul>
				<li><a href="/bList?typ=1">게임</a></li>
				<li><a href="/bList?typ=2">스포츠</a></li>
				<li><a href="/bList?typ=3">연예/방송</a></li>
			</ul>
		</header>
		<section>
			<jsp:include page="${page}"/>
		</section>
		<footer>
		</footer>
	</div>
</body>
</html>