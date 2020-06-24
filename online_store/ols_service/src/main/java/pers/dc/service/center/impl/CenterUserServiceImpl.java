package pers.dc.service.center.impl;

import org.springframework.stereotype.Service;
import pers.dc.bean.Users;
import pers.dc.dao.UserDao;
import pers.dc.service.center.CenterUserService;

@Service
public class CenterUserServiceImpl implements CenterUserService {

    final UserDao userDao;

    public CenterUserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public Users getUserInfo(String userId) {
        return userDao.getOne(userId);
    }
}
