package pers.dc.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pers.dc.bean.Users;
import pers.dc.bean.bo.UserCreationBO;
import pers.dc.util.JsonResult;
import pers.dc.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/passport")
public class PassportController {

    final UserService userService;

    public PassportController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/usernameIsExist")
    public JsonResult usernameIsExist(String username) {
        if (StringUtils.isBlank(username))
            return JsonResult.errorMsg("用戶名不能為空！");
        if (userService.usernameExisted(username))
            return JsonResult.errorMsg("用戶名已經存在！");
        return JsonResult.ok();
    }

    @PostMapping("/register")
    public JsonResult register(@RequestBody @Valid UserCreationBO userCreationBO) {
        if (userService.usernameExisted(userCreationBO.getUsername()))
            return JsonResult.errorMsg("用戶名已經存在！");
        Users user = userService.createUser(userCreationBO);
        return JsonResult.ok(user);
    }

}