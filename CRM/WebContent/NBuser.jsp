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
<title>Insert title here</title>
</head>
<style type="text/css">
table {
	position: absolute;
	top: 100px;
	border-collapse: collapse;
	border: 1px solid gainsboro;
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
	top:-40px;
	left: 700px;
}

#pa {
	position: absolute;
	top: 340px;
	left: 570px;
}

#pa li {
	list-style-type: none;
	display: inline-block;
}

#jilu {
	position: absolute;
	top: 280px;
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
}
.q{
position: relative;
left:60px;
}
table{
position: relative;
top:-10px;
}

</style>
</head>
<body>
	<div id="zong">
		<p>用户列表</p>

				<table>
			<tr>
				<td>序号</td>
				<td>用户名</td>
				<td>部门</td>
				<td>角色</td>
				<td colspan="2">手机号</td>
				<td colspan="2">邮箱</td>
				<td colspan="3">更新时间</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${list}" var="user">
				<tr>
					<td>${user.user_id }</td>
					<td>${user.username}</td>
					<td>${user.department_id }</td>
					<td>${user.role_id}</td>
					<td colspan="2">${user.mobile}</td>
					<td colspan="2">${user.email}</td>
					<td colspan="3">${user.update_time}</td>
					<td><a href="user?n=selectById&user_id=${user.user_id}"><i
							class="fa fa-pencil"></i></a>
							 <a href="user?n=delete&user_id=${user.user_id}"><i class="fa fa-times"></i></a></td>
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
						<a href="nb?b=NBU&page=${page2-1}">上一页</a>
					</c:if></li>
				<li class="active">
				<c:forEach var="i" begin="1" end="${page}">
						<a href="nb?b=NBU&page=${i}">第${i}页</a>
					</c:forEach>
					</li>
				<li>
				<c:if test="${page2>=1&&page2<page-1}">
						<a href="nb?b=NBU&page=${page2+1}">下一页</a>
					</c:if>
					</li>
			</ul>
			</nav>
		</div>
	</div>
</body>
</html>