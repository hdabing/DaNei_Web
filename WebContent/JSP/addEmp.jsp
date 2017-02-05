<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加员工</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/add.do" method="post">
		<fieldset>
			<legend>添加员工</legend>
			姓名：
			<input name="name" />
			<br> 薪水：
			<input name="salary" />
			<br> 年龄：
			<input name="age" />
			<br>
			<input type="submit" value="确定" />
		</fieldset>
	</form>
	<a href='<%=request.getContextPath()%>/list.do'>返回员工列表</a>
</body>
</html>