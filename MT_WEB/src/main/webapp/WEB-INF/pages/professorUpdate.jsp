<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="top.jsp"/>
<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 修改专家信息 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <%--modelAttribute要与UserController中toAdd方法中的键保持一致，也要和Add方法的参数名保持一致--%>
                <form:form action="/MyTech/professorChange" modelAttribute = "professor"  id="admin-form" name="addForm">
                    <div class="panel-body bg-light">
                        <div class="section-divider mt20 mb40">
                            <span> 基本信息 </span>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label for="id" class="field-label text-muted fs14 mb10">ID</label>
                                <label for="id" class="field prepend-icon">
                                    <form:input path="id" cssClass="gui-input" placeholder="科技成果ID..." readonly="true"/>
                                    <label for="id" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label for="name" class="field-label text-muted fs14 mb10">姓名</label>
                                <label for="name" class="field prepend-icon">
                                    <form:input path="name" cssClass="gui-input" placeholder="专家姓名..." />
                                    <label for="name" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label for="organization" class="field-label text-muted fs14 mb10">所属机构</label>
                                <label for="organization" class="field prepend-icon">
                                    <form:input path="organization" cssClass="gui-input" placeholder="所属机构..." />
                                    <label for="organization" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label for="area" class="field-label text-muted fs14 mb10">研究领域</label>
                                <label for="area" class="field prepend-icon">
                                    <form:input path="area" cssClass="gui-input" placeholder="研究领域(空格分隔)..." />
                                    <label for="area" class="field-icon">
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
                                <label for="workNumber" class="field-label text-muted fs14 mb10">成果数量</label>
                                <label for="workNumber" class="field prepend-icon">
                                    <form:input path="workNumber" cssClass="gui-input" placeholder="成果数量..." readonly="true"/>
                                    <label for="workNumber" class="field-icon">
                                        <i class="fa fa-user"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="section row">
                            <div class="col-md-6">
                                <label for="verifyState" class="field-label text-muted fs14 mb10">专家状态</label>
                                <label for="verifyState" class="field prepend-icon">
                                    <form:input path="verifyState" cssClass="gui-input" placeholder="专家状态..." />
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