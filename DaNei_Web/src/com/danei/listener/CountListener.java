package com.danei.listener;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//统计在线人数，监听器例子
public class CountListener implements HttpSessionListener {

	public CountListener() {
		System.out.println("CountListener监听器构造方法...");
	}

	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("session创建了...");
		HttpSession session = arg0.getSession();

		// 获取上下文,通过session对象获得上下文，再将count绑定到上下文中
		ServletContext context = session.getServletContext();
		Integer count = (Integer) context.getAttribute("count");
		if (count == null) {
			count = 1;
		} else {
			count++;
		}
		context.setAttribute("count", count);
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("session对象销毁了...");
		HttpSession session = arg0.getSession();

		// 获取上下文,通过session对象获得上下文，再将count绑定到上下文中
		ServletContext context = session.getServletContext();
		Integer count = (Integer) context.getAttribute("count");
		if (count == null) {
			count = 0;
		} else {
			count--;
		}
		context.setAttribute("count", count);
	}

}
