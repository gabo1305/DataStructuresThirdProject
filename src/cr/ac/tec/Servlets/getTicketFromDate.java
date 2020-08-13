package cr.ac.tec.Servlets;

import cr.ac.tec.FileProccessing.JsonExchange;
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
@WebServlet(value = "consultDate")
public class getTicketFromDate extends HttpServlet {
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

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Date=req.getParameter("Date");
        RequestManager requestManager=RequestManager.getInstance();
       resp.getWriter().print(JsonExchange.getStringFromObject(requestManager.getTicketsFromDate(Date)));
    }
}
