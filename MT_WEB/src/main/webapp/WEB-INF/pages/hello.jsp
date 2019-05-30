<%--
  Created by IntelliJ IDEA.
  User: xuyun
  Date: 2019/5/5
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
    <script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js">
    </script>
    <script type="text/javascript">
        function aaa(){
            $.ajax({
                url:"/hello/123",
                type:'get',
                dataType:'text',
                success:function(data){
                    alert("success");
                    console.log(data);
                },
                error:function (data) {
                    alert("error");
                    console.log(data);
                }
            });
            //window.location.href="/hello/123";
        }
    </script>
</head>
<body>
<h2>${messag}</h2>
<a href="/hello/123">321321</a>
<p>${bbb}</p>
</body>
</html>
