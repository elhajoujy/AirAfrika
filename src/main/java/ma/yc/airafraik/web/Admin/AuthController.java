package ma.yc.airafraik.web.Admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.yc.airafraik.service.AccountService;
import ma.yc.airafraik.service.impl.AccountAdminServiceImpl;

import java.io.IOException;

@WebServlet(name = "AuthController", value = {"/admin-login","/admin-logout"})
public class AuthController extends HttpServlet {


    private AccountService accountService ;
    private boolean isAuth ;

    @Override
    public void init() throws ServletException {
        this.accountService = new AccountAdminServiceImpl();
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getServletPath().equals("/admin-login")){
            req.getRequestDispatcher("views/admin/login.jsp").forward(req,resp);
        }else if (req.getServletPath().equals("/admin-logout")){
            req.getSession().invalidate();
            resp.sendRedirect("admin-login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        isAuth = this.accountService.checkLoginAccount(username, password) != null;
        if (isAuth){
            req.getSession().setAttribute("isAuthentified",true);
            req.getSession().setAttribute("username",username);
            req.getSession().setAttribute("password",password);
            req.setAttribute("message","Welcome "+username);
            resp.sendRedirect("admin-dashboard");
        }else{
            req.setAttribute("message","Username or password is incorrect");
//            req.getRequestDispatcher("views/admin/login.jsp").forward(req,resp);
            resp.sendRedirect("admin-dashboard");

        }

    }
}

