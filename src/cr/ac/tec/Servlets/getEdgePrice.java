package cr.ac.tec.Servlets;

import cr.ac.tec.Rail.RequestManager.RequestManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/EdgesPrice")
public class getEdgePrice extends HttpServlet {
    private static final String From="From";
    private static final String To="To";
    private static final String Incorrect="There is no edge between the select nodes";
    private static final String Message="The price is ";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Start=req.getParameter(From);
        String End=req.getParameter(To);
        double price= RequestManager.getInstance().getEdgePrice(Start,End);
        if(price==Integer.MAX_VALUE)resp.getWriter().print(Incorrect);
        else resp.getWriter().print(Message+price);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
