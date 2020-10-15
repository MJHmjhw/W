<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="jquery/jquery.js"></script>
<script src="jquery/jquery.validate.min.js"></script>
<script src="jquery/messages_zh.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>写邮件</title>
</head>
<body>
<form action="msg">
	<table>
		<tr>
			<td>收件人</td>
			<td><input type="text" name="receiver"/></td>
		</tr>
		<tr>
			<td>主题</td>
			<td><input type="text" name="subject"/></td>
		</tr>
		<tr>
			<td>内容</td>
			<td><textarea name="content" rows="20" cols="120"></textarea></td>
		</tr>
	</table>
	<input type="hidden" name="ms" value = "writeMsg"/>
	<input type="submit" name="c" value="发送"/>
	<input type="submit" name="c" value="存草稿"/>

</form>
<a href="msg?ms=allSJ">查看已发送邮件</a>

</body>
<script type="text/javascript">
		$().ready(function() { 
			$("form").validate({
				rules : {
					receiver:{
						required : true,
						minlength : 1,
						maxlength : 11
					},
					subject:{
						required : true,
						minlength : 1,
						maxlength : 50
					},
					content:{
						required : true,
						minlength : 1,
						maxlength : 200
					}
					
				},
				messages:{
					receiver:{
						required : "请输入收件人",
						minlength : 1,
						maxlength : 11
					},
					subject:{
						required : "请输入主题",
						minlength : 1,
						maxlength : 50
					},
					content:{
						required : "请输入内容",
						minlength : 1,
						maxlength : 200
					}
				}
			
			});
		})
	</script>
</html>