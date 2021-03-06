package pers.dc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.dc.bean.bo.OrderBO;
import pers.dc.service.OrderService;
import pers.dc.util.CookieUtils;
import pers.dc.util.JsonResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/orders")
@Api(tags = "「訂單」相關接口")
public class OrderController {

    final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    @ApiOperation(value = "「訂單創建」接口", notes = "創建訂單")
    public JsonResult createOrder(@RequestBody OrderBO orderBO,
                                  HttpServletRequest request, HttpServletResponse response) {
        if (orderBO == null)
            return JsonResult.errorMsg("輸入為空");
        CookieUtils.setCookie(request, response, "shopcart", "");
        return JsonResult.ok(orderService.createOrder(orderBO));
    }
}