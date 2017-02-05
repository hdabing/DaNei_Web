package com.danei.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

/**
 * Created by Administrator on 2016/12/7.
 */
public class AjaxServlet extends HttpServlet {
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// 解决页面中文乱码问题
		System.out.println("---HTTP请求成功！---");
		res.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = res.getWriter();
		out.println("上证指数：3560");
		out.flush();
		out.close();
	}
}
