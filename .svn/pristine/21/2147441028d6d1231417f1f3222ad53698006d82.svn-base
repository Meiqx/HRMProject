package cn.tedu.web;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.context.Context;

import cn.tedu.dao.JobDao;
import cn.tedu.entity.Job;
import cn.tedu.utils.DateUtils;
import cn.tedu.utils.ThUtils;

/**
 * Servlet implementation class JobInputServlet
 */
public class JobInputServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		ThUtils.write("jobInput", response, new Context());
	}

	

}
