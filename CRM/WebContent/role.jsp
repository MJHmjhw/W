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
<title>Insert title here</title>
</head>
<style>
#pa {
	position: absolute;
	top: 350px;
	left:350px;
}

#pa li {
	list-style-type: none;
	display: inline-block;
}
    td {
        padding: 10px 30px 10px 30px;
        text-align: center;
        font-size: 15px;
    }

    .a {
        width: 300px;
    }

    .b {
        width: 400px;
    }

    #a11 {
        border-radius: 15%;
        position: relative;
        left: 30px;
        border: none;
        background-color: gray;
        padding-top: 3px;
        padding-bottom: 3px;
        top: -2px;
    }

    #a12 {
        border-radius: 15%;
        position: relative;
        left: 1100px;
        top: -10px;
    }

    nav {
        position: relative;
        left: 670px;
        top: -10px;
    }
    #aaa{
        font-weight: 10px;
        
    }
    #q{
    position:relative;
    left:70px;
    width:1200px;
    }
    #qqqqq{
    position: absolute;
    
    left:500px;
    top:500px;
    }
    #inp{
    position: absolute;
    left:300px;
    }
      #in{
    position: absolute;
    left:480px;
    }
    #zong{
        position: absolute;
    top:350px;
    }
    
    
</style>

<body>
    <div id="q">
            <h3>&numsp;&numsp;角色管理</h3>
            <form action="role">
            <input id="inp" type="text" name="name">
            <input type="hidden" name="r" value="selectF">
            <input id="in"type="submit">
            </form>
        <a href="addrole.jsp" id="ch"><button id="a12" class="btn btn-primary" name="r" value="addRole">添加角色</button></a>
        <table border="1px " class="table table-bordered table table-hover">
            <tr id="aaa">
                <td>序号</td>
                <td>角色名称</td>
                <td>角色描述</td>
                <td>更新时间</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${list}" var="role">
            <tr>
                <td>${role.role_id}</td>
                <td>${role.role_name}</td>
                <td>${role.remark}</td>
                <td>${role.update_time}</td>
                <td>
                 <a href="role?r=selectById&role_id=${role.role_id}"><i class="fa fa-pencil" ></i></a>
                 <a href="role?r=deleteRole&role_id=${role.role_id}"><i class="fa fa-times" ></i></a>
                </td>
            </tr>
      </c:forEach>

            <c:forEach items="${list1}" var="role">
            <tr>
                <td>${role.role_id}</td>
                <td>${role.role_name}</td>
                <td>${role.remark}</td>
                <td>${role.update_time}</td>
                <td>
                 <a href="role?r=selectById&role_id=${role.role_id}"><i class="fa fa-pencil" ></i></a>
                 <a href="role?r=deleteRole&role_id=${role.role_id}"><i class="fa fa-times" ></i></a>
                </td>
            </tr>
      </c:forEach>
        </table>
        <div  id="zong">
        		<p>总共${count}条记录，第${page2}页,每页5条记录</p>
		</div>

		<c:if test="${count%5==0}">
			<c:set var="page" value="${count/5}" />
		</c:if>
		<c:if test="${count%5!=0}">
			<c:set var="page" value="${count/5+1}" />
		</c:if>
		</div>
		
		<div id="pa">
			<nav aria-label="Page navigation">
			<ul class="pagination">
				<li><c:if test="${page2>1&&page2<=page}">
						<a href="role?r=allRole&page=${page2-1}">上一页</a>
					</c:if></li>
				<li class="active">
				<c:forEach var="i" begin="1" end="${page}">
						<a href="role?r=allRole&page=${i}">第${i}页</a>
					</c:forEach>
					</li>
				<li>
				<c:if test="${page2>=1&&page2<page-1}">
						<a href="role?r=allRole&page=${page2+1}">下一页</a>
					</c:if>
					</li>
			</ul>
			</nav>
		</div>
	
</body>
</html>