<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="top.jsp"/>
<%--购买积分界面--%>
<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 充值积分 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <%--modelAttribute要与UserController中toAdd方法中的键保持一致，也要和Add方法的参数名保持一致--%>
                    <form method="post" action="charge" id="contact">

                        <div class="panel-body bg-light p25 pb15">
                            <div class="section">
                                <label for="credit" class="field-label text-muted fs18 mb10">积分数量</label>
                                <label for="credit" class="field prepend-icon">
                                    <input type="text" name="credit" id="credit" class="gui-input" placeholder="请输入充值积分数量...">
                                    <label for="credit" class="field-icon">
                                        <i class="glyphicon glyphicon-usd"></i>
                                    </label>
                                </label>
                            </div>
                        </div>
                        <div class="panel-footer clearfix">
                            <button type="submit" class="button btn-primary mr10 pull-right">充值</button>
                            <span class="ml20 text-danger">${error_message}</span>
                        </div>
                    </form>
            </div>
        </div>
    </div>
</section>


<jsp:include page="bottom.jsp"/>