package pers.dc.controller.center;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.dc.service.center.MyOrdersService;
import pers.dc.util.JsonResult;

@RestController
@RequestMapping("/myorders")
@Api(tags = "「用戶中心」相關接口")
public class MyOrdersController {

    final MyOrdersService myOrdersService;

    public MyOrdersController(MyOrdersService myOrdersService) {
        this.myOrdersService = myOrdersService;
    }

    @PostMapping("/statusCounts")
    @ApiOperation(value = "「獲取各狀態訂單數量」接口", notes = "獲取各狀態訂單數量")
    public JsonResult getStatusCounts(String userId) {
        if (StringUtils.isBlank(userId))
            return JsonResult.errorMsg("用戶ID不能為空");
        return JsonResult.ok(myOrdersService.getOrderStatusCount(userId));
    }

    @PostMapping("/trend")
    @ApiOperation(value = "「獲取各訂單狀態」接口", notes = "獲取各訂單狀態")
    public JsonResult getTrend(String userId, int page, int pageSize) {
        if (StringUtils.isBlank(userId))
            return JsonResult.errorMsg("用戶ID不能為空");
        return JsonResult.ok(myOrdersService.getOrderTrends(userId, page, pageSize));
    }
}
