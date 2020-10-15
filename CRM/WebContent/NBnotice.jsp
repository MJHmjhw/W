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
<title>Insert title here</title>
</head>
<style>
td {
	text-align: center;
	font-size: 15px;
}

.a {
	width: 300px;
}

.b {
	width: 400px;
}

#a11 {
	border-radius: 15%;
	position: relative;
	left: 30px;
	border: none;
	background-color: gray;
	padding-top: 3px;
	padding-bottom: 3px;
	top: -2px;
}

#a12 {
	border-radius: 15%;
	position: relative;
	left: 1050px;
	top: -10px;
}

nav {
	position: relative;
	left: 670px;
	top: -10px;
}

#qqqqq {
	width: 1200px;
	position: relative;
	left: 70px;
}

h3 {
	position: relative;
	left: -40px;
}

#pa {
	position: absolute;
	top: 350px;
	left: 400px;
}

#pa li {
	list-style-type: none;
	display: inline-block;
}

.bu2 {
	position: relative;
	left: 13px;
	top: -5px;
}

.bu1 {
	position: relative;
	left: -13px;
	top: 10px;
}

#zong {
	position: absolute;
	top: 350px;
}

#zx {
	width: 10px;
}
#qw{
position: relative;
left:300px;
}

</style>
<body>
	<div id="qqqqq">
		<h3>&numsp;&numsp;公告信息</h3>
		<table>

			<tr>

 				<td><!-- <select name="" id=""> -->
<!-- 						<option value="">主题</option> -->
<!-- 						<option value="">日期</option> -->
<!-- 						<option value="">年份</option> -->
<!-- 				</select> -->
				</td>
			</tr>
		</table>
		<table border="1px " class="table table-bordered table table-hover">
			<tr>
				<td>序号</td>
				<td>公告人</td>
				<td class="a">公告主题</td>
				<td>通知范围</td>
				<td class="b">公告内容</td>
				<td>公告时间</td>
				<td>截止时间</td>
			</tr>
			<c:forEach items="${list}" var="notice">
				<tr>
					<td>${notice.notice_id}</td>
					<td>${notice.creater}</td>
					<td id="zx">${notice.subject}</td>
					<td>${notice.receive_id}</td>
					<td>${notice.text}</td>
					<td>${notice.pub_time}</td>
					<td>${notice.expire_time}</td>
				</tr>
			</c:forEach>
			<c:forEach items="${list1}" var="notice">
				<tr>
					<td>${notice.notice_id}</td>
					<td>${notice.creater}</td>
					<td id="zx">${notice.subject}</td>
					<td>${notice.receive_id}</td>
					<td>${notice.text}</td>
					<td>${notice.pub_time}</td>
					<td>${notice.expire_time}</td>
				</tr>
			</c:forEach>
		</table>
		<div id="zong">

			<p>总共${count}条记录，第${page2}页,每页3条记录</p>
		</div>

		<c:if test="${count%5==0}">
			<c:set var="page" value="${count/5}" />
		</c:if>
		<c:if test="${count%5!=0}">
			<c:set var="page" value="${count/5+1}" />
		</c:if>
	</div>
	<div id="pa">
		<nav aria-label="Page navigation">
		<ul class="pagination">
			<li><c:if test="${page2>1}">
					<a href="nb?b=NBN&page=${page2-1}">上一页</a>
				</c:if></li>
			<li class="active">
				<%-- 				<c:forEach var="i" begin="1" end="${page}"> --%> <%-- 						<a href="not?q=allNotice&page=${i}">第${i}页</a> --%>
				<%-- 					</c:forEach> --%> <a>${page2}</a>
			</li>
			<li><c:if test="${page2<=page}">
					<a href="nb?b=NBN&page=${page2+1}">下一页</a>
				</c:if></li>
		</ul>
		</nav>
	</div>
</html>