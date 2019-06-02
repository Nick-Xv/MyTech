<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="top.jsp"/>
<!-- jquery -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<!-- bootstrap-table.min.js -->
<script src="https://cdn.bootcss.com/bootstrap-table/1.11.1/bootstrap-table.min.js"></script>
<!-- 引入中文语言包 -->
<script src="https://cdn.bootcss.com/bootstrap-table/1.11.1/locale/bootstrap-table-zh-CN.min.js"></script>

<section id="content" class="table-layout animated fadeIn">
    <div class="tray tray-center">
        <div class="content-header">
            <h2> 专家列表 </h2>
            <p class="lead"></p>
        </div>
        <div class="container body-content" style="padding-top:20px;">
            <div class="panel panel-default">
                <div class="panel-heading">搜索条件</div>
                <div class="panel-body">
                    <form class="form-inline">
                        <div class="row">
                            <div class="col-sm-4">
                                <label class="control-label">专家姓名：</label>
                                <input id="txtName" type="text" class="form-control">
                            </div>
                            <div class="col-sm-4">
                                <label class="control-label">所属组织：</label>
                                <input id="txtOrganization" type="text" class="form-control">
                            </div>
                            <div class="col-sm-4">
                                <label class="control-label">研究领域：</label>
                                <input id="txtArea" type="text" class="form-control">
                            </div>
                        </div>

                        <div class="row text-right" style="margin-top:20px;">
                            <div class="col-sm-12">
                                <input class="btn btn-primary" type="button" value="查询" onclick="SearchData()">
                                <input class="btn btn-default" type="button" value="批量删除" onclick="BtchDeleteBook()">
                            </div>
                        </div>
                    </form>
                </div>
            </div>

            <table id="table"></table>
    </div>
    </div>
</section>


<script type="text/javascript">
    $(document).ready(function () {
        $('#table').bootstrapTable({
            data: ${profList},
            url:'/mytech/jdisjai',
            //queryParamsType: '',              //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
            //queryParams: queryParams,
            //method: 'post',
            //contentType: "application/x-www-form-urlencoded; charset=UTF-8",
            pagination: true,
            pageNumber: 1,
            pageSize: 10,
            pageList: [10, 20, 50, 100],
            sidePagination: "client",         //分页方式：client客户端分页，server服务端分页（*）
            striped: true,                    //是否显示行间隔色
            cache: false,
            uniqueId: "id",               //每一行的唯一标识，一般为主键列
            height:500,
            paginationPreText: "上一页",
            paginationNextText: "下一页",
            columns: [
                { checkbox: true },
                { title: '序号', width: 50, align: "center", formatter: function (value, row, index) { return index + 1; } },
                { title: '姓名', field: 'name' ,editable:true},
                { title: '所属组织', field: 'organization',editable:true },
                { title: '研究领域', field: 'area',editable:true },
                { title: '被引数', field: 'referenceCount' },
                { title: '状态', field: 'verifyState' ,editable:true},
                { title: '操作', field: 'id ', formatter: option }
            ]
        });
    });

    //查询条件
    function queryParams(params) {
        return {
            pageSize: params.pageSize,
            pageIndex: params.pageNumber,
            name: $.trim($("#txtName").val()),
            organization: $.trim($("#txtOrganization").val()),
            area: $.trim($("#txtArea").val()),
        };
    }

    //查询事件
    function SearchData() {
        var name = $.trim($("#txtName").val());
        var organization =$.trim($("#txtOrganization").val());
        var area = $.trim($("#txtArea").val());
        window.location.href='/MyTech/viewUncheckedProfessor';
    }
    
    //操作
    function option(value, row, index) {
        var optionBtn = '<button id="delete" userId=' +
            value +
            ' onclick="deleteBtn(this)">删除</button><button id="updateBtn" onclick="update(' +
            value + ')">修改</button>'
        return optionBtn;
    }

    // 删除操作
    function deleteBtn(dom){
        var mymessage = confirm("确认删除嘛？");
        if(mymessage == true) {
            $.ajax({
                url: path + '/user/' + $(dom).attr("userId"),
                type: 'delete',
                success: function(data) {
                    $(dom).parent().parent().hide();
                },
                error: function(data) {
                    alert("服务器繁忙")
                }
            });
        }
    }

    // 编辑操作
    function updateBtn(id) {
        layer.open({
            type: 2,
            title: '编辑用户',
            area: ['500px', '440px'],
            fix: false,
            content: path + '/xxx/xxxxUpd/' + id,
            end: function() {
                $("#mytab").bootstrapTable('refresh', {
                    url: path + "/xx/list"
                });
            }
        });
    }

    //批量删除
    function BtchDeleteBook(){
        var opts = $('#table').bootstrapTable('getSelections');
        if (opts == "") {
            alert("请选择要删除的数据");
        }
        else {
            var idArray = [];
            for (var i = 0; i < opts.length; i++) {
                idArray.push(opts[i].BookId);
            }
            if (confirm("确定删除：" + idArray + "吗？")) {
                alert("执行删除操作");
            }
        }
    }
</script>

<jsp:include page="bottom.jsp"/>