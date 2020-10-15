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
<title>联系记录</title>
<style type="text/css">
#a {
	width: 1200px;
	position: relative;
	left: 50px;
	top: 35px;
	text-align: center;
}

#b {
	position: absolute;
	left: 1100px;
	width: 100px;
}

#pa {
	position: absolute;
	top: 340px;
	left: 1100px;
}

#pa li {
	list-style-type: none;
	display: inline-block;
}

p {
	position: absolute;
	top: 370px;
	left: 80px;
}
#from{
position: absolute;
left:800px;
top:60px;
}
#but{
position: absolute;
left:1150px;
top:50px;
}

</style>
</head>
<body>
	<a href="addCus_L_Rec.jsp" id="but"><button class="btn btn-primary">添加记录</button></a>
	<form action="record" >
	<div id="from">
	<input type="hidden" name="rec"value="selectF">
		<input type="text" onclick="" type="button"name="name">
		
		
		<input type="submit" value="提交查询" class="btn btn-default">
		</div>
		<h3 id="c">&nbsp;&nbsp;&nbsp;&nbsp;联系记录</h3>


		<table class="table table-bordered" id="a">
			<tr>
				<td>记录ID</td>
				<td>客户ID</td>
				<td>联系类型</td>
				<td>联系主题</td>
				<td>备注</td>
				<td>修改人</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${list}" var="r">
				<tr>
					<td>${r.record_id}</td>
					<c:forEach items="${selectCus}" var="c">
						<c:if test="${c.customer_id==r.customer_id}">
							<td>${c.customer_name}</td>
						</c:if>
					</c:forEach>
					<td>${r.link_type}</td>
					<td>${r.link_subject}</td>
					<td>${r.remark}</td>
					<td>${user.username}</td>
					<td><a href="record?rec=selectById&record_id=${r.record_id}"><i
							class="fa fa-pencil"></i></a> <a
						href="record?rec=deleteCus_l_rec&record_id=${r.record_id}"><i
							class="fa fa-times"></i></a></td>
				</tr>
			</c:forEach>
						<c:forEach items="${list1}" var="r">
				<tr>
					<td>${r.record_id}</td>
					<c:forEach items="${selectCus}" var="c">
						<c:if test="${c.customer_id==r.customer_id}">
							<td>${c.customer_name}</td>
						</c:if>
					</c:forEach>
					<td>${r.link_type}</td>
					<td>${r.link_subject}</td>
					<td>${r.remark}</td>
					<td>${user.username}</td>
					<td><a href="record?rec=selectById&record_id=${r.record_id}"><i
							class="fa fa-pencil"></i></a> <a
						href="record?rec=deleteCus_l_rec&record_id=${r.record_id}"><i
							class="fa fa-times"></i></a></td>
				</tr>
			</c:forEach>
		<c:forEach items="${list1}" var="r">
				<tr>
					<td>${r.record_id}</td>
					<c:forEach items="${selectCus}" var="c">
						<c:if test="${c.customer_id==r.customer_id}">
							<td>${c.customer_name}</td>
						</c:if>
					</c:forEach>
					<td>${r.link_type}</td>
					<td>${r.link_subject}</td>
					<td>${r.remark}</td>
					<td>${user.username}</td>
					<td><a href="record?rec=selectById&record_id=${r.record_id}"><i
							class="fa fa-pencil"></i></a> <a
						href="record?rec=deleteCus_l_rec&record_id=${r.record_id}"><i
							class="fa fa-times"></i></a></td>
				</tr>
			</c:forEach>
						<c:forEach items="${list1}" var="r">
				<tr>
					<td>${r.record_id}</td>
					<c:forEach items="${selectCus}" var="c">
						<c:if test="${c.customer_id==r.customer_id}">
							<td>${c.customer_name}</td>
						</c:if>
					</c:forEach>
					<td>${r.link_type}</td>
					<td>${r.link_subject}</td>
					<td>${r.remark}</td>
					<td>${user.username}</td>
					<td><a href="record?rec=selectById&record_id=${r.record_id}"><i
							class="fa fa-pencil"></i></a> <a
						href="record?rec=deleteCus_l_rec&record_id=${r.record_id}"><i
							class="fa fa-times"></i></a></td>
				</tr>
			</c:forEach>

		</table>
	</form>
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
			<li><c:if test="${page2>1}">
					<a href="record?rec=selectAll&page=${page2-1}">上一页</a>
				</c:if></li>
			<li class="active"><a>${page2}</a> <li>
		           <c:if
					test="${page2<(page-1)}">
					<a href="record?rec=selectAll&page=${page2+1}">下一页</a>
				</c:if></li></ul>
		</nav>
	</div>
</body>

</html>