<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel" style="height: 40px">

            <div class="pull-left info" >
                <p> ${user.username}</p>

            </div>
        </div>

        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu" data-widget="tree">
            <li class="treeview">
                <a href="/main">
                    <i class="fa fa-home"></i> <span>首页</span>
                    <span class="pull-right-container">
              </span>
                </a>
            </li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-users"></i> <span>学生</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/team/list"><i class="fa fa-circle-o"></i> 班级管理</a></li>
                    <li><a href="#"><i class="fa fa-circle-o"></i> 学生管理</a></li>
                </ul>
            </li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-male"></i> <span>职工</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="/worker/list"><i class="fa fa-circle-o"></i> 职工管理</a></li>
                </ul>
            </li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-money"></i> <span>学费</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="#"><i class="fa fa-circle-o"></i> 学费设置</a></li>
                    <li><a href="#"><i class="fa fa-circle-o"></i> 收费历史</a></li>
                    <li><a href="#"><i class="fa fa-circle-o"></i> 学费统计</a></li>
                </ul>
            </li>
            <li class="treeview">
                <a href="#">
                    <i class="fa fa-book"></i> <span>费用支出</span>
                    <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
                </a>
                <ul class="treeview-menu">
                    <li><a href="#"><i class="fa fa-circle-o"></i> 费用登记审批</a></li>
                    <li><a href="#"><i class="fa fa-circle-o"></i> 费用科目</a></li>
                </ul>
            </li>
        </ul>
    </section>
</aside>