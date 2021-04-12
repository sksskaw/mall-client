<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="mall.client.vo.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
	<h1>index</h1>
	<%
		List<Ebook> ebookList = (List<Ebook>)request.getAttribute("ebookList");
	%>
	
	<table border="1">
		<tr>
		<%
			int i = 0; //5줄마다 칸을 띄우기 위해 내부 반복문 연산자
			for(Ebook ebook : ebookList){
				i++;
		%>
				<td>
					<div><img src="<%=request.getContextPath()%>/img/default.jpg"></div>
					<div>제목 : <%=ebook.getEbookTitle()%></div>
					<div>가격 : <%=ebook.getEbookPrice()%>￦</div>
				</td>
			<%
				if(i%5==0){
			%>
		</tr>
		
		<tr>
			<%		
				}
			%>		
				
		<%
			}
		%>
		</tr>
	</table>
</body>
</html>