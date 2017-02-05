<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jQuery_Ajax实现</title>
<script type="text/javascript" src="../js/jquery-1.8.3.js"></script>
<style type="text/css">
table,tr,td {
	border: 1px solid #ccc;
	border-collapse: collapse;
}

span {
	color: red;
}
</style>
<script type="text/javascript">
	//span显示数据
	$(function() {
		$("#show_data").click(function() {
			$.ajax({
				url : "Ajax01.do",
				type : "get",
				success : function(result) {
					$("#msg").html(result);
				}
			});
		});
	});
	//验证输入框的名字
	$(function() {
		$("#username").blur(function() {
			var name = $("#username").val();
			$("#username_msg").html("正在检测...");
			$.ajax({
				url : "check.do",
				type : "post",
				data : {
					"name" : name
				},
				success : function(result) {
					$("#username_msg").html(result);
				}
			});
		});
	});
</script>
</head>
<body>
	<a href="#" id="show_data">查看上证指数</a>
	<span id="msg"></span>
	<hr>
	<table>
		<tr>
			<th>新闻标题
			</td>
			<th>时间
			</td>
		</tr>
		<tr>
			<td>习近平主席会见美国副总统</td>
			<td>2016-11-26</td>
		</tr>

		<tr>
			<td>新加坡与中国经济合作</td>
			<td>2016-10-25</td>
		</tr>

	</table>
	<hr>
	账号：
	<input type="text" id="username" />
	<span id="username_msg"></span>
</body>
</html>