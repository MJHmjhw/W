<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户列表</title>
<link rel="stylesheet" href="bootstrap.min.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="afont-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="bootstrap.min.css">
</head>
<style type="text/css">
body {
	margin: 0px;
	padding: 0px;
	background-color: #ECF0F5;
}

#right {
	height: 600px;
	width: 1580px;
	background-color: #FFFFFF;
	-webkit-box-shadow: 2px 2px 5px #909090;
}

#rightUp {
	height: 30px;
	width: 1580px;
	background-color: #FFFFFF;
}

#rightTable {
	height: 400px;
	width: 1560px;
	margin: 10px;
	background-color: #FFFFFF;
}

#tab {
	position: relative;
	left: 10px;
	top: 10px;
	width: 1200px;
	text-align: center;
}

#tab, tr {
	height: 40px;
}

#tab, td {
	border-color: #D6D9E1;
}

#tab, th {
	border-color: #D6D9E1;
}

.l1 {
	width: 60px;
}

.l2, .l3 {
	width: 80px;
}

.l4 {
	width: 140px;
}

.l10, .l11 {
	width: 160px
}

.l12 {
	width: 140px
}

#rightBelow {
	height: 30px;
	width: 1580px;
	background-color: #FFFFFF;
}

.butBelow {
	width: 62px;
	height: 30px;
	border: 2px solid #D6D9E1;
	border-radius: 3px;
	position: relative;
	left: 1205px;
}
#as{
position: 
absolute;
left:1100px;
}

#butBelowCentre {
	width: 40px;
}
/* 	 li { */
/* 	list-style-type: none; */
/* 	display: inline-block; */
/* } */
/* #pen{ */
/* position: absolute; */
/* left:100px; */
/* top:100px; */
/* } */
</style>
<body>
	<div id="right">
		<div>
			<p style="font-size: 25px; padding: 8px;">客户列表</p>
		</div>
		<div id="rightUp">
		 <a href="addcustomer.jsp" id="as"><button class="btn btn-primary">添加客户</button></a>
			<form action="customershow">
				<span style="position: relative; left: 10px;">搜索内容： <input
					type="hidden" name="n" value="dim" /> <input type="text"
					name="str"
					style="width: 180px; height: 30px; border-radius: 8px; border: 2px solid #D6D9E1;" />
				</span>
				<button type="submit"
					style="width: 80px; height: 30px; border: 2px solid #D6D9E1; border-radius: 8px; position: relative; left: 50px;">搜索</button>

				</span>
			</form>
			<span style="position: relative; left: 1480px; bottom: 30px">
				<a href="addcustomer.jsp" target="content">
					<button
						style="width: 80px; height: 30px; border: 2px solid #D6D9E1; border-radius: 8px; color: #FFFFFF; background-color: #4682B4;">添加客户</button>
			</a>
			</span>
		</div>
		<div id="rightTable">
			<table id="tab" border="1px"
				style="border-collapse: collapse; border-color: #D6D9E1;">
				<tr>
					<th class="l1" style="text-align: center;">客户ID</th>
					<th class="l2" style="text-align: center;">客户姓名</th>
					<th class="l3" style="text-align: center;">客户性别</th>
					<th class="l4" style="text-align: center;">客户手机</th>
					<th class="l5" style="text-align: center;">客户地址</th>
					<th class="l6" style="text-align: center;">客户邮箱</th>
					<th class="l7" style="text-align: center;">客户职位</th>
					<th class="l8" style="text-align: center;">客户微博</th>
					<th class="l9" style="text-align: center;">客户座机</th>
					<th class="l10" style="text-align: center;">出生日期</th>
					<th class="l11" style="text-align: center;">更新时间</th>
					<th class="l12" style="text-align: center;">操作</th>
				</tr>
				<c:forEach items="${list}" var="customer">
					<tr>
						<td class="l1">${customer.customer_id}</td>
						<td class="l2">${customer.customer_name}</td>
						<td class="l3"><c:choose>
								<c:when test="${customer.customer_is_male==true}">男</c:when>
								<c:otherwise>女</c:otherwise>
							</c:choose></td>
						<td class="l4">${customer.customer_mobile}</td>
						<td class="l5">${customer.customer_address}</td>
						<td class="l6">${customer.customer_email}</td>
						<td class="l7">${customer.customer_position}</td>
						<td class="l8">${customer.customer_blog}</td>
						<td class="l9">${customer.customer_tel}</td>
						<td class="l10">${customer.customer_birth}</td>
						<td class="l11">${customer.update_time}</td>
						<td class="l12"><a
							href="customershow?n=byID&id=${customer.customer_id}"> <i
								class="fa fa-pencil" id="pen"></i>
						</a> <a href="customershow?n=delete&id=${customer.customer_id}"> <i
								class="fa fa-times" id="time"></i>
						</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div id="rightBelow">
			<span style="position: relative; left: 10px; top: 5px;">
				总共有${count} 条记录，当前第${page2}页 <c:if test="${count%8==0}">
					<c:set var="page" value="${count/8}"></c:set>
				</c:if> <c:if test="${count%8!=0}">
					<c:set var="page" value="${count/8+1}"></c:set>
				</c:if> <!-- 展示show界面 --> <c:if test="${m eq 'show'}">
					<c:if test="${page2>1&&page2<=page}">
						<a href="customershow?n=show&page=${page2-1}">
							<button class="butBelow">上一页</button>
						</a>
					</c:if>

					<a href="customershow?n=show&page=${page2}">
						<button class="butBelow" id="butBelowCentre">${page2}</button>
					</a>

					<c:if test="${page2>=1&&page2<page-1}">
						<a href="customershow?n=show&page=${page2+1}">
							<button class="butBelow">下一页</button>
						</a>
					</c:if>
				</c:if> <!-- 展示模糊查询 --> <c:if test="${m eq 'dim'}">
					<c:if test="${page2>1&&page2<=page }">
						<a href="customershow?n=dim&page=${page2-1}&str=${NAME}">
							<button class="butBelow">上一页</button>
						</a>
					</c:if>

					<a href="customershow?n=dim&page=${page2}&str=${NAME}">
						<button class="butBelow" id="butBelowCentre">${page2}</button>
					</a>

					<c:if test="${page2>=1&&page2<page-1 }">
						<a href="customershow?n=dim&page=${page2+1}&str=${NAME}">
							<button class="butBelow">下一页</button>
						</a>
					</c:if>
				</c:if>
			</span>
		</div>
	</div>
</body>
</html>