package cr.ac.tec.Classes;

import cr.ac.tec.FileProccessing.PlainText;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
import java.io.IOException;

@WebServlet(name = "varas",value = "/cual")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.setContentType("application/json");
        resp.getWriter().print(PlainText.readFile("C:\\Users\\Gabriel Solano\\Documents\\GitHub\\DataStructuresThirdProyect\\web\\estaciones.json"));

    }
}