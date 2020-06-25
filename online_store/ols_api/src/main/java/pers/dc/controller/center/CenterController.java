package pers.dc.controller.center;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import pers.dc.bean.Users;
import pers.dc.service.center.CenterUserService;
import pers.dc.util.CookieUtils;
import pers.dc.util.JsonResult;
import pers.dc.util.JsonUtils;
import springfox.documentation.spring.web.json.Json;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@RestController
@Api(tags = "「用戶中心」相關接口")
public class CenterController {

    final CenterUserService centerUserService;

    public CenterController(CenterUserService centerUserService) {
        this.centerUserService = centerUserService;
    }

    @GetMapping("/center/userInfo")
    @ApiOperation(value = "「獲取用戶信息」接口", notes = "獲取用戶信息")
    public JsonResult getUserInfo(String userId) {
        if (StringUtils.isBlank(userId))
            return JsonResult.errorMsg("用戶ID不能為空");
        return JsonResult.ok(centerUserService.getUserInfo(userId));
    }

    @PostMapping("/userInfo/update")
    @ApiOperation(value = "「更新用戶信息」接口", notes = "更新用戶信息")
    public JsonResult updateUserInfo(String userId, @RequestBody Users userInfo,
                                     HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        if (StringUtils.isBlank(userId))
            return JsonResult.errorMsg("用戶ID不能為空");
        Users user = centerUserService.updateUserInfo(userId, userInfo);
        System.out.println(JsonUtils.objectToJson(user));
        CookieUtils.setCookie(request, response, "user", URLEncoder.encode(JsonUtils.objectToJson(user), "UTF-8"));
        return JsonResult.ok();
    }

    @PostMapping("/userInfo/uploadFace")
    @ApiOperation(value = "「上傳用戶圖片」接口", notes = "上傳用戶圖片")
    public JsonResult uploadFace(String userId, MultipartFile file,
                                 HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        if (StringUtils.isBlank(userId))
            return JsonResult.errorMsg("用戶ID不能為空");
        if (file == null)
            return JsonResult.errorMsg("圖片為空");
        Users user = centerUserService.uploadFace(userId, file);
        CookieUtils.setCookie(request, response, "user", URLEncoder.encode(JsonUtils.objectToJson(user), "UTF-8"));
        return JsonResult.ok();
    }

    @PostMapping("/myorders/statusCounts")
    @ApiOperation(value = "「獲取各狀態訂單數量」接口", notes = "獲取各狀態訂單數量")
    public JsonResult getStatusCounts(String userId) {
        if (StringUtils.isBlank(userId))
            return JsonResult.errorMsg("用戶ID不能為空");
        return JsonResult.ok(centerUserService.getOrderStatusCount(userId));
    }

}
