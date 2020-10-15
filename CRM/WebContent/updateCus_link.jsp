<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="jquery/jquery.js"></script>
<script src="jquery/jquery.validate.min.js"></script>
<script src="jquery/messages_zh.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap.min.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="afont-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="bootstrap.min.css">
<style type="text/css">
#a {
	width: 1200px;
	position: relative;
	left: 50px;
	top: 35px;
	text-align: center;
}

.a {
	position: absolute;
	left: 1150px;
	top: 50px;
}
</style>
</head>

<body>
	<h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;修改联系人</h3>
	<form action="link">
		<table class="table table-bordered" id="a">
			<tr>
				<td>联系人ID</td>
				<td><input type="text" name="link_id"
					value="${customer.link_id}"></td>
			</tr>
			<tr>
				<td>客户ID</td>
				<td><input type="text" name="customer_id"
					value="${customer.customer_id}"></td>
			</tr>
			<tr>
				<td>联系人姓名</td>
				<td><input type="text" name="link_name" id="name"
					value="${customer.link_name}"><i id="i"></i></td>
			</tr>
			<tr>
				<td>性别</td>
				<c:if test="${customer.link_is_male=='男'}">
					<td><input type="radio" name="link_is_male" value="男"
						checked="checked">男 <input type="radio"
						name="link_is_male" value="女">女</td>
				</c:if>
				<c:if test="${customer.link_is_male=='女'}">
					<td><input type="radio" name="link_is_male" value="男"
						checked="checked">男<input type="radio" name="link_is_male"
						value="女" checked="checked">女</td>
				</c:if>
			</tr>
			<tr>
				<td>职位</td>
				<td><input type="text" name="link_position"
					value="${customer.link_position}"></td>
			</tr>
			<tr>
				<td>联系人电话</td>
				<td><input type="text" name="link_mobile"
					value="${customer.link_mobile}"></td>
			</tr>
			<tr>
				<td>年龄</td>
				<td><input type="text" name="link_age"
					value="${customer.link_age}"></td>
			</tr>
			<tr>
				<td>与客户关系</td>
				<td><select name="link_relation">
						<c:if test="${customer.link_relation==1}">
							<option>亲属</option>
						</c:if>
						<c:if test="${customer.link_relation==2}">
							<option>朋友</option>
						</c:if>
						<c:if test="${customer.link_relation==3}">
							<option>同事</option>
						</c:if>
						<c:if test="${customer.link_relation==4}">
							<option>上司</option>
						</c:if>
				</select></td>
			</tr>
			<tr>
				<td>备注</td>
				<td><input type="text" name="remark"
					value="${customer.remark }"></td>
			</tr>
		</table>
		<!-- 	    <input type="" name=""value=""> -->

		<div class="a">
			<input type="hidden" name="cusl" value="updateCus_link"> <input
				type="submit" name="" value="提交修改" class="btn btn-primary">
		</div>
	</form>
</body>
<script type="text/javascript">
var flag=true;
$("#name").blur(function(){
	if($("#name").val()=='${customer.link_name}'){
		alert(1);
		$("#i").text("");
	}else{
	$.get({
		url:"link?cusl=check",
		data:{			
			link_name:$("#name").val()
		},
		success:function(data){
			if(data=="0"){
				$("#i").text("联系人姓名可以使用");
				flag=true;
			}else{
				$("#i").text("联系人姓名不可以使用");
				flag=false;
			}

		}
		
	})
	}
})
			function a(){
				return flag;
			}




	$().ready(function() {
		$("form").validate({
			rules : {
				link_id : {
					required : true,
					minlength : 1,
					maxlength : 10
				},
				customer_id : {
					required : true,
					minlength : 1,
					maxlength : 10
				},
				link_name : {
					required : true,
					minlength : 1,
					maxlength : 50
				},
				link_position : {
					required : true,
					minlength : 1,
					maxlength : 100
				},
				link_mobile : {
					required : true,
					minlength : 1,
					maxlength : 20
				},
				link_age : {
					required : true,
					minlength : 1,
					maxlength : 10
				},
				remark : {
					required : true,
					minlength : 1,
					maxlength : 50
				}

			},

			messages : {
				link_id : {
					required : "请输入联系人ID",
					minlength : "最小的长度",
					maxlength : "最大长度为10"
				},
				customer_id : {
					required : "请输入客户ID",
					minlength : "最小的长度",
					maxlength : "最大长度为10"
				},
				link_name : {
					required : "请输入联系人姓名",
					minlength : "最小的长度",
					maxlength : "最大长度为50"
				},
				link_position : {
					required : "请输入联系人职位",
					minlength : "最小的长度",
					maxlength : "最大长度为100"
				},
				link_mobile : {
					required : "请输入联系人电话",
					minlength : "最小的长度",
					maxlength : "最大长度为20"
				},
				link_age : {
					required : "请输入联系人年龄",
					minlength : "最小的长度",
					maxlength : "最大长度为10"
				},
				remark : {
					required : "请输入备注",
					minlength : "最小的长度",
					maxlength : "最大长度为50"
				}
			}
		});
	})
</script>
</html>