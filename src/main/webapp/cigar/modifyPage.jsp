<%@ page language="java" contentType="text/html; charset=UTF-8"
import="cigar.*"
    pageEncoding="UTF-8"%>
<%
	String idStr = request.getParameter("id");
	if(idStr == null){
		response.sendRedirect("../index.jsp");
	}else{
	CigarService service = new OracleCigarService(new OracleCigarDAO());
	Cigar cigar = service.read(Integer.parseInt(idStr));
		if(cigar == null){
			response.sendRedirect("../index.jsp");
		}else{
				
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 정보 수정 페이지</title>
</head>
<body>
<%@ include file = "../common/header.jsp" %> 
	<h3>상품 정보 수정</h3>
	<form action="modify.jsp" method="post">
		<input type="hidden" name="id" value="<%= cigar.getCigarId() %>">
		<input type="text" name="name" value="<%=cigar.getName() %>" placeholder="상품명"><br>
		<input type="text" name="tar" value="<%=cigar.getTar() %>" placeholder="타르함유"><br>
		<input type="text" name="nico" value="<%=cigar.getNicotine() %>" placeholder="니코틴함유"><br>
		<input type="text" name="price" value="<%=cigar.getPrice() %>" placeholder="가격"><br>
		<br>
		<input type="submit" value="정보 수정">
		<a href="detailPage.jsp?id=<%=cigar.getCigarId()%>"><input type="button" value="취소"></a>
	</form>
<%@ include file = "../common/footer.jsp" %> 	
</body>
</html>
<% 		}
	}
		%>