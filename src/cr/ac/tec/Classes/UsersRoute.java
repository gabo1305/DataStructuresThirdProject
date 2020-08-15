package cr.ac.tec.Classes;


import cr.ac.tec.FileProccessing.PlainText;
import cr.ac.tec.Rail.RequestManager.RequestManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/usersRoute")

public class UsersRoute extends HttpServlet {
    private final String UsersRoute="C:\\Tecnologico de Costa Rica\\Tercer Semestre\\Algoritmos y estructuras\\RailSpot\\JsonFiles\\Users.json";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestManager.getInstance().updateGraphFileRep();
        resp.getWriter().print(PlainText.readFile(UsersRoute));
    }
}
