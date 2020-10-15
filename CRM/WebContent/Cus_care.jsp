<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="afont-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="bootstrap.min.css">
<title>Insert title here</title>
<style type="text/css">

#a {
	width: 1200px;
	position: relative;
	left: 50px;
	top: 35px;
	text-align: center;
}
#b{
position: relative;
left:1150px;
 top :60px;
}
#pa li {
	list-style-type: none;
	display: inline-block;
}
#pa {
	position: absolute;
	top: 400px;
	left: 1170px;
}

#jilu {
	position: relative;
	top: 280px;
}
#as{
position: absolute;
top:-100px;
left:100px;
}
#ss{
position: absolute;
left:600px;
top:80px;
}
</style>
</head>

<body>
<a href="addCus_care.jsp"><button class="btn btn-primary" id="b">添加关怀记录</button></a>
	<form action="care">
	<div id="ss">
	<input type="text"name="name" value="">
	<input type="hidden"name="ca" value="selectF">
	<input type="submit"value="提交">
	</div>
	<h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;客户关怀</h3>
		<table   class="table table-bordered" id="a">
			<tr>
				<td>客户关怀ID</td>
				<td>客户ID</td>
				<td>关怀主题</td>
				<td>关怀方式</td>
				<td>备注</td>
				<td>下次关怀时间</td>
				<td>操作</td>
			</tr>
			
			<c:forEach items="${list}" var="r">
			<tr>
			<td>${r.customer_id}</td>
			<c:forEach items="${cus}" var="cus">
			<c:if test="${cus.customer_id==r.customer_id}">
			<td>${cus.customer_name}</td>
			</c:if>
			</c:forEach>
			<td>${r.care_subject}</td>
			<td>${r.care_type}</td>
			<td>${r.remark}</td>
			<td>${r.next_time}</td>
							<td><a
					href="care?ca=selectById&customer_care_id=${r.customer_care_id}"><i
						class="fa fa-pencil"></i></a> <a
					href="care?ca=deleteCus_care&customer_care_id=${r.customer_care_id}"><i
						class="fa fa-times"></i></a></td>
			</tr>
			</c:forEach>
						<c:forEach items="${list1}" var="r">
			<tr>
			<td>${r.customer_id}</td>
			<c:forEach items="${cus}" var="cus">
			<c:if test="${cus.customer_id==r.customer_id}">
			<td>${cus.customer_name}</td>
			</c:if>
			</c:forEach>
			<td>${r.care_subject}</td>
			<td>${r.care_type}</td>
			<td>${r.remark}</td>
			<td>${r.next_time}</td>
							<td><a
					href="care?ca=selectById&customer_care_id=${r.customer_care_id}"><i
						class="fa fa-pencil"></i></a> <a
					href="care?ca=deleteCus_care&customer_care_id=${r.customer_care_id}"><i
						class="fa fa-times"></i></a></td>
			</tr>
			</c:forEach>




		</table>


	</form>
			<div id="jilu">
			<p id="as">总共${count}条记录，第${page2}页,每页5条记录</p>
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