package cr.ac.tec.Servlets;

import cr.ac.tec.Rail.RequestManager.RequestManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/newRoute")
public class AddRoute extends HttpServlet {
    private final String StartPoint="Initial";
    private final String FinalPoint="Final";
    private final String Distance="Distance";
    private final String messageCorrect="Route added";
    private final String messageInCorrect="The route already exists";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String Init=req.getParameter(StartPoint);
        String Final=req.getParameter(FinalPoint);
        String distance=req.getParameter(Distance);
        int Distance=Integer.parseInt(distance);
        RequestManager requestManager=RequestManager.getInstance();
        boolean value=requestManager.addRelationShip(Init,Final,Distance);

        if(value)resp.getWriter().print(messageCorrect);
        else resp.getWriter().print(messageInCorrect);

    }
}
