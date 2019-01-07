<%@ page import="beans.ProductBean" %>
<%@ page import="dao.DaoFactory" %>
<%@ page import="dao.ProductDaoService" %>
<%@ page import="java.util.List" %>
<%@ page import="beans.ShoppingCartBean" %>
<%--
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
<table>
    <tr>
        <th>商品名称</th>
        <th>商品数量</th>
    </tr>
    <%
        ShoppingCartBean shoppingCartBean=(ShoppingCartBean) session.getAttribute("shoppingCart");
        if(shoppingCartBean!=null){
            int count=0;
            int productNum=0;
            List<Integer> productNums=shoppingCartBean.getProductNums();
            for(String productName:shoppingCartBean.getProductNames()){
                productNum=productNums.get(count);
                out.print("<tr>");
                out.print("<td>"+productName+"</td>");
                out.print("<td>"+productNum+"</td>");
                out.print("</tr>");
                count++;
            }
        }
    %>
</table>
<form action="${pageContext.request.contextPath}/addShopList" method="post">
    <p>添加商品名称：<label>
        <input type="text" name="product"/>
    </label></p>
    <input type="submit"/>
</form>
</body>
</html>
