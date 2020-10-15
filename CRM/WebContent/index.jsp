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
</head>
<style>
body {
	background-color: gainsboro;
}

div {
	position: absolute;
	left: 35%;
	top: 150px;
	background-color: white;
}

#a {
	padding: 150px;
}

input {
	width: 250px;
	padding: 10px;
}

p {
	color: black;
	text-align: center;
}

img {
	position: relative;
	left: 40px;
}

#button {
	background-color: crimson;
	border: none;
	color: floralwhite;
	text-align: center;
	width: 271px;
	padding: 8px;
}
</style>

<body>
	<form action="login">
		<div id="a">
			<img src="img/logo.jpg" alt=""><br>
			<p>智游客户关系管理系统</p>
			<br> <input type="text" name="username"><br> <br>
			<input type="password" name="password"><br> <br> <input type="submit" value="登录" id="button">
		</div>
	</form>
	<script type="text/javascript">
		$().ready(function() { // jquery预备函数,加载完文件后就执行这个函数
			$("form").validate({
				/* 校验分为两部分,第一部分是校验规则 */
				rules : {
					username : {
						required : true,
						minlength : 1,
						maxlength : 14
					},
					password : {
						required : true,
						minlength : 1,
						maxlength : 14
					}
				},
				/* 对应规则的提示信息 */
				messages : {
					username : {
						required : "请输入账号",
						minlength : "账号最少为1位",
						maxlength : "账号最长为14位"
					},
					password : {
						required : "请输入密码",
						minlength : "密码最少1位",
						maxlength : "密码最多14位"
					}
				}
			});
		})
	</script>
</body>


</html>