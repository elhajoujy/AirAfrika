package ma.yc.airafraik.web;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.yc.airafraik.core.Print;
import ma.yc.airafraik.entities.ReservationEntity;
import ma.yc.airafraik.entities.VolEntity;
import ma.yc.airafraik.service.ReservationService;
import ma.yc.airafraik.service.SearchVolsService;
import ma.yc.airafraik.service.impl.ReservationServiceImpl;
import ma.yc.airafraik.service.impl.SearchVolsServiceImpl;

import java.io.IOException;

@WebServlet(name = "RservationDetailsController", value = "/reservation-details")
public class RservationDetailsController extends HttpServlet {

    private ReservationService reservationService ;
    private SearchVolsService searchVolsService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        reservationService = new ReservationServiceImpl();
        searchVolsService = new SearchVolsServiceImpl();
        super.init(config);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String id = req.getParameter("id");
        Print.log("id : " + id);
        VolEntity vol = searchVolsService.searchVolParId(id);
        req.setAttribute("vol",vol);
        //TODO : we will use this attribute in the jsp page
        req.getSession().setAttribute("vol",vol);

//        try{
//            if (reservationEntity != null){
//                req.setAttribute("reservation",reservationEntity);
        if (id != null) {
            req.getRequestDispatcher("reservation-confirmation-page.jsp").forward(req, resp);
        }else{
            resp.sendRedirect("/");
        }

//            }else{
////            req.getRequestDispatcher("index.jsp").forward(req, resp);
//                resp.sendRedirect("/");
//
//
//            }
//        }catch (Exception e){
//            Print.log("Error : " + e.getMessage());
//            resp.sendRedirect("/");
//        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
