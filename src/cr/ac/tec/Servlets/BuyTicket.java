package cr.ac.tec.Servlets;

import cr.ac.tec.FileProccessing.JsonExchange;
import cr.ac.tec.Rail.Purchase.Ticket;
import cr.ac.tec.Rail.RequestManager.RequestManager;
import cr.ac.tec.Rail.Roads.Nodes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 */
@WebServlet(name="ATM",value = "/buy")
public class BuyTicket extends HttpServlet {
    private static final int random=1;
    private static final String UserName="UserName";
    private static final String Start="Start";
    private static final String End="End";
    private static final String Amount="Amount";
    private static final String date="Date";
    private static final int zero=0;

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {


            String Name = req.getParameter(UserName);
            RequestManager requestManager = RequestManager.getInstance();
            String startStop = req.getParameter(Start);
            String endStop = req.getParameter(End);
            String date1 = req.getParameter(date);
            Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(date1);
            System.out.println("La fecha es "+date2);
            System.out.println("Name " + Name);
            System.out.println("Start " + startStop);
            System.out.println("End " + endStop);
            int amount = Integer.parseInt(req.getParameter(Amount));
            ArrayList<Ticket> ArrayListTicket = requestManager.getTicket(Name, startStop, endStop, amount,date2);
            if(ArrayListTicket==null || ArrayListTicket.isEmpty())resp.getWriter().print("There is no route between the selected routes");
            else resp.getWriter().print("The route is "+JsonExchange.getStringFromObject(ArrayListTicket.get(zero).getTrajectory()));
            //resp.sendRedirect("/prueba.html");


        }
        catch (Exception e){}
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
