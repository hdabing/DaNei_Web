package com.danei.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.danei.dao.EmployeeDAO;
import com.danei.dao.UserDAO;
import com.danei.entity.Employee;
import com.danei.entity.User;

public class ActionServlet extends HttpServlet {

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
		if (action.equals("/list")) {

			try {
				EmployeeDAO dao = new EmployeeDAO();
				List<Employee> employees = dao.findAll();
				// 使用转发，将处理转交给List.jsp
				// 第一步，绑定数据
				request.setAttribute("emplist", employees);
				// 第二步，获取转发器
				RequestDispatcher rd = request
						.getRequestDispatcher("/JSP/List.jsp");
				// 第三步，转发
				rd.forward(request, response);
				// 简写方式
				// request.getRequestDispatcher("/JSP/List.jsp").forward(request,
				// response);
			} catch (Exception e) {
				e.printStackTrace();
				// 转发的方式处理异常
				// request.setAttribute("error_msg", "系统繁忙，请稍后再重试。");
				// request.getRequestDispatcher("error.jsp").forward(request,
				// response);
				// 将异常抛给容器
				throw new ServletException(e);
				/* <!--在web.xml中异常处理配置；声明式异常常原来处理系统异常--> */
				/*
				 * <error-page> <exception-type> javax.servlet.ServletException
				 * </exception-type> <location> /error2.jsp </location>
				 * </error-page>
				 */
			}
		}
		// 添加员工信息
		else if (action.equals("/add")) {

			String name = request.getParameter("name");
			String salary = request.getParameter("salary");
			String age = request.getParameter("age");

			// 将员工信息插入到数据库中
			try {
				EmployeeDAO dao = new EmployeeDAO();
				Employee e = new Employee();
				e.setName(name);
				e.setSalary(Double.parseDouble(salary));
				e.setAge(Integer.parseInt(age));
				dao.save(e);
				// out.println("添加成功<br/><br/>");
				// out.println("<a href='list'>返回员工列表</a>");
				// 重定向
				response.sendRedirect(request.getContextPath() + "/list.do");
				System.out.println("重定向之后执行的代码...");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// 转发的方式处理异常
				// request.setAttribute("error_msg", "系统繁忙，请稍后再重试。");
				// request.getRequestDispatcher("error.jsp").forward(request,
				// response);
				// 将异常抛给容器
				throw new ServletException(e);
				/* <!--在web.xml中异常处理配置；声明式异常常原来处理系统异常--> */
				/*
				 * <error-page> <exception-type> javax.servlet.ServletException
				 * </exception-type> <location> /error2.jsp </location>
				 * </error-page>
				 */
			}
		}
		// 删除员工信息
		else if (action.equals("/delete")) {
			// 获取id并且转换为整型
			int id = Integer.parseInt(request.getParameter("id"));
			try {
				EmployeeDAO dao = new EmployeeDAO();
				Employee e = new Employee();
				dao.delete(id);
				// 删除数据后重定向到list页面
				response.sendRedirect(request.getContextPath() + "/list.do");
			} catch (Exception e) {
				e.printStackTrace();
				// 转发的方式处理异常
				// request.setAttribute("error_msg", "系统繁忙，请稍后再重试。");
				// request.getRequestDispatcher("error.jsp").forward(request,
				// response);
				// 将异常抛给容器
				throw new ServletException(e);
				/* <!--在web.xml中异常处理配置；声明式异常常原来处理系统异常--> */
				/*
				 * <error-page> <exception-type> javax.servlet.ServletException
				 * </exception-type> <location> /error2.jsp </location>
				 * </error-page>
				 */
			}
		}
		// 加载显示修改员工信息页面
		else if (action.equals("/load")) {

			// 获取id并且转换为整型
			int id = Integer.parseInt(request.getParameter("id"));
			try {
				EmployeeDAO dao = new EmployeeDAO();
				Employee e = new Employee();
				// 通过获得得id生成一个修改页面
				e = dao.findById(id);

				// 使用转发，将处理转交给List.jsp
				// 第一步，绑定数据
				request.setAttribute("empUpdate", e);
				// 第二步，获取转发器
				RequestDispatcher rd = request
						.getRequestDispatcher("/JSP/updateEmp.jsp");
				// 第三步，转发
				rd.forward(request, response);
				// 简写方式
				// request.getRequestDispatcher("/JSP/updateEmp.jsp").forward(request,
				// response);
			} catch (Exception e) {
				e.printStackTrace();
				// 转发的方式处理异常
				// request.setAttribute("error_msg", "系统繁忙，请稍后再重试。");
				// request.getRequestDispatcher("error.jsp").forward(request,
				// response);
				// 将异常抛给容器
				throw new ServletException(e);
				/* <!--在web.xml中异常处理配置；声明式异常常原来处理系统异常--> */
				/*
				 * <error-page> <exception-type> javax.servlet.ServletException
				 * </exception-type> <location> /error2.jsp </location>
				 * </error-page>
				 */
			}
		}
		// 修改员工信息
		else if (action.equals("/modify")) {
			// 获取id并且转换为整型
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String salary = request.getParameter("salary");
			String age = request.getParameter("age");

			try {
				EmployeeDAO dao = new EmployeeDAO();
				Employee e = new Employee();
				e.setId(id);
				e.setName(name);
				e.setSalary(Double.parseDouble(salary));
				e.setAge(Integer.parseInt(age));
				dao.modify(e);
				// out.println("修改成功<br/><br/>");
				// out.println("<a href='list'>返回员工列表</a>");
				// 修改数据后重定向到list页面
				response.sendRedirect(request.getContextPath() + "/list.do");
			} catch (Exception e) {
				e.printStackTrace();
				// 转发的方式处理异常
				// request.setAttribute("error_msg", "系统繁忙，请稍后再重试。");
				// request.getRequestDispatcher("error.jsp").forward(request,
				// response);
				// 将异常抛给容器
				throw new ServletException(e);
				/* <!--在web.xml中异常处理配置；声明式异常常原来处理系统异常--> */
				/*
				 * <error-page> <exception-type> javax.servlet.ServletException
				 * </exception-type> <location> /error2.jsp </location>
				 * </error-page>
				 */
			}
		}

		// 用户信息列表
		else if (action.equals("/userList")) {
			try {
				UserDAO userdao = new UserDAO();
				List<User> users = userdao.findAll();
				// 使用转发，将处理转交给List.jsp
				// 第一步，绑定数据
				request.setAttribute("userList", users);
				// 第二步，获取转发器
				RequestDispatcher rd = request
						.getRequestDispatcher("/JSP/userList.jsp");
				// 第三步，转发
				rd.forward(request, response);
				// 简写方式
				// request.getRequestDispatcher("/JSP/userList.jsp").forward(request,
				// response);
			} catch (Exception e) {
				e.printStackTrace();
				// 转发的方式处理异常
				// request.setAttribute("error_msg", "系统繁忙，请稍后再重试。");
				// request.getRequestDispatcher("error.jsp").forward(request,
				// response);
				// 将异常抛给容器
				throw new ServletException(e);
				/* <!--在web.xml中异常处理配置；声明式异常常原来处理系统异常--> */
				/*
				 * <error-page> <exception-type> javax.servlet.ServletException
				 * </exception-type> <location> /error2.jsp </location>
				 * </error-page>
				 */
			}
		}
		// 添加用户信息
		else if (action.equals("/addUser")) {
			
			String usrename = request.getParameter("usrename");
			String password = request.getParameter("password");
			String truename = request.getParameter("truename");
			String sex = request.getParameter("sex");

			// 将用户信息插入到数据库中
			try {
				UserDAO userdao = new UserDAO();
				User user = new User();
				user.setUsername(usrename);
				user.setPassword(password);
				user.setTruename(truename);
				user.setSex(sex);
				userdao.add(user);
				// 重定向
				response.sendRedirect(request.getContextPath() + "/userList.do");
				System.out.println("重定向之后执行的代码...");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				// 转发的方式处理异常
				// request.setAttribute("error_msg", "系统繁忙，请稍后再重试。");
				// request.getRequestDispatcher("error.jsp").forward(request,
				// response);
				// 将异常抛给容器
				throw new ServletException(e);
				/* <!--在web.xml中异常处理配置；声明式异常常原来处理系统异常--> */
				/*
				 * <error-page> <exception-type> javax.servlet.ServletException
				 * </exception-type> <location> /error2.jsp </location>
				 * </error-page>
				 */
			}
		}
		// 删除用户信息
		else if (action.equals("/deleteUser")) {
			// 获取id并且转换为整型
			int id = Integer.parseInt(request.getParameter("id"));
			try {
				UserDAO userdao = new UserDAO();
				User user = new User();
				userdao.delete(id);
				// 删除数据后重定向到list页面
				response.sendRedirect(request.getContextPath() + "/userList.do");
			} catch (Exception e) {
				e.printStackTrace();
				// 转发的方式处理异常
				// request.setAttribute("error_msg", "系统繁忙，请稍后再重试。");
				// request.getRequestDispatcher("error.jsp").forward(request,
				// response);
				// 将异常抛给容器
				throw new ServletException(e);
				/* <!--在web.xml中异常处理配置；声明式异常常原来处理系统异常--> */
				/*
				 * <error-page> <exception-type> javax.servlet.ServletException
				 * </exception-type> <location> /error2.jsp </location>
				 * </error-page>
				 */
			}
		}
		// 加载显示修改用户信息页面
		else if (action.equals("/loadUser")) {

			String username = request.getParameter("username");
			try {
				UserDAO userdao = new UserDAO();
				User user = new User();
				// 通过username获得生成一个修改页面
				user = userdao.findByUsername(username);

				// 使用转发，将处理转交给List.jsp
				// 第一步，绑定数据
				request.setAttribute("userUpdate", user);
				// 第二步，获取转发器
				RequestDispatcher rd = request
						.getRequestDispatcher("/JSP/updateUser.jsp");
				// 第三步，转发
				rd.forward(request, response);
				// 简写方式
				// request.getRequestDispatcher("/JSP/updateUser.jsp").forward(request,
				// response);
			} catch (Exception e) {
				e.printStackTrace();
				// 转发的方式处理异常
				// request.setAttribute("error_msg", "系统繁忙，请稍后再重试。");
				// request.getRequestDispatcher("error.jsp").forward(request,
				// response);
				// 将异常抛给容器
				throw new ServletException(e);
				/* <!--在web.xml中异常处理配置；声明式异常常原来处理系统异常--> */
				/*
				 * <error-page> <exception-type> javax.servlet.ServletException
				 * </exception-type> <location> /error2.jsp </location>
				 * </error-page>
				 */
			}
		}
		// 修改用户信息
		else if (action.equals("/modifyUser")) {
			// 获取id并且转换为整型
			int id = Integer.parseInt(request.getParameter("id"));
			String usrename = request.getParameter("usrename");
			String password = request.getParameter("password");
			String truename = request.getParameter("truename");
			String sex = request.getParameter("sex");
			System.out.println(id + "" + usrename);
			try {
				UserDAO userdao = new UserDAO();
				User user = new User();
				user.setId(id);
				user.setUsername(usrename);
				user.setPassword(password);
				user.setTruename(truename);
				user.setSex(sex);
				userdao.modify(user);

				// out.println("修改成功<br/><br/>");
				// out.println("<a href='list'>返回员工列表</a>");
				// 修改数据后重定向到list页面
				response.sendRedirect(request.getContextPath() + "/userList.do");
			} catch (Exception e) {
				e.printStackTrace();
				// 转发的方式处理异常
				// request.setAttribute("error_msg", "系统繁忙，请稍后再重试。");
				// request.getRequestDispatcher("error.jsp").forward(request,
				// response);
				// 将异常抛给容器
				throw new ServletException(e);
				/* <!--在web.xml中异常处理配置；声明式异常常原来处理系统异常--> */
				/*
				 * <error-page> <exception-type> javax.servlet.ServletException
				 * </exception-type> <location> /error2.jsp </location>
				 * </error-page>
				 */
			}
		}
		// 登录成功跳转
		else if (action.equals("/login")) {
			//先比较验证码是否正确
			//获取用户输入的验证码
			String number1=request.getParameter("checkcode");
			//获取预先绑定的验证码
			HttpSession session = request.getSession();
			String number2=(String)session.getAttribute("number");
			if (!number1.equalsIgnoreCase(number2)) {
				//验证码错误
				request.setAttribute("checkcode_error","验证码错误");
				request.getRequestDispatcher ("/JSP/login.jsp")
				.forward(request, response);
				return;
			}
			//读取用户名和密码
			String name = request.getParameter("name");
			String passwd = request.getParameter("passwd");
			try {
				UserDAO userdao = new UserDAO();
				User user = userdao.findByUsername(name);
				//用户的密码与数据库对应用户的密码相同，则登录成功，否则提示密码错误
				if (user !=null&&user.getPassword().equals(passwd)) {
					
					// 用户的密码与数据库对应用户的密码相同，则登录成功
					
					//登录成功后，将一些数据绑定到session中
					//绑定数据到session对象中
					session.setAttribute("user", user);
					response.sendRedirect(request.getContextPath() + "/JSP/success.jsp");
				}else {
					//登录失败，跳转到登录失败页面
					request.setAttribute("login_failed", "用户名或密码错误");
					request.getRequestDispatcher ("/JSP/login.jsp")
					.forward(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
				// 转发的方式处理异常
				// request.setAttribute("error_msg", "系统繁忙，请稍后再重试。");
				// request.getRequestDispatcher("error.jsp").forward(request,
				// response);
				// 将异常抛给容器
				throw new ServletException(e);
				/* <!--在web.xml中异常处理配置；声明式异常常原来处理系统异常--> */
				/*
				 * <error-page> <exception-type> javax.servlet.ServletException
				 * </exception-type> <location> /error2.jsp </location>
				 * </error-page>
				 */
			}
		} else {
			// System.out.println("请输入正确格式的路径");
		}
	}

}
