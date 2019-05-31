<%--
  Created by IntelliJ IDEA.
  User: xuyun
  Date: 2019/5/21
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Bootstrap 模板</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/part1.css" rel="stylesheet">
    <style>

    </style>
    <script type="text/javascript">
    	var theRequest;
    	var str;
        function GetRequest() {
            var url = location.search; //获取url中"?"符后的字串
            theRequest = new Object();
            if (url.indexOf("?") != -1) {
                str = url.substr(1);
                strs = str.split("&");
                for (var i = 0; i < strs.length; i++) {
                    theRequest[decodeURIComponent(strs[i].split("=")[0])] = unescape(decodeURIComponent(strs[i].split("=")[1]));
                }
            }
            //alert(theRequest['mode']);
            document.getElementById('title').value=theRequest['title'];
            document.getElementById('author').value=(theRequest['author']=="undefined" || theRequest['author'] == null)?"":theRequest['author'];
            document.getElementById('keyword').value=(theRequest['keyword']=="undefined" || theRequest['keyword'] == null)?"":theRequest['keyword'];
            document.getElementById('date1').value=theRequest['date1'];
            document.getElementById('date2').value=theRequest['date2'];
            if(theRequest['mode']=="true") {
                //alert("aaa");
                document.getElementById("advsearch").className="collapse in";
                document.getElementById("mode").value="true";
            }
            if(theRequest['filter']=="1") {document.getElementById("filter1").classList.add("filterselected");}
            else if(theRequest['filter']=="2") {document.getElementById("filter2").classList.add("filterselected");}
            else if(theRequest['filter']=="3") {document.getElementById("filter3").classList.add("filterselected");}
            else if(theRequest['filter']=="4") {document.getElementById("filter4").classList.add("filterselected");}
            if(theRequest['filter']=="10") {document.getElementById("filter10").classList.add("filterselected");}
            return theRequest;
        }
    	function aaa() {
    		//alert(document.getElementById("titlelabel").style.width);
    		if(document.getElementById("advsearch").className=='collapse') {
    			document.getElementById("mode").value="true";
    		}
    		else {
    			document.getElementById("mode").value="false";
    		}
        }
    	var num1;
    	var num2;
    	function filter(num) {
    		num1 = num;
    		window.location.href="search2.html?title="+theRequest['title']
    								+"&author="+theRequest['author']
    								+"&keyword="+theRequest['keyword']
    								+"&date1="+theRequest['date1']
    								+"&date2="+theRequest['date2']
    								+"&mode="+document.getElementById("mode").value
    								+"&filter="+num1;
    	}
    	function pager(num) {
    		num2 = num;
    		window.location.href="search2.html?title="+theRequest['title']
    								+"&author="+theRequest['author']
    								+"&keyword="+theRequest['keyword']
    								+"&date1="+theRequest['date1']
    								+"&date2="+theRequest['date2']
    								+"&mode="+document.getElementById("mode").value
    								+"&filter="+((theRequest['filter']=="undefined" || theRequest['filter'] == null)?"":theRequest['filter'])
    								+"&start="+num2*20;
    	}
    </script>

    <script>

    </script>
</head>
<body onload="GetRequest()">
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
<div id="searchjumbotronsmall" class="jumbotron">
    <div class="container">
        <form class="form-inline" action="/MyTech/search2" method="get">
            <div>
                <input type="" class="form-controlctm form-control" id="title" name="title" placeholder="主题" value=""/>
                <button type="submit" class="btn btnctm" style="width: 70px; margin-left: 4px;">检索</button>
				<button type="button" class="btn btnctm" style="margin-left: 4px;" id="btn" onclick="aaa()" data-toggle="collapse" data-target="#advsearch">高级检索</button>
				<div class="collapse" id="advsearch">
					<input type="" class="form-controlctm form-control" id="author" name="author" placeholder="作者" value=""/>
					<input type="" class="form-controlctm form-control" id="keyword" name="keyword" placeholder="关键词" value=""/>
					<div class="dategroup">
						<label style="height: 34px; line-height:34px;vertical-align: center;margin-top: 0; margin-right: 4px;">起始日期</label>
						<input type="month" class="form-controlctm form-control" id="date1" name="date1" placeholder="日期" value=""/>
					</div>
					<div class="dategroup">
						<label style="height: 34px; line-height:34px;vertical-align: center;margin-top: 0; margin-right: 4px;">截止日期</label>
						<input type="month" class="form-controlctm form-control" id="date2" name="date2" placeholder="日期" value=""/>
					</div>
				</div>
            </div>
			<input type="hidden" id="mode" name="mode" value="false"/>
        </form>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-8">
            <c:forEach items="${productList}" var="product">
                <div class="resultlist">
                    <h4><a href="/MyTech/essay?id=${product.id}">${product.title}</a></h4>
                    <p>作者: ${product.author}</p>
                    <p>链接: <a href=${product.url}>${product.url}</a></p>
                </div>
            </c:forEach>
        </div>
		<div id="" class="col-md-4">
			<h3 style="margin-top: 20px;margin-bottom: 10px;">结果筛选</h3>
			<h4 style="margin-top: 20px;margin-bottom: 10px;">发表时间</h4>
			<ul class="list-group list-unstyled">
				<%--<li id="filter1" class="filter"><a href="javascript:void(0);" onclick="filter(1)">1年内</a></li>--%>
				<%--<li id="filter2" class="filter"><a href="javascript:void(0);" onclick="filter(2)">3年内</a></li>--%>
				<%--<li id="filter3" class="filter"><a href="javascript:void(0);" onclick="filter(3)">5年内</a></li>--%>
				<%--<li id="filter4" class="filter"><a href="javascript:void(0);" onclick="filter(4)">5年前</a></li>--%>
                <li id="filter1" class="filter"><a href="javascript:void(0);" onclick="filter(1)">2019年</a></li>
                <li id="filter2" class="filter"><a href="javascript:void(0);" onclick="filter(2)">2018年起</a></li>
                <li id="filter3" class="filter"><a href="javascript:void(0);" onclick="filter(3)">2017年起</a></li>
                <li id="filter4" class="filter"><a href="javascript:void(0);" onclick="filter(4)">2016年起</a></li>
                <li id="filter4" class="filter"><a href="javascript:void(0);" onclick="filter(5)">2015年起</a></li>
			</ul>
			<h4 style="margin-top: 20px;margin-bottom: 10px;">被引次数</h4>
			<ul class="list-group list-unstyled">
				<li id="filter10" class="filter"><a href="javascript:void(0);" onclick="filter(10)">按被引次数排序</a></li>
			</ul>
		</div>
    </div>
	<nav aria-label="Page navigation">
	  <ul class="pagination">
		<li>
		  <a href="#" aria-label="Previous">
			<span aria-hidden="true">&laquo;</span>
		  </a>
		</li>
		<li><a href="javascript:void(0);" onclick="pager(1)">1</a></li>
		<li><a href="javascript:void(0);" onclick="pager(2)">2</a></li>
		<li><a href="javascript:void(0);" onclick="pager(3)">3</a></li>
		<li><a href="javascript:void(0);" onclick="pager(4)">4</a></li>
		<li><a href="javascript:void(0);" onclick="pager(5)">5</a></li>
		<li>
		  <a href="#" aria-label="Next">
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
</body>
</html>
