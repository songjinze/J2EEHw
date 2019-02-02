<%@ page import="listener.SessionListener" %><%--
  Created by IntelliJ IDEA.
  User: jinze
  Date: 2019/1/7
  Time: 0:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>userPage</title>
</head>
<body>
<p>
    当前在线用户数：<%=SessionListener.getSessionNumber()%>
</p>
</body>
</html>
