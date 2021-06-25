package application.DAO;

import application.entity.User;

import java.util.List;

public interface UserDAO {
    public List<User> getUserList();
    void save (User user);
    User getUser (String email);
    User getUserByID (int id);
    void update(User user);
    void delete(int id);
}
