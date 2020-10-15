package com.zhiyou.servelt;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;import org.eclipse.jdt.internal.compiler.ast.SuperReference;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.swing.internal.plaf.metal.resources.metal;
import com.zhiyou.model.Message;
import com.zhiyou.model.Role;
import com.zhiyou.model.User;
import com.zhiyou.service.MsgService;
import com.zhiyou.service.impl.MsgServiceImpl;

public class MsgServlet extends HttpServlet {
	private MsgService service = new MsgServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ms = req.getParameter("ms");
		System.out.println(ms);
		if (ms.equals("writeMsg")) {
			writeMsg(req, resp);
		}
		if (ms.equals("allCG")) {
			allCG(req, resp);
		}
		if (ms.equals("allSJ")) {
			allSJ(req, resp);
		}
		if (ms.equals("updateCG")) {
			updateCG(req, resp);
		}
		if (ms.equals("deleteCG")) {
			deleteCG(req, resp);
		}
		if (ms.equals("updateSJ")) {
			updateSJ(req, resp);
		}
		if (ms.equals("deleteSJ")) {
			deleteSJ(req, resp);
		}
		if (ms.equals("allLJ")) {
			allLJ(req, resp);
		}if (ms.equals("selectFJ")) {
			selectFJ(req, resp);
		}if (ms.equals("selectCG")) {
			selectCG(req, resp);
		}if (ms.equals("allGet")) {
			allGet(req, resp);
		}if (ms.equals("updateGet")) {
			updateGet(req, resp);
		}if (ms.equals("deleteGet")) {
			deleteGet(req, resp);
		}if (ms.equals("selectById")) {
			selectById(req, resp);
		}if (ms.equals("updateById")) {
			updateById(req, resp);
		}
	}

	// 正常发送状态等于2
	public void writeMsg(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("a");
		String receive = req.getParameter("receiver");
		List<User> list = service.allUser();
		String subject = req.getParameter("subject");
		// 判断发送状态
		String c = req.getParameter("c");
		int status = 0;
		if (c.equals("发送")) {
			status = 2;
		} else if (c.equals("存草稿")) {
			status = 0;
		}
		// 获取收件人名字，确定收件人ID
		int receiver = 0;
		for (User user2 : list) {
			if (user2.getUsername().equals(receive)) {
				receiver = user2.getUser_id();
			}
		}

		String content = req.getParameter("content");
		int sender = user.getUser_id();
		Timestamp save_time = new Timestamp(System.currentTimeMillis());
		Timestamp send_time = new Timestamp(System.currentTimeMillis());
		Message message = new Message(1,subject, content, sender, 2, status, save_time, send_time, null, receiver, null,
				null, null);
		service.writeMsg(message);
		req.getRequestDispatcher("WriteReturn.jsp").forward(req, resp);
	}

	// *************************************************************************************************
	// 所有草稿件
	public void allCG(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int page = req.getParameter("page") == null || req.getParameter("page").equals("") ? 1
				: Integer.valueOf(req.getParameter("page"));
		List<Message> list = service.allCG(page);
		User user = (User) req.getSession().getAttribute("a");
		List<User> list2 = service.allUser();
		req.setAttribute("count", service.sum());
		req.setAttribute("page2", page);
		req.setAttribute("list", list);
		req.setAttribute("list1", list2);
		req.setAttribute("user", user);
		req.getRequestDispatcher("allCG.jsp").forward(req, resp);
	}

	// 草稿件删除到垃圾箱
	public void updateCG(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String string = req.getParameter("message_id");
		int message_id = Integer.valueOf(string);
		System.out.println(message_id);
		service.updateCG(message_id);
		allCG(req, resp);
	}

	// 直接删除
	public void deleteCG(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String string = req.getParameter("message_id");
		int message_id = Integer.valueOf(string);
		service.deleteCG(message_id);
		allCG(req, resp);
	}

	// **************************************************************************************************
	// 所有已发送邮件
	public void allSJ(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int page = req.getParameter("page") == null || req.getParameter("page").equals("") ? 1
				: Integer.valueOf(req.getParameter("page"));
		List<Message> list = service.allSJ(page);
		User user = (User) req.getSession().getAttribute("a");
		List<User> list2 = service.allUser();
		req.setAttribute("count", service.sum2());
		req.setAttribute("page2", page);
		req.setAttribute("list", list);
		req.setAttribute("list1", list2);
		req.setAttribute("user", user);
		req.getRequestDispatcher("allSJ.jsp").forward(req, resp);
	}

	// 草稿件删除到垃圾箱
	public void updateSJ(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String string = req.getParameter("message_id");
		int message_id = Integer.valueOf(string);
		service.updateSJ(message_id);
		allSJ(req, resp);
	}

	// 直接删除
	public void deleteSJ(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String string = req.getParameter("message_id");
		int message_id = Integer.valueOf(string);
		service.deleteSJ(message_id);
		allSJ(req, resp);
	}

	// *****************************************************************
	// 垃圾箱所有邮件
	public void allLJ(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int page = req.getParameter("page") == null || req.getParameter("page").equals("") ? 1
				: Integer.valueOf(req.getParameter("page"));
		List<Message> list = service.allLJ(page);
		User user = (User) req.getSession().getAttribute("a");
		List<User> list2 = service.allUser();
		req.setAttribute("count", service.sum3());
		req.setAttribute("page2", page);
		req.setAttribute("list", list);
		req.setAttribute("list1", list2);
		req.setAttribute("user", user);
		req.getRequestDispatcher("allLJ.jsp").forward(req, resp);
	}

	// 删除垃圾箱邮件
	public void deleteLJ(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String string = req.getParameter("message_id");
		int message_id = Integer.valueOf(string);
		service.deleteLJ(message_id);
		allLJ(req, resp);
	}

	//
	public void selectFJ(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int page = req.getParameter("page") == null || req.getParameter("page").equals("") ? 1
				: Integer.valueOf(req.getParameter("page"));
		List<Message> list2 = service.selectFJ2();
		String recname = req.getParameter("recname");
		List<User> list3 = service.selectFJ(recname, page);		
		req.setAttribute("page2", page);
		List<Message> list=new ArrayList<Message>();	
		for (User user : list3) {
			for (Message message : list2) {
				if (user.getUser_id()==message.getReceiver()) {
					list.add(message);
				}
			}
		}
		req.setAttribute("count", list.size()); 
		req.setAttribute("list2", list);//message
		req.setAttribute("list3", list3);//user
		req.getRequestDispatcher("allSJ.jsp").forward(req, resp);
	}
	//模糊草稿箱
	public void selectCG(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int page = req.getParameter("page") == null || req.getParameter("page").equals("") ? 1
				: Integer.valueOf(req.getParameter("page"));
		String name = req.getParameter("name");
		List<User> user = service.selectFJ(name, page);
		List<Message> CG= service.selectCG2();
		List<Message> list=new ArrayList<>();
		for (Message message : CG) {
			for (User user1 : user) {
				if (user1.getUser_id()==message.getReceiver()) {
					list.add(message);
				}
			}
			
		}
		System.out.println(list.size());
		req.setAttribute("count", list.size()); 
		req.setAttribute("page2", page);
		req.setAttribute("list3", list);
		req.setAttribute("list2", user);
		System.out.println(user);
		System.out.println(list);
		System.out.println(CG);
		req.getRequestDispatcher("allCG.jsp").forward(req, resp);
	}
	//
	public void allGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int page = req.getParameter("page") == null || req.getParameter("page").equals("") ? 1
				: Integer.valueOf(req.getParameter("page"));
		User user = (User) req.getSession().getAttribute("a");
		List<User> list2 = service.allUser();
		List<Message> list=new ArrayList<>();
		List<Message> all = service.allGet(page);
		for (Message message : all) {
			if (message.getReceiver()==user.getUser_id()) {
				list.add(message);
			}
		}
		req.setAttribute("count", list.size()); 
		req.setAttribute("page2", page);
		req.setAttribute("user", user);
		req.setAttribute("list", list);
		req.setAttribute("list1", list2);
		req.getRequestDispatcher("allGet.jsp").forward(req, resp);
	}
	//收件箱删除到垃圾箱 
	public void updateGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String string = req.getParameter("message_id");
		int message_id = Integer.valueOf(string);
		service.updateGet(message_id);
		allGet(req, resp);
	}
	public void deleteGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String string = req.getParameter("message_id");
		int message_id = Integer.valueOf(string);
		service.deleteGet(message_id);
		allGet(req, resp);
	}
	//通过ID回显草稿
	public void selectById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String string = req.getParameter("message_id");
		
		int message_id = Integer.valueOf(string);
		Message message = service.selectById(message_id);
		req.setAttribute("message", message);
		req.getRequestDispatcher("CGupdate.jsp").forward(req, resp);
	}
	public void updateById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("a");
		String receive = req.getParameter("receiver");
		List<User> list = service.allUser();
		String subject = req.getParameter("subject");
		// 判断发送状态
		String c = req.getParameter("c");
		int status = 0;
		if (c.equals("发送")) {
			status = 2;
		} else if (c.equals("存草稿")) {
			status = 0;
		}
		// 获取收件人名字，确定收件人ID
		int receiver = 0;
		for (User user2 : list) {
			if (user2.getUsername().equals(receive)) {
				receiver = user2.getUser_id();
			}
		}
		String string = req.getParameter("message_id");
		System.out.println(string);
		int message_id1= Integer.valueOf(string);
		System.out.println();
		Message selectById = service.selectById(message_id1);
		Integer message_id = selectById.getMessage_id();
		String content = req.getParameter("content");
		int sender = user.getUser_id();
		Timestamp save_time = new Timestamp(System.currentTimeMillis());
		Timestamp send_time = new Timestamp(System.currentTimeMillis());
		Message message = new Message(message_id,subject, content, sender, 2, status, save_time, send_time, null, receiver, null,
				null, null);
	
		
		service.update(message);
		req.getRequestDispatcher("WriteReturn.jsp").forward(req, resp);

		
	}
	

}
