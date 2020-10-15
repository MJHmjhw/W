<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="bootstrap.min.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="afont-awesome-4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="bootstrap.min.css">
<style type="text/css">
table {
	position: absolute;
	top: 100px;
	border-collapse: collapse;
	border: 1px solid gainsboro;
	width:900px;
}

td {
	width: 100px;
	height: 30px;
	border: 1px solid gainsboro;
	text-align: center;
}

p {
	font-size: 25px;
}

span:nth-of-type(2) {
	position: relative;
	left: 20px;
}

select {
	position: relative;
	left: 20px;
}

button:nth-of-type(1) {
	position: relative;
	left: 30px;
	background-color: gainsboro;
}

#btn {
	position: relative;
	left: 300px;
}

#pa {
	position: relative;
	top: 200px;
	left: 580px;
}

#pa li {
	list-style-type: none;
	display: inline-block;
}

#jilu {
	position: relative;
	top: 250px;
}

#jilu p {
	font-size: 16px;
}

input {
	outline: none;
}

#zong {
	position: relative;
	top: 50px;
	left: 50px;
	width: 900px;
	height: 500px;
	margin: auto;
}

#ch button {
	background-color: #337ab7;
	position: relative;
	top: -30px;
}
</style>
</head>
<body>
	<div id="zong">
		<p>收件箱</p>
		<div>
			<span>搜索内容：发件人姓名</span>
			<form action="msg">
				<input type="text" name="name" value="${str}">
				<!-- 		<span>搜索字段：</span> -->
				<!--         <select name="find" id=""> -->
				<!--                     <option>用户名</option> -->
				<!--                     <option>id</option> -->
				<!--         </select> -->
				<input type="hidden" name="ms" value="selectCG"> <input
					type="submit" value="搜索" />
			</form>

		</div>
		<table>
			<tr>
				<td>序号</td>
				<td>发件人</td>
				<td>发送时间</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${list}" var="msg">
				<tr>
					<td>${msg.message_id }</td>
					<td><c:if test="${msg.sender==user.user_id}">
							<c:forEach items="${list1}" var="all">
								<c:if test="${msg.sender==all.user_id }">
										${all.username}
									</c:if>
							</c:forEach>
						</c:if></td>
					<td style="width: 200px;">${msg.send_time}</td>
					<td>
					<a href="msg?ms=updateGet&message_id=${msg.message_id}"><i class="fa fa-trash-o" /></i></a>
					<a href="msg?ms=deleteGet&message_id=${msg.message_id}"><i class="fa fa-times"></i></a>
					</td>
				</tr>
			</c:forEach>
			
			
			
						<c:forEach items="${list3}" var="ms">
				<tr>
					<td>${ms.message_id }</td>
				<%-- 	<c:if test="${msg.sender==user.user_id }"> --%>
							<c:forEach items="${list2}" var="all">
								<c:if test="${ms.receiver==all.user_id }">
										<td>${all.username}</td> 
									</c:if>
							</c:forEach>
<%-- 						</c:if>--%>
					<td style="width: 200px;">${ms.send_time}</td>
					<td><a href="msg?n=delete&id=${ms.message_id}"><i
							class="fa fa-times"></i></td>
				</tr>
			</c:forEach>
		</table>





		<div id="jilu">
			<p>总共${count}条记录，第${page2}页,每页5条记录</p>
		</div>

		<c:if test="${count%5==0}">
			<c:set var="page" value="${count/5}" />
		</c:if>
		<c:if test="${count%5!=0}">
			<c:set var="page" value="${count/5+1}" />
		</c:if>



		<div id="pa">
			<nav aria-label="Page navigation">
			<ul class="pagination">

				<li><c:if test="${page2>1&&page2<=page}">
						<a href="msg?ms=allGet&page=${page2-1}">上一页</a>
					</c:if></li>
				<li class="active"><a>${page2}</a></li>

				<li><c:if test="${page2>=1&&page2<page-1}">
						<a href="msg?ms=allGet&page=${page2+1}">下一页</a>
					</c:if></li>

			</ul>
			</nav>
		</div>
	</div>
</body>
</html>