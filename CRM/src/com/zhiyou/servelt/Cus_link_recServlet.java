package com.zhiyou.servelt;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou.model.Customer;
import com.zhiyou.model.Customer_Link_Record;
import com.zhiyou.model.User;
import com.zhiyou.service.Cus_link_recService;
import com.zhiyou.service.impl.Cus_link_recServiceImpl;

public class Cus_link_recServlet extends HttpServlet {
	Cus_link_recService service=new Cus_link_recServiceImpl();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String rec = req.getParameter("rec");
		if (rec.equals("selectAll")) {
			selectAll(req, resp);
		}
		if (rec.equals("addCus_L_rec")) {
			addCus_l_rec(req, resp);
		}
		if (rec.equals("updateCus_L_rec")) {
			updateCus_l_rec(req, resp);
		}
		if (rec.equals("deleteCus_l_rec")) {
			deleteCus_l_rec(req, resp);
		}if (rec.equals("selectById")) {
			selectById(req, resp);
		}if (rec.equals("selectF")) {
			selectF(req, resp);
		}if (rec.equals("check")) {
			check(req, resp);
		}
	}

	public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("a");
		int page = req.getParameter("page") == null || req.getParameter("page").equals("") ? 1
				: Integer.valueOf(req.getParameter("page"));
		List<Customer_Link_Record> list = service.selectAll(page);
		List<Customer> selectCus = service.selectCus();
		req.setAttribute("selectCus", selectCus);
		req.setAttribute("count", service.sum());
		req.setAttribute("page2", page);
		req.setAttribute("list", list);
		req.setAttribute("user", user);
		req.getRequestDispatcher("Cus_L_rec.jsp").forward(req, resp);	
	}

	public void addCus_l_rec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				String string = req.getParameter("record_id");
				User user = (User) req.getSession().getAttribute("a");
				int record_id=Integer.valueOf(string);
				String string2 = req.getParameter("customer_id");
				int customer_id=Integer.valueOf(string2);
				Integer creater = user.getUser_id();
				String link_type = req.getParameter("link_type");
				String link_subject = req.getParameter("link_subject");
				String remark = req.getParameter("remark");
				Timestamp update_time=new Timestamp(System.currentTimeMillis());
				String string3 = req.getParameter("updater");
				int updater=Integer.valueOf(string3);
				Customer_Link_Record customer_Link_Record=new Customer_Link_Record(record_id, customer_id, link_type, link_subject, 
						null, null, remark, null, null, creater, update_time, updater);
				service.addRec(customer_Link_Record);
				selectAll(req, resp);
				
	}

	public void updateCus_l_rec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String string = req.getParameter("record_id");
		User user = (User) req.getSession().getAttribute("a");
		int record_id=Integer.valueOf(string);
		String string2 = req.getParameter("customer_id");
		int customer_id=Integer.valueOf(string2);
		Integer creater = user.getUser_id();
		String link_type = req.getParameter("link_type");
		String link_subject = req.getParameter("link_subject");
		String remark = req.getParameter("remark");
		Timestamp update_time=new Timestamp(System.currentTimeMillis());
		Integer updater = user.getUser_id();
		System.out.println(updater);
		Customer_Link_Record customer_Link_Record=new Customer_Link_Record(record_id, customer_id, link_type, link_subject, 
				null, null, remark, null, null, creater, update_time, updater);
		System.out.println(customer_Link_Record);
		service.updateRec(customer_Link_Record);
		selectAll(req, resp);
		
	}

	public void deleteCus_l_rec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String string = req.getParameter("record_id");
		service.deleteRec(Integer.valueOf(string));
		selectAll(req, resp);
	}
	public void selectById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String string = req.getParameter("record_id");
		int record_id=Integer.valueOf(string);
		Customer_Link_Record selectById = service.selectById(record_id);
		req.setAttribute("selectById", selectById);
		req.getRequestDispatcher("updateCus_L_Rec.jsp").forward(req, resp);
	}
	public void selectF(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("a");
		int page = req.getParameter("page") == null || req.getParameter("page").equals("") ? 1
				: Integer.valueOf(req.getParameter("page"));
		String name = req.getParameter("name");
		List<Customer_Link_Record> list2 = service.selectF(name, page);
		List<Customer> selectCus = service.selectCus();
		req.setAttribute("selectCus", selectCus);
		req.setAttribute("count", service.sum2(name));
		req.setAttribute("page2", page);
		req.setAttribute("list1", list2);
		req.setAttribute("user", user);
		req.getRequestDispatcher("Cus_L_rec.jsp").forward(req, resp);	
	}
	public void s(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String string = req.getParameter("record_id");
		service.deleteRec(Integer.valueOf(string));
		selectAll(req, resp);
	}
	public void check(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("link_type");	
		System.out.println(name);
		// 将name传给service 让他去调用dao层,看数据库中是否存在
		int i = service.selectByName(name);
		// 将返回值传递给前台页面
		resp.getWriter().write(String.valueOf(i));
	}

}
