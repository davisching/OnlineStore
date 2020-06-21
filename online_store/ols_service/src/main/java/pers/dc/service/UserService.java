package pers.dc.service;

import pers.dc.bean.Users;
import pers.dc.bean.bo.UserCreationBO;

public interface UserService {
    boolean usernameExisted(String username);
    Users createUser(UserCreationBO userCreationBO);
}
