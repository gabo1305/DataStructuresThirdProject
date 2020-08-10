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
        System.out.println("Esto es Start: " +Start);
        String End=req.getParameter("End");
        System.out.println("Esto es End: " +End);
        RequestManager requestManager=RequestManager.getInstance();
        double price=requestManager.getPrice("0","1");
        resp.getWriter().print(price);
        System.out.println("El precio es: "+price);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
