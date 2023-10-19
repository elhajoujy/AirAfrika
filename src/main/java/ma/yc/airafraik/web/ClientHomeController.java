package ma.yc.airafraik.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.yc.airafraik.service.PaiementService;
import ma.yc.airafraik.service.impl.PaypalPaiementServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "clientHomeServlet", value = "/home")
public class ClientHomeController extends HttpServlet {




    public ClientHomeController() {
    }

    public ClientHomeController(String message, PaiementService paiementService) {
        this.message = message;
        this.paiementService = paiementService;
    }

    private String message;
    PaiementService paiementService ;
    @Override
    public void init() {
        message = "Home client ! Air Afraik";
        paiementService = new PaypalPaiementServiceImpl();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
