package com.zhiyou.servelt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou.model.Department;
import com.zhiyou.model.Notice;
import com.zhiyou.model.Role;
import com.zhiyou.model.User;
import com.zhiyou.service.NBSerivce;
import com.zhiyou.service.impl.NBServiceImpl;

public class NBservlet extends HttpServlet{
	NBSerivce service=new NBServiceImpl();
	
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				String b=req.getParameter("b");
				System.out.println(b);
				if (b.equals("NBN")) {
					NBN(req, resp);
				}if (b.equals("NBU")) {
					NBU(req, resp);
				}if (b.equals("NBD")) {
					NBD(req, resp);
				}				
}
public void NBU(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int page = req.getParameter("page") == null || req.getParameter("page").equals("") ? 1
			: Integer.valueOf(req.getParameter("page"));
	List<User> list = service.allUser(page);
	List<Department> allDep = service.allDepartment(page);
	List<Role> allRole = service.allRole();
	req.setAttribute("allDep", allDep);
	req.setAttribute("allRole", allRole);
	req.setAttribute("count", service.sumU());
	req.setAttribute("page2", page);
	req.setAttribute("list", list);
	req.getRequestDispatcher("NBuser.jsp").forward(req, resp);
}
public void NBN(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int page = req.getParameter("page") == null || req.getParameter("page").equals("") ? 1
			: Integer.valueOf(req.getParameter("page"));
	List<Notice> list = service.allNotice(page);
	req.setAttribute("count", service.sumN());
	req.setAttribute("page2", page);
	req.setAttribute("list", list);
	req.getRequestDispatcher("NBnotice.jsp").forward(req, resp);
}
public void NBD(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int page = req.getParameter("page") == null || req.getParameter("page").equals("") ? 1
			: Integer.valueOf(req.getParameter("page"));
	List<Department> list = service.allDepartment(page);
	req.setAttribute("count", service.sumD());
	req.setAttribute("page2", page);
	req.setAttribute("list", list);
	req.getRequestDispatcher("NBdepartment.jsp").forward(req, resp);
}
}
