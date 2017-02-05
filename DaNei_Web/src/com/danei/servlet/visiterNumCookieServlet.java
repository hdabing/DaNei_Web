package com.danei.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class visiterNumCookieServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// 读取Cookie
		Cookie[] cookies = request.getCookies();
		Integer count = 0;
		if (cookies != null) {

			for (int i = 0; i < cookies.length; i++) {
				String cName = cookies[i].getName();
				String cValue = cookies[i].getValue();
				if (cName == "JSESSIONID") {
					// 不是第一次访问
					count = 1;
					count++;
				} else {
					// 第一次访问
					count++;
				}
			}
			out.println("你是第" + count + "个访客！");
		} else {
			out.println("找不到任何的cookie！" + "<br/>");
		}
	}

}
