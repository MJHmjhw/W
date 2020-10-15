<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="jquery/jquery.js"></script>
<script src="jquery/jquery.validate.min.js"></script>
<script src="jquery/messages_zh.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="afont-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
	<form action="care" onsubmit="return a()">
		<table class="table table-bordered" >
			<tr>
				<td>客户关怀ID</td>
				<td><input type="text" name="customer_care_id" value=""></td>
			</tr>
			<tr>
				<td>客户ID</td>
				<td><input type="text" name="customer_id" value=""></td>
			</tr>
			<tr>
				<td>关怀主题</td>
				<td><input type="text" name="care_subject" value="" id="name"><i id="i"></i></td>
			</tr>
			<tr>
				<td>关怀方式</td>
				<td><input type="text" name="care_type" value=""></td>
			</tr>
			<tr>
				<td>备注</td>
				<td><input type="text" name="remark" value=""></td>
			</tr>
			<tr>
				<td>下次关怀时间</td>
				<td>	<input size="16" type="date" value="next_time">
</td>
			</tr>
		</table>
			<input type="hidden"name="ca" value="addCus_care">
	<input type="submit" value="提交添加">
	</form>
</body>
	<script type="text/javascript">
	var flag=true;
	$("#name").blur(function(){
		$.get({
			url:"care?ca=check",
			data:{
				
				care_subject:$("#name").val()
			},
			success:function(data){
				if(data=="0"){
					$("#i").text("关怀主题可以使用");
					flag=true;
				}else{
					$("#i").text("关怀主题不可以使用");
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
					customer_care_id:{
						required : true,
						minlength : 1,
						maxlength : 15
					},
					customer_id:{
						required : true,
						minlength : 1,
						maxlength : 10
					},
					care_subject:{
						required : true,
						minlength : 1,
						maxlength : 50
					},
					care_type:{
						required : true,
						minlength : 1,
						maxlength :50
					},
					remark:{
						required : true,
						minlength : 1,
						maxlength : 100
					},
				},
				messages:{
					customer_care_id:{
						required : "请输入客户关怀ID",
						minlength : "最小长度 为1",
						maxlength : "最大长度为10"
					},
					customer_id:{
						required : "请输入客户ID",
						minlength : "最小长度 为1",
						maxlength : "最大长度为10"
					},
					care_subject:{
						required : "请输入关怀主题",
						minlength : "最小长度 为1",
						maxlength : "最大长度为50"
					},
					care_type:{
						required : "请输入关怀方式",
						minlength : "最小长度 为1",
						maxlength : "最大长度为50"
					},
					remark:{
						required : "请输入备注",
						minlength : "最小长度 为1",
						maxlength : "最大长度为100"
					},
				}

			});
		})
		</script>
</html>