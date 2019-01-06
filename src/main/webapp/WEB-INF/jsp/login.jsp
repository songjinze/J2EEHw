<%--
  Created by IntelliJ IDEA.
  User: 73460
  Date: 2018/12/24
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
<h2>Welcome!</h2>
<form method="post" action="${pageContext.request.contextPath}/login">
    <p>Username:<label>
        <input type="text" name="uname" />
    </label></p>
    <p>Password:<label>
        <input type="text" name="passwd" />
    </label></p>
    <input type="submit" name="login" />
</form>
</body>
</html>
