<%@page import="java.awt.print.Printable"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
import="cigar.*"
    pageEncoding="UTF-8"%>
<%@ include file="/common/isAdminLogged.jsp" %>    
<%
System.out.println("오긴하냐 1");
	String idStr = request.getParameter("id");
	String name = request.getParameter("name");
	String tar = request.getParameter("tar");
	String nico = request.getParameter("nico");
	String price = request.getParameter("price");
	
	if(idStr == null){
		response.sendRedirect("../index.jsp");
	}
	else if(name ==null || tar ==null || nico==null || price ==null){
		response.sendRedirect("detailPage.jsp?id="+idStr);		
	}else{
		CigarService service = new OracleCigarService(new OracleCigarDAO());
		Cigar cigar = service.read(Integer.parseInt(idStr));
		
		cigar.setName(name);
		cigar.setTar(tar);
		cigar.setNicotine(nico);
		cigar.setPrice(Integer.parseInt(price));
			if(service.edit(cigar, name,tar,nico,Integer.parseInt(price))){
				
				response.sendRedirect("../index.jsp");
			}else{
				response.sendRedirect("modifyPage.jsp?no="+idStr);
			}
		}
%>  
