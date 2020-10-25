package cn.tedu.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.tedu.dao.TraingDao;

/**
 * 培训-保存
 */
public class Y_TrainingToSaveServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Integer id = Integer.valueOf(request.getParameter("id"));

		String effect = request.getParameter("effect");

		String summarize = request.getParameter("summarize");

		 
		TraingDao t= new TraingDao();
		t.setToSave(effect,summarize,id);
		
		response.sendRedirect(request.getContextPath()+"/Y_TrainingToSeeServlet");
		
	}

}
