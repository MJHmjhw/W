package com.zhiyou.servelt;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou.dao.impl.Customer_CategoryDaoImpl;
import com.zhiyou.model.Customer_Category;
import com.zhiyou.service.Customer_CategoryService;
import com.zhiyou.service.impl.Customer_CategoreServiceImpl;

public class Cus_goryServlet extends HttpServlet {
	Customer_CategoryService service = new Customer_CategoreServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String g = req.getParameter("g");
		System.out.println(g);
		if (g.equals("allGory")) {
			allGory(req, resp);
		}
		if (g.equals("addGory")) {
			addGory(req, resp);
		}
		if (g.equals("deleteGory")) {
			deleteGory(req, resp);
		}
		if (g.equals("updateGory")) {
			updateGory(req, resp);
		}
		if (g.equals("selectById")) {
			selectById(req, resp);
		}
		if (g.equals("updateGory")) {
			updateGory(req, resp);
		}
		if (g.equals("selectF")) {
			selectF(req, resp);
		}if (g.equals("check")) {
			check(req, resp);
		}
	}

	protected void allGory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int page = req.getParameter("page") == null ? 1 : Integer.valueOf(req.getParameter("page"));
		List<Customer_Category> list = service.allGory(page);
		req.setAttribute("list", list);
		req.setAttribute("page2", page);
		req.setAttribute("count", service.sum());
		req.setAttribute("n", "show");
		req.getRequestDispatcher("allGory.jsp").forward(req, resp);
	}

	protected void addGory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// String parameter = req.getParameter("customer_category_id");
		// int customer_category_id=Integer.valueOf(parameter);
		String customer_category_name = req.getParameter("customer_category_name");
		String customer_category_desc = req.getParameter("customer_category_desc");
		String remark = req.getParameter("remakr");
		Timestamp update_time = new Timestamp(System.currentTimeMillis());
		Customer_Category category = new Customer_Category(1, customer_category_name, customer_category_desc, null,
				remark, null, null, update_time, null);
		service.addGory(category);
		allGory(req, resp);
	}

	protected void deleteGory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String parameter = req.getParameter("customer_category_id");
		int customer_category_id = Integer.valueOf(parameter);
		service.deleteGory(customer_category_id);
		allGory(req, resp);
	}

	protected void updateGory(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String parameter = req.getParameter("customer_category_id");
		int customer_category_id = Integer.valueOf(parameter);
		String customer_category_name = req.getParameter("customer_category_name");
		String customer_category_desc = req.getParameter("customer_category_desc");
		Timestamp update_time = new Timestamp(System.currentTimeMillis());
		Customer_Category category = new Customer_Category(customer_category_id, customer_category_name,
				customer_category_desc, null, null, null, null, update_time, null);
		service.updateGory(category);
		allGory(req, resp);

	}

	protected void selectById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String parameter = req.getParameter("customer_category_id");
		int customer_category_id = Integer.valueOf(parameter);
		Customer_Category category = service.selectById(customer_category_id);
		req.setAttribute("a", category);
		req.getRequestDispatcher("updateGory.jsp").forward(req, resp);
	}

	protected void selectF(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int page = req.getParameter("page") == null ? 1 : Integer.valueOf(req.getParameter("page"));
		String name = req.getParameter("name");
		List<Customer_Category> list = service.selectF(name, page);
		req.setAttribute("list1", list);
		req.setAttribute("page2", page);
		req.setAttribute("count", service.sum2(name));
		req.getRequestDispatcher("allGory.jsp").forward(req, resp);
	}

	protected void check(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("customer_category_name");
		int i = service.selectByName(name);
		resp.getWriter().write(String.valueOf(i));
	}

}
