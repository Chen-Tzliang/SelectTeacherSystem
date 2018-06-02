<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/13
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/Admin/login" method="post" >
    管理员姓名：<input type="text" id="adminName" name="adminName"/><br>
    管理员密码：<input type="password" id="adminPassword" name="adminPassword"/><br>
    <input type="submit" value="提交" id="login" /><a href="Admin/update.jsp">增加管理员</a>
</form>
</body>
</html>