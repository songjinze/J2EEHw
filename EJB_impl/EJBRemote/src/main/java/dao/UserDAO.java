package dao;

import beans.UserBean;
import util.ExceptionHandler;
import util.ResourceGetter;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Stateless
public class UserDAO implements UserDaoService{

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public UserBean getUserByUname(String username) {
        try{
            Query query=entityManager.createQuery("from user u where u.uname="+username);
            List list=query.getResultList();
            entityManager.clear();
            return (UserBean) list.get(0);
        }catch (Exception e){
            ExceptionHandler.handleException(e);
            return null;
        }
    }

    @Override
    public boolean insertUser(String uname, String passwd, double balance) {
        UserBean userBean=new UserBean();
        userBean.setPasswd(passwd);
        userBean.setBalance(balance);
        userBean.setUname(uname);
        entityManager.persist(userBean);
        return true;
    }
}
