package com.danei.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		// 创建session
		HttpSession session = request.getSession();
		// 等价于HttpSession session=request.getSession(true);

		// setMaxInactiveInterval设置session的缺省的超时时间,单位为秒s
		// session.setMaxInactiveInterval(30);


		// getId获取session的sessionid
		String sessionid = session.getId();
		if (sessionid != null) {

			out.println("sessionid：" + sessionid + "<br/>");

			// getAttribute绑定count；session要求绑定值count为对象，count需要包装成对象Integer
			Integer count = (Integer) session.getAttribute("count");
			if (count == null) {
				// 第一次访问
				count = 1;
			} else {
				// 不是第一次访问
				count++;
			}
			//
			session.setAttribute("count", count);
			out.println("你是第" + count + "个访客！");
			// invalidate删除session
			//session.invalidate();
		} else {
			out.println("sessionid不存在哦！");
		}
		out.close();
	}

}
