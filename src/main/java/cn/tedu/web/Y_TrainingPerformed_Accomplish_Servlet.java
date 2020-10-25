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
 * 培训查看-完成
 */
public class Y_TrainingPerformed_Accomplish_Servlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id = Integer.valueOf(request.getParameter("id"));
		
		TraingDao t = new TraingDao();
		List<Y_Educate> list = t.getInDetailsl(id);
		System.out.println("培训查看-完成： "+list);

		Context context = new Context();
		context.setVariable("details", list.get(0));
		ThUtils.write("trainingView-Accomplish", response, context);
		
		/* response.sendRedirect(request.getContextPath()+"/Y_TrainingToSeeServlet"); */
		
	}


}
