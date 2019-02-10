package service;

public interface UserBusinessService {
    /**
     * 是否有当前用户
     * @param username
     * @return
     */
    boolean hasUser(String username);

    /**
     * 密码是否正确
     * 用户名需要是已经存在的用户
     * @param username
     * @param password
     * @return
     */
    boolean isCorrectPassword(String username, String password);

    /**
     *
     * @param username
     * @param passwd
     * @return
     */
    boolean signUpOneUser(String username, String passwd);
}
