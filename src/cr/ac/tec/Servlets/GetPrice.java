package cr.ac.tec.Servlets;

import cr.ac.tec.Rail.RequestManager.RequestManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/getPrice")
public class GetPrice extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Start=req.getParameter("Start");
        String End=req.getParameter("End");
        String Amount=req.getParameter("Amount");
        System.out.println(Amount);
        int ticketNumber=Integer.parseInt(Amount);
        RequestManager requestManager=RequestManager.getInstance();
        double price=requestManager.getPrice(Start,End);
        double saved=price;
        price=ticketNumber*price;
        if(ticketNumber>45)ticketNumber=45;
        double discount=saved*0.02*(ticketNumber-1);
        price-=discount;
        resp.getWriter().print(price);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
