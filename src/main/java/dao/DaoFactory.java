package dao;

public class DaoFactory {
    public static UserDaoService getUserDaoService(){
        return new UserDAO();
    }
    public static ProductDaoService getGoodDaoService(){
        return new ProductDAO();
    }
}
