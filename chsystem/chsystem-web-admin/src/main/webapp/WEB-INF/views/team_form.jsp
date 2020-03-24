<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>管理平台 | 班级管理</title>
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
                班级管理
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="/main"><i class="fa fa-dashboard"></i> 首页</a></li>
                <li class="active">${tbTeam.id == null ? "新增" : "编辑"}班级</li>
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

                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">${tbTeam.id == null ? "新增" : "编辑"}班级</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form:form id="inputForm" cssClass="form-horizontal" action="/team/save" method="post" modelAttribute="tbTeam">
                            <form:hidden path="id" />
                            <div class="box-body">
                                <div class="form-group">
                                    <label for="grade" class="col-sm-2 control-label">年级</label>

                                    <div class="col-sm-10">
                                        <form:input cssClass="form-control required" path="grade" placeholder="请输入年级" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="teamName" class="col-sm-2 control-label">班级名</label>
                                    <div class="col-sm-10">
                                        <form:input cssClass="form-control required" path="teamName" placeholder="请输入班级名" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="stuNumber" class="col-sm-2 control-label">学生人数</label>
                                    <div class="col-sm-10">
                                        <form:input cssClass="form-control" path="stuNumber" placeholder="请输入学生人数" />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="teamNote" class="col-sm-2 control-label">班级信息</label>
                                    <div class="col-sm-10">
                                        <form:input cssClass="form-control" path="teamNote" placeholder="请输入班级信息" />
                                    </div>
                                </div>
                            </div>

                            <div class="box-footer">
                                <button type="button" class="btn btn-default" onclick="history.go(-1);">返回</button>
                                <button type="submit" class="btn btn-info pull-right">提交</button>
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </section>
    </div>

    <jsp:include page="../includes/copyright.jsp" />
</div>

<jsp:include page="../includes/footer.jsp" />
</body>
</html>