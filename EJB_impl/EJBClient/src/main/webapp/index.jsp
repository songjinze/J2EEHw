<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<h2>Welcome!</h2>
<form action="${pageContext.request.contextPath}/loginPage">
    <input type="submit" value="登录" />
</form>
<form action="${pageContext.request.contextPath}/signupPage">
    <input type="submit" value="注册" />
</form>
</body>
</html>
