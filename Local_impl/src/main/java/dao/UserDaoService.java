package dao;

import beans.UserBean;

public interface UserDaoService {
    /**
     * 根据用户名得到用户
     * @param username
     * @return
     */
    UserBean getUserByUname(String username);

    /**
     *
     * @param uname
     * @param passwd
     * @param balance
     * @return
     */
    boolean insertUser(String uname, String passwd, double balance);
}
