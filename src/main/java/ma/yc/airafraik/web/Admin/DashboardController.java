package ma.yc.airafraik.web.Admin;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.yc.airafraik.entities.VolEntity;
import ma.yc.airafraik.enums.ReservationStatus;
import ma.yc.airafraik.service.AccountService;
import ma.yc.airafraik.service.AvionService;
import ma.yc.airafraik.service.ReservationService;
import ma.yc.airafraik.service.VolsService;
import ma.yc.airafraik.service.impl.AccountAdminServiceImpl;
import ma.yc.airafraik.service.impl.AvionServiceImpl;
import ma.yc.airafraik.service.impl.ReservationServiceImpl;
import ma.yc.airafraik.service.impl.VolsServiceImpl;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

@WebServlet(name = "DashboardController", value = {"/admin-dashboard","/admin-delete-vol","/admin-add-vol","/admin-update-vol","/admin-add-avion","/admin-delete-avion","/admin-update-avion"})
public class DashboardController extends HttpServlet {

    private AccountService accountService ;
    private boolean isAuthentified = false;
    private String message;
    private VolsService volsService;
    private AvionService avionService;
    private ReservationService reservationService;
    private ServletContext context;


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    public void init() throws ServletException {
        this.accountService = new  AccountAdminServiceImpl();
        this.volsService = new VolsServiceImpl();
        this.avionService = new AvionServiceImpl();
        this.reservationService = new ReservationServiceImpl();


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        if (this.verifyAccount(req,resp)){
//            return ;
//        }


        if (req.getServletPath().equals("/admin-delete-vol")){
            String idVol = req.getParameter("idVol");
            boolean IsDeleted =  this.volsService.deleteVol(idVol);

            if (IsDeleted){
                message = "Vol supprimé avec succès";
            }else{
                message = "Erreur lors de la suppression du vol";
            }
        }

        req.setAttribute("message",message);
        Collection<VolEntity> volEntities = this.volsService.consulterVols();
        req.setAttribute("vols",volEntities);
        req.setAttribute("avions",this.avionService.consulterAvions());


        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();

// Get the current year
        int currentYear = calendar.get(Calendar.YEAR);

// Calculate dynamic dates for the current year
        String currentYearStartDate = currentYear + "-01-01";
        String currentYearEndDate = currentYear + "-12-31";

        int nbrReservationAnullerAnnee = this.reservationService.statisticsReservation(ReservationStatus.ANNULER, generateConditions(currentYearStartDate, currentYearEndDate));
        int nbrReservationConfirmerAnnee = this.reservationService.statisticsReservation(ReservationStatus.CONFIRMER, generateConditions(currentYearStartDate, currentYearEndDate));

        Date currentDate = new Date();
        calendar.setTime(currentDate);

        String currentMonthStartDate = dateFormat.format(calendar.getTime());
        calendar.add(Calendar.MONTH, 1); // Add one month to get the end of the current month
        calendar.add(Calendar.DATE, -1); // Subtract one day to get the last day of the current month
        String currentMonthEndDate = dateFormat.format(calendar.getTime());

        int nbrReservationConfirmerMois = this.reservationService.statisticsReservation(ReservationStatus.CONFIRMER, generateConditions(currentMonthStartDate, currentMonthEndDate));
        int nbrReservationAnullerMois = this.reservationService.statisticsReservation(ReservationStatus.ANNULER, generateConditions(currentYearStartDate, currentMonthEndDate));



        req.setAttribute("nbrReservationAnullerMois",nbrReservationAnullerMois);
        req.setAttribute("nbrReservationAnullerAnnee",nbrReservationAnullerAnnee);
        req.setAttribute("nbrReservationConfirmerMois",nbrReservationConfirmerMois);
        req.setAttribute("nbrReservationConfirmerAnnee",nbrReservationConfirmerAnnee);
        req.setAttribute("message",message);
        req.getRequestDispatcher("views/admin/dashboard.jsp").forward(req,resp);


    }

    public HashMap<String, String> generateConditions(String startDate, String endDate) {
        HashMap<String, String> conditions = new HashMap<>();
        conditions.put("date_1", startDate);
        conditions.put("date_2", endDate);
        return conditions;
    }

    private boolean verifyAccount(HttpServletRequest req, HttpServletResponse resp) {
        this.isAuthentified = req.getSession().getAttribute("isAuthentified") != null;
        if (!isAuthentified){
            try {
//                req.getRequestDispatcher("views/admin/login.jsp").forward(req,resp);
                resp.sendRedirect("admin-login");
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }



//        ma.yc.airafraik.dto.Account account = (ma.yc.airafraik.dto.Account) req.getSession().getAttribute("account");
//        if(account != null){
//            if(accountService.isAccountValid(account)){
//                this.isAccountValid = true;
//            }
//        }
//        if (isAccountValid){
//            req.setAttribute("account",account);
//        }else{
//            try {
//                resp.sendRedirect("login");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        return false;
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
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doOptions(req, resp);
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
