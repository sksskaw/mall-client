<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>cartList</title>
</head>          
<body>
	<jsp:include page="/WEB-INF/view/inc/mainMenu.jsp"></jsp:include>
	
	<h1>장바구니</h1>
	
	<!-- request객체에 담아둔 List 가져오기 -->
	<%
		List<Map<String, Object>> cartList = (List<Map<String, Object>>)request.getAttribute("cartList");
		int totalPrice = 0;
	%>
	
	<!-- 장바구니 정보 List 출력 -->
	<table border="1">
		<%
			for(Map<String, Object> list : cartList){
				totalPrice = totalPrice + Integer.parseInt((String)list.get("ebookPrice"));
		%>
			<tr>
				<td>
					<div><%=list.get("ebookNo")%></div>
					<div>제목 : <%=list.get("ebookTitle")%></div>
					<div>주문날자 : <%=list.get("cartDate")%></div>
				</td>
				<td>가격 : <%=list.get("ebookPrice")%></td>
			</tr>
		<%
			}
		%>
		
		<tr>
			<td></td>
			<td>총 금액 : <%=totalPrice%></td>
		</tr>
	</table>
</body>
</html>