<%@ page language="java" contentType="text/html; charset=UTF-8"
import="cigar.*"
    pageEncoding="UTF-8"%>
<%
	String idStr = request.getParameter("id");
	if(idStr == null || idStr.isEmpty()) {
		response.sendRedirect(request.getContextPath()+"/common/error.jsp?idError=1");
	}else{
		CigarService service = new OracleCigarService(new OracleCigarDAO());
		Cigar cigar = service.read(Integer.parseInt(idStr));
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세 페이지</title>
</head>
<body>
<%@ include file = "/common/header.jsp" %>
	<h3>상품 상세 정보</h3>
		<% 	if(cigar == null){ %>
			<p>해당 도서의 정보가 없습니다.</p>
	<% 	}else{ %>
			<ul>
				<li>상품ID : <%= cigar.getCigarId() %> </li>
				<li>상품명 : <%= cigar.getName() %> </li>
				<li>타르함유 : <%= cigar.getTar() %></li>
				<li>니코틴함유 : <%= cigar.getNicotine() %></li>
				<li>가격 : <%= cigar.getPrice() %> </li>
			</ul>
			<br>
		<% 
			if(session.getAttribute("AdminId") != null){ %>
				<a href="modifyPage.jsp?id=<%=cigar.getCigarId()%>"><button>상품정보수정</button></a>
				<a href="removePage.jsp?id=<%=cigar.getCigarId()%>"><button>상품 삭제</button></a>
			<%}else if(session.getAttribute("MemberId") != null){ %>
				<a href="<%= request.getContextPath() %>/cart/add.jsp?cigarId=<%=cigar.getCigarId()%>"><button>장바구니 담기</button></a>
			<% } %>
			<a href="<%= request.getContextPath() %>/index.jsp?"><button>상품 목록</button></a>
	<% } %>	
	<%@ include file = "/common/footer.jsp" %>
</body>
</html>
<% } %>