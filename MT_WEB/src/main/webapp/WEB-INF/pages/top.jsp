<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入常量类进行条件判断--%>
<%@page import="com.woxue.mt.global.Constant" %>

<%--
所有用户：
    文献检索（购买、评论、举报功能在文献详情页实现，不需要导航栏目）

普通用户：
    个人中心（按钮：修改）
    猜你喜欢
    购买积分（放在右上角，作为一个左侧导航太显眼了）
    专家动态（显示已关注的专家的动态）
    领域动态（显示感兴趣的领域的动态）
    已购资源


专家用户(增加一个栏目，其余功能和普通用户是一样的)：
    个人中心（增加栏目：ta的文献、ta的专利）
    管理科技成果（增删改查、转让）
    发布动态


管理员：
    用户列表（查看已注册用户，增删改查）
    专家认证审核
    科技成果审核
    管理科技成果
--%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="assets/skin/default_skin/css/theme.css">
<link rel="stylesheet" type="text/css" href="assets/admin-tools/admin-forms/css/admin-forms.css">
<link rel="shortcut icon" href="assets/img/favicon.ico">
<!-- 引入bootstrap样式 -->
<link href="https://cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<!-- 引入bootstrap-table样式 -->
<link href="https://cdn.bootcss.com/bootstrap-table/1.11.1/bootstrap-table.min.css" rel="stylesheet">
<script src="https://cdn.bootcss.com/jquery/2.2.3/jquery.min.js"></script>
<link href="css/part2.css" rel="stylesheet">
<style>

</style>
<head>
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <script src="//cdn.bootcss.com/Chart.js/2.1.6/Chart.bundle.js"></script>
    <title>个人资料</title>
</head>

<body class="admin-validation-page" data-spy="scroll" data-target="#nav-spy" data-offset="200">
<div id="main">
    <header class="navbar navbar-fixed-top navbar-shadow">
        <div class="navbar-branding">
            <a class="navbar-brand" href="/MyTech/search">
                <b>STUDYIO</b> System
            </a>
            <span id="toggle_sidemenu_l" class="ad ad-lines"></span>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown menu-merge">
                <a href="#" class="dropdown-toggle fw600 p15" data-toggle="dropdown">
                    <img src="assets/img/avatars/5.jpg" alt="avatar" class="mw30 br64">
                    <span class="hidden-xs pl15"> ${sessionScope.user.name} </span>
                    <span class="caret caret-tp hidden-xs"></span>
                </a>
                <ul class="dropdown-menu list-group dropdown-persist w250" role="menu">
                    <li class="list-group-item">
                        <a href="/MyTech/self" class="animated animated-short ">
                            <span class="fa fa-user"></span> 个人信息
                            <span class="label label-warning"></span>
                        </a>
                    </li>
                    <li class="list-group-item">
                        <a href="/MyTech/to_change_password" class="animated animated-short">
                            <span class="fa fa-gear"></span> 设置密码 </a>
                    </li>
                    <c:if test="${sessionScope.user.character==Constant.CHAR_USER}">
                        <li class="list-group-item">
                            <a href="/MyTech/to_add_application" class="animated animated-short">
                                <span class="fa fa-book"></span> 申请成为专家 </a>
                        </li>
                    </c:if>
                    <c:if test="${sessionScope.user.character==Constant.CHAR_USER || sessionScope.user.character==Constant.CHAR_EXPERT}">
                        <li class="list-group-item">
                            <a href="/MyTech/to_charge" class="animated animated-short">
                                <span class="fa fa-dollar"></span> 购买积分 </a>
                        </li>
                    </c:if>
                    <li class="dropdown-footer">
                        <a href="/MyTech/quit" class="">
                            <span class="fa fa-power-off pr5"></span> 退出 </a>
                    </li>

                </ul>
            </li>
        </ul>
    </header>
    <aside id="sidebar_left" class="nano nano-light affix">
        <div class="sidebar-left-content nano-content" >
            <header class="sidebar-header">
                <div class="sidebar-widget author-widget">
                    <div class="media">
                        <a class="media-left" href="#">
                            <img src="assets/img/avatars/3.jpg" class="img-responsive">
                        </a>
                        <div class="media-body">
                            <div class="media-author">${sessionScope.user.name}--${sessionScope.user.character}</div>
                            <div class="media-links">
                                <a href="/MyTech/quit">退出</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="sidebar-widget search-widget hidden">
                    <div class="input-group">
                        <span class="input-group-addon">
                            <i class="fa fa-search"></i>
                        </span>
                        <input type="text" id="sidebar-search" class="form-control" placeholder="Search...">
                    </div>
                </div>
            </header>
            <ul class="nav sidebar-menu">
                <%--基本功能栏：普通用户和专家用户可见--%>
                <c:if test="${sessionScope.user.character==Constant.CHAR_USER || sessionScope.user.character==Constant.CHAR_EXPERT}">
                    <li class="sidebar-label pt20">基本功能</li>

                    <li>
                        <a href="/MyTech/self">
                            <span class="glyphicon glyphicon-home"></span>
                            <span class="sidebar-title">个人中心</span>
                        </a>
                    </li>

                    <li>
                        <a href="/MyTech/user_moment">
                            <span class="fa fa-book"></span>
                            <span class="sidebar-title">专家动态</span>
                        </a>
                    </li>

                    <li>
                        <a href="/MyTech/search">
                            <span class="glyphicon glyphicon-th-list"></span>
                            <span class="sidebar-title">检索科技资源</span>
                        </a>
                    </li>

                    <%--<li>--%>
                        <%--<a href="/claim_voucher/to_add">--%>
                            <%--<span class="glyphicon glyphicon-th-large"></span>--%>
                            <%--<span class="sidebar-title">专家检索</span>--%>
                        <%--</a>--%>
                    <%--</li>--%>

                    <li>
                        <a href="/MyTech/purchasePage">
                            <span class="fa fa-database"></span>
                            <span class="sidebar-title">已购资源</span>
                        </a>
                    </li>
                </c:if>

                <%--专家功能栏：仅专家可见--%>
                <c:if test="${sessionScope.user.character==Constant.CHAR_EXPERT}">
                    <li class="sidebar-label pt15">专家功能</li>

                    <li>
                        <a class="accordion-toggle" href="#">
                            <span class="glyphicon glyphicon-bookmark"></span>
                            <span class="sidebar-title">文献管理</span>
                            <span class="caret"></span>
                        </a>
                        <ul class="nav sub-nav">
                            <li class="active">
                                <a href="/MyTech/local_essay_list">
                                    <span class="glyphicon glyphicon-calendar"></span> 我的文献 </a>
                            </li>
                            <li class="active">
                                <a href="/MyTech/to_add_local_essay">
                                    <span class="glyphicon glyphicon-check"></span> 上传文献 </a>
                            </li>
                        </ul>
                    </li>

                    <li>
                        <a class="accordion-toggle" href="#">
                            <span class="fa fa-columns"></span>
                            <span class="sidebar-title">动态管理</span>
                            <span class="caret"></span>
                        </a>
                        <ul class="nav sub-nav">
                            <li class="active">
                                <a href="/MyTech/user_my_moment">
                                    <span class="glyphicon glyphicon-calendar"></span> 我的动态 </a>
                            </li>
                            <li class="active">
                                <a href="/MyTech/user_add_moment">
                                    <span class="glyphicon glyphicon-check"></span> 新增动态 </a>
                            </li>
                        </ul>
                    </li>
                </c:if>

                <%--管理员功能栏：仅管理员可见--%>
                <c:if test="${sessionScope.user.character==Constant.CHAR_ADMIN}">
                    <li class="sidebar-label pt20">管理员功能</li>

                    <li>
                        <a href="/MyTech/overview">
                            <span class="glyphicon glyphicon-globe"></span>
                            <span class="sidebar-title">数据概览</span>
                        </a>
                    </li>

                    <li>
                        <a href="/MyTech/self">
                            <span class="glyphicon glyphicon-home"></span>
                            <span class="sidebar-title">个人中心</span>
                        </a>
                    </li>

                    <li>
                        <a href="/MyTech/user_list">
                            <span class="glyphicon glyphicon-user"></span>
                            <span class="sidebar-title">用户列表</span>
                        </a>
                    </li>

                    <li>
                        <a href="/MyTech/professorManage">
                            <span class="glyphicon glyphicon-sort"></span>
                            <span class="sidebar-title">专家列表</span>
                        </a>
                    </li>

                    <li>
                        <a href="/MyTech/scienceManage">
                            <span class="glyphicon glyphicon-folder-close"></span>
                            <span class="sidebar-title">管理科技成果</span>
                        </a>
                    </li>

                    <li class="active">
                        <a href="/MyTech/to_application_list">
                            <span class="glyphicon glyphicon-pencil"></span>
                            <span class="sidebar-title">专家认证审核</span>
                        </a>
                    </li>

                    <%--<li>--%>
                        <%--<a href="/claim_voucher/to_add">--%>
                            <%--<span class="fa fa-cubes"></span>--%>
                            <%--<span class="sidebar-title">科技成果审核</span>--%>
                        <%--</a>--%>
                    <%--</li>--%>
                </c:if>
            </ul>
            <div class="sidebar-toggle-mini">
                <a href="#">
                    <span class="fa fa-sign-out"></span>
                </a>
            </div>
        </div>
    </aside>
    <section id="content_wrapper">