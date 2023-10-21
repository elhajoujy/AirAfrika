package ma.yc.airafraik.web.Admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.yc.airafraik.entities.VolEntity;
import ma.yc.airafraik.service.AccountService;
import ma.yc.airafraik.service.AvionService;
import ma.yc.airafraik.service.SearchVolsService;
import ma.yc.airafraik.service.impl.AccountAdminServiceImpl;
import ma.yc.airafraik.service.impl.AvionServiceImpl;
import ma.yc.airafraik.service.impl.SearchVolsServiceImpl;

import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "DashboardController", value = "/admin-dashboard")
public class DashboardController extends HttpServlet {

    private AccountService accountService ;
    private boolean isAccountValid = true;
    private String message;
    private SearchVolsService searchVolsService;
    private AvionService avionService;


    @Override
    public void init() throws ServletException {
        this.accountService = new  AccountAdminServiceImpl();
        this.searchVolsService = new SearchVolsServiceImpl();
        this.avionService = new AvionServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        this.verifyAccount(req,resp);
        req.setAttribute("message",message);
        Collection<VolEntity> volEntities = this.searchVolsService.consulterVols();
        req.setAttribute("vols",volEntities);
        req.setAttribute("avions",this.avionService.consulterAvions());
        req.getRequestDispatcher("views/admin/dashboard.jsp").forward(req,resp);


    }

    private void verifyAccount(HttpServletRequest req, HttpServletResponse resp) {
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
