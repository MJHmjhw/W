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
import com.zhiyou.service.UserService;
import com.zhiyou.service.impl.UserServiceImpl;

public class UserServlet extends HttpServlet {
	private UserService service = new UserServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		
		User user = (User) req.getSession().getAttribute("a");
		if (user == null) {
			resp.sendRedirect("index.html");
			return;
		}
		String n = req.getParameter("n");
		System.out.println(n);
		if (n.equals("main")) {
			show(req, resp);
		}
		if (n.equals("show")) {
			selectAll(req, resp);
		}
		if (n.equals("exit")) {
			exit(req, resp);
		}
		if (n.equals("delete")) {
			delete(req, resp);
		}
		if (n.equals("addShow")) {
			addShow(req, resp);
		}
		if (n.equals("selectById")) {
			selectById(req, resp);
		}
		if (n.equals("selectF")) {
			selectF(req, resp);
		}
		if (n.equals("update")) {
			update(req, resp);
		}if (n.equals("add")) {
			add(req, resp);
		}if (n.equals("check")) {
			check(req, resp);
		}
	}

	// 进入主界面
	public void show(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("main.jsp").forward(req, resp);
	}

	// 查询所有用户
	public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int page = req.getParameter("page") == null || req.getParameter("page").equals("") ? 1
				: Integer.valueOf(req.getParameter("page"));
		List<User> list = service.selectAll(page);
		List<Department> allDep = service.selectAllDep();
		List<Role> allRole = service.selectAllRole();
		req.setAttribute("allDep", allDep);
		req.setAttribute("allRole", allRole);
		req.setAttribute("count", service.sum());
		req.setAttribute("page2", page);
		req.setAttribute("list", list);
		req.getRequestDispatcher("show.jsp").forward(req, resp);
	}

	// 退出界面
	public void exit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("main.jsp").forward(req, resp);
	}

	// 删除用户
	public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String i = req.getParameter("id");
		int id = Integer.parseInt(i);
		service.delete(id);
		selectAll(req, resp);
	}

	// 添加用户
	public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String address = req.getParameter("address");
		String tel = req.getParameter("tel");
		String email = req.getParameter("email");
		String hobby = req.getParameter("hobby");
		String card_num = req.getParameter("card_num");
		String password = req.getParameter("password");
		String mobile = req.getParameter("mobile");
		String ag = req.getParameter("age");
		int age = Integer.parseInt(ag);
		String id_num = req.getParameter("id_num");
		String nation = req.getParameter("nation");
		String remark = req.getParameter("remark");
		String parameter = req.getParameter("is_male");
		boolean is_male = false;
		if (parameter.equals("男")) {
			is_male = true;
		}
		if (parameter.equals("女")) {
			is_male = false;
		}
		String a = req.getParameter("education");
		int education = 0;
		if (a.equals("小学")) {
			education = 1;
		}
		if (a.equals("初中")) {
			education = 2;
		}
		if (a.equals("高中")) {
			education = 3;
		}
		if (a.equals("专科")) {
			education = 4;
		}
		if (a.equals("本科")) {
			education = 5;
		}
		if (a.equals("硕士")) {
			education = 6;
		}
		if (a.equals("博士")) {
			education = 7;
		} else {
			education = 0;
		}
		String ma = req.getParameter("marry");
		int marry = 0;
		if (ma.equals("未婚")) {
			marry = 0;
		}
		if (ma.equals("已婚")) {
			marry = 1;
		}
		if (ma.equals("离异")) {
			marry = -1;
		} else {
			marry = 0;
		}
		String string = req.getParameter("department_id");
		int department_id = service.selectDept(string);
Timestamp update_time=new Timestamp(System.currentTimeMillis());
		String string2 = req.getParameter("role_id");
		int role_id = service.selectRole(string2);
		User user = new User(1, department_id, role_id, username, is_male, mobile, age, address, null, null, password,
				tel, id_num, email, hobby, education, card_num, nation, marry, null, remark, null, null, update_time, null);
		service.add(user);
		selectAll(req, resp);
	}

	// 更新用户
	public void selectById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		User user = service.selectById(Integer.valueOf(id));
		List<Role> list = service.seList();
		req.setAttribute("list1", list);
		List<Department> list2 = service.selectAllDep();
		req.setAttribute("list2", list2);
		req.setAttribute("user", user);
		req.getRequestDispatcher("update.jsp").forward(req, resp);

	}

	// 模糊查询
	public void selectF(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int page = req.getParameter("page") == null || req.getParameter("page").equals("") ? 1
				: Integer.valueOf(req.getParameter("page"));
		String string = req.getParameter("name");
		req.setAttribute("string", string);
		List<User> list = service.selectF(string, page);
		req.setAttribute("count", service.Fsum(string));
		req.setAttribute("page2", page);
		req.setAttribute("list1", list);
		req.getRequestDispatcher("show.jsp").forward(req, resp);
	}

	// 更新用户
	public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String address = req.getParameter("address");
		String tel = req.getParameter("tel");
		String email = req.getParameter("email");
		String hobby = req.getParameter("hobby");
		String card_num = req.getParameter("card_num");
		String password = req.getParameter("password");
		String mobile = req.getParameter("mobile");
		String ag = req.getParameter("age");
		int age = Integer.parseInt(ag);
		String id_num = req.getParameter("id_num");
		String nation = req.getParameter("nation");
		String remark = req.getParameter("remark");
		String parameter = req.getParameter("is_male");

		boolean is_male = false;
		if (parameter.equals("男")) {
			is_male = true;
		}
		if (parameter.equals("女")) {
			is_male = false;
		} else {
			is_male = true;
		}
		String a = req.getParameter("education");
		System.out.println(a);
		int education = 0;
		if (a.equals("小学")) {
			education = 1;
		}
		if (a.equals("初中")) {
			education = 2;
		}
		if (a.equals("高中")) {
			education = 3;
		}
		if (a.equals("专科")) {
			education = 4;
		}
		if (a.equals("本科")) {
			education = 5;
		}
		if (a.equals("硕士")) {
			education = 6;
		}
		if (a.equals("博士")) {
			education = 7;
		} else {
			education = 0;
		}
		String ma = req.getParameter("marry");
		int marry = 0;
		if (ma.equals("未婚")) {
			marry = 0;
		}
		if (ma.equals("已婚")) {
			marry = 1;
		}
		if (ma.equals("离异")) {
			marry = -1;
		} else {
			marry = 0;
		}
		String string = req.getParameter("department_id");
		//根据部门名称获取部门id存到user对象
		Department department = service.selectD(string);
		Integer department_id = department.getDepartment_id();
		String string2 = req.getParameter("role_id");
		Role role = service.selectR(string2);
		Integer role_id = role.getRole_id();
	
		
		String string3 = req.getParameter("user_id");
		int user_id=Integer.parseInt(string3);
		User user = new User(user_id, department_id,role_id , username, is_male, mobile, age, address, null, null, password,tel, id_num, email, hobby, education, card_num, nation, marry, null, remark, null, null, null, null);
		service.update(user);
		selectAll(req, resp);
	}

	// 跳添加用户页面前先跳该方法
	public void addShow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Department> dep = service.selectAllDep();
		List<Role> role = service.selectAllRole();
		req.setAttribute("depList", dep);
		req.setAttribute("roleList", role);
		req.getRequestDispatcher("add.jsp").forward(req, resp);

	}	
	
	public void check(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 接收前台传过来的name
		String name = req.getParameter("username");	
		System.out.println(name);
		// 将name传给service 让他去调用dao层,看数据库中是否存在
		int i = service.selectByName(name);
		// 将返回值传递给前台页面
		resp.getWriter().write(String.valueOf(i));

	}
}
