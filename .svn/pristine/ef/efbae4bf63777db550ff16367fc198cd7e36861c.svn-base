package cn.tedu.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.context.Context;

import cn.tedu.dao.TraingDao;
import cn.tedu.entity.Users;
import cn.tedu.utils.ThUtils;

//培训录入填写人员
public class Y_TrainServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		
		TraingDao t = new TraingDao();
		List<Users> list = t.getEname();
		System.out.println("list: "+list);
		Context context = new Context();
		context.setVariable("ename", list);
		
		ThUtils.write("trainingSchool", response, context);
	}
}
