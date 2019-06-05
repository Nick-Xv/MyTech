<%--
  Created by IntelliJ IDEA.
  User: xuyun
  Date: 2019/5/21
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>搜索STUDYIO的专家</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/part1.css" rel="stylesheet">
    <link rel="shortcut icon" href="assets/img/favicon.ico">
</head>
<body onload="GetRequest()">
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
<div id="searchjumbotronsmall" class="jumbotron">
    <div class="container">
        <form class="form-inline" action="/MyTech/search4" method="get">
            <div>
                <input type="" class="form-controlctm form-control" id="title" name="title" placeholder="主题" value=""/>
                <button type="submit" class="btn btnctm" style="width: 70px; margin-left: 4px;">检索</button>
            </div>
        </form>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-8">
            <c:forEach items="${professorList}" var="professor">
                <div class="resultlist">
                    <h4><a href="/MyTech/professor?id=${professor.id}">${professor.name}</a></h4>
                    <p>机构: ${professor.organization}</p>
                    <p>领域：${professor.area}</p>
                    <p>被引频次：${professor.referenceCount}</p>
                    <p>作品数量：${professor.workNumber}</p>
                </div>
            </c:forEach>
        </div>
        <div id="fil-sor" class="col-md-4" hidden>
            <h4 style="margin-top: 20px;margin-bottom: 10px;">排序方式</h4>
            <ul class="list-group list-unstyled">
                <li id="sorter1" class="filter"><a href="javascript:void(0);" onclick="sorter(1)">按被引次数排序</a></li>
                <li id="sorter2" class="filter"><a href="javascript:void(0);" onclick="sorter(2)">按作品数量排序</a></li>
            </ul>
        </div>
    </div>
    <nav aria-label="Page navigation">
        <ul class="pagination paginationctm">
            <li id="previous">
                <a href="javascript:void(0);" onclick="pager(-1)" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <li id="firstpage" style="display: none;"><a href="javascript:void(0);" onclick="pager(-10)">1</a></li>
            <li id="ellipsis" style="display: none;" class="disabled"><a href="javascript:void(0);">...</a></li>
            <li id="pager1"><a href="javascript:void(0);" onclick="pager(1)">1</a></li>
            <li id="pager2"><a href="javascript:void(0);" onclick="pager(2)">2</a></li>
            <li id="pager3"><a href="javascript:void(0);" onclick="pager(3)">3</a></li>
            <li id="pager4"><a href="javascript:void(0);" onclick="pager(4)">4</a></li>
            <li id="pager5"><a href="javascript:void(0);" onclick="pager(5)">5</a></li>
            <li id="next">
                <a href="javascript:void(0);" onclick="pager(0)" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>
</div>


<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/part1.js"></script>
</body>
</html>
