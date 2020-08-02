package cr.ac.tec.Classes;

import cr.ac.tec.FileProccessing.PlainText;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileWriter;
import java.io.IOException;

@WebServlet(value = "/algo",name = "lol")
public class xd extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text = "{\n" +
                "  \"nodes\": [\n" +
                "    {\n" +
                "      \"id\": \"nHeredia\",\n" +
                "      \"label\": \"Heredia\",\n" +
                "      \"x\": 5,\n" +
                "      \"y\": 0,\n" +
                "      \"size\": 3\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"nSanJose\",\n" +
                "      \"label\": \"San Jose\",\n" +
                "      \"x\": 1,\n" +
                "      \"y\": 15,\n" +
                "      \"size\": 3\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"nCartago\",\n" +
                "      \"label\": \"Cartago\",\n" +
                "      \"x\": 8,\n" +
                "      \"y\": 13,\n" +
                "      \"size\": 3\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"nGuarco\",\n" +
                "      \"label\": \"Guarco\",\n" +
                "      \"x\": 7,\n" +
                "      \"y\": 14,\n" +
                "      \"size\": 3\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"nPuntarenas\",\n" +
                "      \"label\": \"Puntarenas\",\n" +
                "      \"x\": 2,\n" +
                "      \"y\": 14,\n" +
                "      \"size\": 3\n" +
                "    }\n" +
                "  ],\n" +
                "  \"edges\": [\n" +
                "    {\n" +
                "      \"id\": \"e0\",\n" +
                "      \"source\": \"nHeredia\",\n" +
                "      \"target\": \"nSanJose\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"e1\",\n" +
                "      \"source\": \"nSanJose\",\n" +
                "      \"target\": \"nCartago\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"e2\",\n" +
                "      \"source\": \"nCartago\",\n" +
                "      \"target\": \"nHeredia\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"e3\",\n" +
                "      \"source\": \"nCartago\",\n" +
                "      \"target\": \"nGuarco\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";
        PlainText.writeFile("C:\\Users\\migue\\DataStructuresThirdProyect\\web\\estaciones.json",text);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}