package service;

public class ServiceFactory {
    public static UserBusinessService getUserBusinessService(){
        return new UserBusinessServiceImpl();
    }
    public static ProductBusinessService getProductBusinessService(){
        return new ProductBusinessServiceImpl();
    }
}
