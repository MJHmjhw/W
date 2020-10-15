<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="jquery/jquery.js"></script>
<script src="jquery/jquery.validate.min.js"></script>
<script src="jquery/messages_zh.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Insert title here</title>
<link
	rel="stylesheet" href="bootstrap/bootstrap-3.3.7-dist/css/bootstrap.min.css"  
	type="text/css" />
<style type="text/css">
	body {
		margin: 0px;
		padding: 0px;
		background-color: #ECF0F5;
	}
	#right {
		height: 750px;
		width: 1580px;
		background-color: #FFFFFF;
		-webkit-box-shadow: 2px 2px 5px #909090;
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
		width: 1540px;
		text-align:center;
	}
	#tab,tr {
		height: 40px;
	}
	#tab,td {
		 border-color:#D6D9E1;
	}
	
	.butBelow {
		width: 62px;
	    height: 30px;
		border:2px solid #D6D9E1;
		border-radius: 3px;
		position: relative;
		left:500px;
		top:-220px;
		
	}
	.butBelow2 {
		width: 62px;
	    height: 30px;
		border:2px solid #D6D9E1;
		border-radius: 3px;
		position: relative;
		left: 709px;
		top:-220px;
		
	}
	.l1 {
		width: 220px;
	}
	.l2 {
		width: 500px;
		text-align:left;
	}
	.l3 {
		width: 220px;
	}
	
	.l4 {
		text-align:left;
	}
	.input {
		border: 2px solid #D6D9E1;
		font-size: 18px;
	}
</style>
</head>
<body>
<div id="right">
	<form action="customershow" onsubmit="return a()">
	<div><p style="font-size: 25px; padding:8px;">添加用户</p></div>
	<div id="rightTable">
		<table id="tab" border="1px" style="border-collapse: collapse; border-color:#D6D9E1;">
			<tr>
				<td class="l1">客户姓名</td>
				<td class="l2">
					<input class="input" style="margin-left: 5px;" type="text" name="customer_name" id="name"/><i id="i"></i>
				</td>
				<td class="l3">客户性别</td>
					<td class="l4">
						<input class="input" style="margin-left: 5px;" type="radio" name="sex" value="true"  checked="true"/>男
						<input class="input" style="margin-left: 5px;" type="radio" name="sex" value="false" />女
					</td>
			</tr>
			<tr>
				<td class="l1">客户手机</td>
				<td class="l2"><input  class="input" style="margin-left: 5px;" type="text" name="customer_mobile" id="phone"/><i id="i2"></i></td>
				<td class="l3">客户地址</td>
				<td class="l2"><input  class="input" style="margin-left: 5px;" type="text" name="customer_address" /></td>
			</tr>
			<tr>
				<td class="l1">客户邮箱</td>
				<td class="l2"><input  class="input" style="margin-left: 5px;" type="text" name="customer_email" /></td>
				<td class="l3">客户职位</td>
				<td class="l4"><input  class="input" style="margin-left: 5px;" type="text" name="customer_position" /></td>
			</tr>
			<tr>
				<td class="l1">客户微博</td>
				<td class="l2"><input class="input" style="margin-left: 5px;" type="text" name="customer_blog" /></td>
				<td class="l3">客户座机</td>
				<td class="l4"><input  class="input" style="margin-left: 5px;" type="text" name="customer_tel" /></td>
			</tr>
			<tr>
				<td class="l1">出生日期</td>
				<td class="l2"><input class="input" style="margin-left: 5px;" type="text" name="customer_birth" /></td>
				<td class="l3">更新时间</td>
				<td class="l4"><input  class="input" style="margin-left: 5px;" type="text" name="update_time" /></td>
			</tr>
		</table>
	</div>
		<span style=" position: relative; top: 230px;">
			<input type="hidden" name="n" value="add">
			<button class="butBelow"  type="submit" style="background-color: #4682B4; color: #FFFFFF; border-color: #4682B4;">保存</button>
		</span>
	</form>
		<span style=" position: relative; top: 200px;">
			<a href="customershow?n=show" target="content">
				<button class="butBelow2">返回</button>
			</a>
		</span>
</div>
</body>
	<script type="text/javascript">
	var flag=true;
	$("#name").blur(function(){
		$.get({
			url:"customershow?n=check1",
			data:{
				customer_name:$("#name").val(),
			},
			success:function(data){
				if(data=="0"){
					$("#i").text("客户名可以使用");
					flag=true;
				}else{
					$("#i").text("客户名不可以使用");
					flag=false;
				}

			}
			
		})
	})
		$("#phone").blur(function(){
		$.get({
			url:"customershow?n=check2",
			data:{
				customer_mobile:$("#phone").val()
			},
			success:function(data){
				if(data=="0"){
					$("#i2").text("客户电话可以使用");
					flag=true;
				}else{
					$("#i2").text("客户电话不可以使用");
					flag=false;
				}

			}
			
		})
	})
				function a(){
					return flag;
				}

	
	
	
		$().ready(function() { // jquery预备函数,加载完文件后就执行这个函数
			$("form").validate({
				/* 校验分为两部分,第一部分是校验规则 */
				rules : {
					customer_name : {
						required : true,
						minlength : 1,
						maxlength : 10
					},
					customer_mobile : {
						required : true,
						minlength : 1,
						maxlength : 20
					},
					customer_address : {
						required : true,
						minlength : 1,
						maxlength : 100
					},
					customer_email : {
						required : true,
						minlength : 1,
						maxlength : 100
					},
					customer_position : {
						required : true,
						minlength : 1,
						maxlength : 100
					},
					customer_blog : {
						required : true,
						minlength : 1,
						maxlength : 100
					},
					customer_tel : {
						required : true,
						minlength : 1,
						maxlength : 100
					},
					customer_birth : {
						required : true,
						minlength : 1,
						maxlength : 100
					}
				},
				messages: {
					customer_name : {
						required : "请输入客户姓名",
						minlength : "最小长度为1",
						maxlength : "最大长度为10"
					},
					customer_mobile : {
						required : "请输入客户手机号",
						minlength : "最小长度为1",
						maxlength : "最大长度为10"
					},
					customer_address : {
						required : "请输入客户地址",
						minlength : "最小长度为1",
						maxlength : "最大长度为100"
					},
					customer_email : {
						required :"请输入客户邮箱",
						minlength : "最小长度为1",
						maxlength : "最大长度为100"
					},
					customer_position : {
						required : "请输入客户职位",
						minlength : "最小长度为1",
						maxlength : "最大长度为100"
					},
					customer_blog : {
						required : "请输入客户微博",
						minlength : "最小长度为1",
						maxlength : "最大长度为100"
					},
					customer_tel : {
						required : "请输入客户电话",
						minlength : "最小长度为1",
						maxlength : "最大长度为100"
					},
					customer_birth : {
						required : "请输入客户生日",
						minlength : "最小长度为1",
						maxlength : "最大长度为100"
					}
				}
				
			});
		})
	</script>
</html>