package dao;

public class DaoFactory {
    public static ProductDaoService getProductDaoService(){
        return new ProductDAO();
    }
    public static UserDaoService getUserDaoService(){
        return new UserDAO();
    }
}
