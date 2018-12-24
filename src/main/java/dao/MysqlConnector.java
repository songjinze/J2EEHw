package dao;

import util.ExceptionHandler;
import util.ResourceGetter;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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
        } catch (NamingException |SQLException e) {
            ExceptionHandler.handleException(e);
        }
    }
    private void initDatabase() throws SQLException{
        con.createStatement().executeUpdate(ResourceGetter.getResourceFile("/init.sql"));
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
    public Connection getConnection() {
        return MysqlConnector.getInstance().con;
    }
}
