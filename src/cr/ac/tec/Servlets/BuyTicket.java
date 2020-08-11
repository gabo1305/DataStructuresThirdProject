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
import java.util.ArrayList;

@WebServlet(name="ATM",value = "/buy")
public class BuyTicket extends HttpServlet {
    private static final int random=1;
    private static final String UserName="UserName";
    private static final String Start="Start";
    private static final String End="End";
    private static final String Amount="Amount";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Name=req.getParameter(UserName);
        RequestManager requestManager=RequestManager.getInstance();
        String startStop=req.getParameter(Start);
        String endStop=req.getParameter(End);
        int amount=Integer.parseInt(req.getParameter(Amount));
        ArrayList<Ticket> ArrayListTicket= requestManager.getTicket(Name,startStop,endStop,amount);
        PrintWriter printWriter=resp.getWriter();
        if(ArrayListTicket==null)printWriter.print("null");
        else printWriter.print(JsonExchange.getStringFromObject(ArrayListTicket));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
