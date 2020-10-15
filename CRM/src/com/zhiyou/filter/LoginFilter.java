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
	//���ò������ص���������
	private String[] uris = {"/CRM/index.jsp","/CRM/login"};
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}


	//��������ķ���
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		//��õ�ǰ�����URI
		String uri = req.getRequestURI();
		//���ϱ����鶨��Ϊlist���ϣ��ж�URI�Ƿ��ڼ����г��֣����ַ��У���������
		if(!Arrays.asList(uris).contains(uri)){
			User user = (User)req.getSession().getAttribute("a");
			if(user == null){
				resp.sendRedirect("index.jsp");
				return;
			}
		}
		
		//�β�chain��������
		chain.doFilter(req, resp);
	}


	@Override
	public void destroy() {
	}


}