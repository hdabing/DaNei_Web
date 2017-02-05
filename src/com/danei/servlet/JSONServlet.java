package com.danei.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.danei.entity.Note;

/**
 * Created by Administrator on 2016/12/7.
 */
public class JSONServlet extends HttpServlet {
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// 将笔记信息以JSON格式输出
		List<Note> list = new ArrayList<Note>();

		Note note = new Note();
		note.setId("01");
		note.setName("Java变量");

		Note note1 = new Note();
		note1.setId("02");
		note1.setName("Ajax应用");

		list.add(note);
		list.add(note1);
		// 解决页面中文乱码问题
		res.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = res.getWriter();
		// 将note对象转成JSON字符串
		// JSONObject json=JSONObject.fromObject(note);
		JSONArray json = JSONArray.fromObject(list);

		String json_str = json.toString();
		//System.out.println(json_str);
		out.print(json_str);
		out.flush();
		out.close();
	}

	private void setContentType(String string) {
		// TODO Auto-generated method stub

	}
}
