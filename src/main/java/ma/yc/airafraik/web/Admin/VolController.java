package ma.yc.airafraik.web.Admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.yc.airafraik.dao.Impl.VolDaoImpl;
import ma.yc.airafraik.dao.VolDao;
import ma.yc.airafraik.dto.ResponseDto;
import ma.yc.airafraik.entites.VolEntity;

import java.io.IOException;
import java.util.Collection;

@WebServlet(name = "volServerlet", value = "/admin/vol")
public class VolController extends HttpServlet {

    private String message;
    private VolDao volDao ;
    @Override
    public void init() throws ServletException {
        this.volDao = new VolDaoImpl();
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


}
