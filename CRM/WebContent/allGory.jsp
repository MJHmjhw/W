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
table {
	position: absolute;
	top: 100px;
	width:800px;
	border-collapse: collapse;
	border: 1px solid gainsboro;
}

td {
	width: 100px;
	height: 30px;
	border: 1px solid gainsboro;
	text-align: center;
}

#p {
	font-size: 15px;
	position: absolute;
	top:200px;
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
	left: 700px;
}

#pa {
	position: absolute;
	top: 400px;
	left:900px;
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
	position:relative;
	top:-30px;
}
</style>
<body>
	<div id="zong">
		<h3>客户分类列表</h3>
		<div>
			<span>搜索内容：輸入分类名称</span>
			<form action="gory">
				<input type="text" name="name" value="${str}">
				<input type="hidden" name="g" value="selectF"> <input
					type="submit" value="搜索" />
			</form>

			<a href="addGory.jsp" id="ch"><button class="btn btn-primary"
					id="btn">添加类型</button></a>
		</div>
		<table>
			<tr>
						<td><b>序号</b></td>
						<td><b>分类名称</b></td>
						<td><b>分类描述</b></td>
						<td><b>更新时间</b></td>
						<td><b>操作</b></td>
					</tr>
					<c:forEach items="${list}" var="cate">
					<tr>
						<td>${cate.customer_category_id}</td>
						<td>${cate.customer_category_name}</td>
						<td>${cate.customer_category_desc}</td>
						<td>${cate.update_time}</td>
						<td>
					<a href="gory?g=deleteGory&customer_category_id=${cate.customer_category_id}"><i class="fa fa-times"></i></a>
					<a href="gory?g=selectById&customer_category_id=${cate.customer_category_id}"><i class="fa fa-pencil"></i></a> 
					</td>
					</tr>
					</c:forEach>
					
										<c:forEach items="${list1}" var="cate">
					<tr>
						<td>${cate.customer_category_id}</td>
						<td>${cate.customer_category_name}</td>
						<td>${cate.customer_category_desc}</td>
						<td>${cate.update_time}</td>
						<td>
					<a href="gory?g=deleteGory&customer_category_id=${cate.customer_category_id}"><i class="fa fa-times"></i></a>
					<a href="gory?g=selectById&customer_category_id=${cate.customer_category_id}"><i class="fa fa-pencil"></i></a> 
					</td>
					</tr>
					</c:forEach>
		</table>
		        <div  id="zong">
        		<p id="p">总共${count}条记录，第${page2}页,每页5条记录</p>
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
				<li><c:if test="${page2>1&&page2<=page}">
						<a href="gory?g=allGory&page=${page2-1}">上一页</a>
					</c:if></li>
				<li class="active">
				<c:forEach var="i" begin="1" end="${page}">
						<a href="gory?g=allGory&page=${i}">第${i}页</a>
					</c:forEach>
					</li>
				<li>
				<c:if test="${page2>=1&&page2<page-1}">
						<a href="gory?g=allGory&page=${page2+1}">下一页</a>
					</c:if>
					</li>
			</ul>
			</nav>
		</div>



</body>

</html>