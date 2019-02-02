import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class UserDao {
    @PersistenceContext
    EntityManager em;
    public void addUser(int userId,double account,String bankId){
        try {
            User user = new User();
            user.setId(userId);
            user.setAccount(account);
            user.setBankid(bankId);
            em.persist(user);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public boolean updateUser(User user){
        try{
            em.merge(user);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
