package com.zhiyou.servelt;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou.model.Role;
import com.zhiyou.service.RoleService;
import com.zhiyou.service.impl.RoleServiceImpl;

public class RoleServlet extends HttpServlet{
	private RoleService service=new RoleServiceImpl();
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				String r = req.getParameter("r");
				System.out.println(r);
				if (r.equals("addrole")) {
					addRole(req, resp);
				}if (r.equals("allRole")) {
					allRole(req, resp);
				}if (r.equals("addRole")) {
					addRole(req, resp);
				}if (r.equals("selectById")) {
					selectById(req, resp);
				}if (r.equals("deleteRole")) {
					deleteRole(req, resp);
				}if (r.equals("updateRole")) {
					updateRole(req, resp);
				}if (r.equals("selectF")) {
					selectF(req, resp);
				}if (r.equals("check")) {
					check(req, resp);
				}
}
public void addRole(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String role_name = req.getParameter("role_name");
	String remark = req.getParameter("remark");
	Timestamp update_time=new Timestamp(System.currentTimeMillis());
	Role role=new Role(1, role_name, 1, 2, remark, null, null, update_time, null);
	service.addRole(role);
	allRole(req, resp);
	
}
public void allRole(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int page = req.getParameter("page") == null || req.getParameter("page").equals("") ? 1
			: Integer.valueOf(req.getParameter("page"));
	String i = req.getParameter("role_id");
	List<Role> list = service.allRole(page);
	req.setAttribute("count", service.sum());
	req.setAttribute("page2", page);
	req.setAttribute("list", list);
	req.getRequestDispatcher("role.jsp").forward(req, resp);
	
}
public void deleteRole(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String string = req.getParameter("role_id");
		service.deleteRole(Integer.valueOf(string));
		allRole(req, resp);
	
}
public void exit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.getRequestDispatcher("main.jsp").forward(req, resp);

}
public void selectById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String string = req.getParameter("role_id");
	Role role=service.selectById(Integer.valueOf(string));
	req.setAttribute("role", role);
	req.getRequestDispatcher("updateRole.jsp").forward(req, resp);
	
}
public void updateRole(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String role_name = req.getParameter("role_name");
	String remark = req.getParameter("remark");
	Timestamp update_time=new Timestamp(System.currentTimeMillis());
	String parameter = req.getParameter("role_id");
	int role_id=Integer.parseInt(parameter);
	Role role=new Role(role_id, role_name, 1, null, remark, null, null, update_time, null);
	service.updateRole(role);
	allRole(req, resp);
}
public void selectF(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int page = req.getParameter("page") == null || req.getParameter("page").equals("") ? 1
			: Integer.valueOf(req.getParameter("page"));
	String i = req.getParameter("department_id");
	String name=req.getParameter("name");
	List<Role> list =service.selectF(name, page);
	System.out.println(list);
	req.setAttribute("count", service.sum2(name));
	req.setAttribute("page2", page);
	req.setAttribute("list", list);
	req.getRequestDispatcher("role.jsp").forward(req, resp);
	


}public void check(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
String name = req.getParameter("role_name");
int i = service.selectByName(name);
resp.getWriter().write(String.valueOf(i));
}

}
