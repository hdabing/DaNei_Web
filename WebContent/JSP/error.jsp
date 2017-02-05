<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>error错误提示页面</title>
</head>
<body>
	<!-- 后面已经采用将异常抛给容器的方式 -->
	<!-- 转发的方式处理异常 -->
	<%-- <%	
		//getAttribute获取对应的绑定名
		String msg=
		(String) request.getAttribute("error_msg");
	%>
	<%=msg %> --%>
	<!-- 等价于下面 -->
	${error_msg}
</body>
</html>