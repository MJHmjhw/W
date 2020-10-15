<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="jquery/jquery.js"></script>
<script src="jquery/jquery.validate.min.js"></script>
<script src="jquery/messages_zh.js"></script>
<head><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="afont-awesome-4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="record" onsubmit="return a()">
		<table  class="table table-bordered table table-hover">
			<tr>
				<td>记录ID</td>
				<td><input type="text" name="record_id" value="${ selectById.record_id}"></td>
			</tr>
			<tr>
				<td>客户ID</td>
				<td><input type="text" name="customer_id" value="${selectById.customer_id }"></td>
			</tr>
			<tr>
				<td>联系类型</td>
				<td><input type="text" name="link_type" value="${selectById.link_type }"></td>
			</tr>
			<tr>
				<td>联系主题</td>
				<td><input type="text" name="link_subject" value="${selectById.link_subject}" id="name"><i id="i"></i></td>
			</tr>
			<tr>
				<td>备注</td>
				<td><input type="text" name="remark" value="${selectById.remark }"></td>
			</tr>
			<tr>
				<td>修改人</td>
				<td><input type="text" name="updater" value="${user.user_id}"></td>
			</tr>
		</table>
		<input type="hidden" name="rec" value="updateCus_L_rec">
		<input type="submit" >
		</form>
</body>
	<script type="text/javascript">
	var flag=true;
	$("#name").blur(function(){
		if('${selectById.link_subject}'==$("#name").val()){
			$("#i").text("");
		}else{
		$.get({
			url:"link?rec=check",
			data:{
				link_subject :$("#name").val()
			},
			success:function(data){
				if(data=="0"){
					$("#i").text("联系主题可以使用");
					flag=true;
				}else{
					$("#i").text("联系主题不可以使用");
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
				record_id:{
						required : true,
						minlength : 1,
						maxlength : 10
					},
					customer_id:{
						required : true,
						minlength : 1,
						maxlength : 10
					},
					link_type:{
						required : true,
						minlength : 1,
						maxlength : 50
					},
					link_subject:{
						required : true,
						minlength : 1,
						maxlength : 200
					},
					remark:{
						required : true,
						minlength : 1,
						maxlength : 50
					},
					updater:{
						required : true,
						minlength : 1,
						maxlength : 11
					}
				},
				messages:{
					record_id:{
						required :"请输入记录ID",
						minlength : "最小位数1",
						maxlength : "最大位数10"
					},
					customer_id:{
						required : "请输入顾客ID",
						minlength : "最小位数1",
						maxlength : "最大位数10"
					},
					link_type:{
						required :"请输入联系类型",
						minlength : "最小位数1",
						maxlength : "最大位数50"
					},
					link_subject:{
						required : "请输入联系主题",
						minlength : "最小位数1",
						maxlength : "最大位数200"
					},
					remark:{
						required : "请输入备注",
						minlength : "最小位数1",
						maxlength : "最大位数50"
					},
					updater:{
						required : "请输入更新人",
						minlength : "最小位数1",
						maxlength : "最大位数11"
					}
			}
		});
	})
</script>
</html>