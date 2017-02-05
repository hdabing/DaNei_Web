<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息列表</title>
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
<body>
	<!-- 访问地址输入http://localhost:8080/DaNei_Web/userList.do -->
	<h2>用户信息列表</h2>
	<table>
		<tr>
			<th>ID</th>
			<th>用户名</th>
			<th>密码</th>
			<th>真实名</th>
			<th>性别</th>
			<th>操作</th>
		</tr>
		<!-- 利用c:forEach来遍历集合或数组，不再需要java代码 -->
		<c:forEach items="${userList}" var="u" varStatus="s">
		<tr class="row${s.index%2+1 } %>">
			<td>${u.id}</td>
			<td>${u.username}</td>
			<td>${u.password}</td>
			<td>${u.truename}</td>
			<td>${u.sex}</td>
			<td>
				<a href="<%=request.getContextPath()%>/deleteUser.do?id=${u.id}"
					onclick="return confirm('是否删除${u.name}?')">删除</a>
				&nbsp;&nbsp;
				<a href="<%=request.getContextPath()%>/loadUser.do?username=${u.name}">修改</a>

			</td>
		</tr>
		</c:forEach>
	</table>
	<br />
	<a href="<%=request.getContextPath()%>/JSP/addUser.jsp">添加用户</a>

</body>
</html>