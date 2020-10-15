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

#from {
	position: absolute;
	left: 800px;
	top: 60px;
}

#but {
	position: absolute;
	left: 1150px;
	top: 50px;
}
</style>
</head>
<body>
	<a href="add_Cus.jsp" id="but"><button class="btn btn-primary">添加记录</button></a>
	<form action="link">
		<div id="from">
			<input type="hidden" name="cusl" value="selectF"> <input
				type="text" name="name"> <input type="submit" value="提交查询"
				class="btn btn-default">
		</div>
		<h3 id="c">&nbsp;&nbsp;&nbsp;&nbsp;添加客户</h3>


		<table class="table table-bordered" id="a">
			<tr>
				<td>联系人ID</td>
				<td>客户ID</td>
				<td>联系人姓名</td>
				<td>性别</td>
				<td>职位</td>
				<td>联系电话</td>
				<td>与客户关系</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${list}" var="r">
				<tr>
					<td>${r.link_id}</td>
					<c:forEach items="${cus}" var="cus">
						<c:if test="${cus.customer_id==r.customer_id}">
							<td>${cus.customer_name}</td>
						</c:if>
					</c:forEach>
					<td>${r.link_name}</td>
					<c:if test="${r.link_is_male =='男'}">
						<td>男</td>
					</c:if>
							<c:if test="${r.link_is_male =='女'}">
						<td>女</td>
					</c:if>
					<td>${r.link_position}</td>
					<td>${r.link_mobile}</td>
					<td><c:if test="${r.link_relation==1}">
							<option>亲属</option>
						</c:if> <c:if test="${r.link_relation==2}">
							<option>朋友</option>
						</c:if> <c:if test="${r.link_relation==3}">
							<option>同事</option>
						</c:if> <c:if test="${r.link_relation==4}">
							<option>上司</option>
						</c:if></td>
					<td><a href="link?cusl=selectById&link_id=${r.link_id}"><i
							class="fa fa-pencil"></i></a> <a
						href="link?cusl=deleteCus_link&link_id=${r.link_id}"><i
							class="fa fa-times"></i></a></td>
				</tr>
			</c:forEach>
				<c:forEach items="${list1}" var="r">
				<tr>
					<td>${r.link_id}</td>
					<c:forEach items="${cus}" var="cus">
						<c:if test="${cus.customer_id==r.customer_id}">
							<td>${cus.customer_name}</td>
						</c:if>
					</c:forEach>
					<td>${r.link_name}</td>
					<c:if test="${r.link_is_male =='男'}">
						<td>男</td>
					</c:if>
							<c:if test="${r.link_is_male =='女'}">
						<td>女</td>
					</c:if>
					<td>${r.link_position}</td>
					<td>${r.link_mobile}</td>
					<td><c:if test="${r.link_relation==1}">
							<option>亲属</option>
						</c:if> <c:if test="${r.link_relation==2}">
							<option>朋友</option>
						</c:if> <c:if test="${r.link_relation==3}">
							<option>同事</option>
						</c:if> <c:if test="${r.link_relation==4}">
							<option>上司</option>
						</c:if></td>
					<td><a href="link?cusl=selectById&link_id=${r.link_id}"><i
							class="fa fa-pencil"></i></a> <a
						href="link?cusl=deleteCus_link&link_id=${r.link_id}"><i
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
					<a href="link?cusl=selectCus_link&page=${page2-1}">上一页</a>
				</c:if></li>
			<li class="active"><a>${page2}</a>
			<li><c:if test="${page2<(page-1)}">
					<a href="link?cusl=selectCus_link&page=${page2+1}">下一页</a>
				</c:if></li>
		</ul>
		</nav>
	</div>
</body>
</html>