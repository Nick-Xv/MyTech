<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>加入STUDYIO</title>
    <meta name="keywords" content="HTML5 Bootstrap 3 Admin Template UI Theme" />
    <meta name="description" content="AbsoluteAdmin - A Responsive HTML5 Admin UI Framework">
    <meta name="author" content="AbsoluteAdmin">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="assets/skin/default_skin/css/theme.css">
    <link rel="stylesheet" type="text/css" href="assets/admin-tools/admin-forms/css/admin-forms.css">
    <link rel="shortcut icon" href="assets/img/favicon.ico">
</head>
<body class="external-page external-alt sb-l-c sb-r-c">
<div id="main" class="animated fadeIn">
    <section id="content_wrapper">
        <section id="content">
            <div class="admin-form theme-info mw500" id="login">
                <div class="content-header">
                    <h1> MyTech</h1>
                    <p class="lead">欢迎使用科技专家资源共享平台</p>
                </div>
                <div class="panel mt30 mb25">
                    <form method="post" action="register" id="contact">

                        <div class="panel-body bg-light p25 pb15">
                            <div class="section">
                                <label for="id" class="field-label text-muted fs18 mb10">账号</label>
                                <label for="id" class="field prepend-icon">
                                    <input type="text" name="id" id="id" class="gui-input" placeholder="请输入账号...">
                                    <label for="id" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="section">
                                <label for="nickName" class="field-label text-muted fs18 mb10">昵称</label>
                                <label for="nickName" class="field prepend-icon">
                                    <input type="text" name="nickName" id="nickName" class="gui-input" placeholder="请输入昵称...">
                                    <label for="nickName" class="field-icon">
                                        <i class="fa fa-male"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="section">
                                <label for="password1" class="field-label text-muted fs18 mb10">密码</label>
                                <label for="password1" class="field prepend-icon">
                                    <input type="password" name="password1" id="password1" class="gui-input" placeholder="请输入密码...">
                                    <label for="password1" class="field-icon">
                                        <i class="fa fa-lock"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="section">
                                <label for="password2" class="field-label text-muted fs18 mb10">重复密码</label>
                                <label for="password2" class="field prepend-icon">
                                    <input type="password" name="password2" id="password2" class="gui-input" placeholder="请输入密码...">
                                    <label for="password2" class="field-icon">
                                        <i class="fa fa-lock"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="panel-footer clearfix">
                            <button type="submit" class="button btn-primary mr10 pull-right">注册</button>
                            <a href="/MyTech/to_login" style="text-decoration: none">
                                <span class="text-info">已有账号前往登录</span>
                            </a>
                            <span class="ml20 text-danger">${error_message}</span>
                        </div>
                    </form>
                </div>
            </div>
        </section>
    </section>
</div>
<script src="vendor/jquery/jquery-1.11.1.min.js"></script>
<script src="vendor/jquery/jquery_ui/jquery-ui.min.js"></script>
<script src="assets/js/utility/utility.js"></script>
<script src="assets/js/demo/demo.js"></script>
<script src="assets/js/main.js"></script>
</body>
</html>
