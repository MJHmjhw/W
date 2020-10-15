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
	<link rel="stylesheet" href="bootstrap.min.css">
     <style type="text/css">
         tr td:nth-of-type(1){
            width:50px;
            text-align: center;
        }
        input{
            outline: none;
            border: none;
        }
        #btn{
            text-align: center;
        }
         p{
            font-size: 20px;
        }
        #fanhui{
        	position: absolute;
        	left:550px;
        	top:415px;
        }
    </style>
</head>
<body>

<form action="gory" onsubmit="return a()">

 <p>添加分类</p>
    <table class="table table-bordered">
	<tr>
						<td id="c1">分类名称</td>
						<td id="c3"><input type="text" name="customer_category_name" id="name"style="border:1px solid #ADADAD"/><i id="i"></i></td>
					</tr>
					<tr style="height: 300px;">
					<td id="c2">分类描述</td>
					<td><textarea id="c4" name="customer_category_desc" cols="120" rows="10" style="outline:none;resize:none;border:none;">
						
					</textarea></td>
					</tr>
</table>
<div id="btn">  
<input type="hidden" name="g" value="addGory"/>
<input type="hidden" name="user_id" value="${user_session.user_id}"/>

<input type="submit" class="btn btn-primary" value="添加"/> 
</div>
</form>
<div id="fanhui"><a href="gory?g=allGory" class="btn btn-default">返回</a></div>
</body>
	<script type="text/javascript">
	$("#name").blur(function(){
		$.get({
			url:"gory?g=check",
			data:{
				customer_category_name:$("#name").val()
			},
			success:function(data){
				if(data=="0"){
					$("#i").text("部门名称可以使用");
					flag=true;
				}else{
					$("#i").text("部门名称不可以使用");
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
					customer_category_name:{
						required : true,
						minlength : 1,
						maxlength : 15
					},
					customer_category_desc:{
						required : true,
						minlength : 1,
						maxlength : 100
					}
				},
				messages:{
					customer_category_name:{
						required : "请输入分类名称",
						minlength : "最小长度 为1",
						maxlength : "最大长度为15"
					},
					customer_category_desc:{
						required : "请输入分类描述",
						minlength : "最小长度 为1",
						maxlength : "最大长度为100"
					}
				}

			});
		})
	</script>
</html>