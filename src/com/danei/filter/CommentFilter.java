package com.danei.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.springframework.http.HttpRequest;

public class CommentFilter implements Filter {

	public CommentFilter() {
		System.out.println("FilterA构造器...");
	}

	public void destroy() {
		System.out.println("FilterA的destroy方法...");

	}
	//FilterChain过滤链
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("FilterA的doFilter方法开始执行...");
		//经常需要用到HttpServletRequest与HttpServletResponse实例对象，需要强转
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse) response;
		//设置浏览器请求的编码
		request.setCharacterEncoding("utf-8");
		//设置服务器响应的编码
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out=response.getWriter();
		String content=req.getParameter("content");
		if (content.indexOf("狗")!=-1) {
			//包含敏感字
			out.println("<h1>评论内容包含了敏感字--\"狗\"！</h1>");
		}else {
			//继续向后调用
			chain.doFilter(request, response);
		}
		System.out.println("FilterA的doFilter方法执行完毕...");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("FilterA的init方法...");

	}

}
