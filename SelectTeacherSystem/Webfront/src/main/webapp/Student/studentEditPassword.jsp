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
                        <li class="active">个人信息</li>
                        <li >修改密码</li>
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
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><%=session.getAttribute("studentName")%><span class="caret"></span></a>
                        <ul class="dropdown-menu animated fadeInDown">
                            <li class="profile-img">
                                <img src="/img/profile/picjumbo.com_HNCK4153_resize.jpg" class="profile-img">
                            </li>
                            <li>
                                <div class="profile-info">
                                    <h4 class="username"><%=session.getAttribute("studentName")%></h4>
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
                            <div class="title">毕业生选题|学生板块</div>
                        </a>
                        <button type="button" class="navbar-expand-toggle pull-right visible-xs">
                            <i class="fa fa-times icon"></i>
                        </button>
                    </div>
                    <ul class="nav navbar-nav">
                        <li class="">
                            <a href="/Student/studentIndex.jsp">
                                <span class="icon fa fa-tachometer"></span><span class="title">首页</span>
                            </a>
                        </li>
                        <li class=" active panel panel-default dropdown">
                            <a data-toggle="collapse" href="#dropdown-element">
                                <span class="icon fa fa-desktop"></span><span class="title">个人信息</span>
                            </a>
                            <!-- Dropdown level 1 -->
                            <div id="dropdown-element" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <ul class="nav navbar-nav">
                                        <li><a href="/Student/studentListStudent/<%=session.getAttribute("studentId")%>">查看信息</a>
                                        </li>
                                        <li><a href="/Student/studentEditStudent/<%=session.getAttribute("studentId")%>/">编辑信息</a>
                                        </li>
                                        <li><a href="/Student/studentEditPassword/<%=session.getAttribute("studentId")%>/">修改密码</a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </li>
                        <!-- Dropdown level 1 -->
                        <li class=" panel panel-default dropdown">
                            <a data-toggle="collapse" href="#dropdown-form">
                                <span class="icon fa fa-file-text-o"></span><span class="title">课题信息</span>
                            </a>
                            <!-- Dropdown level 1 -->
                            <div id="dropdown-form" class="panel-collapse collapse">
                                <div class="panel-body">
                                    <ul class="nav navbar-nav">
                                        <li><a href="/Course/studentListCourse/<%=session.getAttribute("studentId")%>">课题浏览</a>
                                        </li>
                                        <li><a href="/Course/studentCourseSelect/<%=session.getAttribute("studentId")%>">进入选题</a>
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
                                        <li><a href="/Message/ListCourse/<%=session.getAttribute("studentId")%>">进行留言</a>
                                        </li>
                                        <li><a href="/Message/ListMessage/<%=session.getAttribute("studentId")%>">查看留言</a>
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
                                        <li><a href="/Student/studentCourseSelectLook/<%=session.getAttribute("studentId")%>">查看选择的课题</a>
                                        </li>
                                        <li><a href="/SelectStudent/ListTeacher/<%=session.getAttribute("studentId")%>">查看选题结果</a>
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
                            <a href="/Student/studentLicense.jsp">
                                <span class="icon fa fa-thumbs-o-up"></span><span class="title">使用说明</span>
                            </a>
                        </li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </nav>
        </div>
        <div class="copyrights">Collect from <a href="#" >学生模块</a></div>
        <!-- Main Content -->
        <div class="container-fluid">
            <div class="side-body">
                <div class="page-title">
                    <span class="title">学生信息修改</span>
                    <div class="description">下面是学生的信息，你可以通过键入来修改,修改失败返回首页！</div>
                </div>
                <div class="row">
                    <div class="col-xs-12">
                        <div class="card">
                            <div class="card-header">
                                <div class="card-title">
                                    <div class="title">学生信息</div>
                                </div>
                            </div>
                            <div class="card-body">
                                <form class="form-horizontal" action="/Student/studentUpdateStudentPassword/${student.studentId}" method="post">
                                    <div class="sub-title">学号</div>
                                    <div>
                                        <input type="text" class="form-control" disabled id="studentId" name="studentId" value="${student.studentId}" >
                                    </div>
                                    <div class="sub-title">姓名</div>
                                    <div>
                                        <input type="text" class="form-control"id="studentName" name="studentName" value="${student.studentName}" >
                                    </div>
                                    <div class="sub-title">密码</div>
                                    <div>
                                        <input type="text" class="form-control"id="studentPassword" name="studentPassword" value="${student.studentPassword}" >
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-offset-2 col-sm-10">
                                            <button type="submit" class="btn btn-default" >修改</button>
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

