package cn.tedu.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.tedu.dao.UserDao;

/**
 * 登录业务
 */
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//获取登录页面提交的用户名和密码参数数值
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserDao dao = new UserDao();
		Boolean b = dao.login(username,password);
		if(b) {//登录成功,跳转到首页
			
			//将登陆成功的状态保存到session中10-07
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			
			response.sendRedirect(request.getContextPath()+"/HomeServlet");
		}else {//登陆失败,重新登录
			response.sendRedirect(request.getContextPath()+"/login.html");
		}

		
	}

}
