<%@page import="mall.client.vo.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 상단 메인 메뉴 -->
<%
	if(session.getAttribute("loginClient") == null){
%>
	<!-- 로그아웃 -->
	<form action="<%=request.getContextPath()%>/LoginController" method="post">
		ID : <input type="text" name="clientMail">
		PW : <input type="password" name="clientPw">
		<button type="submit">로그인</button>
	</form>
	<ul>
		<li><a href="<%=request.getContextPath()%>/InsertClientController">회원가입</a></li>
	</ul>
<%
	} else{
%>
	<!-- 로그인 -->
	<div>
		<div>
			<%=((Client)(session.getAttribute("loginClient"))).getClientMail()%>님 반갑습니다.
		</div>
		<ul>
			<li><a href="<%=request.getContextPath()%>/LogoutController">로그아웃</a></li>
			<li><a href="<%=request.getContextPath()%>/SelectOneClientController">회원정보</a></li>
			<li><a href="<%=request.getContextPath()%>/DeleteClientController">회원탈퇴</a></li>
			<li><a href="<%=request.getContextPath()%>/CartListController">장바구니</a></li>
		</ul>
	</div>
<%
	}
%>