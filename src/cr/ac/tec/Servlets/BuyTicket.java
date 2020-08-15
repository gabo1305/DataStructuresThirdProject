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
    private static final String DateFormat="yyyy-MM-dd";
    private static final String IncorrectMessage="There is no route between the selected routes";
    private static final String CorrectMessage="The route is ";




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
            System.out.println("startStop: "+startStop);
            String endStop = req.getParameter(End);
            System.out.println("endStop"+endStop);
            String date1 = req.getParameter(date);
            Date date2 = new SimpleDateFormat(DateFormat).parse(date1);

            int amount = Integer.parseInt(req.getParameter(Amount));
            ArrayList<Ticket> ArrayListTicket = requestManager.getTicket(Name, startStop, endStop, amount,date2);
            if(ArrayListTicket==null || ArrayListTicket.isEmpty()) {
                resp.getWriter().print(IncorrectMessage);
            }
            else {
                resp.getWriter().print(CorrectMessage+JsonExchange.getStringFromObject(ArrayListTicket.get(zero).getTrajectory()));
            }
        }
        catch (Exception e){
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
