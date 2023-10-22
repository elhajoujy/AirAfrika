package ma.yc.airafraik.web;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ma.yc.airafraik.core.Print;
import ma.yc.airafraik.entities.ClientEntity;
import ma.yc.airafraik.entities.ReservationEntity;
import ma.yc.airafraik.entities.VolEntity;
import ma.yc.airafraik.enums.ReservationStatus;
import ma.yc.airafraik.service.ReservationService;
import ma.yc.airafraik.service.SearchVolsService;
import ma.yc.airafraik.service.impl.ReservationServiceImpl;
import ma.yc.airafraik.service.impl.SearchVolsServiceImpl;
import org.hibernate.Session;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Collection;

@WebServlet(name = "RservationConfirmationController", value = "/reservation-confirmation")
public class RservationConfirmationController extends HttpServlet {

    private SearchVolsService searchVolsService ;
    private ReservationService reservationService;
    private HttpSession session;
    private ServletContext context;
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.searchVolsService = new SearchVolsServiceImpl();
        this.context = config.getServletContext();
        this.reservationService = new ReservationServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(); // Get the session associated with the request

        String id = req.getParameter("id");
        Double prixTotal = Double.parseDouble(req.getParameter("prixTotal"));

        if (id != null) {
            Print.log("id : " + id);
            VolEntity vols = searchVolsService.searchVolParId(id);
            req.setAttribute("vols",vols);
//            reservationEntity.setVolEntities((Collection<VolEntity>) req.getSession().getAttribute("vols"));
//            reservationEntity.setPrixTotal((Double) req.getSession().getAttribute("prixTotal"));
//            reservationEntity.setDate_Reservation(new Timestamp(System.currentTimeMillis()));
//            reservationEntity.setNumberDeAdulets((Integer) req.getSession().getAttribute("numberDeAdulets"));
//            reservationEntity.setNumberDeEnfants((Integer) req.getSession().getAttribute("numberDeEnfants"));
//            reservationEntity.setNumberDeBebes((Integer) req.getSession().getAttribute("numberDeBebe"));

            session.setAttribute("vols", vols);
            prixTotal = vols.getPrix() * (Integer) session.getAttribute("numberDeAdultes") + vols.getPrix() * (Integer) session.getAttribute("numberDeEnfants") + vols.getPrix() * (Integer) session.getAttribute("numberDeBebes");
            session.setAttribute("prixTotal", prixTotal);


            req.getRequestDispatcher("reservation-confirmation.jsp").forward(req, resp);

        }else{
            resp.sendRedirect("/");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get the values from the form


        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        String adresse = req.getParameter("adresse");
        String email = req.getParameter("email");
        String telephone = req.getParameter("telephone");

        //TODO : CALL THE SERVICE TO SAVE THE RESERVATION

        ClientEntity client = new ClientEntity();
        client.setNom(nom);
        client.setPrenom(prenom);
        client.setAdresse(adresse);
        client.setEmail(email);
        client.setTelephone(telephone);

        ReservationEntity reservationEntity = new ReservationEntity();
        reservationEntity.setClient(client);
        VolEntity vol = (VolEntity) req.getSession().getAttribute("vol");
        reservationEntity.setStatus(ReservationStatus.EN_ATTENTE);
        reservationEntity.getVolEntities().add(vol);
        double prixTotal = vol.getPrix() * (Integer) context.getAttribute("numberDeAdultes")
                + vol.getPrix() * (Integer) context.getAttribute("numberDeEnfants")
                + vol.getPrix() * (Integer) context.getAttribute("numberDeBebes");
        reservationEntity.setPrixTotal(prixTotal);
        reservationEntity.setDate_Reservation(new Timestamp(System.currentTimeMillis()));
        reservationEntity.setNumberDeAdulets(((Integer) context.getAttribute("numberDeAdultes")));
        reservationEntity.setNumberDeEnfants((Integer) context.getAttribute("numberDeEnfants"));
        reservationEntity.setNumberDeBebes((Integer) context.getAttribute("numberDeBebes"));



        this.reservationService.confirmationReservation(reservationEntity);


        resp.sendRedirect("/thank-you.jsp");

    }

}

