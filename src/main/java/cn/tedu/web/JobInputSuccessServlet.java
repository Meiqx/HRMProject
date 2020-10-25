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
 * Servlet implementation class JobServlet
 */
public class JobInputSuccessServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String time1 = request.getParameter("time");
		String iss1 = request.getParameter("iss");
		String job = request.getParameter("job");
		String spe = request.getParameter("spe");
		String exp = request.getParameter("exp");
		String stu = request.getParameter("stu");
		String school = request.getParameter("school");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		Date time = null;
		try {
			time = DateUtils.getDate(time1);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		String context = request.getParameter("context");
		int iss = Integer.valueOf(iss1) ;

		Job j = new Job(0,name,Integer.valueOf(sex),Integer.valueOf(age),job,spe,exp,stu,school,tel,email,time,context,iss);

		JobDao dao = new JobDao();

		dao.save(j);
		response.sendRedirect(request.getContextPath()+"/JobCheckServlet");
	}


}
