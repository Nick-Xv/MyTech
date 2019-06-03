<%--
  Created by IntelliJ IDEA.
  User: xuyun
  Date: 2019/5/21
  Time: 15:45
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
    <link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">
</head>
<body style="background-color: #EEE;">
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
<div id="essaybody">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <h2>${title}</h2>
                <p>作者: ${authors}</p>
                <h3>摘要</h3>
                <p>${info}</p>
                <h3>关键词</h3>
                <p>${keywords}</p>
            </div>
            <div class="col-md-3">
				<div hidden id="essaytype" value="0"></div>
                <h4 style="margin-top: 30px;">查看文献</h4>
                <p id="link"><a href="javascript:purchase(&quot;${id1}&quot;,&quot;${id2}&quot;);">#外部链接</a></p>
                <h4 style="margin-top: 20px;">被引次数</h4>
                <p style="font-size: 40px;">${refcount}</p>
                <h4 style="margin-top: 20px;">查看次数</h4>
                <p style="font-size: 40px;">${clickcount}</p>
                <h4 style="margin-top: 20px;">网友评分</h4>
                <p style="font-size: 20px;">${grade}</p>
            </div>
        </div>
    </div>
</div>


<div id="commentjumbotron">
    <div class="container">
    	<div class="row">
    		<div class="col-md-9">
    			<h4>评论评分</h4>
    			<form action="/MyTech/essay" method="get">
                    <input type="hidden" id="theisid" name="id" value=${id}></input>
    			    <textarea class="form-control" id="textareactm" name="comment" rows="3"></textarea>
					<div class="star-rating"> 
					  <fieldset> 
						<input hidden type="radio" id="star5" name="rating" value="5" /><label for="star5" title="卓越">五星</label>
						<input hidden type="radio" id="star4" name="rating" value="4" /><label for="star4" title="优秀">四星</label>
						<input hidden type="radio" id="star3" name="rating" value="3" /><label for="star3" title="良好">三星</label>
						<input hidden type="radio" id="star2" name="rating" value="2" /><label for="star2" title="中等">二星</label>
						<input hidden type="radio" id="star1" name="rating" value="1" /><label for="star1" title="很差">一星</label>
					  </fieldset> 
					  <button type="submit" id="btn2" class="btn btnctm">提交</button>
					</div> 
    			</form>
    		</div>
    	</div>
    </div>
    <div id="commentgroup">
    	<div class="container">
    		<div class="row">
    			<div class="col-md-9">
    				<h4>评论</h4>
    				<c:forEach items="${commentList}" var="comment">
    				    <div class="commentlist">
    				        <h5>${comment.userId} <small>${comment.publishTime}</small></h5>
    				        <p>${comment.content}</p>
    				    </div>
    				</c:forEach>
    			</div>
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
