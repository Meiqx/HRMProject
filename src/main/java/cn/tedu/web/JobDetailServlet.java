package cn.tedu.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.context.Context;

import cn.tedu.dao.JobDao;
import cn.tedu.entity.Job;
import cn.tedu.utils.ThUtils;

public class JobDetailServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.valueOf(request.getParameter("id"));

		JobDao dao = new JobDao();

		Context context = new Context();

		Job job = dao.editorQuery(id);

		context.setVariable("job", job);

		ThUtils.write("jobDetail", response, context);

	}


}
