package ma.yc.airafraik.web.Admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.yc.airafraik.entities.AvionEntity;
import ma.yc.airafraik.entities.VolEntity;
import ma.yc.airafraik.service.AvionService;
import ma.yc.airafraik.service.VolService;
import ma.yc.airafraik.service.impl.VolServiceImpl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "AvionController", value = "/admin-avion")
public class AvionController extends HttpServlet {

    private VolService volService ;
    private AvionService avionService;
    private String message;
    @Override
    public void init() throws ServletException {
        this.volService = new VolServiceImpl();
        super.init();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        // : AJOUTER NOUVEAU AVION AND GO BACK TO ADMIN DASHBOARD
        String code = request.getParameter("code");
        String heureDepart = request.getParameter("heure_depart");
        String heureArrivee = request.getParameter("heure_arrivee");
        String dateDepartStr = request.getParameter("date_depart");
        String dateArriveeStr = request.getParameter("date_arrivee");
        String villeDepart = request.getParameter("ville_depart");
        String villeArrivee = request.getParameter("ville_arrivee");
        int nombreDePlaces = Integer.parseInt(request.getParameter("nombre_de_places"));
        double prix = Double.parseDouble(request.getParameter("prix"));
        Integer avionId = Integer.parseInt(request.getParameter("avion"));

        // Parse date strings to Date objects
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateDepart = null;
        Date dateArrivee = null;
        try {
            dateDepart = dateFormat.parse(dateDepartStr);
            dateArrivee = dateFormat.parse(dateArriveeStr);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }

        // Create a new VolEntity object and set the data
        VolEntity vol = new VolEntity();
        vol.setCode(code);
        vol.setHeureDepart(heureDepart);
        vol.setHeureArrivee(heureArrivee);
        vol.setDateDepart(dateDepart);
        vol.setDateArrive(dateArrivee);
        vol.setVilleDepart(villeDepart);
        vol.setVilleArrivee(villeArrivee);
        vol.setNomberDePlaces(nombreDePlaces);
        AvionEntity avion = new AvionEntity();
        vol.setAvion(this.avionService.consulterAvion(avionId.toString()));
        // You need to retrieve the AvionEntity object based on avionId and set it to vol

        vol.setPrix(prix);

        if (this.volService.ajouterVol(vol))
            request.setAttribute("message","Avion ajouté avec succès");
        else
            request.setAttribute("message","Erreur lors de l'ajout de l'avion");

//        req.getRequestDispatcher("views/admin/dashboard.jsp").forward(req,resp);
        resp.sendRedirect("admin-dashboard");
    }
}
