<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="top.jsp"/>
<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 修改科技成果信息 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <%--modelAttribute要与UserController中toAdd方法中的键保持一致，也要和Add方法的参数名保持一致--%>
                <form:form action="/MyTech/scienceChange" modelAttribute="science"  id="admin-form" name="addForm">
                    <div class="panel-body bg-light">
                        <div class="section-divider mt20 mb40">
                            <span> 基本信息 </span>
                        </div>

                        <div class="section row">
                            <div class="col-md-6">
                                <label for="id" class="field-label text-muted fs14 mb10">ID</label>
                                <label for="id" class="field prepend-icon">
                                    <form:input path="id" cssClass="gui-input" placeholder="专家ID..." readonly="true"/>
                                    <label for="id" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label for="title" class="field-label text-muted fs14 mb10">标题</label>
                                <label for="title" class="field prepend-icon">
                                    <form:input path="title" cssClass="gui-input" placeholder="标题..." />
                                    <label for="title" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label for="author" class="field-label text-muted fs14 mb10">作者</label>
                                <label for="author" class="field prepend-icon">
                                    <form:input path="author" cssClass="gui-input" placeholder="作者..." readonly="true"/>
                                    <label for="author" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label for="publishTime" class="field-label text-muted fs14 mb10">发表时间</label>
                                <label for="publishTime" class="field prepend-icon">
                                    <form:input path="publishTime" cssClass="gui-input" placeholder="发表时间(空格分隔)..." readonly="true"/>
                                    <label for="publishTime" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label for="referenceCount" class="field-label text-muted fs14 mb10">被引数</label>
                                <label for="referenceCount" class="field prepend-icon">
                                    <form:input path="referenceCount" cssClass="gui-input" placeholder="被引数..." readonly="true"/>
                                    <label for="referenceCount" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label for="keyword" class="field-label text-muted fs14 mb10">关键字</label>
                                <label for="keyword" class="field prepend-icon">
                                    <form:input path="keyword" cssClass="gui-input" placeholder="关键字..." />
                                    <label for="keyword" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label for="summary" class="field-label text-muted fs14 mb10">概要</label>
                                <label for="summary" class="field prepend-icon">
                                    <form:input path="summary" cssClass="gui-input" placeholder="概要..." />
                                    <label for="summary" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label for="url" class="field-label text-muted fs14 mb10">链接</label>
                                <label for="url" class="field prepend-icon">
                                    <form:input path="url" cssClass="gui-input" placeholder="链接..." />
                                    <label for="url" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label for="verifyState" class="field-label text-muted fs14 mb10">科技成果状态</label>
                                <label for="verifyState" class="field prepend-icon">
                                    <form:input path="verifyState" cssClass="gui-input" placeholder="科技成果状态..." />
                                    <label for="verifyState" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                        </div>

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