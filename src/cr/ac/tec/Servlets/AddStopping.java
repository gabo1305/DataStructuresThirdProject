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
@WebServlet(name = "AddStopping",value = "/addStopping")
public class AddStopping extends HttpServlet {
    private final static String StopName="StopName";
    private final static String XPos="XAxis";
    private final static String YPos="YAxis";

    /**
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter(StopName);
        String posX=req.getParameter(XPos);
        String posY=req.getParameter(YPos);
        if(RequestManager.getInstance().addNode(name,posX,posY))resp.getWriter().print("The node has been added");
        else resp.getWriter().print("The node already exist");
        //resp.sendRedirect("/Admin.jsp");
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
