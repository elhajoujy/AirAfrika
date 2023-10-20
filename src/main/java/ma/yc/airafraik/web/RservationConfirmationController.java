package ma.yc.airafraik.web;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.yc.airafraik.core.Print;
import ma.yc.airafraik.entities.VolEntity;
import ma.yc.airafraik.service.SearchVolsService;
import ma.yc.airafraik.service.impl.SearchVolsServiceImpl;

import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "RservationConfirmationController", value = "/reservation-confirmation")
public class RservationConfirmationController extends HttpServlet {

    private SearchVolsService searchVolsService ;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.searchVolsService = new SearchVolsServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        if (id != null) {
            Print.log("id : " + id);
            VolEntity vols = searchVolsService.searchVolParId(id);
            req.setAttribute("vols",vols);
            req.getRequestDispatcher("reservation-confirmation.jsp").forward(req, resp);

        }else{
            resp.sendRedirect("/");
        }
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
