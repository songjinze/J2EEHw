package dao;

import util.ExceptionHandler;
import util.ResourceGetter;

import java.sql.*;

public class UserDAO implements UserDaoService{

    private final String userScript="/getUser.sql";
    @Override
    public boolean hasUser(String username) {
        if(username==null){
            return false;
        }
        try {
            PreparedStatement preparedStatement=MysqlConnector.getInstance().getConnection().prepareStatement(ResourceGetter.getResourceFileContext(userScript));
            preparedStatement.setString(1, username);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()&&resultSet.getString("uname")!=null){
                return true;
            }
            preparedStatement.close();
        } catch (SQLException e) {
            ExceptionHandler.handleException(e);
        }
        return false;
    }

    @Override
    public boolean isCorrectPassword(String username, String password) {
        if(username==null||password==null){
            return false;
        }
        try {
            PreparedStatement preparedStatement=MysqlConnector.getInstance().getConnection().prepareStatement(ResourceGetter.getResourceFileContext(userScript));
            preparedStatement.setString(1,username);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next()&&resultSet.getString("passwd").equals(password)){
                return true;
            }
            preparedStatement.close();
        }catch(SQLException e){
            ExceptionHandler.handleException(e);
        }
        return false;
    }

    @Override
    public boolean signUpOneUser(String username, String passwd) {
        if(username==null||passwd==null){
            return false;
        }
        try{
            PreparedStatement preparedStatement=MysqlConnector.getInstance().getConnection().prepareStatement(ResourceGetter.getResourceFileContext("/signUp.sql"));
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,passwd);
            int resultRowCount=preparedStatement.executeUpdate();
            if(resultRowCount!=0){
                MysqlConnector.getInstance().commitCon();
                return true;
            }
            preparedStatement.close();
        }catch(SQLException e){
            ExceptionHandler.handleException(e);
        }
        return false;
    }
}
