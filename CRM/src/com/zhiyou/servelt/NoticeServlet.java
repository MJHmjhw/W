package com.zhiyou.servelt;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;
import com.zhiyou.model.Department;
import com.zhiyou.model.Notice;
import com.zhiyou.service.NoticeService;
import com.zhiyou.service.impl.NoticeServiceImpl;

public class NoticeServlet extends HttpServlet {
	private NoticeService service = new NoticeServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String q = req.getParameter("q");
		System.out.println(q);
		if (q.equals("allNotice")) {
			allNotice(req, resp);
		}
		if (q.equals("addN")) {
			addN(req, resp);
		}
		if (q.equals("updateNotice")) {
			updateNotice(req, resp);
		}
		if (q.equals("deleteNotice")) {
			deleteNotice(req, resp);
		}
		if (q.equals("selectF")) {
			selectF(req, resp);
		}
		if (q.equals("selectById")) {
			selectById(req, resp);
		}
		if (q.equals("addNotice")) {
			addNotice(req, resp);
		}
		if (q.equals("check")) {
			check(req, resp);
		}
	}

	public void allNotice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int page = req.getParameter("page") == null || req.getParameter("page").equals("") ? 1
				: Integer.valueOf(req.getParameter("page"));
		List<Notice> list = service.allNotice(page);
		req.setAttribute("count", service.sum());
		req.setAttribute("page2", page);
		req.setAttribute("list", list);
		req.getRequestDispatcher("notice.jsp").forward(req, resp);
	}

	public void addNotice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String parameter2 = req.getParameter("receive_id");
		List<Department> list = service.departments();
		int receive_id = 0;
		for (Department department : list) {
			if (department.getDepartment_name().equals(parameter2)) {
				receive_id = department.getDepartment_id();
				System.out.println(receive_id);
			}
		}
		String subject = req.getParameter("subject");
		String text = req.getParameter("text");
		Timestamp pub_time = new Timestamp(System.currentTimeMillis());
		Timestamp expire_time = new Timestamp(System.currentTimeMillis());
		String remark = req.getParameter("remark");
		Timestamp create_time = new Timestamp(System.currentTimeMillis());
		String parameter3 = req.getParameter("creater");
		int creater = Integer.parseInt(parameter3);
		Timestamp update_time = new Timestamp(System.currentTimeMillis());
		Notice notice = new Notice(1, receive_id, subject, text, pub_time, expire_time, 2, remark, create_time, creater,
				update_time, null);

		service.addNotice(notice);
		allNotice(req, resp);

	}

	public void updateNotice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String parameter2 = req.getParameter("receive_id");
		List<Department> list = service.departments();
		int receive_id = 0;
		for (Department department : list) {
			if (department.getDepartment_name().equals(parameter2)) {
				receive_id = department.getDepartment_id();
			}
		}
		String subject = req.getParameter("subject");
		String id = req.getParameter("id");
		String text = req.getParameter("text");
		Timestamp pub_time = new Timestamp(System.currentTimeMillis());
		Timestamp expire_time = new Timestamp(System.currentTimeMillis());
		String remark = req.getParameter("remark");
		Timestamp create_time = new Timestamp(System.currentTimeMillis());
		String parameter3 = req.getParameter("creater");
		int creater = Integer.parseInt(parameter3);
		Timestamp update_time = new Timestamp(System.currentTimeMillis());
		Notice notice = new Notice(Integer.valueOf(id), receive_id, subject, text, pub_time, expire_time, 2, remark,
				create_time, creater, update_time, null);
		service.updateNotice(notice);
		allNotice(req, resp);

	}

	public void deleteNotice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String string = req.getParameter("notice_id");
		System.out.println(string);
		int notice_id = Integer.parseInt(string);
		service.deleteNotice(notice_id);
		allNotice(req, resp);
	}

	public void selectF(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int page = req.getParameter("page") == null || req.getParameter("page").equals("") ? 1
				: Integer.valueOf(req.getParameter("page"));
		String i = req.getParameter("notice_id");
		String string = req.getParameter("name");
		List<Notice> list = service.selectF(page, string);
		req.setAttribute("count", service.sum2(string));
		req.setAttribute("page2", page);
		req.setAttribute("list1", list);
		req.getRequestDispatcher("notice.jsp").forward(req, resp);
	}

	public void selectById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String parameter = req.getParameter("notice_id");
		int notice_id = Integer.parseInt(parameter);
		Notice notice = service.selectById(notice_id);
		req.setAttribute("notice", notice);
		List<Department> list = service.departments();
		req.setAttribute("department", list);
		req.getRequestDispatcher("updateNotice.jsp").forward(req, resp);
	}

	public void addN(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Department> list = service.departments();
		req.setAttribute("list", list);
		req.getRequestDispatcher("addNotice.jsp").forward(req, resp);
	}

	public void check(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("subject");
		int i = service.selectSubject(name);
		resp.getWriter().write(String.valueOf(i));
	}
}
