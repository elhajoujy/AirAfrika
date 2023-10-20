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

@WebServlet(name = "RechercheVolController", value = "/recherche")
public class RechercheVolController  extends HttpServlet {

    private SearchVolsService searchVolsService = new SearchVolsServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Print.log("Hello from RechercheVolController");
        //Todo : getting information from the request
        String depart = req.getParameter("depart");
        String origin = req.getParameter("origin");
        String departuredate = req.getParameter("departure-date");
        String retourdate = req.getParameter("return-date");
        //TODO : if those information are null then we will redirect to the home page



        if (depart == null  || origin == null || departuredate == null ) {
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }else{
            //TODO : if those information are not null then we will search for the vols
            Collection<VolEntity> vols = searchVolsService.searchVols(origin,depart,departuredate,retourdate,"1");
            req.setAttribute("vols",vols);
            req.getRequestDispatcher("recherche-page.jsp").forward(req, resp);
        }





    }

    @Override
    protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doHead(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }
}
