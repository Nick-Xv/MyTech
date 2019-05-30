<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.woxue.mt.global.Constant" %>
<jsp:include page="top.jsp"/>
<%--个人信息页面--%>
<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 个人信息 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <div class="panel-body bg-light">
                    <div class="section-divider mt20 mb40">
                        <span> 基本信息 </span>
                    </div>
                    <div class="section row">
                        <div class="col-md-2"><strong>用户身份</strong></div>
                        <div class="col-md-4">${sessionScope.user.character}</div>
                    </div>
                    <div class="section row">
                        <div class="col-md-2"><strong>帐号</strong></div>
                        <div class="col-md-4">${sessionScope.user.id}</div>
                    </div>
                    <div class="section row">
                        <div class="col-md-2"><strong>昵称</strong></div>
                        <div class="col-md-4">${sessionScope.user.name}</div>
                    </div>
                    <div class="section row">
                        <div class="col-md-2"><strong>积分</strong></div>
                        <div class="col-md-4">${sessionScope.user.credit}</div>
                    </div>
                    <div class="section row">
                        <div class="col-md-2"><strong>手机号码</strong></div>
                        <div class="col-md-4">${sessionScope.user.phone}</div>
                    </div>
                    <div class="section row">
                        <div class="col-md-2"><strong>E-mail</strong></div>
                        <div class="col-md-4">${sessionScope.user.email}</div>
                    </div>

                    <c:if test="${sessionScope.user.character==Constant.CHAR_EXPERT}">
                        <div class="section-divider mt20 mb40">
                            <span> 专家信息 </span>
                        </div>
                        <div class="section row">
                            <div class="col-md-2"><strong>姓名</strong></div>
                            <div class="col-md-4">${sessionScope.professor.name}</div>
                        </div>
                        <div class="section row">
                            <div class="col-md-2"><strong>机构</strong></div>
                            <div class="col-md-4">${sessionScope.professor.organization}</div>
                        </div>
                        <div class="section row">
                            <div class="col-md-2"><strong>职称</strong></div>
                            <div class="col-md-4">${sessionScope.professor.post}</div>
                        </div>
                        <div class="section row">
                            <div class="col-md-2"><strong>出生日期</strong></div>
                            <div class="col-md-4">${sessionScope.professor.birthday}</div>
                        </div>
                        <div class="section row">
                            <div class="col-md-2"><strong>简介</strong></div>
                            <div class="col-md-4">${sessionScope.professor.introduction}</div>
                        </div>
                    </c:if>
                    <div class="panel-footer text-right">
                        <button type="button" class="button" onclick="javascript:window.history.go(-1);"> 返回 </button>
                        <a href="/MyTech/user_to_update_by_user?id=${sessionScope.user.id}">
                            <button type="button" class="button btn-default"> 修改 </button>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="bottom.jsp"/>