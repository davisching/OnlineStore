package pers.dc.service.center.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import pers.dc.bean.Users;
import pers.dc.bean.vo.center.OrderStatusCountVO;
import pers.dc.config.ConfigProperties;
import pers.dc.dao.OrderDao;
import pers.dc.dao.UserDao;
import pers.dc.service.center.CenterUserService;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@Service
public class CenterUserServiceImpl implements CenterUserService {

    final UserDao userDao;
    final OrderDao orderDao;

    public CenterUserServiceImpl(UserDao userDao, OrderDao orderDao) {
        this.userDao = userDao;
        this.orderDao = orderDao;
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        Users user = userDao.getOne(userId);
        user.setFace("http://localhost:8088/" + file);
        user.setUpdatedTime(new Date());
        return userDao.save(user);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public OrderStatusCountVO getOrderStatusCount(String userId) {
        long waitPayCounts = 0, waitDeliverCounts = 0, waitReceiveCounts = 0, waitCommentCounts = 0;

        for (long status : orderDao.findStatusByUserId(userId)) {
            if (status == 10) waitPayCounts += 1;
            else if (status == 20) waitDeliverCounts += 1;
            else if (status == 30) waitReceiveCounts += 1;
            else waitCommentCounts += 1;
        }

        return new OrderStatusCountVO(waitPayCounts, waitDeliverCounts, waitReceiveCounts, waitCommentCounts);
    }
}
