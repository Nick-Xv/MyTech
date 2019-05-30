<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html lang="zh-CN">
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>Bootply snippet - Bootstrap Dashboard with Off-canvas Sidebar</title>
    <meta name="generator" content="Bootply" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="description" content="example of a Bootstrap dashboard template with  collapsible offcanvas sidebar. The left sidebar collaspes on smaller screens and can be toggled." />
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <link rel="apple-touch-icon" href="/bootstrap/img/apple-touch-icon.png">
    <link rel="apple-touch-icon" sizes="72x72" href="/bootstrap/img/apple-touch-icon-72x72.png">
    <link rel="apple-touch-icon" sizes="114x114" href="/bootstrap/img/apple-touch-icon-114x114.png">
    <script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>

    <style type="text/css">
        body {
            padding-top: 50px;
            background-color: #f5f5f5;
        }
        footer {
            padding-left: 15px;
            padding-right: 15px;
            background-color: #fff;
        }

        @media screen and (max-width: 768px) {
            .row-offcanvas {
                position: relative;
                -webkit-transition: all 0.25s ease-out;
                -moz-transition: all 0.25s ease-out;
                transition: all 0.25s ease-out;
            }
            .row-offcanvas-left
            .sidebar-offcanvas {
                left: -33%;
            }
            .row-offcanvas-left
            .active {
                left: 33%;
            }
            .sidebar-offcanvas {
                position: absolute;
                top: 0;
                width: 33%;
                margin-left: 10px;
            }
        }
        .nav-sidebar {
            background-color: #f5f5f5;
            margin-right: -15px;
            margin-bottom: 20px;
            margin-left: -15px;
        }
        .nav-sidebar > li > a {
            padding-right: 20px;
            padding-left: 20px;
        }
        .nav-sidebar > .active > a {
            color: #fff;
            background-color: #428bca;
        }
        .main {
            padding: 20px;
            background-color: #fff;
        }
        @media (min-width: 768px) {
            .main {
                padding-right: 40px;
                padding-left: 40px;
            }
        }
        .main .page-header {
            margin-top: 0;
        }
    </style>
</head>

<!-- BODY -->
<body >
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">科技资源共享平台-管理后台</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/background/overview">控制台</a></li>
                <li><a href="/background/setting">设置</a></li>
                <li><a href="/background/help">帮助</a></li>
            </ul>
            <form class="navbar-form navbar-right">
                <input type="text" class="form-control" placeholder="输入关键词...">
            </form>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row row-offcanvas row-offcanvas-left">
        <div class="col-sm-3 col-md-2 sidebar-offcanvas" id="sidebar" role="navigation">
            <ul class="nav nav-sidebar">
                <li class="active"><a href="/MyTech/background/overview">概览</a></li>
                <li><a href="/MyTech/background/scienceManage" target="_ext">科技成果管理</a></li>
                <li><a href="/MyTech/background/userManage" target="_ext">用户管理</a></li>
                <li><a href="/MyTech/background/professorManage" target="_ext">专家管理</a></li>
            </ul>
        </div><!--/span-->

        <div class="col-sm-9 col-md-10 main">
            <p class="visible-xs">
                <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas"><i class="glyphicon glyphicon-chevron-left"></i></button>
            </p>

            <h1 class="page-header">
                概览
            </h1>

            <canvas id="myChart"></canvas>>
        </div><!--/row-->
    </div>
</div><!--/.container-->

<footer>
    <p class="pull-right">©Beihang Software</p>
</footer>

<script type='text/javascript' src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type='text/javascript' src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<!-- JavaScript jQuery code from Bootply.com editor  -->

<script type='text/javascript'>
    $(document).ready(function() {
        $('[data-toggle=offcanvas]').click(function() {
            $('.row-offcanvas').toggleClass('active');
        });
    });
</script>

<script>
    (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
        (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
        m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
    })(window,document,'script','//www.google-analytics.com/analytics.js','ga');
    ga('create', 'UA-40413119-1', 'bootply.com');
    ga('send', 'pageview');
</script>
<script>
    var ctx = document.getElementById('myChart').getContext('2d');
    var chart = new Chart(ctx, {
        type: 'line',
        data: {
            labels: ${labels},
            datasets: [
                {label: '用户数',
                backgroundColor: 'rgb(255,181,178)',
                borderColor: 'rgb(255,181,178)',
                data: ${userData}
                },
                {label: '科技专家数',
                backgroundColor: 'rgb(187,241,255)',
                borderColor: 'rgb(187,241,255)',
                data: ${professorData}
                },
                {label: '科技成果数',
                    backgroundColor: 'rgb(255,243,198)',
                    borderColor: 'rgb(255,243,198)',
                    data: ${scienceData}
                }
            ]
        },
        options: {}
    });
</script>>

</body>
</html>

