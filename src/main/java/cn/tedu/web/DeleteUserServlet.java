package cn.tedu.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.dao.UserDao;

/**
 * 09.30员工信息删除功能
 */
public class DeleteUserServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//实现思路，由页面中传递过来的id值在userDao中删除对应id的user
		String oid = request.getParameter("id");
		int id = Integer.valueOf(oid);//转成int类型
		
		UserDao dao = new UserDao();
		dao.deleteUser(id);
		
		response.sendRedirect(request.getContextPath()+"/ShowUserServlet");
	}

}
