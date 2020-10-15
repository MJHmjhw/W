<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="jquery/jquery.js"></script>
<script src="jquery/jquery.validate.min.js"></script>
<script src="jquery/messages_zh.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="bootstrap.min.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="afont-awesome-4.7.0/css/font-awesome.min.css">
<title>Insert title here</title>
</head>
<style>
table, td {
	border: 1px solid #ccc;
	border-collapse: collapse;
	background-color: white;
	height: 50px;
}

td {
	width: 200px;
}

.a {
	width: 200px;
	text-align: center;
}

.b {
	width: 300px;
}

#w {
	position: relative;
	left: 700px;
	top: 30px;
	border-radius: 15%;
	border: none;
	font-size: 20px;
	background-color: lightblue;
	color: white;
	background-color: rgb(110, 108, 122);
}

#q {
	position: relative;
	left: 200px;
	top: 30px;
	background-color: rgb(110, 108, 122);
	border: none;
	color: white;
	font-size: 20px;
	border-radius: 15%;
}

#aaa {
	width: 1900px;
	position: relative;
	left: 120px;
	top: -20px;
}

textarea {
	height: 30px;
}
</style>
<body>
	<div id="aaa">
		<form action="user">
			<table>
				<th><h2>更新用户</h2></th>
				<tr>
					<td class="a">用户名</td>
					<td><input type="text" value="${user.username}" id="name2"
						name="username"><i id="i"></i></td>
					<td class="a">密码</td>
					<td><input type="password" value="${user.password}"
						name="password"></td>
				</tr>

				<tr>
					<td class="a">部门</td>
					<td class="b"><select name="department_id" id="">
							<c:forEach items="${list2}" var="d">
								<c:if test="${d.department_id==user.department_id}">
									<option selected="selected">${d.department_name}</option>
								</c:if>
							</c:forEach>
							<c:forEach items="${list2}" var="d">
								<c:if test="${d.department_id!=user.department_id}">
									<option>${d.department_name}</option>
								</c:if>
							</c:forEach>
					</select></td>
					<td class="a">角色</td>
					<td class="b"><select name="role_id" id="">
							<c:forEach items="${list1}" var="d">
								<c:if test="${d.role_id==user.role_id}">
									<option selected="selected">${d.role_name}</option>
								</c:if>
								<c:if test="${d.role_id!=user.role_id}">
									<option>${d.role_name}</option>
								</c:if>
							</c:forEach>
					</select></td>
				</tr>

				<tr>
					<td class="a">性别</td>
					<td class="b"><input type="radio" name="is_male"
						value="${user.is_male}">男 <input type="radio"
						checked="checked" name="is_male" value="${user.is_male}">女</td>
					<td class="a">手机号</td>
					<td class="b"><input type="text" value="${user.mobile}"
						name="mobile"></td>
				</tr>

				<tr>
					<td class="a">地址</td>
					<td class="b"><input type="text" value="${user.address}"
						name="address"></td>
					<td class="a">年龄</td>
					<td class="b"><input type="text" value="${user.age}"
						name="age"></td>
				</tr>

				<tr>
					<td class="a">固定电话</td>
					<td class="b"><input type="text" value="${user.tel}"
						name="tel"></td>
					<td class="a">身份证号</td>
					<td class="b"><input type="text" value="${user.id_num}"
						name="id_num"></td>
				</tr>

				<tr>
					<td class="a">电子邮箱</td>
					<td class="b"><input type="text" value="${user.email}"
						name="email"></td>
					<td class="a">QQ号</td>
					<td class="b"><input type="text" name="qq" value=""></td>
				</tr>

				<tr>
					<td class="a">爱好</td>
					<td class="b"><input type="text" value="${user.hobby}"
						name="hobby"></td>
					<td class="a">学历</td>
					<td class="b"><select name="education" id="">
							<option value="">小学</option>
							<option>初中</option>
							<option>高中</option>
							<option>专科</option>
							<option>大学</option>
							<option>硕士</option>
							<option>博士</option>
					</select></td>
				</tr>

				<tr>
					<td class="a">工资卡号</td>
					<td class="b"><input type="text" value="${user.card_num}"
						name="card_num"></td>
					<td class="a">民族</td>
					<td class="b"><input type="text" value="${user.nation}"
						name="nation"></td>
				</tr>

				<tr>
					<td class="a">婚姻状况</td>
					<td class="b"><select name="marry" id="">
							<option value="${user.marry}">离异</option>
							<option value="${user.marry}">未婚</option>
							<option value="${user.marry}">已婚</option>
					</select></td>
					<td></td>
					<td></td>
				</tr>

				<tr>
					<td class="a">备注</td>
					<td colspan="3"><textarea name="remark" id="" cols="30"
							rows="10"></textarea></td>
				</tr>
			</table>

			<input type="hidden" name="user_id" value="${user.user_id}">
			<input type="hidden" name="n" value="update"> <input id="q"
				type="submit"> <input id="w" type="reset">
		</form>
	</div>
</body>
<script type="text/javascript">

var flag=true;
$("#name2").blur(function(){
	alert('${user.username}');
	if('${user.username}'==$("#name2").val()){
		alert(1);
		$("#i").text("");
	}else{
	$.get({
		url:"user?n=check",
		data:{
			
			username:$("#name2").val()
		},
		success:function(data){
			if(data=="0"){
				$("#i").text("用户名可以使用");
				flag=true;
			}else{
				$("#i").text("用户名不可以使用");
				flag=false;
			}

		}
	})
	}
})
		
function a(){
	return flag;
}


$().ready(function(){
	$("form").validate({
		rules:{
			username:{
				required:true,
				minlength:1,
				maxlength:14
			},
			password:{
				required:true,
				minlength:8
			},
			department_id:{
				required:true,
				minlength:1
				},
				role_id:{
					required:true,
					minlength:1
					},
					address:{
						required:true,
						minlength:1
						},
						age:{
							required:true,
							minlength:2,
							maxlength:3
							},
							mobile:{
								required:true,
								minlength:11,
								maxlength:11
								},
							id_num:{
									required:true,
									minlength:18,
									maxlength:18
									},
									email:{
										required:true,
										email:true
										},
										qq:{
											required:true,
											maxlength:12,
											minlength:5
											},
											hobby:{
												required:true,
												maxlength:100
												},
													card_num:{
														required:true,
														},
														nation:{
															required:true,
															minlength:1,
															maxlength:6
															},
															remark:{
																required:true,
																maxlength:100
																}
										
			},
			messages:{
				username:{
					required:"请输入用户名",
					minlength:"最小长度为1",
					maxlength:"最大长度为16"
				},
				password:{
					required:"请输入密码",
					minlength:"最小长度为8"
				},
				department_id:{
					required:"请输入用户ID",
					minlength:"最小长度为1"
					},
					role_id:{
						required:"请输入角色ID",
						minlength:"最小长度为1"
						},
						address:{
							required:"请输入地址",
							minlength:"最小长度为1"
							},
							age:{
								required:"请输入年龄",
								minlength:"最小长度为2",
								maxlength:"最大长度为3"
								},
								mobile:{
									required:true,
									minlength:"最小长度为11",
									maxlength:"最大长度为11"
									},
								id_num:{
										required:"请输入身份证号",
										minlength:"最小长度为18",
										maxlength:"最大长度为18"
										},
										email:{
											required:"请输入邮箱地址",
											email:"邮箱格式错误xxx@xxx"
											},
											qq:{
												required:"请输入qq",
												maxlength:"最大长度为12",
												minlength:"最小长度为5"
												},
												hobby:{
													required:"请输入爱好",
													maxlength:"最大长度为100"
													},
														card_num:{
															required:"请输入卡号",
															},
															nation:{
																required:"请输入民族",
																minlength:"最小长度为1",
																maxlength:"最大长度为6"
																},
																remark:{
																	required:"请输入备注",
																	maxlength:"最大长度为100"
																	}
			}
				
		
		
	})
	
})

</script>
</html>