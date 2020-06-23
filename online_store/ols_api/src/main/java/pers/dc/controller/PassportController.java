package pers.dc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import pers.dc.bean.Users;
import pers.dc.bean.bo.UserCreationBO;
import pers.dc.bean.bo.UserLoginBO;
import pers.dc.bean.vo.UserVO;
import pers.dc.util.CookieUtils;
import pers.dc.util.JsonResult;
import pers.dc.service.UserService;
import pers.dc.util.JsonUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@RequestMapping("/passport")
@Api(tags = "「用戶」相關接口")
public class PassportController {

    final UserService userService;

    public PassportController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/usernameIsExist")
    @ApiOperation(value = "「查詢用戶名是否存在」接口", notes = "查詢用戶名是否存在")
    public JsonResult usernameIsExist(String username) {
        if (StringUtils.isBlank(username))
            return JsonResult.errorMsg("用戶名不能為空！");
        if (userService.usernameExisted(username))
            return JsonResult.errorMsg("用戶名已經存在！");
        return JsonResult.ok();
    }

    @PostMapping("/register")
    @ApiOperation(value = "「用戶註冊」接口", notes = "進行用戶註冊（判斷輸入長度是否合適，密碼是否一致，用戶名是否存在）")
    public JsonResult register(@RequestBody @Valid UserCreationBO userCreationBO,
                               HttpServletRequest request, HttpServletResponse response) {
        if (userService.usernameExisted(userCreationBO.getUsername()))
            return JsonResult.errorMsg("用戶名已經存在！");
        Users user = userService.createUser(userCreationBO);

        CookieUtils.setCookie(request, response, "user",
                JsonUtils.objectToJson(new UserVO(user)), true);

        // TODO 生成用戶 TOKEN ， 存入 redis 會話 ， 同步 購物車

        return JsonResult.ok(user);
    }

    @PostMapping("/login")
    @ApiOperation(value = "「用戶登陸」接口", notes = "進行用戶登陸（判斷輸入是否為空）")
    public JsonResult login(@RequestBody @Valid UserLoginBO userLoginBO,
                            HttpServletRequest request, HttpServletResponse response) {
        Users user = userService.userLogin(userLoginBO);

        if (user == null)
            return JsonResult.errorMsg("用戶不存在");

        CookieUtils.setCookie(request, response, "user",
                JsonUtils.objectToJson(new UserVO(user)), true);

        // TODO 生成用戶 TOKEN ， 存入 redis 會話 ， 同步 購物車

        return JsonResult.ok(user);
    }

    @PostMapping("/logout")
    @ApiOperation(value = "「用戶登出」接口", notes = "進行用戶登出")
    public JsonResult logout(@RequestParam String userId,
                             HttpServletRequest request, HttpServletResponse response) {
        CookieUtils.deleteCookie(request, response, "user");

        // TODO 用戶退出，要清空購物車
        // TODO 分布式會話中，清除用戶數據

        return JsonResult.ok();
    }
}