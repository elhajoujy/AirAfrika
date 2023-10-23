package ma.yc.airafraik.web.Admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.yc.airafraik.dao.Impl.VolDaoImpl;
import ma.yc.airafraik.dao.VolDao;
import ma.yc.airafraik.dto.ResponseDto;
import ma.yc.airafraik.entities.AvionEntity;
import ma.yc.airafraik.entities.VolEntity;
import ma.yc.airafraik.service.AvionService;
import ma.yc.airafraik.service.VolService;
import ma.yc.airafraik.service.impl.AvionServiceImpl;
import ma.yc.airafraik.service.impl.VolServiceImpl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

@WebServlet(name = "volServerlet", value = "/admin-vol/*")
public class VolController extends HttpServlet {

    private String message;
    private VolDao volDao ;
    private AvionService avionService;
    private VolService volService;

    @Override
    public void init() throws ServletException {
        this.volDao = new VolDaoImpl();
        this.avionService = new AvionServiceImpl();
        this.volService = new VolServiceImpl();
        super.init();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //set json type content
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        Collection<VolEntity> volEntities = this.volDao.consulterVols();
        resp.setStatus(200);
        resp.getWriter().write(
                new ResponseDto(200,volEntities.toString(),"message").toJson()
        );

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
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
        avion = this.avionService.consulterAvion(avionId.toString());
        vol.setAvion(avion);
        // You need to retrieve the AvionEntity object based on avionId and set it to vol

        vol.setPrix(prix);


        if (this.volService.ajouterVol(vol)) {
            message = "Vol ajouté avec succès";
            request.setAttribute("message", message);
        }else {
            message = "Erreur lors de l'ajout du vol";
            request.setAttribute("message", message);
        }
//        request.getRequestDispatcher("views/admin/dashboard.jsp").forward(request,resp);
        resp.sendRedirect("admin-dashboard");
    }
}
