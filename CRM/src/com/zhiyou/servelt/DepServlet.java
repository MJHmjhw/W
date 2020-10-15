package com.zhiyou.servelt;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou.model.Department;
import com.zhiyou.model.Role;
import com.zhiyou.model.User;
import com.zhiyou.service.DepService;
import com.zhiyou.service.impl.DepServiceImpl;

public class DepServlet extends HttpServlet{
	DepService service=new DepServiceImpl();
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String d=req.getParameter("d");
	System.out.println(d);
	if (d.equals("allDept")) {
		allDept(req, resp);
	}if (d.equals("addDept")) {
		addDept(req, resp);
	}if (d.equals("updateDept")) {
		updateDep(req, resp);
	}if (d.equals("deleteDept")) {
		deleteDep(req, resp);
	}
	if (d.equals("selectF")) {
		selectF(req, resp);
	}if (d.equals("selectById")) {
		selectById(req, resp);
	}if (d.equals("check")) {
		check(req, resp);
	}
}
public void allDept(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int page = req.getParameter("page") == null || req.getParameter("page").equals("") ? 1
			: Integer.valueOf(req.getParameter("page"));
	String i = req.getParameter("role_id");
	List<Department> list = service.allDepartment(page);
	req.setAttribute("count", service.sum());
	req.setAttribute("page2", page);
	req.setAttribute("list", list);
	req.getRequestDispatcher("Department.jsp").forward(req, resp);	
}
public void addDept(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String department_name = req.getParameter("department_name");
			String remark = req.getParameter("remark");
			Timestamp update_time=new Timestamp(System.currentTimeMillis());
			System.out.println(update_time);
			Department department=new Department(1, department_name, null, null, remark, null, null, update_time, null);
			service.addDepartment(department);
			allDept(req, resp);
			
			
			
}
public void updateDep(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String department_name = req.getParameter("department_name");
	String parameter = req.getParameter("department_id");
	int department_id=Integer.parseInt(parameter);
	String remark = req.getParameter("remark");
	Timestamp update_time=new Timestamp(System.currentTimeMillis());
	Department department=new Department(department_id, department_name, null, null, remark, null, null, update_time, null);
	service.updateDepartment(department);
	allDept(req, resp);
}
public void deleteDep(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String  a = req.getParameter("department_id");
	int department_id=Integer.parseInt(a);
	service.deleteDepartment(department_id);
	allDept(req, resp);
}
public void selectF(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int page = req.getParameter("page") == null || req.getParameter("page").equals("") ? 1
			: Integer.valueOf(req.getParameter("page"));
	String i = req.getParameter("department_id");
	String name=req.getParameter("name");
	List<Department> list =service.selectF(name, page);
	req.setAttribute("count", service.sum2(name));
	req.setAttribute("page2", page);
	req.setAttribute("list1", list);
	req.getRequestDispatcher("Department.jsp").forward(req, resp);
}
public void selectById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String parameter = req.getParameter("department_id");
	int department_id=Integer.parseInt(parameter);
	System.out.println(department_id);
	Department department =service.seletcById(department_id);
	System.out.println(department);
	req.setAttribute("dept", department);
	req.getRequestDispatcher("updateDept.jsp").forward(req, resp);
}
public void check(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String name = req.getParameter("department_name");	
	System.out.println(name);
	int i = service.selectByName(name);
	resp.getWriter().write(String.valueOf(i));
}

}

