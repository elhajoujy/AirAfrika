package ma.yc.airafraik.web.Admin;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.yc.airafraik.service.VolService;
import ma.yc.airafraik.service.impl.VolServiceImpl;

import java.io.IOException;

@WebServlet(name = "DashboardController", value = "/vol-supprimer")
public class volSupprimerController extends HttpServlet {

    private VolService volService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.volService = new VolServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String id = req.getParameter("id");
      boolean isSupprimer = this.volService.supprimerVol(id);
      if(isSupprimer){
        //TODO : SOMETHIGN TO DO
      }

      resp.sendRedirect("admin-dashboard");


    }
}
