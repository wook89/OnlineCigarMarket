<%@ page language="java" contentType="text/html; charset=UTF-8"
import="cigar.*"
    pageEncoding="UTF-8"%>
<%
	String idStr = request.getParameter("id");
	if(idStr == null){
		response.sendRedirect("../index.jsp");
	}else{
		CigarService service = new OracleCigarService(new OracleCigarDAO());
		if(service.remove(Integer.parseInt(idStr))){
			response.sendRedirect("../index.jsp");
		}else{
			response.sendRedirect("detailPage.jsp?id="+idStr);
		}
	}
%>    
