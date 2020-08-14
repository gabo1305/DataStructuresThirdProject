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
@WebServlet(value = "/getPrice")
public class GetPrice extends HttpServlet {
    private static final String StartPoint="Start";
    private static final String EndPoint="End";
    private static final String Amounttickets="Amount";
    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Start=req.getParameter(StartPoint);
        String End=req.getParameter(EndPoint);
        String Amount=req.getParameter(Amounttickets);
        int ticketNumber=Integer.parseInt(Amount);
        RequestManager requestManager=RequestManager.getInstance();
        double price=requestManager.getPrice(Start,End);
        System.out.println(Start+End +"fefggeg");
     if(price==Integer.MAX_VALUE){
            resp.getWriter().print("There route is not available or you did not select a station");
            return;
        }
        double saved=price;
        price=ticketNumber*price;
        if(ticketNumber>45)ticketNumber=45;
        double discount=saved*0.02*(ticketNumber-1);
        price-=discount;
        resp.getWriter().print(price);
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
