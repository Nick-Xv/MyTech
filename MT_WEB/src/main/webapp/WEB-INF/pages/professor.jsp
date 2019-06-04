<%--
  Created by IntelliJ IDEA.
  User: xuyun
  Date: 2019/5/31
  Time: 23:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>STUDYIO Professor</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/part1.css" rel="stylesheet">


</head>
<body onload="checkwatch()">
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
		<div style="display: inline-block;">
			<h2 style="margin-top: 30px;">${name}</h2>
			<h3 style="margin-top: 20px;">${ins} ${prof}</h3>
			<p class="info1" ${p1}>${birth}</p>
			<p class="info1" ${p2}>${area}</p>
			<p class="info2" ${p1}>${info}</p>
			<p class="info2" ${p2}>${data}</p>
		</div>
        <div style="display: inline-block; float: right; padding: 22px 30px 0 0" >
        	<button id="watch" class="btn btnctm" type="button" onclick="watch1('${id1}','${id2}')" value="${watched}" ${hidden}>关注</button>
        </div>
    </div>
</div>

<div class="container">
    <div class="row">
        <div class="col-md-9">
            <h3 style="padding-bottom: 20px;">论文</h3>
			<c:forEach items="${productList}" var="product">
			    <div class="essaylist">
			        <p><a href="/MyTech/essay?id=${product.id}">${product.title},${product.author},${product.publishTime}</a></p>
			    </div>
			</c:forEach>

			<div class="essaylist">
				<p><a href="${url}&start=20"><strong>>>查看该专家的所有论文</strong></a></p>
			</div>
        </div>
		<div class="col-md-3">
		    <h3 ${networkHidden}>关系网络</h3>
		    <c:forEach items="${profList}" var="professor">
		        <div class="professorlist">
		            <h4>${professor.name}</h4>
		            <p><a href="${professor.url}">>>查看资料</a></p>
		        </div>
		    </c:forEach>
		</div>
    </div>
	<div class="row" ${momenthid}>
	    <div class="col-md-8">
			<h3 style="padding-top:30px;padding-bottom: 5px;">发布的动态</h3>
			<c:forEach items="${momentList}" var="moment">
				<div class="momentlist">
					<p>${moment.content}</p>
					<p>发布于${moment.publishTime}</p>
				</div>
			</c:forEach>

			<div class="momentlist">
				<p><a href="${url1}&start=20"><strong>>>查看该专家的所有动态</strong></a></p>
			</div>

		</div>
	</div>
</div>


<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<!-- 包括所有已编译的插件 -->
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript" src="js/part4.js"></script>
</body>
</html>
