package cn.tedu.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.context.Context;

import cn.tedu.dao.UserDao;
import cn.tedu.entity.Users;
import cn.tedu.utils.ThUtils;

/**
 * 人员信息查看页功能的实现2019.09.28
 * 
 */
public class ShowUserServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDao dao = new UserDao();
		List<Users> users = dao.findAll();
		
		Context context = new Context();
		context.setVariable("users", users);
		ThUtils.write("showUser", response, context);
	}

}
