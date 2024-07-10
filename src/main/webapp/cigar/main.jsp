<%@ page language="java" contentType="text/html; charset=UTF-8"
import = "java.util.*"
import = "cigar.*"
    pageEncoding="UTF-8"%>
<%
	CigarService service = new OracleCigarService(new OracleCigarDAO());
	List<Cigar> cigarList = service.listAll();
	cigarList.sort(Comparator.comparing(j-> j.getCigarId()));
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품관리 메인 페이지</title>
<style>
	table{
		border-collapse : collapse;
		text-align : center;
	}
	td{
		padding : 5px;
	}
</style>
</head>
<body>
<%@ include file = "../common/header.jsp" %> 
<h3>상품목록</h3>
	<a href="registPage.jsp"><button>상품등록</button></a><br>
	<br>
	<%if(cigarList.size() == 0){ %>
		<p>등록되어있는 상품이 없습니다.</p>	
		<% }else{ %>
		<table border=1>
			<tr><th>상품ID</th><th>이름</th><th>타르함유</th><th>니코틴함유</th><th>가격</th></tr>
			<% for(Cigar cigar : cigarList) { %>
				<tr>
					<td><%= cigar.getCigarId() %></td>
					<td><a href="detailPage.jsp?id=<%=cigar.getCigarId()%>"><%= cigar.getName() %></a></td>
					<td><%= cigar.getTar()%></td>
					<td><%= cigar.getNicotine()%></td>
					<td><%= String.format("%,d",cigar.getPrice())%>원</td>
				</tr>
			<%} %>
		</table>
		<%} %>
<%@ include file = "../common/footer.jsp" %> 		
</body>
</html>