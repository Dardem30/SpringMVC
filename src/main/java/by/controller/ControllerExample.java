package by.controller;

import by.DAO.DAOImple;
import by.model.AdminkaEntity;
import by.model.EmployeeEntity;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by УВД on 20.05.2017.
 */
@Controller
public class ControllerExample {
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView main(){
        ModelAndView modelAndView=new ModelAndView("login");
        return modelAndView;
    }
    @RequestMapping(value = "/lp")
    public ModelAndView security(AdminkaEntity adminkaEntity, HttpServletRequest request, HttpServletResponse response){
        DAOImple daoImple=new DAOImple();
        if(daoImple.getAdminkaByLogin(request.getParameter("login"))!=null && daoImple.getAdminkaByPassword(request.getParameter("password"))!=null){
            ModelAndView modelAndView=new ModelAndView("index");
            modelAndView.addObject("newEmployee",new EmployeeEntity());
            HttpSession session=request.getSession();
            session.setAttribute("forward","forward");
            session.setMaxInactiveInterval(1*60);
            Cookie cookie=new Cookie("login",request.getParameter("login"));
            cookie.setMaxAge(1*60);
            response.addCookie(cookie);
            return modelAndView;
        }else {
            ModelAndView modelAndView=new ModelAndView("login");
            return modelAndView;
        }
    }
    @RequestMapping(value = "/saveEmployee")
    public ModelAndView addEmployee(@ModelAttribute("list")EmployeeEntity employeeEntity){
        DAOImple daoImple=new DAOImple();
        employeeEntity.setImage(daoImple.loadImageById(1));
        daoImple.saveEmployee(employeeEntity);
        ModelAndView modelAndView=new ModelAndView("list");
        modelAndView.addObject("list",daoImple.getAll());
        return modelAndView;
    }
    @RequestMapping(value = "/listEmployee")
    public ModelAndView listEmployee() {
        ModelAndView modelAndView = new ModelAndView("list");
        DAOImple daoImple=new DAOImple();
        modelAndView.addObject("list",daoImple.getAll());
        return modelAndView;
    }
    @RequestMapping(value = "/deleteEmployee")
    public ModelAndView deleteEmployee(@ModelAttribute("employeeForDelete") EmployeeEntity employeeEntity,HttpServletRequest request){
        DAOImple daoImple=new DAOImple();
        daoImple.deleteBYId(Long.parseLong(request.getParameter("employeeId")));
        ModelAndView modelAndView=new ModelAndView("list");
        modelAndView.addObject("list",daoImple.getAll());
        return modelAndView;
    }
    @RequestMapping(value = "/onUpdate")
    public ModelAndView updateReturnEmployee(){
        ModelAndView modelAndView=new ModelAndView("update");
        DAOImple daoImple=new DAOImple();
        modelAndView.addObject("employers",new EmployeeEntity());
        return modelAndView;
    }
    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public ModelAndView updateEmployee(@ModelAttribute("employers") EmployeeEntity employeeEntity,HttpServletRequest request){
        DAOImple daoImple=new DAOImple();
        EmployeeEntity employeeEntity1=new EmployeeEntity();
        employeeEntity1.setEmployeeId(Long.parseLong(request.getParameter("employeeId")));
        employeeEntity1.setFirstname(request.getParameter("firstname"));
        employeeEntity1.setLastname(request.getParameter("lastname"));
        employeeEntity1.setImage(daoImple.loadImageById(Long.parseLong(request.getParameter("employeeId"))));
        daoImple.updateEmployee(employeeEntity1);
        ModelAndView modelAndView=new ModelAndView("list");
        modelAndView.addObject("list",daoImple.getAll());
        return modelAndView;
    }
    @RequestMapping(value = "/exit")
    public ModelAndView exit(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("JSESSIONID")){
                    break;
                }
            }
        }
        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate();
        }
        ModelAndView modelAndView=new ModelAndView("login");
        return modelAndView;
    }
}
