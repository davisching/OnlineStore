package pers.dc.controller.center;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.dc.bean.vo.center.AddCommentBO;
import pers.dc.service.center.MyCommentsService;
import pers.dc.util.JsonResult;

import java.util.List;

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

    @PostMapping("/pending")
    @ApiOperation(value = "「刷新用戶評論」接口", notes = "刷新用戶評論")
    public JsonResult pending(String userId, String orderId) {
        if (StringUtils.isBlank(userId) || StringUtils.isBlank(orderId))
            JsonResult.errorMsg("輸入不能為空");
        return JsonResult.ok(myCommentsService.getPendingComment(userId, orderId));
    }

    @PostMapping("/saveList")
    @ApiOperation(value = "「新增用戶評論」接口", notes = "新增用戶評論")
    public JsonResult saveList(String userId, String orderId, @RequestBody List<AddCommentBO> commentList) {
        if (StringUtils.isBlank(userId) || StringUtils.isBlank(orderId))
            JsonResult.errorMsg("輸入不能為空");
        myCommentsService.addComment(userId, orderId, commentList);
        return JsonResult.ok();
    }

}
