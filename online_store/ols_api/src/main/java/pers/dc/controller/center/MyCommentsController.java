package pers.dc.controller.center;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.dc.service.center.MyCommentsService;
import pers.dc.util.JsonResult;

@RestController
@RequestMapping("/mycomments")
@Api(tags = "「用戶中心 - 評論」相關接口")
public class MyCommentsController {

    final MyCommentsService myCommentsService;

    public MyCommentsController(MyCommentsService myCommentsService) {
        this.myCommentsService = myCommentsService;
    }

    @PostMapping("/query")
    @ApiOperation(value = "「獲取用戶評論」接口", notes = "獲取用戶評論")
    public JsonResult queryComments(String userId, int page, int pageSize) {
        if (StringUtils.isBlank(userId))
            JsonResult.errorMsg("用戶ID不能為空");
        return JsonResult.ok(myCommentsService.getMyComments(userId, page, pageSize));
    }
}
