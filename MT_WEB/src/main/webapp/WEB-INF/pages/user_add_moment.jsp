<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="top.jsp"/>
<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 添加新动态 </h2>
            <p class="lead"></p>
        </div>
        <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">
            <div class="panel heading-border">
                <%--modelAttribute要与UserController中toAdd方法中的键保持一致，也要和Add方法的参数名保持一致--%>
                    <div class="panel-body bg-light">
                        <div class="section-divider mt20 mb40">
                            <span> 动态信息 </span>
                        </div>
                        <div class="section">
                            <textarea class="form-control" id="textareactm" name="comment" rows="5">${texttext}</textarea>
                        </div>
                        <p hidden id="tid">${tid}</p>
                        <div class="panel-footer text-right">
                            <button type="button" class="button" onclick="submitMoment()"> 保存 </button>
                            <button type="button" class="button" onclick="javascript:window.history.go(-1);"> 返回 </button>
                        </div>
                    </div>
            </div>
        </div>
    </div>
</section>
<script type="text/javascript">
    function submitMoment() {
        var title = document.getElementById("textareactm").value;
        var tid = document.getElementById("tid").innerHTML;
        var des = title.replace(/\r\n/g, '<br/>').replace(/\n/g, '<br/>').replace(/\s/g, ' ');
        if(tid != "" && tid != null){
            $.ajax({
                url:"/MyTech/user_add_moment?content="+des+"&type=1&tid="+tid,
                type:'get',
                dataType:'text',
                success:function(data){
                    window.location.href="/MyTech/user_my_moment";
                },
                error:function (data) {
                    alert("炸了");
                }
            });
        }
        else
        $.ajax({
            url:"/MyTech/user_add_moment?content="+des,
            type:'get',
            dataType:'text',
            success:function(data){
                window.location.href="/MyTech/user_moment";
            },
            error:function (data) {
                alert("炸了");
            }
        });
    }
</script>
<jsp:include page="bottom.jsp"/>