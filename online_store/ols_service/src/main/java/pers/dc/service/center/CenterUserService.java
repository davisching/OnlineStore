package pers.dc.service.center;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;
import pers.dc.bean.Users;
import pers.dc.bean.vo.center.OrderStatusCountVO;
import pers.dc.bean.vo.center.OrderTrendVO;

public interface CenterUserService {
    Users getUserInfo(String userId);
    Users updateUserInfo(String userId, Users userInfo);
    Users uploadFace(String userId, MultipartFile multipartFile);
}
