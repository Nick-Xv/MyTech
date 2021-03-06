<%--
  Created by IntelliJ IDEA.
  User: xuyun
  Date: 2019/6/2
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>${name}的动态</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/part1.css" rel="stylesheet">
    <link rel="shortcut icon" href="assets/img/favicon.ico">
</head>
<body onload="GetRequest()">
<div id="totalpage" hidden="">10</div>
<nav id="navbar" class="navbar-inverse">
    <div class="container">
        <div class="navbar-header navbar-hover">
            <a class="navbar-brand" href="/MyTech/search">STUDYIO</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-hover">
                <li>
                    <a href="/MyTech/index">WELCOME</a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right navbar-hover">
                <li>
                    <a href="/MyTech/${jump}">${login}</a>
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
        <h2 style="margin-top: 30px;margin-bottom: 20px;">${name}发布的动态</h2>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-md-8">
            <c:forEach items="${momentList}" var="moment">
                <div class="momentlist2">
                    <h4>${moment.content}</h4>
                    <p>发布于${moment.publishTime}</p>
                </div>
            </c:forEach>
        </div>
    </div>
    <nav aria-label="Page navigation">
        <ul class="pagination paginationctm" id="pagerlist"></ul>
    </nav>
</div>



<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/part3.js"></script>
</body>
</html>

