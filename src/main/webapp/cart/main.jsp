<%@page 
import="cart.*"
import="cigar.*"
import="java.util.*"
%>
<%@ include file="/common/isLoggedIn.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	CartService cartService = new CigarCartService(new OracleCartDAO());
	List<CartItem> itemList = cartService.listAll(memberNo);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
<style>
	input[type="number"] {
		width:2em
	}
	form {
		display : inline;
	}
	td,th{
		border : solid black 1px;
		border-collapse : collapsed;
	}
</style>
</head>
<body>
<%@ include file ="/common/header.jsp" %>
<h3>장바구니</h3>
	<% if(itemList.size()==0){ %>
	<p>장바구니가 비어있습니다.</p>		
<% 	}else{ 
	CigarService cigarService = new OracleCigarService(new OracleCigarDAO());
	%>
		<table>
			<tr><th>No.</th><th>책아이디</th><th>제목</th><th>저자</th><th>가격</th></tr>
			<% int numItems = 0, totalPrice =0; 
			for(CartItem item : itemList){ 
			Cigar cigar = cigarService.read(item.getCigarId());
			numItems+=item.getQuantity();
			totalPrice += cigar.getPrice()*item.getQuantity();
			%>
			<tr><td><%= item.getCartId() %></td>
				<td><%= item.getCigarId() %></td>
				<td><%= cigar.getName() %></td>
				<td><%= String.format("%,d",cigar.getPrice()) %>원</td>
				<td><form action ="<%= request.getContextPath()%>/cart/update.jsp" method="post" onsumbmit="return isValidForm()">
						<input type="hidden" name="id" value="<%= item.getCartId() %>">
						<input type="number" name="quantity" value="<%= item.getQuantity() %>">
						<input type="submit" value="수정">
					</form> 
					<button onclick="askConfirmRemove(<%= item.getCartId()%>)">삭제</button>
				</td>
			</tr>
			<% } %>	
		</table>
		<br>
		<p>총 상품가격 : <%= String.format("%,d",totalPrice) %>원 (총 <%= numItems %>품목)</p>
		<button onclick="askConfirmOrder()">주문하기</button>
		<button onclick="askConfirmClear()">장바구니 비우기</button>
	<% }
	%>
		<script>
			function askConfirmOrder(){
				if(confirm("장바구니의 모든 상품을 주문합니다."))
					location = "<%= request.getContextPath()%>/order/orderPage.jsp";
			}
			function askConfirmClear(){
				if(confirm("장바구니의 모든 상품을 삭제합니다."))
					location = "<%= request.getContextPath()%>/cart/clear.jsp";
			}
			function askConfirmRemove(cartId){
				if(confirm(cartId+"행의 상품을 장바구니에서 삭제합니다."))
					location = "<%= request.getContextPath()%>/cart/remove.jsp?id="+cartId;
			}
			function isValidForm(){
				return false;
			}
		</script>	
<%@ include file ="/common/footer.jsp" %>
</body>
</html>










