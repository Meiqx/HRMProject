package cn.tedu.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.context.Context;

import cn.tedu.dao.UserDao;
import cn.tedu.entity.Users;
import cn.tedu.utils.ThUtils;

/**
 * User编辑业务展示页面09.29
 * 上午9点上课，工作进行到编辑editUser.html页面工作
 */
public class EditUserServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取传递的id参数
		String oid = request.getParameter("id");
		int id = Integer.valueOf(oid);//转成字符串
		UserDao dao = new UserDao();
		Users user = dao.findUserById(id);
		Context context = new Context();
		context.setVariable("user", user);
		
		ThUtils.write("editUser", response, context);
		
	}

} 
