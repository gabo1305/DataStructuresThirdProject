package cr.ac.tec.Servlets;

import cr.ac.tec.Rail.RequestManager.RequestManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(value = "/newRoute")
public class AddRoute extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Init=req.getParameter("Initial");
        String Final=req.getParameter("Final");
        String distance=req.getParameter("Distance");
        int Distance=Integer.parseInt(distance);
        RequestManager requestManager=RequestManager.getInstance();
        boolean value=requestManager.addRelationShip(Init,Final,Distance);
        //resp.sendRedirect("/Admin.jsp");
        if(value)resp.getWriter().print("Route added");
        else resp.getWriter().print("The route already exists");

    }
}
