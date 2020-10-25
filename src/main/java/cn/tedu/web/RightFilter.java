package cn.tedu.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//权限访问过滤器，若是登出则不能再访问，必须重新登录成功10-07
public class RightFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		//检查登录状况
		HttpSession session = req.getSession();
		String username = (String)session.getAttribute("username");
		//如果是未登录状况则重定向到登录页面
		String path = req.getRequestURI();//获取url
        
		if(path.indexOf("/login.html")>-1){//登录页面不过滤
        	chain.doFilter(req,resp);
            return;
        }
		if(path.indexOf("/LoginServlet")>-1){//处理登录的LoginServlet不过滤
        	chain.doFilter(req,resp);
            return;
        }
		
		//登录状态验证
		if(username==null) {
			resp.sendRedirect(req.getContextPath()+"/login.html");
			System.out.println("未登录重定向");
			return;
		}else {
			//已登录改为放行状态
			chain.doFilter(req,resp);
			System.out.println("放行");
		}
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
 


}
