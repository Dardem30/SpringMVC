package by.DAO;

import by.model.AdminkaEntity;
import by.model.EmployeeEntity;
import by.utils.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.servlet.ServletOutputStream;
import java.util.List;

/**
 * Created by УВД on 20.05.2017.
 */
public class DAOImple {
    public void saveEmployee(EmployeeEntity employeeEntity){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(employeeEntity);
        session.getTransaction().commit();
        session.close();
    }
    public List<EmployeeEntity> getAll(){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<EmployeeEntity> list=session.createQuery("from EmployeeEntity ").list();
        session.getTransaction().commit();
        session.close();
        return list;
    }
    public byte[] loadImageById(long id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query=session.createQuery("from EmployeeEntity where employeeId=:id");
        query.setLong("id",id);
        EmployeeEntity employeeEntity= (EmployeeEntity) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return employeeEntity.getImage();
    }
    public void deleteBYId(long id){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query=session.createQuery("from EmployeeEntity where employeeId=:id");
        query.setLong("id",id);
        EmployeeEntity employeeEntity= (EmployeeEntity) query.uniqueResult();
        session.delete(employeeEntity);
        session.getTransaction().commit();
        session.close();
    }
    public void deleteForMVC(EmployeeEntity employeeEntity){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(employeeEntity);
        session.getTransaction().commit();
        session.close();
    }
    public void updateEmployee(EmployeeEntity employeeEntity){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(employeeEntity);
        session.getTransaction().commit();
        session.close();
    }
    public AdminkaEntity getAdminkaByPassword(String password){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query=session.createQuery("from AdminkaEntity where password=:password");
        query.setString("password",password);
        AdminkaEntity adminkaEntity= (AdminkaEntity) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return adminkaEntity;
    }
    public AdminkaEntity getAdminkaByLogin(String login){
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query=session.createQuery("from AdminkaEntity where login=:login");
        query.setString("login",login);
        AdminkaEntity adminkaEntity= (AdminkaEntity) query.uniqueResult();
        session.getTransaction().commit();
        session.close();
        return adminkaEntity;
    }
}
