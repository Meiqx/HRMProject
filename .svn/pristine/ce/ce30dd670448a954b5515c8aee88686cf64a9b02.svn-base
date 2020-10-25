package cn.tedu.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.dao.TraingDao;

/**
 * 培训录入操作
 * 
 * @author JAVA
 *
 */
public class Y_TrainingSchool extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符集
		request.setCharacterEncoding("UTF-8");
		
		//获取参数
		String name = request.getParameter("name");//培训名称
		String purpose = request.getParameter("purpose");//培训目的
		String begintime = request.getParameter("begintime");//培训开始时间
		String endtime = request.getParameter("endtime");//培训结束时间
		String datum = request.getParameter("datum");//培训材料
		String teacher = request.getParameter("teacher");//培训讲师
		String student = request.getParameter("student");//培训人员  
		
		TraingDao td = new TraingDao();
		//
		td.Training(name, purpose, begintime, endtime,datum, teacher, student);
	
		response.sendRedirect(request.getContextPath()+"/Y_TrainingToSeeServlet");
	}
	

}
