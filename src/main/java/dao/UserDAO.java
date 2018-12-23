package dao;

public class UserDAO implements UserDaoService{

    @Override
    public boolean hasUser(String username) {
        return false;
    }

    @Override
    public boolean isCorrectPassword(String username, String password) {
        return false;
    }
}
