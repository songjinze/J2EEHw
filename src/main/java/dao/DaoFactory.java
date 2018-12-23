package dao;

public class DaoFactory {
    public static UserDaoService getUserDaoService(){
        return new UserDAO();
    }
    public static GoodDaoService getGoodDaoService(){
        return new GoodDAO();
    }
}
