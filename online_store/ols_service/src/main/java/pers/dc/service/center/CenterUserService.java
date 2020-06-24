package pers.dc.service.center;

import org.springframework.web.multipart.MultipartFile;
import pers.dc.bean.Users;

public interface CenterUserService {
    Users getUserInfo(String userId);
    Users updateUserInfo(String userId, Users userInfo);
    Users uploadFace(String userId, MultipartFile multipartFile);
}
