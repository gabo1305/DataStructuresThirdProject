package cr.ac.tec.Servlets;

import cr.ac.tec.Rail.RequestManager.RequestManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 */
@WebServlet(value = "/deleteRoute")
public class DeleteRelationShip extends HttpServlet {
    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String start=req.getParameter("Estaciones");
        String end=req.getParameter("Paradas");
        RequestManager requestManager=RequestManager.getInstance();
        if(!requestManager.deleteRelationShip(start,end))resp.getWriter().print("The route hasn't been deleted");
        else resp.getWriter().print("The route has been deleted");
        //resp.sendRedirect("/Admin.jsp");
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
