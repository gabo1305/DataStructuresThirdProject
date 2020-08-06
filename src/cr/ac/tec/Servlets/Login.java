package cr.ac.tec.Servlets;

import cr.ac.tec.Rail.Accounts.User;
import cr.ac.tec.SavedInfo.UsersTree;
import cr.ac.tec.Verification.UserVerification;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Console;
import java.io.IOException;
@WebServlet(name = "LoginServlet",value = "/log")
public class Login extends HttpServlet {
    private final String name="UserName";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userID=req.getParameter(name);
        if(!UserVerification.ced(userID)){
            resp.sendRedirect("login.jsp");
            return;
        }

        User user=new User(userID);
        UsersTree tree=UsersTree.getInstance();
        tree.attach(user);
        user=tree.getMember(user);
        resp.getWriter().print(user.getID());
        resp.sendRedirect("prueba.html");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
