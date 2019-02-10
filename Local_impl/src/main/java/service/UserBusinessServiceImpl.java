package service;

import beans.UserBean;
import dao.DaoFactory;
import dao.UserDaoService;

public class UserBusinessServiceImpl implements UserBusinessService {
    private UserDaoService userDaoService= DaoFactory.getUserDaoService();
    @Override
    public boolean hasUser(String username) {
        UserBean userBean=userDaoService.getUserByUname(username);
        if(userBean==null){
            return false;
        }
        return true;
    }

    @Override
    public boolean isCorrectPassword(String username, String password) {
        UserBean userBean=userDaoService.getUserByUname(username);
        if(userBean==null){
            return false;
        }
        return userBean.getPasswd().equals(password);
    }

    @Override
    public boolean signUpOneUser(String username, String passwd) {
        userDaoService.insertUser(username,passwd,0);
        return true;
    }
}
