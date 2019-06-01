<%--
  Created by IntelliJ IDEA.
  User: xuyun
  Date: 2019/5/31
  Time: 23:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bootstrap 模板</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/part1.css" rel="stylesheet">
</head>
<body>
<nav id="navbar" class="navbar-inverse">
    <div class="container">
        <div class="navbar-header navbar-hover">
            <a class="navbar-brand" href="/MyTech/index">STUDYIO</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-hover">
                <li>
                    <a href="/MyTech/index">OTHER</a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right navbar-hover">
                <li>
                    <a href="/MyTech/index">SIGN IN</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<!-- <div id="essayjumbotronsmall" class="jumbotron">
    <div class="container">
        <button type="submit" class="btn" id="btn">Submit</button>
    </div>
</div> -->
<div id="professorjumbotron" class="jumbotron">
    <div class="container">
        <h2 style="margin-top: 30px;">宋友</h2>
        <h3 style="margin-top: 20px;">北京航空航天大学 教授</h3>
        <p style="margin-top: 20px;">出生日期 1970年1月</p>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-md-9">
            <h3>简介</h3>
            <p style="padding-bottom: 20px;">老师很好</p>
            <h3>关系网络</h3>
            <c:forEach items="${productList}" var="product">
                <div class="professorlist">
                    <h4>林广艳</h4>
                    <p>合作次数:10</p>
                </div>
            </c:forEach>
            <div class="professorlist">
                <h4>林广艳</h4>
                <p>合作次数:10</p>
            </div>
            <div class="professorlist">
                <h4>林广艳</h4>
                <p>合作次数:10</p>
            </div>
        </div>
    </div>
</div>


<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
