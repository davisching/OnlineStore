package pers.dc.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pers.dc.bean.bo.UserCreationBO;
import pers.dc.bean.bo.UserLoginBO;
import pers.dc.enums.Gender;
import pers.dc.util.Encryptors;
import pers.dc.bean.Users;
import pers.dc.dao.UserDao;
import pers.dc.service.UserService;

import java.util.Date;
import java.util.UUID;

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

    private static final String USER_FACE = "http://122.152.205.72:88/group1/M00/00/05/CpoxxFw_8_qAIlFXAAAcIhVPdSg994.png";

    @Override
    @Transactional
    public Users createUser(UserCreationBO userCreationBO) {

        Users user = new Users();
        user.setId(UUID.randomUUID().toString());
        user.setUsername(userCreationBO.getUsername());
        user.setPassword(Encryptors.getMD5Str(userCreationBO.getPassword()));
        user.setNickname(user.getUsername());
        user.setFace(USER_FACE);
        user.setBirthday(new Date());
        user.setSex(Gender.SECRET.getValue());
        user.setCreatedTime(new Date());
        user.setUpdatedTime(new Date());

        userDao.save(user);

        return user;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Users userLogin(UserLoginBO userLoginBO) {
        String password = Encryptors.getMD5Str(userLoginBO.getPassword());
        return userDao.findByUsernameAndPassword(userLoginBO.getUsername(), password);
    }
}
