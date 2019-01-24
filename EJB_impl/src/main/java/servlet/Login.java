package servlet;

import dao.DaoFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class Login extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        String username=req.getParameter("uname");
        String password=req.getParameter("passwd");
        if(DaoFactory.getUserDaoService().hasUser(username)){
            if(DaoFactory.getUserDaoService().isCorrectPassword(username,password)) {
                HttpSession session=req.getSession();
                session.setAttribute("uname",req.getAttribute("uname"));
                dispatcher = req.getRequestDispatcher("/products");
            }else{
                dispatcher=req.getRequestDispatcher("/error/errorpage");
            }
        }else{
            dispatcher=req.getRequestDispatcher("/error/errorpage");
        }
        dispatcher.forward(req, resp);
    }
}
