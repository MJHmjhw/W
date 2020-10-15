package com.zhiyou.servelt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou.model.Customer;
import com.zhiyou.model.Customer_Link;
import com.zhiyou.model.Department;
import com.zhiyou.service.Cus_LinkService;
import com.zhiyou.service.impl.Cus_LinkServiceImpl;
import com.zhiyou.service.impl.Cus_link_recServiceImpl;

public class Cus_linkServlet extends HttpServlet {
	private Cus_LinkService service = new Cus_LinkServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cusl = req.getParameter("cusl");
		System.out.println(cusl + "***");
		if (cusl.equals("selectCus_link")) {
			allCus_link(req, resp);
		}
		if (cusl.equals("addCus_link")) {
			addCus_link(req, resp);
		}
		if (cusl.equals("deleteCus_link")) {
			deleteCus_link(req, resp);
		}
		if (cusl.equals("selectById")) {
			selectById(req, resp);
		}
		if (cusl.equals("updateCus_link")) {
			updateCus_link(req, resp);
		}if (cusl.equals("selectF")) {
		selectF(req, resp);	
		}if (cusl.equals("check")) {
			check(req, resp);
		}
	}

	public void allCus_link(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int page = req.getParameter("page") == null || req.getParameter("page").equals("") ? 1
				: Integer.valueOf(req.getParameter("page"));

		List<Customer> cus = service.selectCus();
		req.setAttribute("cus", cus);
		List<Customer_Link> list = service.allCus_link(page);
		req.setAttribute("count", service.sum());
		req.setAttribute("page2", page);
		req.setAttribute("list", list);
		req.getRequestDispatcher("Cus_Link.jsp").forward(req, resp);

	}

	public void addCus_link(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String string = req.getParameter("link_id");
		int link_id = Integer.valueOf(string);
		String string2 = req.getParameter("customer_id");
		int customer_id = Integer.valueOf(string2);
		String link_name = req.getParameter("link_name");
		String link_is_male = req.getParameter("link_is_male");
		// if (string3.equals("男")) {
		// link_is_male=true;
		// }if (string3.equals("女")) {
		// link_is_male=false;
		// }
		String link_position = req.getParameter("link_position");
		String link_mobile = req.getParameter("link_mobile");
		String string4 = req.getParameter("link_age");
		int link_age = Integer.valueOf(string4);
		String string5 = req.getParameter("link_relation");
		int link_relation = 0;
		if (string5.equals("亲属")) {
			link_relation = 1;
		}
		if (string5.equals("朋友")) {
			link_relation = 2;
		}
		if (string5.equals("同事")) {
			link_relation = 3;
		}
		if (string5.equals("上司")) {
			link_relation = 4;
		} else {
			link_relation = 2;
		}
		String remark = req.getParameter("remark");
		Customer_Link customer_Link = new Customer_Link(link_id, customer_id, link_name, link_is_male, link_position,
				link_mobile, link_age, link_relation, null, remark, null, null, null, null, null);
		service.addCus_link(customer_Link);
		allCus_link(req, resp);

	}

	public void deleteCus_link(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String string = req.getParameter("link_id");
		int link_id = Integer.valueOf(string);
		service.deleteCus_link(link_id);
		addCus_link(req, resp);
	}

	public void updateCus_link(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String string = req.getParameter("link_id");
		int link_id = Integer.valueOf(string);
		String string2 = req.getParameter("customer_id");
		int customer_id = Integer.valueOf(string2);
		String link_name = req.getParameter("link_name");
		String link_is_male = req.getParameter("link_is_male");
		// if (string3.equals("男")) {
		// link_is_male=true;
		// }if (string3.equals("女")) {
		// link_is_male=false;
		// }
		String link_position = req.getParameter("link_position");
		String link_mobile = req.getParameter("link_mobile");
		String string4 = req.getParameter("link_age");
		int link_age = Integer.valueOf(string4);
		String string5 = req.getParameter("link_relation");
		int link_relation = 0;
		if (string5.equals("亲属")) {
			link_relation = 1;
		}
		if (string5.equals("朋友")) {
			link_relation = 2;
		}
		if (string5.equals("同事")) {
			link_relation = 3;
		}
		if (string5.equals("上司")) {
			link_relation = 4;
		} else {
			link_relation = 2;
		}
		String remark = req.getParameter("remark");
		Customer_Link customer_Link = new Customer_Link(link_id, customer_id, link_name, link_is_male, link_position,
				link_mobile, link_age, link_relation, null, remark, null, null, null, null, null);
		service.updateCus_link(customer_Link);
		allCus_link(req, resp);
	}

	public void selectById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String string = req.getParameter("link_id");
		int link_id = Integer.valueOf(string);
		Customer_Link customer = service.selectById(link_id);
		req.setAttribute("customer", customer);
		req.getRequestDispatcher("updateCus_link.jsp").forward(req, resp);
		;
	}

	public void selectF(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int page = req.getParameter("page") == null || req.getParameter("page").equals("") ? 1
				: Integer.valueOf(req.getParameter("page"));
		String name = req.getParameter("name");
		List<Customer> cus = service.selectCus();
		System.out.println(cus);
		req.setAttribute("cus", cus);
		List<Customer_Link> list = service.selectF(name, page);
		req.setAttribute("count", service.sum2(name));
		req.setAttribute("page2", page);
		req.setAttribute("list1", list);
		req.getRequestDispatcher("Cus_Link.jsp").forward(req, resp);

	}
	public void check(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("link_name");	
		System.out.println(name);
		// 将name传给service 让他去调用dao层,看数据库中是否存在
		int i = service.selectByName(name);
		// 将返回值传递给前台页面
		resp.getWriter().write(String.valueOf(i));
	}

}
