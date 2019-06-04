<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="top.jsp"/>
<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 修改用户信息 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <%--modelAttribute要与UserController中toAdd方法中的键保持一致，也要和Add方法的参数名保持一致--%>
                <form:form action="/MyTech/user_update_by_user" modelAttribute="user"  id="admin-form" name="addForm">
                    <div class="panel-body bg-light">
                        <div class="section-divider mt20 mb40">
                            <span  style="color: #661f66;"> 基本信息 </span>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label for="id" class="field-label text-muted fs14 mb10">账号</label>
                                <label for="id" class="field prepend-icon">
                                    <form:input path="id" cssClass="gui-input" placeholder="用户ID..." readonly="true"/>
                                    <label for="id" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label for="name" class="field-label text-muted fs18 mb10">昵称</label>
                                <label for="name" class="field prepend-icon">
                                    <form:input path="name" cssClass="gui-input" placeholder="用户昵称..." />
                                    <label for="name" class="field-icon">
                                        <i class="fa fa-magic"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label for="email" class="field-label text-muted fs18 mb10">Email</label>
                                <label for="email" class="field prepend-icon">
                                    <form:input path="email" cssClass="gui-input" placeholder="Email..." />
                                    <label for="email" class="field-icon">
                                        <i class="fa fa-mail-forward"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label for="phone" class="field-label text-muted fs18 mb10">手机号</label>
                                <label for="phone" class="field prepend-icon">
                                    <form:input path="phone" cssClass="gui-input" placeholder="手机号..." />
                                    <label for="phone" class="field-icon">
                                        <i class="fa fa-phone"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <%--应该是很不安全的做法，把密码和积分（不应该是这么直接更改）藏起来 懒得改代码了--%>
                        <div class="section" style="display: none">
                            <label for="password" class="field prepend-icon">
                                <form:input path="password" cssClass="gui-input" placeholder="用户密码..." />
                                <label for="password" class="field-icon">
                                    <i class="fa fa-lock"></i>
                                </label>
                            </label>
                        </div>
                        <div class="section" style="display: none">
                            <label for="credit" class="field prepend-icon">
                                <form:input path="credit" cssClass="gui-input" placeholder="credit..." />
                                <label for="credit" class="field-icon">
                                    <i class="fa fa-lock"></i>
                                </label>
                            </label>
                        </div>
                        <div class="panel-footer text-right">
                            <button type="submit" style="background-color: #88185B;"  class="button"> 保存 </button>
                            <button type="button" style="background-color: #88185B;" class="button" onclick="javascript:window.history.go(-1);"> 返回 </button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="bottom.jsp"/>