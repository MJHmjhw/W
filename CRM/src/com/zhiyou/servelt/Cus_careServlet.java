package com.zhiyou.servelt;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou.model.Customer;
import com.zhiyou.model.Customer_Care;
import com.zhiyou.model.Customer_Link;
import com.zhiyou.service.Cus_careService;
import com.zhiyou.service.impl.Cus_careServiceImpl;

public class Cus_careServlet extends HttpServlet {
	private Cus_careService service = new Cus_careServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ca = req.getParameter("ca");
		System.out.println(ca);
		if (ca.equals("allCus_care")) {
			allCus_care(req, resp);
		}
		if (ca.equals("addCus_care")) {
			addCus_care(req, resp);
		}
		if (ca.equals("deleteCus_care")) {
			deleteCus_care(req, resp);
		}
		if (ca.equals("updateCus_care")) {
			updateCus_care(req, resp);
		}
		if (ca.equals("selectById")) {
			selectById(req, resp);
		}
		if (ca.equals("selectF")) {
			selectF(req, resp);
		}if (ca.equals("check")) {
			check(req, resp);
		}
	}

	public void allCus_care(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int page = req.getParameter("page") == null || req.getParameter("page").equals("") ? 1
				: Integer.valueOf(req.getParameter("page"));
		List<Customer_Care> list = service.allCare(page);
		req.setAttribute("count", service.sum());
		req.setAttribute("page2", page);
		List<Customer> cus = service.allCus();
		req.setAttribute("list", list);
		req.setAttribute("cus", cus);
		req.getRequestDispatcher("Cus_care.jsp").forward(req, resp);

	}

	public void addCus_care(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String string = req.getParameter("customer_care_id");
		int customer_care_id = Integer.valueOf(string);
		String string2 = req.getParameter("customer_id");
		int customer_id = Integer.valueOf(string2);
		String care_subject = req.getParameter("care_subject");
		String care_type = req.getParameter("care_type");
		String remark = req.getParameter("remark");
		String nt = req.getParameter("next_time");
		String type = req.getParameter("type");
//		Calendar cal = Calendar.getInstance();
//		int year=cal.get(Calendar.YEAR);
//		int month=cal.get(Calendar.MONTH);
//		int day=cal.get(Calendar.DAY_OF_MONTH);
//		int hour = cal.get(Calendar.HOUR_OF_DAY);
//		int minute = cal.get(Calendar.MINUTE);
//		int secound = cal.get(Calendar.SECOND);
//		String p = year+"-"+month+"-" +day+""+ hour + ":" + minute + ":" + secound;
//		String nt1 = nt + " " + p;
		Timestamp next_time = new Timestamp(System.currentTimeMillis());
		Customer_Care care = new Customer_Care(customer_care_id, customer_id, care_subject, care_type, null, remark,
				next_time, null, null, null, null);
		service.addCare(care);
		allCus_care(req, resp);

	}

	public void deleteCus_care(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String string = req.getParameter("customer_care_id");
		int customer_care_id = Integer.valueOf(string);
		service.deleteCare(customer_care_id);
		allCus_care(req, resp);
	}

	public void updateCus_care(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String string = req.getParameter("customer_care_id");
		int customer_care_id = Integer.valueOf(string);
		String string2 = req.getParameter("customer_id");
		int customer_id = Integer.valueOf(string2);
		String care_subject = req.getParameter("care_subject");
		String care_type = req.getParameter("care_type");
		String remark = req.getParameter("remark");
		String nt = req.getParameter("next_time");
		String type = req.getParameter("type");
		Timestamp next_time = new Timestamp(System.currentTimeMillis());
		Customer_Care care = new Customer_Care(customer_care_id, customer_id, care_subject, care_type, null, remark,
				next_time, null, null, null, null);
		service.updateCare(care);
		allCus_care(req, resp);
	}

	public void selectById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String string = req.getParameter("customer_care_id");
		int customer_care_id = Integer.valueOf(string);
		Customer_Care care = service.selectById(customer_care_id);
		req.setAttribute("care", care);
		req.getRequestDispatcher("updateCus_care.jsp").forward(req, resp);
	}

	public void selectF(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int page = req.getParameter("page") == null || req.getParameter("page").equals("") ? 1
				: Integer.valueOf(req.getParameter("page"));
		String name = req.getParameter("name");
		List<Customer> cus = service.allCus();
		req.setAttribute("cus", cus);
		List<Customer_Care> list = service.selectF(name, page);
		System.out.println(list);
		req.setAttribute("count", service.sum2(name));
		req.setAttribute("page2", page);
		req.setAttribute("list1", list);
		req.getRequestDispatcher("Cus_care.jsp").forward(req, resp);
	}
	public void check(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("care_subject");	
		System.out.println(name);
		int i = service.selectByName(name);
		resp.getWriter().write(String.valueOf(i));
	}
}
