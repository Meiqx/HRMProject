package cn.tedu.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

public class ThUtils {
	private static TemplateEngine te;
	//模板引擎初始化代码 写在static里面保证只执行一次
	static {
		te = new TemplateEngine();
		//创建解析器
		ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
		//设置字符集
		resolver.setCharacterEncoding("utf-8");
		//设置后缀
		resolver.setSuffix(".html");
		//模板引擎和解析器关联
		te.setTemplateResolver(resolver);
	}
	public static void write(String path,HttpServletResponse response,Context context) throws IOException {
		//把页面和数据交给模板引擎对象
		String html = te.process(path, context);
		//设置响应类型
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		pw.print(html);
		pw.close();
		
	}
}
