<%@ page import="dao.ProductDaoService" %>
<%@ page import="dao.DaoFactory" %>
<%@ page import="beans.ProductBean" %>
<%@ page import="java.util.*" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: 73460
  Date: 2018/12/23
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>goods</title>
    <%
        ProductDaoService productDaoService= DaoFactory.getProductDaoService();
        List<ProductBean> productBeanList=productDaoService.getProducts("");
    %>
</head>
<body>
<table>
    <tr>
        <%
            out.print("<th>Name</th>");
            out.print("<th>Price</th>");
        %>
    </tr>
    <%
        for(ProductBean productBean:productBeanList){
            out.print("<tr>");
            out.print("<td>"+productBean.getPname()+"</td>");
            out.print("<td>"+productBean.getPrice()+"</td>");
            out.print("</tr>");
        }
    %>
</table>
</body>
</html>
