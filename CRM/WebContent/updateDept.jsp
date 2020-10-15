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
            position: relative;
            top: 100px;
        }
         h3{
             
            position: relative;
            top: -50px;
        }
        #aaa{
            width: 1200px;
            position: relative;
            left: 70px;
            top: 50px;
        }
    </style>
</head>
<body>
<form action="dept" onsubmit="return a()">
    <div id="aaa">
    <h3>更新部门</h3>
    <table class="table table-bordered">
  
    <tr>
      <td colspan="2">部门名称</td>
      <td colspan="6">
         <input type="text" name="department_name" value="${dept.department_name }"id="name"/><i id="i"></i>
      </td>
    </tr>
    <tr>
      <td colspan="2" rowspan="6" style="line-height:200px;" >部门描述</td>
      <td colspan="6" rowspan="6">
          <textarea name="remark" id="" cols="80" rows="10" style="outline:none;resize:none;border:none;" placeholder="请输入部门描述">${dept.remark}</textarea>
      </td>
    </tr>
</table>

<div id="btn">   
<input type="hidden" name="department_id" value="${dept.department_id}"> 
<input type="hidden" name="d" value="updateDept"> 
    <input type="submit"class="btn btn-primary" value="提交">
    <input type="insert"class="btn btn-primary" value="重置">

</div>
</div>
</form>
</body>
<script type="text/javascript">
var flag=true;
$("#name").blur(function(){
	if($("#name").val()=='${dept.department_name }'){
		$("#i").text("");
	}else{
	$.get({
		url:"dept?d=check",
		data:{			
			department_name:$("#name").val()
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
	}
})
			function a(){
				return flag;
			}




$().ready(function(){
	$("form").validate({
		rules:{
			department_name:{
				required:true,
				minlength:1,
				maxlength:50
			},
			remark:{
				required:true,
				minlength:1,
				maxlength:100
			}	
			},
			messages:{
				department_name:{
					required:"请输入部门名称",
					minlength:"最小长度为1",
					maxlength:"最大长度为100"
				},
				remark:{
					required:"请输入备注",
					minlength:"最小长度为1",
					maxlength:"最大长度为100"
				}	
				
			}
		})
		})

</script>
</html>