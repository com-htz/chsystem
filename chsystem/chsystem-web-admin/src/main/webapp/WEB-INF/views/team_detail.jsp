<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="row">
    <div class="col-xs-6">
        <dl>
            <dt>年级：</dt>
            <dd>${tbTeam.grade}</dd>
            <br />

            <dt>班级名：</dt>
            <dd>${tbTeam.teamName}</dd>
            <br />

            <dt>学生人数：</dt>
            <dd>${tbTeam.stuNumber}</dd>
            <br />
        </dl>
    </div>

    <div class="col-xs-6">
        <dl>
            <dt>班级信息：</dt>
            <dd>${tbTeam.teamNote}</dd>
            <br />

        </dl>
    </div>
</div>