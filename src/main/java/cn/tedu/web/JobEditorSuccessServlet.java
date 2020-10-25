package cn.tedu.web;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.dao.JobDao;
import cn.tedu.entity.Job;
import cn.tedu.utils.DateUtils;

/**
 * Servlet implementation class JobEditorSuccessServlet
 */
public class JobEditorSuccessServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id =Integer.valueOf(request.getParameter("id"));
		String name = request.getParameter("name");
		int sex = Integer.parseInt(request.getParameter("sex"));
		int age = Integer.parseInt(request.getParameter("age"));
		String job = request.getParameter("job");
		String spe = request.getParameter("spe");
		String exp = request.getParameter("exp");
		String stu = request.getParameter("stu");
		String school = request.getParameter("school");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		Date time = null;
		try {
			time = DateUtils.getDate(request.getParameter("time"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String content = request.getParameter("content");
		int iss = Integer.valueOf(request.getParameter("iss")) ;
		Job j = new Job(id,name,sex,age,job,spe,exp,stu,school,tel,email,time,content,iss);
		
		JobDao dao = new JobDao();		
		dao.jobEditorUpdate(j);
		
		
		
		response.sendRedirect(request.getContextPath()+"/JobTalentPoolServlet");
	}

	

}
