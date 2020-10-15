<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
	left:400px;
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
    
</style>

<body>
    <div id="q">
            <h3>&numsp;&numsp;部门管理</h3>
        <table border="1px " class="table table-bordered table table-hover">
            <tr id="aaa">
                <td>序号</td>
                <td>部门名称</td>
                <td>部门描述</td>
                <td>更新时间</td>
            </tr>
            <c:forEach items="${list}" var="department">
            <tr>
                <td>${department.department_id}</td>
                <td>${department.department_name}</td>
                <td>${department.remark}</td>
                <td>${department.update_time}</td>
            </tr>
      </c:forEach>


        </table>
        
        		<p>总共${count}条记录，第${page2}页,每页5条记录</p>
		</div>

		<c:if test="${count%5==0}">
			<c:set var="page" value="${count/5}" />
		</c:if>
		<c:if test="${count%5!=0}">
			<c:set var="page" value="${count/5+1}" />
		</c:if>
		
		
		<div id="pa">
			<nav aria-label="Page navigation">
			<ul class="pagination">
				<li><c:if test="${page2>1&&page2<=page}">
						<a href="nb?b=NBD&page=${page2-1}">上一页</a>
					</c:if></li>
				<li class="active">
				<c:forEach var="i" begin="1" end="${page}">
						<a href="nb?b=NBD&page=${i}">第${i}页</a>
					</c:forEach>
					</li>
				<li>
				<c:if test="${page2>=1&&page2<page-1}">
						<a href="nb?b=NBD&page=${page2+1}">下一页</a>
					</c:if>
					</li>
			</ul>
			</nav>
		</div>
	
</body>
</html>