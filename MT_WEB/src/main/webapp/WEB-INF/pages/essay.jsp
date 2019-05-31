<%--
  Created by IntelliJ IDEA.
  User: xuyun
  Date: 2019/5/21
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bootstrap 模板</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/part1.css" rel="stylesheet">
    <style>

    </style>

    <script>

    </script>
</head>
<body style="background-color: #EEE;">
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
<div id="essaybody">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <h2>A Tactical Information Management System for Unmanned Vehicles Using Vehicular Adhoc Networks</h2>
                <p>作者: <a href="#">Jeyaprakash, Thangakumar</a>; Mukesh, Rajeshwari</p>
                <p>BMC COMPLEMENTARY AND ALTERNATIVE MEDICINE  卷: 15     文献号: 258   出版年: JUL 30 2015</p>
                <h3>摘要</h3>
                <p>Unmanned Ground Vehicles (UGV) are playing a vital role in Military Services. The main abstract of this project is proposed for provide a Tactical information Management system for Unmanned Ground Vehicles using Vehicular Adhoc Networks [1] (VANET). VANET is a perfect option for vehicle to vehicle communication to share the Information with each other. An Information Control Unit will be attached inbuilt with all unmanned ground vehicles to share the information. An Information Control unit consists of front and rear Radar (Radio Detection and Ranging), Event Data Recorder, Global positioning system (GPS), Sensor, and a communication system. When a failure detected in an Unmanned Ground vehicle due to the enemy attack, the tactical information will be shared with the neighboured UGVs among the VANET about the status of failed UGV. The damaged UGV will be replaced immediately with the neighbour to fill up the gap using the Tactical information shared using the WAVE (Wireless Application for Vehicle Environment) SMS protocol. This information is used to avoid collision also during fog.</p>
                <h3>关键词</h3>
                <p>Unmanned Vehicles; Vehicular Adhoc Networks; Radio Detection and Ranging</p>
            </div>
            <div class="col-md-3">
                <h4 style="margin-top: 30px;">查看文献</h4>
                <p><a href="#">知网</a></p>
                <p><a href="#">万方</a></p>
                <h4 style="margin-top: 20px;">被引次数</h4>
                <p style="font-size: 40px;">4</p>
                <h4 style="margin-top: 20px;">网友评分</h4>
                <p style="font-size: 20px;">4.5/5</p>
            </div>
        </div>
    </div>
</div>


<div id="commentjumbotron">
    <div class="container">
    	<div class="row">
    		<div class="col-md-9">
    			<h4>发表看法</h4>
    			<form action="/MyTech/essay" method="post">
    			    <textarea class="form-control" id="textareactm" name="comment" rows="3"></textarea>
    			    <button type="submit" id="btn2" class="btn btnctm">提交</button>
    			</form>
    		</div>
    	</div>
    </div>
    <div id="commentgroup">
    	<div class="container">
    		<div class="row">
    			<div class="col-md-9">
    				<h4 style="padding-top:10px;">评论</h4>
    				<c:forEach items="${commentList}" var="comment">
    				    <div class="commentlist">
    				        <h5>${product.用户名} <small>${product.发表时间}</small></h5>
    				        <p>${product.评论内容}啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊
    						啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊
    						啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊
    						啊啊啊啊啊啊啊啊啊啊啊啊</p>
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
</body>
</html>
