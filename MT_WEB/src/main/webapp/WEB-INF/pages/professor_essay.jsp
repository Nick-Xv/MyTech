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
    <title>Bootstrap 模板</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/part1.css" rel="stylesheet">
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
                    <a href="/MyTech/index">OTHER</a>
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
        <h2 style="margin-top: 30px;margin-bottom: 20px;">${name}的所有论文</h2>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-md-8">
            <c:forEach items="${productList}" var="product">
                <div class="resultlist">
                    <h4><a href="/MyTech/essay?id=${product.id}">${product.title}</a></h4>
                    <p>作者: ${product.author}</p>
                    <p>关键字：${product.keyword}</p>
                    <p>年份：${product.publishTime}</p>
                    <p><a href=${product.url}>#外部链接</a></p>
                </div>
            </c:forEach>
        </div>
        <div id="fil-sor" class="col-md-4">
            <h3 style="margin-top: 20px;margin-bottom: 10px;">结果筛选</h3>
            <h4 style="margin-top: 20px;margin-bottom: 10px;">发表时间</h4>
            <ul class="list-group list-unstyled">
                <li id="filter1" class="filter"><a href="javascript:void(0);" onclick="filter(1)">2019年</a></li>
                <li id="filter2" class="filter"><a href="javascript:void(0);" onclick="filter(2)">2018年起</a></li>
                <li id="filter3" class="filter"><a href="javascript:void(0);" onclick="filter(3)">2017年起</a></li>
                <li id="filter4" class="filter"><a href="javascript:void(0);" onclick="filter(4)">2016年起</a></li>
                <li id="filter5" class="filter"><a href="javascript:void(0);" onclick="filter(5)">2015年起</a></li>
            </ul>
            <h4 style="margin-top: 20px;margin-bottom: 10px;">排序方式</h4>
            <ul class="list-group list-unstyled">
                <li id="sorter1" class="filter"><a href="javascript:void(0);" onclick="sorter(1)">按被引次数排序</a></li>
                <li id="sorter2" class="filter"><a href="javascript:void(0);" onclick="sorter(2)">按发表年份排序</a></li>
            </ul>
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
