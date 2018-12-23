package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlConnector {
    private static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
    private static final String DB_URL="jdbc:mysql://localhost:3306/j2ee" +
            "?serverTimezone=GMT%2B8";      //3036 is default port, sjz is my own database
    private static final String user="root";
    private static final String passwd="Sjz19980226";

    private volatile static MysqlConnector instance;
    private Connection con;
    private MysqlConnector(){
        try {
            // 注册驱动
            Class.forName(JDBC_DRIVER);
            con= DriverManager.getConnection(DB_URL,user,passwd);
        }catch(ClassNotFoundException | SQLException e){
            // TODO 添加异常判断
        }
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
    public Statement createStatement() throws SQLException{
        return con.createStatement();
    }
}
