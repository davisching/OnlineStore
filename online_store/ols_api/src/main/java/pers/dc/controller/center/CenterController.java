package pers.dc.controller.center;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.dc.service.center.CenterUserService;
import pers.dc.util.JsonResult;

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

}
