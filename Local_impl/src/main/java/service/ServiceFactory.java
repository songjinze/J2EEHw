package service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceFactory {
    public static UserBusinessService getUserBusinessService(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");
        return (UserBusinessService) context.getBean("userBusinessService");
    }
    public static ProductBusinessService getProductBusinessService(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");
        return (ProductBusinessService) context.getBean("productBusinessService");
    }
}
