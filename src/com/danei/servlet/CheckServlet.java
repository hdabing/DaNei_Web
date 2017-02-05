package com.danei.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

/**
 * Created by Administrator on 2016/12/9.
 */
public class CheckServlet extends HttpServlet {
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		
		System.out.println("---HTTP请求成功！---");
		// 解决页面中文乱码问题
		res.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = res.getWriter();
		// post请求默认以UTF-8编码格式
		req.setCharacterEncoding("UTF-8");
		// 接收请求带过来的name值
		String name = req.getParameter("name");
		// 控制台打印name是否获取成功
		System.out.println("name：" + name);

		// 检测name值是否可用
		if (name.equals("admin")) {
			out.println("用户名已被占用！");
		} else if (name.equals("")) {
			out.println("用户名不能为空！");
		}
		else {
			out.println("用户名可用！");
		}
		out.flush();
		out.close();
	}
}
