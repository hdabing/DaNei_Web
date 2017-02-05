<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>验证码</title>
</head>
<body>
	<h1>验证码测试</h1>
	<br> 
	//直接访问http://localhost:8080/DaNei_Web/JSP/Checkcode.jsp，src即可链接到CheckcodeServlet
	<img alt="" src="../Checkcode" border="1px" 
		      onclick="this.src='checkcode'+Math.random();"/>
		<br />
</body>
</html>