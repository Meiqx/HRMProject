package cn.tedu.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.context.Context;

import cn.tedu.dao.JobDao;
import cn.tedu.entity.Job;
import cn.tedu.utils.ThUtils;

/**
 * Servlet implementation class TalentPool
 */
public class JobTalentPoolServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
	
		JobDao dao = new JobDao();	 
		List<Job> job = dao.getTalentPool();
		Context context = new Context();
		context.setVariable("job", job);
		 		
		ThUtils.write("jobTalentPool", response, context);
	}

}
