package dao;

import beans.UserBean;

import javax.ejb.Local;
import javax.ejb.Remote;

@Local
public interface UserDaoService {
    UserBean getUserByUname(String username);
    boolean insertUser(String uname,String passwd,double balance);
}
