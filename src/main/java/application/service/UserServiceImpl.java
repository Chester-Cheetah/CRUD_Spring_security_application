package application.service;

import application.DAO.UserDAO;
import application.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO dao;

    @Override
    @Transactional(readOnly = true)
    public List<User> getUserList() {
        return dao.getUserList();
    }

    @Override
    @Transactional
    public boolean save(User user) {
        if (dao.getUser(user.getEmail()) == null) {
            dao.save(user);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public User getUserByID(int id) {
        return dao.getUserByID(id);
    }

    @Override
    @Transactional
    public boolean update(User user) {
        User existedUser = dao.getUser(user.getEmail());
        if (existedUser == null || existedUser.getId() == user.getId()) {
            dao.update(user);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public void delete(int id) {
        dao.delete(id);
    }
}
