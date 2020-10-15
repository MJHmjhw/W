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
	<h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;添加联系人</h3>
	<form action="link" onsubmit="return a()">
		<table class="table table-bordered" id="a">
			<tr>
				<td>联系人ID</td>
				<td><input type="text" name="link_id" value=""></td>
			</tr>
			<tr>
				<td>客户ID</td>
				<td><input type="text" name="customer_id" value=""></td>
			</tr>
			<tr>
				<td>联系人姓名</td>
				<td><input type="text" name="link_name" value="" id="name"><i id="i"></i></td>
			</tr>
			<tr>
				<td>性别</td>
				<td><input type="radio" name="link_is_male" value="男"
					checked="checked">男 <input type="radio" name="link_is_male"
					value="女">女</td>
			</tr>
			<tr>
				<td>职位</td>
				<td><input type="text" name="link_position" value=""></td>
			</tr>
			<tr>
				<td>联系人电话</td>
				<td><input type="text" name="link_mobile" value=""></td>
			</tr>
			<tr>
				<td>年龄</td>
				<td><input type="text" name="link_age" value=""></td>
			</tr>
			<tr>
				<td>与客户关系</td>
				<td><select name="link_relation">
						<option>亲属</option>
						<option>朋友</option>
						<option>同事</option>
						<option>上司</option>
				</select></td>
			</tr>
			<tr>
				<td>备注</td>
				<td><input type="text" name="remark" value=""></td>
			</tr>
		</table>
		<!-- 	    <input type="" name=""value=""> -->

		<div class="a">
			<input type="hidden" name="cusl" value="addCus_link"> <input
				type="submit" name="" value="提交添加" class="btn btn-primary">
		</div>
	</form>
</body>
<script type="text/javascript">
var flag=true;
$("#name").blur(function(){
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
})
			function a(){
				return flag;
			}





		$().ready(function() {
			$("form").validate({
rules : {
	link_id:{
		required : true,
		minlength : 1,
		maxlength : 10	
	},
	customer_id:{
		required : true,
		minlength : 1,
		maxlength : 10	
	},
	link_name:{
		required : true,
		minlength : 1,
		maxlength : 50	
	},
	link_position:{
		required : true,
		minlength : 1,
		maxlength : 100	
	},
	link_mobile:{
		required : true,
		minlength : 1,
		maxlength : 20	
	},
	link_age:{
		required : true,
		minlength : 1,
		maxlength : 10	
	},
	remark:{
		required : true,
		minlength : 1,
		maxlength : 50	
	}
	
	
				},
				
				messages:{
					link_id:{
						required : "请输入联系人ID",
						minlength : "最小的长度",
						maxlength : "最大长度为10"
					},
					customer_id:{
						required : "请输入客户ID",
						minlength : "最小的长度",
						maxlength : "最大长度为10"
					},
					link_name:{
						required : "请输入联系人姓名",
						minlength : "最小的长度",
						maxlength : "最大长度为50"
					},
					link_position:{
						required : "请输入联系人职位",
						minlength : "最小的长度",
						maxlength : "最大长度为100"
					},
					link_mobile:{
						required : "请输入联系人电话",
						minlength : "最小的长度",
						maxlength : "最大长度为20"
					},
					link_age:{
						required : "请输入联系人年龄",
						minlength : "最小的长度",
						maxlength : "最大长度为10"
					},
					remark:{
						required : "请输入备注",
						minlength : "最小的长度",
						maxlength : "最大长度为50"
					}	
					
					
				}
				});
			})
		</script>
</html>