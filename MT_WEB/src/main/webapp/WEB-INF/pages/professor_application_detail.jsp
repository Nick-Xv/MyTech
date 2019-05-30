<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.woxue.mt.global.Constant" %>
<jsp:include page="top.jsp"/>
<%--专家申请查看详情页面--%>
<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 专家申请详情 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <div class="panel-body bg-light">
                    <div class="section-divider mt20 mb40">
                        <span> 基本信息 </span>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">ID</div>
                        <div class="col-md-6">${application.id}</div>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">申请状态</div>
                        <div class="col-md-6">${application.state}</div>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">申请人</div>
                        <div class="col-md-4">${application.userId}</div>
                        <div class="col-md-2">申请时间</div>
                        <div class="col-md-4">${application.time}</div>
                        <%--<div class="col-md-4"><spring:eval expression="application.time"/></div>--%>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">姓名</div>
                        <div class="col-md-4">${application.name}</div>
                        <div class="col-md-2">职称</div>
                        <div class="col-md-4">${application.post}</div>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">出生日期</div>
                        <div class="col-md-4">${application.birthday}</div>
                    </div>
                    <div class="section row">
                        <div class="col-md-2">机构</div>
                        <div class="col-md-4">${application.organization}</div>
                        <div class="col-md-2">简介</div>
                        <div class="col-md-4">${application.introduction}</div>
                    </div>

                    <div class="section-divider mt20 mb40">
                        <span> 处理流程 </span>
                    </div>

                    <table id="message-table" class="table admin-form theme-warning tc-checkbox-1">
                        <thead>
                        <tr class="">
                            <th class="hidden-xs">处理人</th>
                            <th class="hidden-xs">处理时间</th>
                            <th class="hidden-xs">状态</th>
                            <th class="hidden-xs">备注</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${records}" var="record">
                            <tr class="message-unread">
                                <td>${record.adminId}</td>
                                <td>${record.dealTime}</td>
                                <td>${record.dealMethod}</td>
                                <td>${record.notes}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                    <%--申请者在看到详情页的时候所能使用的功能--%>
                    <c:if test="${sessionScope.user.character==Constant.CHAR_USER}">
                        <div class="panel-footer text-right">
                        <c:if test="${application.state==Constant.APPLICATION_ACCEPTED}">
                            <a href="/MyTech/become_professor?id=${application.id}" class="text-left">
                                <button type="button" class="button"> 成为专家 </button>
                            </a>
                            <span class="text-danger text-left">注意：在成为专家后你的认证信息将无法自由更改，请在确保信息准确后再点击成为专家</span>
                        </c:if>
                            <a href="/MyTech/to_update_application">
                                <button type="button" class="button"> 修改 </button>
                            </a>
                            <button type="button" class="button" onclick="javascript:window.history.go(-1);"> 返回 </button>
                        </div>
                    </c:if>

                    <%--管理员在看到详情页的时候所能使用的功能--%>
                    <c:if test="${sessionScope.user.character==Constant.CHAR_ADMIN}">
                        <div class="panel-footer text-right">
                            <%--一个用来输入备注的输入框（驳回原因）--%>
                            <form method="post" action="application_deny?id=${application.id}" id="contact">
                                <label for="note" class="field-label text-muted fs18 mb10">驳回理由：</label>
                                <label for="note" class="field prepend-icon">
                                    <input type="text" name="note" id="note" class="gui-input" placeholder="请输入理由...">
                                    <label for="note" class="field-icon">
                                        <i class="fa fa-reply"></i>
                                    </label>
                                </label>

                                <button type="submit" class="button"> 驳回 </button>
                            </form>
                            <a href="/MyTech/application_accept?id=${application.id}">
                                <button type="button" class="button"> 通过 </button>
                            </a>
                            <a href="/MyTech/to_application_list">
                                <button type="button" class="button"> 返回 </button>
                            </a>
                        </div>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="bottom.jsp"/>