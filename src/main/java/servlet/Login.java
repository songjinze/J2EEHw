package servlet;

import dao.DaoFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class Login extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        String username=(String)req.getAttribute("uname");
        String password=(String)req.getAttribute("passwd");
        if(DaoFactory.getUserDaoService().hasUser(username)){
            if(DaoFactory.getUserDaoService().isCorrectPassword(username,password)) {
                dispatcher = req.getRequestDispatcher("/goods");
            }else{
                dispatcher=req.getRequestDispatcher("/error/errorpage");
            }
        }else{
            dispatcher=req.getRequestDispatcher("/error/errorpage");
        }
        dispatcher.forward(req, resp);
    }
}
