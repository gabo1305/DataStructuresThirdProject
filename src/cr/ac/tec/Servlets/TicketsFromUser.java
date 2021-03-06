package cr.ac.tec.Servlets;

import cr.ac.tec.FileProccessing.JsonExchange;
import cr.ac.tec.Rail.Purchase.Ticket;
import cr.ac.tec.Rail.RequestManager.RequestManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 */
@WebServlet(value = "ConsultFromUser")
public class TicketsFromUser extends HttpServlet {
    private final String UserNameParameter="UserName";
    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String UserName=req.getParameter(UserNameParameter);
        RequestManager requestManager=RequestManager.getInstance();
        ArrayList<Ticket> List=requestManager.getTicketsByUser(UserName);
        resp.getWriter().print(JsonExchange.getStringFromObject(List));
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
