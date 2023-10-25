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
import ma.yc.airafraik.entities.BagageEntity;
import ma.yc.airafraik.entities.ClientEntity;
import ma.yc.airafraik.entities.ReservationEntity;
import ma.yc.airafraik.entities.VolEntity;
import ma.yc.airafraik.enums.ReservationStatus;
import ma.yc.airafraik.service.BagageService;
import ma.yc.airafraik.service.ReservationService;
import ma.yc.airafraik.service.VolsService;
import ma.yc.airafraik.service.impl.BagageServiceImpl;
import ma.yc.airafraik.service.impl.ReservationServiceImpl;
import ma.yc.airafraik.service.impl.VolsServiceImpl;

import java.io.IOException;
import java.sql.Timestamp;

@WebServlet(name = "RservationConfirmationController", value = "/reservation-confirmation")
public class RservationConfirmationController extends HttpServlet {

    private VolsService volsService;
    private ReservationService reservationService;
    private BagageService bagageService;
    private HttpSession session;
    private ServletContext context;
    private String message ;
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.volsService = new VolsServiceImpl();
        this.context = config.getServletContext();
        this.reservationService = new ReservationServiceImpl();
        this.bagageService = new BagageServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(); // Get the session associated with the request

        String id = req.getParameter("id");
        Double prixTotal = Double.parseDouble(req.getParameter("prixTotal"));

        if (id != null) {
            Print.log("id : " + id);
            VolEntity vols = volsService.searchVolParId(id);
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

        // TODO: 25/10/2023 call prix total de la reservation
        double prixTotal = vol.getPrix() * (Integer) context.getAttribute("numberDeAdultes")
                + vol.getPrix() * (Integer) context.getAttribute("numberDeEnfants")
                + vol.getPrix() * (Integer) context.getAttribute("numberDeBebes");

        reservationEntity.setDate_Reservation(new Timestamp(System.currentTimeMillis()));
        reservationEntity.setNumberDeAdulets(((Integer) context.getAttribute("numberDeAdultes")));
        reservationEntity.setNumberDeEnfants((Integer) context.getAttribute("numberDeEnfants"));
        reservationEntity.setNumberDeBebes((Integer) context.getAttribute("numberDeBebes"));


        // TODO: 25/10/2023 BAGAGE
        BagageEntity bagageEntity = new BagageEntity();
        double poids = Double.parseDouble(req.getParameter("poids"));
        double prixPoids = Double.parseDouble(req.getParameter("poids"));
        bagageEntity.setPrix(bagageService.calculerPrixBagage(prixPoids));
        bagageEntity.setPoids(poids);

        reservationEntity.setPrixTotal(prixTotal + bagageEntity.getPrix());

       Double prixtotal =  this.reservationService.confirmationReservation(reservationEntity);

       if (prixtotal == 0){
           resp.sendRedirect("/sorry-try-again.jsp");
       }

        req.setAttribute("client",client);
        req.setAttribute("reservation",reservationEntity);
        req.setAttribute("prixTotal",prixtotal);
        req.setAttribute("bagage",bagageEntity);

        req.getRequestDispatcher("thank-you.jsp").forward(req, resp);
        //TODO : DISTROY THE SESSION
        session.invalidate();

    }

}

