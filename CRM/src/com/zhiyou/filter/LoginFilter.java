package com.zhiyou.filter;
import java.io.IOException;
import java.util.Arrays;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.zhiyou.model.User;


public class LoginFilter implements Filter{
	//配置不被拦截的请求数组
	private String[] uris = {"/CRM/index.jsp","/CRM/login"};
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}


	//拦截请求的方法
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		//获得当前请求的URI
		String uri = req.getRequestURI();
		//将上边数组定义为list集合，判断URI是否在集合中出现，出现放行，否则拦截
		if(!Arrays.asList(uris).contains(uri)){
			User user = (User)req.getSession().getAttribute("a");
			if(user == null){
				resp.sendRedirect("index.jsp");
				return;
			}
		}
		
		//形参chain用来放行
		chain.doFilter(req, resp);
	}


	@Override
	public void destroy() {
	}


}