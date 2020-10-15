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
</head>
<style type="text/css">
tr td:nth-of-type(1) {
	width: 50px;
	text-align: center;
}

input {
	outline: none;
	border: none;
}

#btn {
	text-align: center;
}

p {
	font-size: 20px;
}
</style>
</head>
<body>
	<form action="not">
	<input type="hidden" name="id" value="${notice.notice_id}">
		<p>更新公告</p>
		<table class="table table-bordered">

			<tr>
				<td colspan="2">发布时间</td>
				<td colspan="6"><input type="text" name="pub_time"
					value="${notice.pub_time}"></td>
				<td colspan="2">截止时间</td>
				<td colspan="6"><input type="text" name="expire_time"
					value="${notice.expire_time}"></td>
			</tr>

			<tr>
				<td colspan="2">主题</td>
				<td colspan="6"><input type="text" name="subject"
					value="${notice.subject}"></td>
				<td colspan="2">通知范围</td>
				<td colspan="6"><select name="receive_id" id="">
				<c:forEach items="${department}" var="d">
                  <c:if test="${d.department_id==notice.receive_id}">
						<option selected="selected">${d.department_name}</option>
					</c:if>
					  <c:if test="${d.department_id!=notice.receive_id}">
						<option>${d.department_name}</option>
					</c:if>
					</c:forEach>
					
					
					
<%-- 	                   <c:forEach items="${list}" var="l"> --%>
<%-- 							<option>${l.department_name}</option> --%>
<%-- 						</c:forEach> --%>
				</select></td>
			</tr>

			<tr>
				<td colspan="2" rowspan="6" style="line-height: 200px;">内容</td>
				<td colspan="14" rowspan="6"><textarea name="text" id=""
						cols="120" rows="10" style="outline: none; resize: none;"
						placeholder="请输入公告">${notice.text}</textarea></td>
			</tr>
		</table>
		<div id="btn">
			<input type="text" name="" value=""> <input type="hidden"
				name="creater" value="${a.user_id}"> <input type="hidden"
				name="q" value="updateNotice"> <input type="hidden"
				name="receive_id" value="${notice.receive_id}"> <input
				type="submit" value="提交" class="btn btn-primary">
		</div>
	</form>
</body>
</html>