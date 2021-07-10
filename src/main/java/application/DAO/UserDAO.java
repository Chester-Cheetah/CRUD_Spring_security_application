package application.DAO;

import application.entity.Role;
import application.entity.User;

import java.util.List;

public interface UserDAO {
    List<User> getUserList();
    void save (User user);
    User getUserByName(String username);
    User getUserByEmail(String email);
    User getUserByID (int id);
    void update(User user);
    void delete(int id);
}
