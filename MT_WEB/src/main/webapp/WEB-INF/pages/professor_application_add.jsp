<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="top.jsp"/>
<%--新建专家申请界面--%>
<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 填写专家申请 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <form:form id="admin-form" name="addForm" action="/MyTech/add_application" modelAttribute="application">
                    <div class="panel-body bg-light">
                        <div class="section-divider mt20 mb40">
                            <span> 基本信息 </span>
                        </div>

                        <div class="section">
                            <label for="birthday" class="field prepend-icon">
                                <form:input path="birthday" cssClass="gui-input" placeholder="出生日期..."/>
                                <label for="birthday" class="field-icon">
                                    <i class="fa fa-lock"></i>
                                </label>
                            </label>
                        </div>

                        <div class="section">
                            <label for="organization" class="field prepend-icon">
                                <form:input path="organization" cssClass="gui-input" placeholder="机构..."/>
                                <label for="organization" class="field-icon">
                                    <i class="fa fa-lock"></i>
                                </label>
                            </label>
                        </div>

                        <div class="section">
                            <label for="introduction" class="field prepend-icon">
                                <form:input path="introduction" cssClass="gui-input" placeholder="简介..."/>
                                <label for="introduction" class="field-icon">
                                    <i class="fa fa-lock"></i>
                                </label>
                            </label>
                        </div>

                        <div class="section">
                            <label for="name" class="field prepend-icon">
                                <form:input path="name" cssClass="gui-input" placeholder="姓名..."/>
                                <label for="name" class="field-icon">
                                    <i class="fa fa-lock"></i>
                                </label>
                            </label>
                        </div>

                        <div class="section">
                            <label for="post" class="field prepend-icon">
                                <form:input path="post" cssClass="gui-input" placeholder="职称..."/>
                                <label for="post" class="field-icon">
                                    <i class="fa fa-lock"></i>
                                </label>
                            </label>
                        </div>


                        <%--<div class="section row">
                            <div class="col-md-3">
                                <label for="organization" class="field prepend-icon">
                                    <form:input path="organization" cssClass="gui-input" placeholder="机构..." readonly="true"/>
                                    <label for="organization" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                            <div class="section" style="text-align:right;">
                                <div class="col-md-9">
                                    <button type="button" class="button" id="addItemButton"> + </button>
                                </div>
                            </div>
                        </div>--%>
                        <div class="panel-footer text-right">
                            <button type="submit" class="button"> 保存 </button>
                            <button type="button" class="button" onclick="javascript:window.history.go(-1);"> 返回 </button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="bottom.jsp"/>