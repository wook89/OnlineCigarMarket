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
<%@ include file = "../common/header.jsp" %> 
<title>상품 삭제 페이지</title>
</head>
<body>
	<h3>상품 삭제</h3>
		<ul>
				<li>상품ID : <%= cigar.getCigarId() %> </li>
				<li>상품명 : <%= cigar.getName() %> </li>
				<li>타르 함유 : <%= cigar.getTar() %> </li>
				<li>니코틴 함유 : <%= cigar.getNicotine() %> </li>
				<li>가격 : <%= cigar.getPrice() %> </li>
			</ul>
			<br>
			<a href="remove.jsp?id=<%=cigar.getCigarId()%>"><button>삭제</button></a>
			<a href="detailPage.jsp?id=<%=cigar.getCigarId()%>"><button>취소</button></a>
<%@ include file = "../common/footer.jsp" %> 			
</body>
</html>

<% 		}
	}
		%>