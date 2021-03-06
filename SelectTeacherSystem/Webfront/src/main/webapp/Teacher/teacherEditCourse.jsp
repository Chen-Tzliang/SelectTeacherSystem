<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/22
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <title>毕业生选课管理系统|学生模块</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Fonts -->
    <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:300,400' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Lato:300,400,700,900' rel='stylesheet' type='text/css'>
    <!-- CSS Libs -->
    <link rel="stylesheet" type="text/css" href="/lib/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/lib/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="/lib/css/animate.min.css">
    <link rel="stylesheet" type="text/css" href="/lib/css/bootstrap-switch.min.css">
    <link rel="stylesheet" type="text/css" href="/lib/css/checkbox3.min.css">
    <link rel="stylesheet" type="text/css" href="/lib/css/jquery.dataTables.min.css">
    <link rel="stylesheet" type="text/css" href="/lib/css/dataTables.bootstrap.css">
    <link rel="stylesheet" type="text/css" href="/lib/css/select2.min.css">
    <!-- CSS App -->
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <link rel="stylesheet" type="text/css" href="/css/themes/flat-blue.css">
</head>

<body class="flat-blue">
<div class="app-container">
    <div class="row content-container">
        <nav class="navbar navbar-default navbar-fixed-top navbar-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-expand-toggle">
                        <i class="fa fa-bars icon"></i>
                    </button>
                    <ol class="breadcrumb navbar-breadcrumb">
                        <li class="active">课题信息</li>
                        <li >添加课题</li>
                    </ol>
                    <button type="button" class="navbar-right-expand-toggle pull-right visible-xs">
                        <i class="fa fa-th icon"></i>
                    </button>
                </div>
                <ul class="nav navbar-nav navbar-right">
                    <button type="button" class="navbar-right-expand-toggle pull-right visible-xs">
                        <i class="fa fa-times icon"></i>
                    </button>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-comments-o"></i></a>
                        <ul class="dropdown-menu animated fadeInDown">
                            <li class="title">
                                通知 <span class="badge pull-right">0</span>
                            </li>
                            <li class="message">
                                没有新通知
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown danger">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-star-half-o"></i> 4</a>
                        <ul class="dropdown-menu danger  animated fadeInDown">
                            <li class="title">
                                通知 <span class="badge pull-right">4</span>
                            </li>
                            <li>
                                <ul class="list-group notifications">
                                    <a href="#">
                                        <li class="list-group-item">
                                            <span class="badge">1</span> <i class="fa fa-exclamation-circle icon"></i> 新通知
                                        </li>
                                    </a>
                                    <a href="#">
                                        <li class="list-group-item">
                                            <span class="badge success">1</span> <i class="fa fa-check icon"></i> 新命令
                                        </li>
                                    </a>
                                    <a href="#">
                                        <li class="list-group-item">
                                            <span class="badge danger">2</span> <i class="fa fa-comments icon"></i> 其他信息
                                        </li>
                                    </a>
                                    <a href="#">
                                        <li class="list-group-item message">
                                            查看所有
                                        </li>
                                    </a>
                                </ul>
                            </li>
                        </ul>
                    </li>
                    <li class="dropdown profile">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><%=session.getAttribute("teacherName")%><span class="caret"></span></a>
                        <ul class="dropdown-menu animated fadeInDown">
                            <li class="profile-img">
                                <img src="/img/profile/picjumbo.com_HNCK4153_resize.jpg" class="profile-img">
                            </li>
                            <li>
                                <div class="profile-info">
                                    <h4 class="username"><%=session.getAttribute("teacherName")%></h4>
                                    <div class="btn-group margin-bottom-2x" role="group">
                                        <button type="button" class="btn btn-default"><i class="fa fa-user"></i> 个人信息</button>
                                        <button type="button" class="btn btn-default"><i class="fa fa-sign-out"></i> 退出</button>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
        <div class="side-menu sidebar-inverse">
            <nav class="navbar navbar-default" role="navigation">
                <div class="side-menu-container">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="#">
                            <div class="icon fa fa-paper-plane"></div>
                            <div class="title">毕业生选题|教师板块</div>
                        </a>
                        <button type="button" class="navbar-expand-toggle pull-right visible-xs">
                            <i class="fa fa-times icon"></i>
                        </button>
                    </div>
                    <ul class="nav navbar-nav">
                        <li class="">
                            <a href="/Teacher/teacherIndex.jsp">
                                <span class="icon fa fa-tachometer"></span><span class="title">首页</span>
                            </a>
                        </li>
                        <li class="  panel panel-default dropdown">
                            <a data-toggle="collapse" href="#dropdown-element">
                                <span class="icon fa fa-desktop"></span><span class="title">个人信息</span>
                            </a>
                            <!-- Dropdown level 1 -->
                            <div id="dropdown-element" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <ul class="nav navbar-nav">
                                        <li><a href="/Teacher/teacherListTeacher/<%=session.getAttribute("teacherId")%>">查看信息</a>
                                        </li>
                                        <li><a href="/Teacher/teacherEditTeacher/<%=session.getAttribute("teacherId")%>/">编辑信息</a>
                                        </li>
                                        <li><a href="/Teacher/teacherEditPassword/<%=session.getAttribute("teacherId")%>">修改密码</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </li>

                        <!-- Dropdown level 1 -->
                        <li class="active panel panel-default dropdown">
                            <a data-toggle="collapse" href="#dropdown-form">
                                <span class="icon fa fa-file-text-o"></span><span class="title">课题信息</span>
                            </a>
                            <!-- Dropdown level 1 -->
                            <div id="dropdown-form" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <ul class="nav navbar-nav">
                                        <li><a href="/Teacher/teacherListCourse/<%=session.getAttribute("teacherId")%>">浏览课题</a>
                                        </li>
                                        <li><a href="/Teacher/teacherAddCourse/<%=session.getAttribute("teacherId")%>">添加选题</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </li>

                        <!-- Dropdown-->
                        <li class="panel panel-default dropdown">
                            <a data-toggle="collapse" href="#component-example">
                                <span class="icon fa fa-cubes"></span><span class="title">留言</span>
                            </a>
                            <!-- Dropdown level 1 -->
                            <div id="component-example" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <ul class="nav navbar-nav">
                                        <li><a href="/Message/TeacherListMessage/<%=session.getAttribute("teacherId")%>">查看留言信息</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </li>
                        <!-- Dropdown-->
                        <li class="panel panel-default dropdown">
                            <a data-toggle="collapse" href="#dropdown-example">
                                <span class="icon fa fa-slack"></span><span class="title">选题情况</span>
                            </a>
                            <!-- Dropdown level 1 -->
                            <div id="dropdown-example" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <ul class="nav navbar-nav">
                                        <li><a href="/HaveClass/teacherLookstudent/<%=session.getAttribute("teacherId")%>">查看学生选择情况</a>
                                        </li>
                                        <li><a href="/HaveClass/teacherchoicestudent/<%=session.getAttribute("teacherId")%>/">进行选题操作</a>
                                        </li>
                                        <li><a href="/SelectStudent/LookTeacherSelect/<%=session.getAttribute("teacherId")%>/">查看所选学生</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </li>
                        <!-- Dropdown-->
                        <li class="panel panel-default dropdown">
                            <a data-toggle="collapse" href="#dropdown-icon">
                                <span class="icon fa fa-archive"></span><span class="title">其他登录</span>
                            </a>
                            <!-- Dropdown level 1 -->
                            <div id="dropdown-icon" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <ul class="nav navbar-nav">
                                        <li><a href="/Admin/adminLogin.jsp">管理员登录</a>
                                        </li>
                                        <li><a href="/Teacher/teacherLogin.jsp">教师登录</a>
                                        </li>
                                        <li><a href="/Student/studentLogin.jsp">学生登录</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </li>
                        <li>
                            <a href="/Teacher/teacherLicense.jsp">
                                <span class="icon fa fa-thumbs-o-up"></span><span class="title">使用说明</span>
                            </a>
                        </li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </nav>
        </div>
        <div class="copyrights">Collect from <a href="#" >教师模块</a></div>
        <!-- Main Content -->
        <div class="container-fluid">
            <div class="side-body">
                <div class="page-title">
                    <span class="title">修改课题信息</span>
                    <div class="description">修改课题</div>
                </div>

                <div class="row">
                    <div class="col-xs-12">
                        <div class="card">
                            <div class="card-header">
                                <div class="card-title">
                                    <div class="title">修改课题</div>
                                </div>
                            </div>
                            <div class="card-body">
                                <form class="form-horizontal" action="/Course/updateCourse/<%=session.getAttribute("teacherId")%>" method="post" id="Register" >
                                    <div class="form-group">
                                        <label for="courseName">课题名称</label>
                                        <input type="text" class="form-control" id="courseName" name="courseName" value="${course.courseName}"  placeholder="写入课题的名称...">
                                    </div>
                                    <div class="form-group">
                                        <label for="courseAnalysis">课题可选人数</label>
                                        <input type="text" class="form-control" id="courseAnalysis" name="courseAnalysis"  value="${course.courseAnalysis}">
                                    </div>
                                    <input type="text" hidden name="courseId" value="${course.courseId}">
                                    <div class="sub-title">课题类别 </div>
                                    <div>
                                        <select name="courseSum" id="courseSum">
                                            <optgroup label="课题类别">
                                                <option value="软件开发" <c:if test="${'软件开发'==course.courseSum}">selected</c:if>>软件开发</option>
                                                <option value="硬件开发" <c:if test="${'硬件开发'==course.courseSum}">selected</c:if>>硬件开发</option>
                                                <option value="理论研究" <c:if test="${'理论研究'==course.courseSum}">selected</c:if>>理论研究</option>
                                                <option value="其他"<c:if test="${'其他'==course.courseSum}">selected</c:if>>其他</option>
                                            </optgroup>
                                        </select>
                                    </div>
                                    <div class="sub-title">课题来源 </div>
                                    <div>
                                        <select name="courseApplytime" id="courseApplytime">
                                            <optgroup label="课题来源">
                                                <option value="生产实际" <c:if test="${'生产实际'==course.courseApplytime}">selected</c:if> >生产实际</option>
                                                <option value="科研项目" <c:if test="${'科研项目'==course.courseApplytime}">selected</c:if>  >科研项目</option>
                                                <option value="虚拟课题" <c:if test="${'虚拟课题'==course.courseApplytime}">selected</c:if> >虚拟课题</option>
                                                <option value="实际课题" <c:if test="${'实际课题'==course.courseApplytime}">selected</c:if> >实际课题</option>
                                            </optgroup>
                                        </select>
                                    </div>
                                    <div class="sub-title">课题的详细说明</div>
                                    <div>
                                        <textarea name="courseCol"  class="form-control" rows="3">${course.courseCol}</textarea>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-offset-2 col-sm-10">
                                            <button type="submit" class="btn btn-default" >修改课题</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <footer class="app-footer">
        <div class="wrapper">
            <span class="pull-right">2.1 <a href="#"><i class="fa fa-long-arrow-up"></i></a></span> © 2015 Copyright. More Templates <a href="#" target="_blank" title="模板之家">教师</a> - Collect from <a href="#" title="网页模板" target="_blank">教师</a>
        </div>
    </footer>
    <div>
        <!-- Javascript Libs -->
        <script type="text/javascript" src="/lib/js/jquery.min.js"></script>
        <script type="text/javascript" src="/lib/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="/lib/js/Chart.min.js"></script>
        <script type="text/javascript" src="/lib/js/bootstrap-switch.min.js"></script>
        <script type="text/javascript" src="/lib/js/jquery.matchHeight-min.js"></script>
        <script type="text/javascript" src="/lib/js/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="/lib/js/dataTables.bootstrap.min.js"></script>
        <script type="text/javascript" src="/lib/js/select2.full.min.js"></script>
        <script type="text/javascript" src="/lib/js/ace/ace.js"></script>
        <script type="text/javascript" src="/lib/js/ace/mode-html.js"></script>
        <script type="text/javascript" src="/lib/js/ace/theme-github.js"></script>
        <!-- Javascript -->
        <script type="text/javascript" src="/js/app.js"></script>
        <script type="text/javascript" src="/js/index.js"></script>
</body>

</html>

