package dao;

import beans.UserBean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.ExceptionHandler;
import util.HibernateUtil;

import java.util.List;


public class UserDAO implements UserDaoService{


    @Override
    public UserBean getUserByUname(String username) {
        SessionFactory sessionFactory=null;
        Transaction transaction=null;
        Session session=null;
        try{
            sessionFactory=HibernateUtil.getSessionFactory();
            session=sessionFactory.openSession();
            transaction=session.beginTransaction();
            Query query=session.createQuery("from UserBean where uname = :uname");
            query.setParameter("uname",username);
            System.out.println("ahahha");
            List<UserBean> userBeanList=(List<UserBean>)query.list();
            transaction.commit();
            if(userBeanList.size()==1){
                return userBeanList.get(0);
            }else{
                return null;
            }
        }catch (Exception e){
            transaction.rollback();
        }finally{
            session.close();
            sessionFactory.close();
        }
        return null;
    }

    @Override
    public boolean insertUser(String uname, String passwd, double balance) {
        UserBean user=new UserBean();
        user.setUname(uname);
        user.setBalance(balance);
        user.setPasswd(passwd);
        SessionFactory sessionFactory=null;
        Transaction transaction=null;
        Session session=null;
        try{
            sessionFactory= HibernateUtil.getSessionFactory();
            session=sessionFactory.openSession();
            transaction=session.beginTransaction();
            session.save(user);
            transaction.commit();
        }catch (Exception e){
            assert transaction != null;
            ExceptionHandler.handleException(e);
            transaction.rollback();
        }finally {
            assert session != null;
            session.close();
            sessionFactory.close();
        }
        return true;
    }
}
