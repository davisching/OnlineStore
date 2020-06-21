package pers.dc.service.impl;

import org.apache.catalina.User;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pers.dc.dao.UserDao;
import pers.dc.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public boolean usernameExisted(String username) {
        return userDao.findOneByUsername(username) != null;
    }
}
