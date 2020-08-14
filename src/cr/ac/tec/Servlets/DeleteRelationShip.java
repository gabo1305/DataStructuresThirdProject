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
    private static final String Estacion="Estaciones";
    private static final String Parada="Paradas";
    private static final String CorrectMessage="The route hasn't been deleted";
    private static final String IncorrectMessage ="The route has been deleted";

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String start=req.getParameter(Estacion);
        String end=req.getParameter(Parada);
        RequestManager requestManager=RequestManager.getInstance();
        if(!requestManager.deleteRelationShip(start,end))resp.getWriter().print(CorrectMessage);
        else resp.getWriter().print(IncorrectMessage);
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
