<%--
  Created by IntelliJ IDEA.
  User: xuyun
  Date: 2019/5/21
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎使用STUDYIO</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/part1.css" rel="stylesheet">
    <link rel="shortcut icon" href="assets/img/favicon.ico">
    <script>

    </script>
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
                    <a href="/MyTech/search">SEARCH</a>
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
<div id="introjumbotron" class="jumbotron">
    <div class="container">
        <h1>StudyIO</h1>
        <h2>科研成果聚集处。</h2>
        <a class="btn btn-primary btn-sm" href="/MyTech/to_register" role="button" style="margin-top: 20px;">现在加入</a>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-4">
            <h2>丰富的文献资源</h2>
            <p>StudyIO有着足够的文献资源存储，与众多数据库进行对接，可以为您整理出您的专属资源库。</p>
        </div>
        <div class="col-md-4">
            <h2>变现您的创作</h2>
            <p>StudyIO提供积分系统，可以为您的科研成果进行标价，提供增值服务。</p>
        </div>
        <div class="col-md-4">
            <h2>完善的统计网络</h2>
            <p>StudyIO为您统计合作关系、领域热点新闻等动态信息，方便您的科研。</p>
        </div>
    </div>
</div>


<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>