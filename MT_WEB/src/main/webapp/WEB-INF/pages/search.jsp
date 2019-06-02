<%--
  Created by IntelliJ IDEA.
  User: xuyun
  Date: 2019/5/21
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>STUDYIO Search</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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
                    <a href="/MyTech/${jump}">${login}</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div id="searchjumbotron" class="jumbotron">
    <div class="container">
        <h2>资源检索</h2>
        <form action="/MyTech/search2" id="form1" method="get">
            <div class="form-inline">
                <input type="" class="form-controlctm form-control" name="title" id="" style="width: 450px;" value="" placeholder="您想找什么？"/>
                <button type="submit" class="btn btnctm" style="width: 70px;">检索</button>
				<button type="button" class="btn btnctm" id="btn" onclick="advsearch()">高级检索</button>
            </div>
			<div id="radiogroup">
				<div class="radio-inline">
				  <label><input type="radio" name="searchtype" id="optionsRadios1" value="option1" onclick="advsearchtype(1)" checked>搜文献</label>
				</div>
				<div class="radio-inline">
				  <label><input type="radio" name="searchtype" id="optionsRadios2" value="option2" onclick="advsearchtype(2)">搜专利</label>
				</div>
				<div class="radio-inline">
				  <label><input type="radio" name="searchtype" id="optionsRadios3" value="option3" onclick="advsearchtype(3)">搜专家</label>
				</div>
			</div>
        </form>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-8">
            <h2>热点推荐</h2>
            <p>正在生成热点推荐信息...</p>
        </div>
        <div class="col-md-4">
            <h2>领域排行</h2>
            <p>正在生成排行信息...</p>
        </div>
    </div>
</div>


<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/part2.js"></script>
</body>
</html>
