<%--
  Created by IntelliJ IDEA.
  User: 73460
  Date: 2018/12/24
  Time: 16:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>signUp</title>
</head>
<body>
<form method="post" action="/signup">
    <p>username:<input type="text" name="uname" /></p>
    <p>password:<input type="text" name="password"/></p>
    <p>confirm password:<input type="text" name="confirmPasswd" /></p>
    <input type="submit" value="submit"/>
</form>
</body>
</html>
