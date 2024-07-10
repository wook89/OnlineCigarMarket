<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록 페이지</title>
</head>
<body>
<%@ include file = "../common/header.jsp" %>

<%
	if(request.getParameter("regError") != null){
		out.print("상품 등록을 위해 아래의 정보를 모두 입력해주세요.");
	}
%>
	<h3>상품 등록</h3>
	<form action="regist.jsp" method="post">
		<input type="text" name="name" placeholder="상품명 입력"><br>
		<input type="text" name="tar" placeholder="타르함유량"><br>
		<input type="text" name="nico" placeholder="니코틴함유량"><br>
		<input type="text" name="price" placeholder="가격 입력"><br>
		<br>
		<input type="submit" value="등록">
		<a href="../index.jsp"><input type="button" value="취소"></a>
	</form>
<%@ include file = "../common/footer.jsp" %>	
</body>
</html>