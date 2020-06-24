package pers.dc.service.center.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import pers.dc.bean.Users;
import pers.dc.config.ConfigProperties;
import pers.dc.config.ResourceConfig;
import pers.dc.dao.UserDao;
import pers.dc.service.center.CenterUserService;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@Service
public class CenterUserServiceImpl implements CenterUserService {

    final UserDao userDao;

    public CenterUserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Users getUserInfo(String userId) {
        return userDao.getOne(userId);
    }

    @Override
    @Transactional
    public Users updateUserInfo(String userId, Users userInfo) {
        Users newInfo = userDao.getOne(userId);
        newInfo.setNickname(userInfo.getNickname());
        newInfo.setRealname(userInfo.getRealname());
        newInfo.setSex(userInfo.getSex());
        newInfo.setMobile(userInfo.getMobile());
        newInfo.setEmail(userInfo.getEmail());
        newInfo.setBirthday(userInfo.getBirthday());
        return userDao.save(newInfo);
    }

    @Override
    @Transactional
    public Users uploadFace(String userId, MultipartFile face) {
        String file = face.getOriginalFilename();
        file = UUID.randomUUID().toString() + file.substring(file.lastIndexOf("."));
        try {
            face.transferTo(new File(ConfigProperties.FACE_FOLDER, file));
            Users user = userDao.getOne(userId);
            user.setFace("http://localhost:8088/" + file);
            user.setUpdatedTime(new Date());
            return userDao.save(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
