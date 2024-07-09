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
<title>Online Cigarette Market</title>
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
<h3>상품목록</h3>
	
	<br>
	<%if(cigarList.size() == 0){ %>
		<p>등록되어있는 상품이 없습니다.</p>	
		<% }else{ %>
		<table border=1>
			<tr><th>상품ID</th><th>이름</th><th>타르함유</th><th>니코틴함유</th><th>가격</th></tr>
			<% for(Cigar cigar : cigarList) { %>
				<tr>
					<td><%= cigar.getCigarId() %></td>
					<td><a href="<%= request.getContextPath() %>/book/detailPage.jsp?id=<%=cigar.getCigarId()%>"><%= cigar.getName() %></a></td>
					<td><%= cigar.getTar()%></td>
					<td><%= cigar.getNicotine()%></td>
					<td><%= String.format("%,d",cigar.getPrice())%>원</td>
				</tr>
			<%} %>
		</table>
		<%} %>
</body>
</html>