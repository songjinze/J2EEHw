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
<form method="post" action="${pageContext.request.contextPath}/signup">
    <p>username:<label>
        <input type="text" name="uname" />
    </label></p>
    <p>password:<label>
        <input type="text" name="password"/>
    </label></p>
    <p>confirm password:<label>
        <input type="text" name="confirmPasswd" />
    </label></p>
    <input type="submit" value="submit"/>
</form>
</body>
</html>
