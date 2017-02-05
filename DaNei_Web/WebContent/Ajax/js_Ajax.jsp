<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
	//创建XMLHttpRequest
	function getXhr() {
		var xhr;
		/* 如果支持XMLHttpRequest该类型 */
		if (window.XMLHttpRequest) {
			xhr = new XMLHttpRequest();
			/* alert(xhr); */
		} else {//ie
			xhr = new ActiveXObject("Microsoft.XMLHTTP");
		}
		return xhr;
	}
	//发送HTTP请求,span显示信息
	function sendRequest() {
		//获取XMLHttpRequest对象
		var xhr = getXhr();
		//创建一个HTTP请求,请求类型-请求地址-默认为true-异步
		xhr.open("get", "Ajax01.do", true);

		//注册一个回调函数，请求处理时自动调用,readyState取值为1-4，status是服务器请求成功状态
		xhr.onreadystatechange = function() {
			//4表示请求处理完毕
			if (xhr.readyState == 4 && xhr.status == 200) {
				//获取服务器返回的信息
				var msg = xhr.responseText;
				//span显示信息
				document.getElementById("msg").innerHTML = msg;
			}
		};
		//发送HTTP请求
		xhr.send(null);
	}
	//验证输入框的名字
	function check_name() {
		//获取输入框内容的值
		var name = document.getElementById("username").value;
		var span = document.getElementById("username_msg");
		//获取XMLHttpRequest对象
		var xhr = getXhr();
		//创建一个HTTP请求,请求类型-请求地址-默认为true-异步
		//get请求
		/* xhr.open("get", "check.do?name="+name);
		//发送HTTP请求
		xhr.send(null); */
		//post请求
		//post请求需要给HTTP协议设置请求
		xhr.open("post", "check.do");
		xhr.setRequestHeader("content-type",
				"application/x-www-form-urlencoded");

		//注册一个回调函数，请求处理时自动调用,readyState取值为1-4，status是服务器请求成功状态
		xhr.onreadystatechange = function() {
			//4表示请求处理完毕
			if (xhr.readyState == 4 && xhr.status == 200) {
				//获取服务器返回的信息
				var msg = xhr.responseText;
				//span显示信息
				document.getElementById("username_msg").innerHTML = msg;
			}
		};

		//发送HTTP请求
		xhr.send("name=" + name);
		document.getElementById("username_msg").innerHTML = "正在检测...";
	}
</script>
</head>
<body>
	<a href="#" onclick="sendRequest();">查看上证指数</a>
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
	<input type="text" id="username" onblur="check_name();" />
	<span id="username_msg"></span>
</body>
</html>