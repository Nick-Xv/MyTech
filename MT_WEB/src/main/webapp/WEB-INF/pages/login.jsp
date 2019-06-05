<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>登录到STUDYIO</title>
    <meta name="keywords" content="HTML5 Bootstrap 3 Admin Template UI Theme" />
    <meta name="description" content="AbsoluteAdmin - A Responsive HTML5 Admin UI Framework">
    <meta name="author" content="AbsoluteAdmin">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="assets/skin/default_skin/css/theme.css">
    <link rel="stylesheet" type="text/css" href="assets/admin-tools/admin-forms/css/admin-forms.css">
    <link rel="shortcut icon" href="assets/img/favicon.ico">
    <link rel="stylesheet" href="css/part2.css">
</head>
<body class="external-page external-alt sb-l-c sb-r-c" style="background-color: #661F66;">
<div id="main" class="animated fadeIn" style="background-color: #661f66;">
    <section id="content_wrapper">
        <section id="content" style="background-color: #661f66;">
            <div id="login" class="admin-form theme-info mw500">
                <div class="content-header">
                    <h1 style="color:#fff;">STUDYIO</h1>
                    <p class="lead" style="color:#fff;">欢迎使用科技专家资源共享平台</p>
                </div>
                <div class="panel mt30 mb25" style="border-radius:0;background-color: #661f66;/* width: 560px; */">
                    <form method="post" action="/MyTech/login" id="contact" style="border-radius=0;">
                        <div class="panel-body bg-light p25 pb15" style="background-color: #fff;padding: 50px 30px;/* width: 560px; */text-align:center;height:275px;vertical-align:middle;display: table-cell;">
                            <div class="section" style="width:400px; display:inline-block;padding-bottom:10px;">
                                <label for="id" class="field-label text-muted fs18 mb10" style="color:#661f66; text-align:left;">账号</label>
                                <span class="text-info">${success_message}</span>
                                <label for="id" class="field prepend-icon">
                                    <input type="text" name="id" id="id" class="gui-input" placeholder="请输入账号...">
                                    <label for="id" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="section" style="width:400px; display:inline-block;text-align:left;">
                                <label for="password" class="field-label text-muted fs18 mb10" style="color:#661f66;">密码</label>
                                <label for="password" class="field prepend-icon" style="text-align:center;">
                                    <input placeholder="请输入密码..." class="gui-input" id="password" name="password" type="password">
                                    <label for="password" class="field-icon">
                                        <i class="fa fa-lock"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="panel-footer clearfix" style="border-radius:0;">
                            <button type="submit" class="button btn-primary mr10 pull-right" style="background-color: #661f66;">登录</button>
                            <a href="/MyTech/to_register">
                                <span class="button btn-default mr10 pull-right">注册</span>
                            </a>
                            <label class="switch ib switch-primary mt10">
                                <input type="checkbox" name="remember" id="remember" checked="true">
                                <label for="remember" data-on="是" data-off="否"></label>
                                <span>记住我</span>
                            </label>
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
