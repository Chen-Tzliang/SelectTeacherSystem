<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>天力学院毕业设计选题管理系统</title>

    <!-- CSS -->
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
    <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assets/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="/assets/css/form-elements.css">
    <link rel="stylesheet" href="/assets/css/style.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Favicon and touch icons -->
    <link rel="shortcut icon" href="/assets/ico/favicon.png">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="/assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="/assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="/assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="/assets/ico/apple-touch-icon-57-precomposed.png">

</head>

<body>

<!-- Top content -->
<div class="top-content">

    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text">
                    <h1><strong>天力学院毕业设计选题管理系统</strong></h1>
                    <div class="description">
                        <p>
                            管理员登录模块
                        </p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">
                    <div class="form-top">
                        <div class="form-top-left">
                            <h3>登录你的账号</h3>
                            <p>请输入你的管理员姓名以及密码：</p>
                        </div>
                        <div class="form-top-right">
                            <i class="fa fa-key"></i>
                        </div>
                    </div>
                    <div class="form-bottom">
                        <form role="form" action="/Admin/login" method="post" class="login-form">
                            <div class="form-group">
                                <label class="sr-only" for="adminName">姓名</label>
                                <input type="text" name="adminName" placeholder="姓名..." class="form-username form-control" id="adminName">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="adminPassword">密码</label>
                                <input type="password" name="adminPassword" placeholder="密码..." class="form-password form-control" id="adminPassword">
                            </div>
                            <button type="submit" class="btn">登录</button>
                        </form>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 social-login">
                    <h3>其他登录方式：</h3>
                    <div class="social-login-buttons">
                        <a class="btn btn-link-1 btn-link-1-facebook" href="/Admin/adminLogin.jsp">
                            <i class="fa fa-facebook"></i> 管理员
                        </a>
                        <a class="btn btn-link-1 btn-link-1-twitter" href="/Teacher/teacherLogin.jsp">
                            <i class="fa fa-twitter"></i> 教师
                        </a>
                        <a class="btn btn-link-1 btn-link-1-google-plus" href="/Student/studentLogin.jsp">
                            <i class="fa fa-google-plus"></i> 学生
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<!-- Javascript -->
<script src="/assets/js/jquery-1.11.1.min.js"></script>
<script src="/assets/bootstrap/js/bootstrap.min.js"></script>
<script src="/assets/js/jquery.backstretch.min.js"></script>
<script src="/assets/js/scripts.js"></script>

<!--[if lt IE 10]>
    <script src="/assets/js/placeholder.js"></script>
<![endif]-->

</body>

</html>