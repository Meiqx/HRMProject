package cn.tedu.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.dao.TraingDao;

/**
 * 培训-删除
 */
public class Y_TrainingPerformed_Delete_Servlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer id = Integer.valueOf(request.getParameter("id"));
		
		TraingDao t = new TraingDao();
		
		t.setDeletid(id);
		
		response.sendRedirect(request.getContextPath()+"/Y_TrainingToSeeServlet");
		
	}


}
