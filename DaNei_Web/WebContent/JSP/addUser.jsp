<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/addUser.do" method="post">
		<fieldset>
			<legend>添加用户</legend>
			用户名：
			<input name="usrename" />
			<br> 密&nbsp;&nbsp;&nbsp;码：
			<input type="password" name="password" />
			<br> 真实名：
			<input name="truename" />
			<br> 性&nbsp;&nbsp;&nbsp;别：
			<input name="sex" />
			<br>
			<input type="submit" value="确定" />
		</fieldset>
	</form>
	<a href='<%=request.getContextPath()%>/userList.do'>返回用户列表</a>
</body>
</html>