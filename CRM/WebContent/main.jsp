<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="file:///C:\Users\22692\Desktop\Html\afont-awesome-4.7.0\css\font-awesome.min.css">
    <link rel="stylesheet" href="afont-awesome-4.7.0/css/font-awesome.min.css">
<title>Insert title here</title>
</head>
<style>
    .dd{
        height: 60px;
        padding-right: 50px;
    }
    body {
        margin: 0px;
        background-color: ghostwhite;
    }

    #b {
        background-color:rgb(43, 2, 85);
        width: 100%;
        padding-top: 18px;
        padding-bottom: 18px;
        padding-left: 10px;
        height: 50px;
        position: relative;
        top: -21px;
    }

    .a1 {
        padding: 30px 0px 30px 0px;
    }

    h3 {
        color: whitesmoke
    }

    .qq{
        position: relative;
        left: 250px;
        top: -40px;
        margin-right: 40px;
        color: white;
        text-decoration: none;
    }

    .qq:hover {
        color: blueviolet;
    }

    #v,#vv {
        position: relative;
        left: 750px;
    }

    #d {
        font-size: 20px;
        background-color: #222d32;
        height: 700px;
        width: 180px;
        position: relative;
        top: -21px;
    }

    button {
        width: 100%;
        padding-left: 10px;
        font-size: 20px;
        color: whitesmoke
    }

    button {
        border-top: none;
        border-right: none;
        border-bottom: none;
        border-left: 5px solid #2c3b41;
        background-color:#2c3b41;
    }

    button:hover {
        
        border-left-color: chocolate;
        background-color: black;
    }

    #a {
        font-size: 15px;
    }

    #b1,
    #b2,
    #b3,
    #b4 {
        display: none;
    }

    #biao {
        width: 1900px;
        height: 700px;
        background-color: gainsboro;
        position: absolute;
        left: 180px;
        top: 0px;
    }

    iframe {
        width: 1310px;
        height: 100%;
        position: relative;
        left: 12px;
        top: 14px;

    }
    .dd i:nth-of-type(2){
        display: none;
        position: relative;
        left: -50px;
        top: 20px;
        

    }
    .dd:hover i:nth-of-type(2){
        display: block;
    }
    .dd:hover i:nth-of-type(1){
        display: none;
    }

    h6{
        font-family: 楷体;
        position: relative;
        top: -60px;
        left: 550px;
         opacity: 60%;

    }

</style>


<body>
    <div id="aaaa">
    <div id="b">
        <h3>智游客户关系管理系统</h3>
        <a class="qq" href="">工作台</a>
        <a  class="qq"href="">报表</a>
        <a  class="qq"href="">客户信息</a>
        <a  class="qq"href="">员工信息</a>
        <a  class="qq"href="">公告信息</a>
        <a  class="qq"href="">发件箱</a>
        <a  class="qq"href="" id="vv" >${a.username}</a>
        <a class="qq"href="" id="v">退出</a>
    </div>
    <div id="d">
        <div><button calss="a1" id="childDiv1" class="fa fa-users a1"
                onclick="oncl(b1,childDiv1)">&nbsp&nbsp客户管理</button></div>
        <div id="b1" class="aaa">
            <a href="customershow?n=show"target="a11"><button class="dd"><i class="fa fa-star-o"></i><i class="fa fa-star"></i>&nbsp&nbsp客户列表</button></a>
            <a href="gory?g=allGory" target="a11"><button class="dd"><i class="fa fa-star-o"></i><i class="fa fa-star"></i>&nbsp&nbsp客户分类</button></a>
            <a href="care?ca=allCus_care"target="a11"><button class="dd"><i class="fa fa-star-o"></i><i class="fa fa-star"></i>&nbsp&nbsp客户关怀</button></a>
            <a href="link?cusl=selectCus_link"target="a11"><button class="dd"><i class="fa fa-star-o"></i><i class="fa fa-star"></i>&nbsp&nbsp联系客户</button></a>
            <a href="record?rec=selectAll"target="a11"><button class="dd"><i class="fa fa-star-o"></i><i class="fa fa-star"></i>&nbsp&nbsp联系记录</button></a>  
            <a href="record?rec=selectAll"target="a11"><button class="dd"><i class="fa fa-star-o"></i><i class="fa fa-star"></i>&nbsp&nbsp客户来源</button></a>
        </div>

        <div><button calss="a1" id="childDiv2" class="fa fa-file-text-o a1"
                onclick="oncl(b2,childDiv2)">&nbsp&nbsp内部信息</button></div>
        <div id="b2"class="aaa">
            <a href="nb?b=NBN"  target="a11"><button class="dd"><i class="fa fa-star-o"></i><i class="fa fa-star"></i>&nbsp&nbsp通知公告</button></a>
            <a href="nb?b=NBU"  target="a11"><button class="dd"><i class="fa fa-star-o"></i><i class="fa fa-star"></i>&nbsp&nbsp员工信息</button></a>
            <a href="nb?b=NBD"  target="a11"><button class="dd"><i class="fa fa-star-o"></i><i class="fa fa-star"></i>&nbsp&nbsp部门信息</button></a>
        </div>

        <div><button calss="a1" id="childDiv3" class="fa fa-envelope-o a1"
                onclick="oncl(b3,childDiv3)">&nbsp&nbsp站内邮件</button></div>
        <div id="b3"class="aaa">
              <a href="write.jsp"  target="a11"><button class="dd"><i class="fa fa-star-o"></i><i class="fa fa-star"target="a11"></i>&nbsp&nbsp发件箱</button></a>
              <a href="msg?ms=allGet"  target="a11"><button class="dd"><i class="fa fa-star-o"></i><i class="fa fa-star"target="a11"></i>&nbsp&nbsp收件箱</button></a>
              <a href="msg?ms=allCG"  target="a11"><button class="dd"><i class="fa fa-star-o"></i><i class="fa fa-star"target="a11"></i>&nbsp&nbsp草稿箱</button></a>
              <a href="msg?ms=allLJ"  target="a11"><button class="dd"><i class="fa fa-star-o"></i><i class="fa fa-star"target="a11"></i>&nbsp&nbsp垃圾箱</button></a>
        </div>

        <div><button calss="a1" id="childDiv4" class="fa fa-sitemap a1"
                onclick="oncl(b4,childDiv4)">&nbsp&nbsp&nbsp&nbsp管理员</button></div>

        <div id="b4"class="aaa">
           <a href="role?r=allRole" class="bbbb" target="a11"><button class="dd" ><i class="fa fa-star-o"></i><i class="fa fa-star"></i>&nbsp&nbsp角色管理</button></a>
           <a href="dept?d=allDept" class="bbbb"target="a11"><button class="dd" ><i class="fa fa-star-o"></i><i class="fa fa-star"></i>&nbsp&nbsp部门管理</button></a>
           <a href="not?q=allNotice" class="bbbb"target="a11"><button class="dd" ><i class="fa fa-star-o"></i><i class="fa fa-star"></i>&nbsp&nbsp公告管理</button></a>
           <a href="user?n=show"  class="bbbb"target="a11"><button class="dd" ><i class="fa fa-star-o"></i><i class="fa fa-star"></i>&nbsp&nbsp用户管理</button></a>
        </div>
        <div id="biao">
            <iframe src="hello.jsp" frameborder="1" name="a11">
		</iframe>
           <h6>智游教育&copy;河南智游臻龙教育科技有限公司</h6> 
        </div>
        
        
    </div></div>



</body>
<script>
    var l = null;
    var b = null;
    function oncl(div, childD) {
        if (l == null) {
            div.style.display = "inline";
            childD.style.backgroundColor = "black";
        }
        if (l == div) {
            if (div.style.display == "inline") {
                childD.style.backgroundColor = "#2c3b41";
                div.style.display = "none";
            } else {
                div.style.display = "inline";
                childD.style.backgroundColor = "black";
            }
            return;
        }
        if (l != null) {
            l.style.display = "none";
            b.style.backgroundColor = "#2c3b41";

        }
        div.style.display = "inline";
        childD.style.backgroundColor = "black";
        l = div;
        b = childD;
    }

</script>
</html>