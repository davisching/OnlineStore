package pers.dc.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.dc.service.UserService;

@RestController
@RequestMapping("/passport")
public class PassportController {

    final UserService userService;

    public PassportController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/usernameIsExist")
    public int usernameIsExist(String username) {
        if (StringUtils.isBlank(username))
            return 500;
        if (!userService.usernameExisted(username))
            return 500;
        return 200;
    }
}
