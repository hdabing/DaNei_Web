package com.danei.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieServlet extends HttpServlet {
	// 实现Cookie的添加和读取
	// 创建Cookie，访问地址：http://localhost:8080/DaNei_Web/addCookie.do
	public void addCookie(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 创建Cookie
		Cookie cookie1 = new Cookie("username", "king");
		Cookie cookie2 = new Cookie("zhangsan", "123456");
		// Cookie的中文参数处理：U设置RLEncoder.encode("李四","utf-8")，还原
		// URLDecoder.decode(cName,"utf-8")
		Cookie cookie3 = new Cookie(URLEncoder.encode("李四", "utf-8"), "123456");

		// 设置Cookie生命周期，cookie.setMaxAge();单位为秒s
		cookie1.setMaxAge(10);
		cookie2.setMaxAge(20);
		cookie3.setMaxAge(30);

		// 修改Cookie的值：在添加时修改,不能修改Cookie名称
		// cookie1.setValue("123456");

		// 添加Cookie
		response.addCookie(cookie1);
		response.addCookie(cookie2);
		response.addCookie(cookie3);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");

		out.println("添加cookie成功！" + "<br/>");
	}

	// 读取Cookie，访问地址：http://localhost:8080/DaNei_Web/readCookie.do
	public void readCookie(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");

		out.println("请通过浏览器查看cookie信息！" + "<br/>");
		// 读取Cookie
		Cookie[] cookies = request.getCookies();
		out.println("cookie信息为：" + "<br/>");
		if (cookies != null) {

			for (int i = 0; i < cookies.length; i++) {
				String cName = cookies[i].getName();
				String cValue = cookies[i].getValue();
				// 还原字符集 URLDecoder.decode
				out.println((i + 1) + "、" + URLDecoder.decode(cName, "utf-8")
						+ "：" + URLDecoder.decode(cValue, "utf-8") + "<br/>");

			}
		} else {
			out.println("找不到任何的cookie！" + "<br/>");
		}
		out.close();
	}

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 中文乱码处理
		request.setCharacterEncoding("utf-8");
		// 获得请求资源路径
		String uri = request.getRequestURI();
		// 分析请求资源路径
		String action = uri.substring(uri.lastIndexOf("/"),
				uri.lastIndexOf("."));
		// 依据分析的结果，调用不同的分支处理
		// 员工信息列表
		if (action.equals("/addCookie")) {
			addCookie(request, response);
		}
		if (action.equals("/readCookie")) {
			readCookie(request, response);
		}

	}

}
