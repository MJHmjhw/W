package com.zhiyou.servelt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou.model.User;
import com.zhiyou.service.UserService;
import com.zhiyou.service.impl.UserServiceImpl;

public class LoginServlet extends HttpServlet{
	private UserService service=new UserServiceImpl();
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
String username = req.getParameter("username");
String password = req.getParameter("password");
User user = service.selectByName(username, password);
if (user==null) {
	resp.sendRedirect("index.jsp");
	return;
}else {
	req.getSession().setAttribute("a", user);
	resp.sendRedirect("user?n=main");
}
}
}
