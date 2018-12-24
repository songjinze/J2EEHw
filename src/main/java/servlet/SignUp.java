package servlet;

import dao.DaoFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class SignUp extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse rep){
        RequestDispatcher dispatcher;
        String username=req.getParameter("uname");
        String password=req.getParameter("password");
        String confirmPasswd=req.getParameter("confrimPasswd");
        if(!password.equals(confirmPasswd)){
            dispatcher=req.getRequestDispatcher("/error/errorpage");
        }
        DaoFactory.getUserDaoService().signUpOneUser(username,password);
        dispatcher=req.getRequestDispatcher("/products");

    }
}
