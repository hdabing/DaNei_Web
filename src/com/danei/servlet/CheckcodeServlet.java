package com.danei.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CheckcodeServlet extends HttpServlet {
	
	//长度为5的验证码，从A~Z,0~9中选取，排除0,O,1,i
	public String getNumber() {
		String number="";
		String chars="ABCDEFGHJKLMNPQRSTUVWXYZ23456789";
		Random random=new Random();
		for (int i = 0; i < 5; i++) {
			number+=chars.charAt(random.nextInt(chars.length()));
		}
		return number;
	}
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Checkcode......");
		//1.绘图
		BufferedImage image=new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);
		//获得画笔
		Graphics g=image.getGraphics();
		//2.给画笔设置颜色，字体大小
		g.setColor(new Color(255,255,255));
		g.setFont(new Font(null, Font.ITALIC, 18));
		//3.给画笔设置背景颜色
		g.fillRect(0, 0, 80, 30);
		//4.重新给画笔设置颜色
		Random r=new Random();
		g.setColor(new Color(r.nextInt(255),
				r.nextInt(255),r.nextInt(255)));
		//5.生成一个随机数
		String number=getNumber();
		//将验证码number绑定session对象上,用来验证
		HttpSession session=request.getSession();
		session.setAttribute("number", number);
		//将验证码转换成图片
		g.drawString(number, 2, 25);
		//6.加上干扰线
		for (int i = 0; i < 8; i++) {
			g.setColor(new Color(r.nextInt(255), 
					r.nextInt(255), r.nextInt(255)));
			g.drawLine(r.nextInt(80), r.nextInt(30),
					r.nextInt(30), r.nextInt(80));
		}
		
		//7.压缩图片并输出
		//设置服务器返回的数据类型为图片类型
		response.setContentType("image/jpeg");
		OutputStream os=response.getOutputStream();
		javax.imageio.ImageIO.write(image, "jpeg", os);
		os.close();
	}

}
