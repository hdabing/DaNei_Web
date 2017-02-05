package com.danei.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.danei.entity.Note;

//扫描LoadNoteController
@Controller
public class LoadNoteController {
	// 调用Dao获取笔记数据，采用JSON返回，想要把谁以JSON返回就return出来
	// 对应上*.do，可以执行后面的内容
	@RequestMapping("/spring01.do")
	// 将返回结果调用jackson.jar包转成json输出
	@ResponseBody
	public List<Note> execute() {

		List<Note> list = new ArrayList<Note>();
		Note note = new Note();
		note.setId("01");
		note.setName("SprngMVC开发");
		Note note1 = new Note();
		note1.setId("02");
		note1.setName("JSON应用");
		list.add(note);
		list.add(note1);

		return list;
	}

	// 对应上*.do，可以执行后面的内容
	@RequestMapping("/spring02.do")
	// 将返回结果调用jackson.jar包转成json输出
	@ResponseBody
	public Note load1() {

		Note note = new Note();
		note.setId("01");
		note.setName("SprngMVC开发");
		return note;
	}

	// 对应上*.do，可以执行后面的内容
	@RequestMapping("/spring03.do")
	// 将返回结果调用jackson.jar包转成json输出
	@ResponseBody
	public Map<String, Object> load2() {

		Map<String, Object> map=new HashMap<String, Object>();
		map.put("001", "zhangsan");
		map.put("002", "lisi");
		return map;
	}
}
