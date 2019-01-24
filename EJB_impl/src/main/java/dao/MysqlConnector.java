package dao;

import util.ExceptionHandler;
import util.ResourceGetter;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class MysqlConnector {

    private volatile static MysqlConnector instance;
    private Connection con;

    private MysqlConnector(){
        InitialContext jndiContext = null;
        DataSource datasource;
        Properties properties = new Properties();
        properties.put(javax.naming.Context.PROVIDER_URL, "jnp:///");
        properties.put(javax.naming.Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
        try {
            jndiContext = new InitialContext(properties);
            datasource = (DataSource) jndiContext.lookup("java:comp/env/jdbc/j2ee");
            con=datasource.getConnection();
            con.setAutoCommit(false);
            initDatabase();
        } catch (NamingException |SQLException e) {
            ExceptionHandler.handleException(e);
        }
    }
    private void initDatabase() throws SQLException{
        con.createStatement().executeUpdate(ResourceGetter.getResourceFileContext("/initProducts.sql"));
        con.createStatement().executeUpdate(ResourceGetter.getResourceFileContext("/initUser.sql"));
        con.createStatement().executeUpdate(ResourceGetter.getResourceFileContext("/addData.sql"));
        con.commit();
    }
    
    public static MysqlConnector getInstance(){
        if(instance==null){
            synchronized (MysqlConnector.class){
                if(instance==null){
                    instance=new MysqlConnector();
                }
            }
        }
        return instance;
    }
    public void commitCon(){
        try {
            MysqlConnector.getInstance().con.commit();
        } catch (SQLException e) {
            ExceptionHandler.handleException(e);
        }
    }

    public Connection getConnection() {
        return MysqlConnector.getInstance().con;
    }
}
