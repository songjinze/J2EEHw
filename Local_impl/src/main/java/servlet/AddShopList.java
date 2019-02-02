package servlet;

import beans.ProductBean;
import beans.ShoppingCartBean;
import util.ExceptionHandler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/addShopList")
public class AddShopList extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException {
        doPost(request,response);
    }

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     */
    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException {
        RequestDispatcher dispatcher;
        String products=request.getParameter("product");
        HttpSession session=request.getSession(false);
        if(session==null){
            //登录失效返回
            dispatcher=request.getRequestDispatcher("/loginPage");
        }else{
            dispatcher=request.getRequestDispatcher("/products");
            // 添加购物车
            ShoppingCartBean shoppingCartBean=(ShoppingCartBean)session.getAttribute("shoppingCart");
            if(shoppingCartBean==null){
                shoppingCartBean=new ShoppingCartBean();
            }
            if(shoppingCartBean.getProductNames().contains(products)){
                int index=shoppingCartBean.getProductNames().indexOf(products);
                Integer i=shoppingCartBean.getProductNums().get(index);
                i++;
                shoppingCartBean.getProductNums().set(index,i);
            }else{
                shoppingCartBean.getProductNames().add(products);
                shoppingCartBean.getProductNums().add(1);
            }
            session.setAttribute("shoppingCart",shoppingCartBean);
        }
        try {
            dispatcher.forward(request,response);
        } catch (IOException e) {
            ExceptionHandler.handleException(e);
        }
    }
}
