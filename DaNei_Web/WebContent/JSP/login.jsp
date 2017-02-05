<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
</head>
<body>
	<form action="login.do" method="post">
		用户名：
		<input type="text" name="name" />
		<br /> 密 &nbsp;&nbsp;码：
		<input type="password" name="passwd"/>
		<%-- <% 
			String msg=(String) request.getAttribute("login_failed");
			String checkcode_msg=(String) request.getAttribute("checkcode_error");
		%> --%>
		<br />
		验证码：<input type="text" name="checkcode"> 
		<br />
		<img alt="" src="../Checkcode" border="1px" 
		      onclick="this.src='checkcode'+Math.random();"/><br />
		<!-- 用户登录验证结果处理 -->
		<span style="color: red;">
		<c:choose>
			<c:when test="${login_failed}==null">" "</c:when>
			<c:otherwise>${login_failed}</c:otherwise>
		</c:choose>
		</span>
		<!-- 验证码验证结果处理 -->
		<span style="color: red;">
		<c:choose>
			<c:when test="${checkcode_error==null}==null">" "</c:when>
			<c:otherwise>${checkcode_error}</c:otherwise>
		</c:choose>
		</span>
		<br />
		<input type="submit" value="登录"> 
	</form>
</body>
</html>