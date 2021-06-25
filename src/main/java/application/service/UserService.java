package application.service;

import application.entity.User;


import java.util.List;


public interface UserService {
    List<User> getUserList ();
    boolean save (User user);
    User getUserByID (int id);
    boolean update (User user);
    void delete (int id);
}
