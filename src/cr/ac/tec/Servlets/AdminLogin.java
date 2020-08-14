package cr.ac.tec.Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 */
@WebServlet("/Adminlog")
public class AdminLogin extends HttpServlet {
    private final String username="adminUsername";
    private final String password="adminPassword";
    private final String AdminPassword="admin";
    private final String AdminPassword2="user";
    private final String AdminRoute="Admin.jsp";
    private final String AdminLoginRoute="AdminLogin.jsp";

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String UserName=req.getParameter(username);
        String Password=req.getParameter(password);
        if((UserName.equals(AdminPassword) && Password.equals(AdminPassword))||(UserName.equals(AdminPassword2) && Password.equals(AdminPassword2))){
            resp.sendRedirect(AdminRoute);
        }
        else{
            resp.sendRedirect(AdminLoginRoute);
        }
    }

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
