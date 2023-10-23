package ma.yc.airafraik.web;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.yc.airafraik.service.ReservationService;
import ma.yc.airafraik.service.impl.ReservationServiceImpl;

import java.io.IOException;

@WebServlet(name = "annulerReservationController", urlPatterns = "/annulerReservation")
public class AnnulerReservationController extends HttpServlet {
    private ReservationService reservationService ;
    @Override
    public void init() throws ServletException {
        this.reservationService = new ReservationServiceImpl();
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("annuler-reservation.jsp").forward(req, resp);
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String numeroReservation = req.getParameter("reservationNumber");
        boolean isCannled  = this.reservationService.annulationReservation(numeroReservation);
        req.getRequestDispatcher("thank-you.jsp").forward(req, resp);
    }
}
