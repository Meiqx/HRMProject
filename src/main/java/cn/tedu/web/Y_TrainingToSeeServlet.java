package cn.tedu.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.context.Context;

import cn.tedu.dao.TraingDao;
import cn.tedu.entity.Y_Educate;
import cn.tedu.utils.ThUtils;

/**
 * 培训计划查看
 * 
 * @author JAVA
 *
 */
public class Y_TrainingToSeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		TraingDao t = new TraingDao();
		List<Y_Educate> list = t.getTts(0);
		System.out.println("培训计划查看:  "+list);
		Context context = new Context();
		context.setVariable("tts", list);
		
		ThUtils.write("TrainingToSee", response, context);
	}


}
