<%@ page language="java" contentType="text/html; charset=UTF-8"
import="cart.*"
    pageEncoding="UTF-8"%>
<%@ include file="/common/isLoggedIn.jsp" %>
<% 
	CartService service = new CigarCartService(new OracleCartDAO());
	String cigarId = request.getParameter("cigarId");
	if(cigarId == null || cigarId.isEmpty()){
		response.sendRedirect(request.getContextPath()+"/common/errorPage.jsp?cigarIdErr=1");
		return;
	}
	if(service.add(new CartItem(memberNo,Integer.parseInt(cigarId), 1))){
		response.sendRedirect(request.getContextPath()+"/cart/main.jsp");
	}else{
		response.sendRedirect(request.getContextPath()+"/common/errorPage.jsp?cigarAddErr=1");
	}
%> 