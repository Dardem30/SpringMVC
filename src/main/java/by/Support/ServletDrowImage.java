package by.Support;

import by.DAO.DAOImple;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by УВД on 20.05.2017.
 */
public class ServletDrowImage extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id=Long.parseLong(request.getParameter("employeeId"));
        DAOImple daoImple=new DAOImple();
        byte[] bytes=daoImple.loadImageById(id);
        response.setContentType("image/jpg");
        ServletOutputStream servletOutputStream=response.getOutputStream();
        servletOutputStream.write(bytes);
        servletOutputStream.close();
        String action=request.getParameter("action");
        if(action.equals("delete")){
            daoImple.deleteBYId(Long.parseLong(request.getParameter("employeeId")));
            request.setAttribute("list",daoImple);
            RequestDispatcher requestDispatcher=request.getRequestDispatcher("list.jsp");
            long id1=Long.parseLong(request.getParameter("employeeId"));
            byte[] bytesy=daoImple.loadImageById(id1);
            response.setContentType("image/jpg");
            ServletOutputStream servletOutputStream1=response.getOutputStream();
            servletOutputStream.write(bytes);
            servletOutputStream.close();
            requestDispatcher.include(request,response);
        }
    }
}
