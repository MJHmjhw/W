package com.zhiyou.servelt;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou.model.Customer;
import com.zhiyou.service.CustomerService;
import com.zhiyou.service.impl.CustomerServiceImpl;




public class CustomerServlet extends HttpServlet{

	CustomerService service = new CustomerServiceImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取页面传递过来的值
		String n = req.getParameter("n");
		
		if(n.equals("show")){
			show(req, resp);
		}
		
		if(n.equals("add")){
			add(req, resp);
		}
		
		if(n.equals("byID")){
			byID(req, resp);
		}
		
		if(n.equals("update")){
			update(req, resp);
		}
		
		if(n.equals("delete")){
			delete(req, resp);
		}
		
		if (n.equals("dim")) {
			dim(req,resp);
		}if (n.equals("check1")) {
			check1(req, resp);
		}if (n.equals("check2")) {
			check2(req, resp);
		}
	}
	public void show(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int page = req.getParameter("page")==null?1:Integer.valueOf(req.getParameter("page"));
		List<Customer> list = service.selectAll(page);
		req.setAttribute("count", service.sum());
		req.setAttribute("page2", page);
		req.setAttribute("list", list);
		req.setAttribute("m", "show");
		req.getRequestDispatcher("customer.jsp").forward(req, resp);
	}
	
	public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String customer_name = req.getParameter("customer_name");
		String sex = req.getParameter("sex");
		String customer_mobile = req.getParameter("customer_mobile");
		String customer_address = req.getParameter("customer_address");
		String customer_email = req.getParameter("customer_email");
		String customer_position = req.getParameter("customer_position");
		String customer_blog = req.getParameter("customer_blog");
		String customer_tel = req.getParameter("customer_tel");
		String customer_birth = req.getParameter("customer_birth");
		String update_time = req.getParameter("update_time");
		//获取取得Timestamp类型的当前系统时间
		Timestamp d = new Timestamp(System.currentTimeMillis()); 
		Customer customer = new Customer(1, 1, 1, 1, 1, customer_name,Boolean.valueOf(sex), customer_mobile, "", customer_address, customer_email, "", customer_position, customer_blog, customer_tel, d, "", 1, "", d, 1, d, 1);
		service.add(customer);
		show(req, resp);
	}
	
	public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String customer_name = req.getParameter("customer_name");
		String sex = req.getParameter("sex");
		String customer_mobile = req.getParameter("customer_mobile");
		String customer_address = req.getParameter("customer_address");
		String customer_email = req.getParameter("customer_email");
		String customer_position = req.getParameter("customer_position");
		String customer_blog = req.getParameter("customer_blog");
		String customer_tel = req.getParameter("customer_tel");
		String customer_birth = req.getParameter("customer_birth");
		String update_time = req.getParameter("update_time");
		//获取取得Timestamp类型的当前系统时间 
		Timestamp d = new Timestamp(System.currentTimeMillis()); 
		Customer customer = new Customer(Integer.valueOf(id), 1, 1, 1, 1, customer_name,Boolean.valueOf(sex), customer_mobile, "", customer_address, customer_email, "", customer_position, customer_blog, customer_tel, d, "", 1, "", d, 1, d, 1);
		service.update(customer);
		show(req, resp);
	}
	
	public void byID(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Customer customer = service.selectByID(Integer.valueOf(id));
		req.setAttribute("customer", customer);
		req.getRequestDispatcher("updateCustomer.jsp").forward(req, resp);
	}
	
	public void delete(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		String id = arg0.getParameter("id");
		service.delete(Integer.valueOf(id));
		show(arg0, arg1);
	}
	
	public void dim(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int page=req.getParameter("page")==null?1:Integer.valueOf(req.getParameter("page"));
		String str = req.getParameter("str");
		req.getSession().setAttribute("NAME", str);
		//将总条数发送给前台
		req.setAttribute("count", service.selectDim(str).size());
		//将当前页码发送给前台
		req.setAttribute("page2",page);
		//发送一个key value用来判断执行查询所有还是模糊查询
		req.setAttribute("m","dim");
		List<Customer> list = service.selectDim(str,page);
		req.setAttribute("list", list);
		//将查询的name重新发送给前台
		req.getRequestDispatcher("customer.jsp").forward(req, resp);
	}
	public void check1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("customer_name");	
		System.out.println(name);
		int i = service.selectByName(name);
		resp.getWriter().write(String.valueOf(i));
	}
	public void check2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("customer_mobile");	
		System.out.println(name);
		int i = service.selectByPhone(name);
		resp.getWriter().write(String.valueOf(i));
	}
}
