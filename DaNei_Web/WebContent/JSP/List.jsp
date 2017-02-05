<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工信息列表</title>
<style type="text/css">
table {
	border: 1px solid #ccc;
	border-collapse: collapse;
	width: 60%;
	cellpadding: 0;
	cellspacing: 0;
	font-style: italic;
	font-size: 24px;
}

th,td {
	border: 1px solid #ccc;
}

.row1 {
	background-color: #fff8dc;
}

.row2 {
	background-color: #f0f0f0;
}
</style>
</head>
<body style="font-size: 30px">
	<!-- 访问地址输入http://localhost:8080/DaNei_Web/list.do -->
	<h2>员工信息列表</h2>
	<table>
		<tr>
			<th>ID</th>
			<th>姓名</th>
			<th>薪水</th>
			<th>年龄</th>
			<th>操作</th>
		</tr>
		<!-- 利用c:forEach来遍历集合或数组，不再需要java代码 -->
		<c:forEach items="${emplist}" var="e" varStatus="s">
		<tr class="row${s.index%2+1 }">
			<td>${e.id}</td>
			<td>${e.name}</td>
			<td>${e.salary}</td>
			<td>${e.age}</td>
			<td>
				<a href="<%=request.getContextPath()%>/delete.do?id=${e.id}"
					onclick="return confirm('是否删除${e.name}?')吗">删除</a>
				&nbsp;&nbsp;
				<a href="<%=request.getContextPath()%>/load.do?id=${e.id}">修改</a>

			</td>
		</tr>
		</c:forEach>
	</table>
	<br />
	<a href="<%=request.getContextPath()%>/JSP/addEmp.jsp">添加员工</a>
</body>
</html>