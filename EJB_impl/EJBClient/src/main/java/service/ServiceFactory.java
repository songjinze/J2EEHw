package service;

import dao.ProductDaoService;
import dao.UserDaoService;

import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;
import java.util.Properties;
public class ServiceFactory {

    private static Object getEJB(String ejbPath){
        final Hashtable properties=new Hashtable();
        properties.put(Context.URL_PKG_PREFIXES,"org.jboss.ejb.client.naming");
        try{
            final Context context=new InitialContext(properties);
            return context.lookup(ejbPath);
        }catch(NamingException e){
            e.printStackTrace();
            return null;
        }
    }
    public static UserBusinessService getUserBusinessService(){
        return (UserBusinessService) getEJB("java:global/EJBClient-1.0-SNAPSHOT/UserBusinessService!service.UserBusinessService");
    }
    public static ProductBusinessService getProductBusinessService(){
        return (ProductBusinessService) getEJB("java:global/EJBClient-1.0-SNAPSHOT/ProductBusinessService!service.ProductBusinessService");
    }
}
