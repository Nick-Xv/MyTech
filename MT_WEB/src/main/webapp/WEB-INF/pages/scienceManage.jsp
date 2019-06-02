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
      <h2> 科技成果列表 </h2>
      <p class="lead"></p>
    </div>
    <div class="container body-content" style="padding-top:20px;">
      <div class="panel panel-default">
        <div class="panel-heading">搜索条件</div>
        <div class="panel-body">
          <form class="form-inline">
            <div class="row">
              <div class="col-sm-4">
                <label class="control-label">标题：</label>
                <input id="txtTitle" type="text" class="form-control">
              </div>
              <div class="col-sm-4">
                <label class="control-label">作者：</label>
                <input id="txtAuthor" type="text" class="form-control">
              </div>
              <div class="col-sm-4">
                <label class="control-label">关键词：</label>
                <input id="txtKeyword" type="text" class="form-control">
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
      data:${sciList},
      //queryParamsType: '',              //默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort
      //queryParams: queryParams,
      //method: "post",
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
        { title: '标题', field: 'title' },
        { title: '作者', field: 'author' },
        { title: '关键字', field: 'keyword' },
        { title: '被引数', field: 'referenceCount' },
        { title: '状态', field: 'verifyState' },
          { title: '链接', field: 'url',formatter: function (value, row, index) {
                  return [
                      '<a href="'+value+'">查看论文</a>'
                  ].join("")
              } },
          { title: '操作', field: 'id', formatter: function (value,row,index) {
                  return '<button id="deleteBtn" onclick="deleteBtn(`' + value + '`)">删除</button><button id="updateBtn" onclick="updateBtn(`' + value + '`)">修改</button>';
              } }
      ]
    });
  });

  //查询条件
  function queryParams(params) {
    return {
      pageSize: params.pageSize,
      pageIndex: params.pageNumber,
      title: $.trim($("#txtTitle").val()),
      author: $.trim($("#txtAuthor").val()),
      keyword: $.trim($("#txtKeyword").val()),
    };
  }

  //查询事件
  function SearchData() {
      var title = $.trim($("#txtTitle").val());
      var author =$.trim($("#txtAuthor").val());
      var keyword = $.trim($("#txtKeyword").val());
      window.location.href='/MyTech/scienceSearch?title='+title+'author='+author+'keyword='+keyword;
  }

  // 删除操作
  function deleteBtn(id){
      var mymessage = confirm("确认删除嘛？");
      if(mymessage == true) {
          window.location.href='/MyTech/scienceDelete?id='+id;
      }
  }

  // 编辑操作
  function updateBtn(id) {
      window.location.href='/MyTech/scienceUpdate?id='+id;
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