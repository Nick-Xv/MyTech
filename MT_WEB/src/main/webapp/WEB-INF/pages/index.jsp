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
    <title>Bootstrap 模板</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/part1.css" rel="stylesheet">

    <script>

    </script>
</head>
<body>
<nav id="navbar" class="navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand">StudyIO</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li>
                    <a href="/MyTech/search">SEARCH</a>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <a href="/MyTech/background/overview">SIGN IN</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div id="introjumbotron" class="jumbotron">
    <div class="container">
        <h1>StudyIO</h1>
        <h2>科研成果聚集处。</h2>
        <a class="btn btn-primary btn-sm" href="/MyTech/search" role="button">现在加入</a>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-4">
            <h2>科技热点</h2>
            <p>这里展示最近访问量较多的科技成果</p>
        </div>
        <div class="col-md-4">
            <h2>科技热点</h2>
            <p>这里展示最近访问量较多的科技成果</p>
        </div>
        <div class="col-md-4">
            <h2>个性化推荐</h2>
            <p>这里展示个性化推荐</p>
        </div>
    </div>
</div>


<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>