package ma.yc.airafraik.web;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.yc.airafraik.core.Print;
import ma.yc.airafraik.entities.VolEntity;
import ma.yc.airafraik.service.VolsService;
import ma.yc.airafraik.service.impl.VolsServiceImpl;

import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "RechercheVolController", value = "/recherche")
public class RechercheVolController  extends HttpServlet {

    private VolsService volsService;
    private ServletContext context;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.volsService = new VolsServiceImpl();
        this.context = config.getServletContext();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Print.log("Hello from RechercheVolController");
        //Todo : getting information from the request
        String depart = req.getParameter("depart");
        String origin = req.getParameter("origin");
        String departuredate = req.getParameter("departure-date");
        String retourdate = req.getParameter("return-date");
        //TODO : if those information are null then we will redirect to the home page

        Integer numberDeAdultes = Integer.parseInt(req.getParameter("numberDeAdultes"));
        Integer numberDeEnfants = Integer.parseInt(req.getParameter("numberDeEnfants"));
        Integer numberDeBebes = Integer.parseInt(req.getParameter("numberDeBebes"));

        this.context.setAttribute("numberDeAdultes",numberDeAdultes);
        this.context.setAttribute("numberDeEnfants",numberDeEnfants);
        this.context.setAttribute("numberDeBebes",numberDeBebes);








        if (depart == null  || origin == null || departuredate == null ) {
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }else{
            //TODO : if those information are not null then we will search for the vols
            Collection<VolEntity> vols = volsService.searchVols(origin,depart,departuredate,retourdate,"1");
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

}
