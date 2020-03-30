<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>

<!DOCTYPE html>
<html>
<head>
    <title>管理平台 | 学生管理</title>
    <jsp:include page="../includes/header.jsp" />
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <jsp:include page="../includes/nav.jsp" />
    <jsp:include page="../includes/menu.jsp" />

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                学生管理
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="/main"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active"><i>学生列表</i></li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${baseResult != null}">
                        <div class="alert alert-${baseResult.status == 200 ? "success" : "danger"} alert-dismissible">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                ${baseResult.message}
                        </div>
                    </c:if>

                    <div class="box box-info box-info-search" style="display: none;">
                        <div class="box-header">
                            <h3 class="box-title">高级搜索</h3>
                        </div>

                        <div class="box-body">
                            <div class="row form-horizontal">
                                <div class="col-xs-12 col-sm-3">
                                    <div class="form-group">
                                        <label for="name" class="col-sm-4 control-label">学生名</label>
                                        <div class="col-sm-8">
                                            <input id="name" class="form-control" placeholder="学生名" />
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="box-footer">
                            <button type="button" class="btn btn-info pull-right" onclick="search();">搜索</button>
                        </div>
                    </div>

                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">学生列表</h3>
                        </div>

                        <div class="box-body">
                            <a href="/student/form" type="button" class="btn btn-sm btn-default"><i class="fa fa-plus"></i> 新增</a>&nbsp;&nbsp;&nbsp;
                            <button type="button" class="btn btn-sm btn-default" onclick="App.deleteMulti('/worker/delete')"><i class="fa fa-trash-o"></i> 删除</button>&nbsp;&nbsp;&nbsp;
                            <a href="#" type="button" class="btn btn-sm btn-default"><i class="fa fa-download"></i> 导入</a>&nbsp;&nbsp;&nbsp;
                            <a href="#" type="button" class="btn btn-sm btn-default"><i class="fa fa-upload"></i> 导出</a>&nbsp;&nbsp;&nbsp;
                            <button type="button" class="btn btn-sm btn-primary" onclick="$('.box-info-search').css('display') == 'none' ? $('.box-info-search').show('fast') : $('.box-info-search').hide('fast')"><i class="fa fa-search"></i> 搜索</button>
                        </div>

                        <!-- /.box-header -->
                        <div class="row">
                        <div class="col-xs-2" style="margin-left: 20px;">
                            <div class="box">
                                <div class="box-header">
                                    <h3 class="box-title">班级列表</h3>
                                </div>
                                <!-- /.box-header -->
                                <div class="box-body no-padding">
                                    <table id="teamTable" class="table table-striped">
                                        <c:forEach items="${tbTeams}" var="tbTeam" varStatus="i">
                                            <tr id="teamName">
                                                <td>${i.count}.</td>
                                                <td>${tbTeam.teamName}</td>
                                                <td style="display: none">${tbTeam.id}</td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </div>
                                <!-- /.box-body -->
                            </div>
                        </div>


                        <div class="col-xs-9 box-body table-responsive">
                            <table id="dataTable" class="table table-hover" >
                                <thead>
                                <tr>
                                    <th><input type="checkbox" class="minimal icheck_master" /></th>
                                    <th>id</th>
                                    <th>姓名</th>
                                    <th>性别</th>
                                    <th>出生日期</th>
                                    <th>身份证号</th>
                                    <th>住址</th>
                                    <th>父亲姓名</th>
                                    <th>父亲联系方式</th>
                                    <th>母亲姓名</th>
                                    <th>母亲联系方式</th>
                                    <th>其他信息</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </table>
                        </div>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
            </div>
        </section>
    </div>

    <jsp:include page="../includes/copyright.jsp" />
</div>

<jsp:include page="../includes/footer.jsp" />

<!-- 自定义模态框 -->
<sys:modal />

<script>
    var _dataTable;
    $(function () {
        var _columns = [
            {
                "data": function (row, type, val, meta) {
                    return '<input id="' + row.id + '" type="checkbox" class="minimal" />';
                }
            },
            {"data": "id"},
            {"data": "name"},
            {"data": "gender"},
            {"data": "birth"},
            {"data": "idCard"},
            {"data": "address"},
            {"data": "father"},
            {"data": "faPhone"},
            {"data": "mother"},
            {"data": "moPhone"},
            {"data": "note"},
            {
                "data": function (row, type, val, meta) {
                    var deleteUrl = "/student/delete";
                    return '<a href="/student/form?id=' + row.id + '" type="button" class="btn btn-sm btn-primary"><i class="fa fa-edit"></i> 编辑</a>&nbsp;&nbsp;&nbsp;' +
                        '<button type="button" class="btn btn-sm btn-danger" onclick="App.deleteSingle(\'' + deleteUrl + '\', \'' + row.id + '\')"><i class="fa fa-trash-o"></i> 删除</button>';
                }
            }
        ];
        _dataTable = App.initDataTables("/student/page", _columns);
    });
    function search() {
        var name = $("#name").val();

        var param = {
            "name": name
        };
        _dataTable.settings()[0].ajax.data = param;
        _dataTable.ajax.reload();
    };
    $('#teamTable').on('click','tr', function() {
        var teamId = $(this).children("td").eq(2).html();
        var param = {
            "teamId": teamId
        };
        _dataTable.settings()[0].ajax.data = param;
        _dataTable.ajax.reload();
    });

</script>
</body>
</html>