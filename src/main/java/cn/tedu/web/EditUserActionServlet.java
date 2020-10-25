package cn.tedu.web;

import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.dao.UserDao;
import cn.tedu.entity.Users;
import cn.tedu.utils.DateUtils;

/**
 * 实际编辑员工信息的Servlet，09.29
 */
public class EditUserActionServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//获取页面传递过来的参数
		String oid = request.getParameter("id");//获取请求参数的用户id
		int id = Integer.valueOf(oid);//将id转成字符串
		String username = request.getParameter("username");//用户名
		String password = request.getParameter("password");//密码
		int sex = Integer.valueOf(request.getParameter("sex"));//性别，0是男，1是女
		int isadmin = Integer.valueOf(request.getParameter("gender"));//是否是管理员
		String birthdayStr = request.getParameter("birthday");//获取生日
		String content = request.getParameter("ygjs");//员工介绍
		
		//创建原有数据库中对应id的Users对象,通过set方法，将该对象参数调整为页面中传入的参数
		UserDao dao = new UserDao();
		Users user = dao.findUserById(id);
		
		//set方法将user属性值设为页面传递的参数值
		user.setId(id);
		user.setUsername(username);
		user.setPassword(password);
		try {
			user.setBirthday(DateUtils.getDate(birthdayStr));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		user.setSex(sex);
		user.setIsadmin(isadmin);
		user.setContent(content);
		
		dao.updateUser(user);
		
		response.sendRedirect(request.getContextPath()+"/ShowUserServlet");
	}
	

}
