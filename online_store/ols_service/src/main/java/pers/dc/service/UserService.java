package pers.dc.service;

import pers.dc.bean.Users;
import pers.dc.bean.bo.UserCreationBO;
import pers.dc.bean.bo.UserLoginBO;

public interface UserService {
    boolean usernameExisted(String username);
    Users createUser(UserCreationBO userCreationBO);
    Users userLogin(UserLoginBO userLoginBO);
}
