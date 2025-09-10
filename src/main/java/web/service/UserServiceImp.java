package web.service;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    private final UserDao userDao;

    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void createUser(User user) {
        userDao.save(user);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        if (user.getId() != null && userDao.findById(user.getId()) != null) {
            userDao.update(user);
        }
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        User user = userDao.findById(id);
        if (user != null) {
            userDao.delete(user);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

}
