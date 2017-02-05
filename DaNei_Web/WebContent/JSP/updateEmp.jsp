<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改员工信息</title>
</head>
<body>
	<h1>修改员工信息</h1>
	<!-- 利用JSTL标签表达式来访问bean的属性，不再需要java代码 -->
	<form action="<%=request.getContextPath()%>/JSP/modify.do?id=${e.id}" method='post'>
			ID：${e.id}<br/>
			<!-- 需要用到id来由表单提交给服务器处理 -->
			<input type='hidden'  name='id' value='${e.id}'/>
			姓名：<input name='name'   value='${e.name}'/><br/>
			薪水：<input name='salary'  value='${e.salary}'/><br/>
			年龄：<input name='age'   value='${e.age}'/><br/>
			<input type='submit'   value='确定'/>
			
	</form>
		<a href='<%=request.getContextPath()%>/list.do'>返回员工列表</a>
</body>
</html>