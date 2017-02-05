<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>统计在线人数</title>
</head>
<body>
	当前系统的在线人数是：
	<%=application.getAttribute("count")%>个！
	<br />
	<!-- <a href="<%=request.getContextPath()%>/logout">退出</a>
	//退出，销毁session，再创建一个servlet实现即可，下面是主要代码
	HttpSession session_logout = request.getSession(); 
	//销毁session 
	session_logout.invalidate();  -->
	<br /> JSP注释方式1：
	<!-- <%=new Date()%> -->
	<br /> JSP注释方式2：
	<%--
	<%=new Date()%>
	--%>
	<br />请查看源代码！

</body>
</html>