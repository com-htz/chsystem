<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="row">
    <div class="col-xs-6">
        <dl>
            <dt>邮箱：</dt>
            <dd>${tbWorker.address}</dd>
            <br />

            <dt>姓名：</dt>
            <dd>${tbWorker.username}</dd>
            <br />

            <dt>手机：</dt>
            <dd>${tbWorker.phone}</dd>
            <br />
        </dl>
    </div>

    <div class="col-xs-6">
        <dl>
            <dt>创建时间：</dt>
            <dd><fmt:formatDate value="${tbWorker.created}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>
            <br />

            <dt>更新时间：</dt>
            <dd><fmt:formatDate value="${tbWorker.updated}" pattern="yyyy-MM-dd HH:mm:ss"/></dd>
        </dl>
    </div>
</div>