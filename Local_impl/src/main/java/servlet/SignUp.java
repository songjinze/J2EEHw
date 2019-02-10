package servlet;

import service.ServiceFactory;
import util.ExceptionHandler;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signup")
public class SignUp extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException {
        doPost(request,response);
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse rep) throws ServletException {
        RequestDispatcher dispatcher;
        String username=req.getParameter("uname");
        String password=req.getParameter("password");
        String confirmPasswd=req.getParameter("confrimPasswd");
        if(!password.equals(confirmPasswd)){
            dispatcher=req.getRequestDispatcher("/error/errorpage");
        }
        boolean result= ServiceFactory.getUserBusinessService().signUpOneUser(username,password);
        if(result) {
            dispatcher = req.getRequestDispatcher("/login");
        }else{
            dispatcher=req.getRequestDispatcher("/error/errorpage");
        }
        try {
            dispatcher.forward(req,rep);
        } catch (IOException e) {
            ExceptionHandler.handleException(e);
        }
    }
}
