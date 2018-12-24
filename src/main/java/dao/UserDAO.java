package dao;

import util.ExceptionHandler;
import util.ResourceGetter;

import java.sql.*;

public class UserDAO implements UserDaoService{

    @Override
    public boolean hasUser(String username) {
        try {
            String getUserScript = "/getUser.sql";
            PreparedStatement preparedStatement=MysqlConnector.getInstance().getConnection().prepareStatement(ResourceGetter.getResourceFile(getUserScript));
            preparedStatement.setString(1, username);
            ResultSet resultSet=preparedStatement.executeQuery();
            
        } catch (SQLException e) {
            ExceptionHandler.handleException(e);
        }
        return false;
    }

    @Override
    public boolean isCorrectPassword(String username, String password) {
        return false;
    }
}
