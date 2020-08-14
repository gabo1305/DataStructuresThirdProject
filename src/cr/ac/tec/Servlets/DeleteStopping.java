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
@WebServlet(value = "/deleteNode")
public class DeleteStopping extends HttpServlet {
    private static final String NodeID="NodeID";
    private static final String CorrectMessage="The node has been deleted";
    private static final String IncorrectMessage="We couldn't delete the stopping";

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
        String Node=req.getParameter(NodeID);
        RequestManager requestManager=RequestManager.getInstance();
        if(!requestManager.deleteNode(Node))resp.getWriter().print(IncorrectMessage);
        else resp.getWriter().print(CorrectMessage);
    }
}
