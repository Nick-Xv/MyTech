<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="top.jsp"/>
<%--上传文献界面--%>
<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 上传文献 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <form:form id="admin-form" name="addForm" action="/MyTech/add_local_essay" modelAttribute="localEssay">
                    <div class="panel-body bg-light">
                        <div class="section-divider mt20 mb40">
                            <span> 基本信息 </span>
                        </div>

                        <div class="section">
                            <label class="field-label text-muted fs14 mb10">标题</label>
                            <label for="title" class="field prepend-icon">
                                <form:input path="title" cssClass="gui-input" placeholder="标题..."/>
                                <label for="title" class="field-icon">
                                    <i class="glyphicon glyphicon-header"></i>
                                </label>
                            </label>
                        </div>

                        <div class="section">
                            <label class="field-label text-muted fs14 mb10">作者</label>
                            <label for="author" class="field prepend-icon">
                                <form:input path="author" cssClass="gui-input" placeholder="作者..."/>
                                <label for="author" class="field-icon">
                                    <i class="glyphicon glyphicon-user"></i>
                                </label>
                            </label>
                        </div>

                        <div class="section">
                            <label class="field-label text-muted fs14 mb10">关键字</label>
                            <label for="keyword" class="field prepend-icon">
                                <form:input path="keyword" cssClass="gui-input" placeholder="关键字..."/>
                                <label for="keyword" class="field-icon">
                                    <i class="glyphicon glyphicon-th-list"></i>
                                </label>
                            </label>
                        </div>

                        <div class="section">
                            <label class="field-label text-muted fs14 mb10">简介</label>
                            <label for="introduce" class="field prepend-icon">
                                <form:input path="introduce" cssClass="gui-input" placeholder="简介..."/>
                                <label for="introduce" class="field-icon">
                                    <i class="glyphicon glyphicon-th-list"></i>
                                </label>
                            </label>
                        </div>

                        <div class="section">
                            <label class="field-label text-muted fs14 mb10">售出积分价格</label>
                            <label for="credit" class="field prepend-icon">
                                <form:input path="credit" cssClass="gui-input" placeholder="售出积分价格..."/>
                                <label for="credit" class="field-icon">
                                    <i class="glyphicon glyphicon-usd"></i>
                                </label>
                            </label>
                        </div>

                        <div class="section-divider mt20 mb40">
                            <span> 上传文件 </span>
                        </div>

                        <%--改这里！！！--%>
                        <form method="post" action="/TomcatTest/UploadServlet" enctype="multipart/form-data">
                            选择一个文件:
                            <input type="file" name="uploadFile" />
                            <br/><br/>
                            <button type="submit" class="button"> 上传 </button>
                        </form>
                        <%--改这里！！！--%>

                        <div class="panel-footer text-right">
                            <button type="submit" class="button"> 确定 </button>
                            <button type="button" class="button" onclick="javascript:window.history.go(-1);"> 返回 </button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</section>

<jsp:include page="bottom.jsp"/>