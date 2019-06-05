<%--
  Created by IntelliJ IDEA.
  User: xuyun
  Date: 2019/5/31
  Time: 23:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${title}</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/part1.css" rel="stylesheet">
    <link rel="shortcut icon" href="assets/img/favicon.ico">
</head>
<body>
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
<div id="essaybody">
    <div class="container">
        <div class="row">
            <div class="col-md-9 patent">
                <h2>${title}</h2>
                <p>发明人: ${author}</p>
                <p>申请号: ${id} 申请日期: ${date}</p>
                <p>申请人: ${author1}</p>
                <p>地址: ${addr}</p>
                <p>专利代理机构: ${agentins}代理人:${agent}</p>
                <p>主分类号: ${main}专利分类号:${sub}</p>
                <h3>摘要</h3>
                <p>${info}</p>
                <h3>主权项</h3>
                <p>${items}</p>
            </div>
            <%--<div class="col-md-3">--%>
                <%--<h4 style="margin-top: 30px;">其它选项</h4>--%>
                <%--<p><a href="#">购买</a></p>--%>
            <%--</div>--%>
        </div>
    </div>
</div>

<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>

