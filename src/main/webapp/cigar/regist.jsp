<%@ page language="java" contentType="text/html; charset=UTF-8"
import ="cigar.*"
    pageEncoding="UTF-8"%>
<%@ include file="/common/isAdminLogged.jsp" %>    
<!DOCTYPE html>
<%
	String name = request.getParameter("name");
	String tar = request.getParameter("tar");
	String nico = request.getParameter("nico");
	String price = request.getParameter("price");
	
	if(name ==null || tar ==null || nico ==null || price ==null){
		
		response.sendRedirect(request.getContextPath()+"/cigar/registPage.jsp?regError=1");	
		
	}else if(name == "" || tar == "" || nico =="" || price==""){
		
		response.sendRedirect(request.getContextPath()+"/cigar/registPage.jsp?regError=1");
	}else{
		CigarService service = new OracleCigarService(new OracleCigarDAO());
		Cigar cigar = new Cigar(name,tar,nico,Integer.parseInt(price));
		
		if(service.regist(cigar)){
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}else{
			response.sendRedirect(request.getContextPath()+"/cigar/registPage.jsp?regError=2");
		}
	}
%>  
