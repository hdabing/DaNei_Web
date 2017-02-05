<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户信息</title>
</head>
<body>
<h2>修改用户信息</h2>
	<form action="<%=request.getContextPath()%>/JSP/modifyUser.do?id=${u.id}" method='post'>
			ID：${u.id}<br/>
			<!-- 需要用到id来由表单提交给服务器处理 -->
			<input type='hidden'  name='id' value='${u.id}'/>
			用户名：<input name='username'   value='${u.username}'/><br/>
			密&nbsp;码：<input type="password" name='password'  value='${u.password}'/><br/>
			真实名：<input  name='truename'   value='${u.truename}'/><br/>
			性&nbsp;别：<input name='sex'   value='${u.sex}'/><br/>
			<input type='submit' value='确定'/>
			
	</form>
		<a href='<%=request.getContextPath()%>/userList.do'>返回用户列表</a>

</body>
</html>