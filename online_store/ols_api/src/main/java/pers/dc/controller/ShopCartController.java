package pers.dc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import pers.dc.bean.bo.ShopCartBO;
import pers.dc.service.ShopCartService;
import pers.dc.util.CookieUtils;
import pers.dc.util.JsonResult;
import pers.dc.util.JsonUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/shopcart")
@Api(tags = "「購物車」相關接口")
public class ShopCartController {

    final ShopCartService shopCartService;

    public ShopCartController(ShopCartService shopCartService) {
        this.shopCartService = shopCartService;
    }


    @PostMapping("/add")
    @ApiOperation(value = "「購物車添加」接口", notes = "將商品添加至購物車中")
    public JsonResult addToShopCart(String userId, @RequestBody List<ShopCartBO> shopCartBOList,
                                    HttpServletRequest request, HttpServletResponse response) {

        //CookieUtils.setCookie(request, response, "shopcart", JsonUtils.objectToJson(shopCartBOList));

        if (StringUtils.isBlank(userId))
            return JsonResult.errorMsg("還未登陸！");

        // TODO 之後會用 redis 儲存

        return JsonResult.ok();
    }

    @GetMapping("/refresh")
    @ApiOperation(value = "「購物車刷新」接口", notes = "刷新購物車內容，返回最新的商品信息")
    public JsonResult refresh(String itemSpecIds) {
        return JsonResult.ok(shopCartService.refresh(itemSpecIds));
    }

    @PostMapping("/del")
    @ApiOperation(value = "「購物車刪除」接口", notes = "將商品從購物車中移除")
    public JsonResult deleteItem(String userId, String itemSpecId,
                                    HttpServletRequest request, HttpServletResponse response) {

        //CookieUtils.setCookie(request, response, "shopcart", JsonUtils.objectToJson(shopCartBOList));
        

        if (StringUtils.isBlank(userId) || StringUtils.isBlank(itemSpecId))
            return JsonResult.errorMsg("參數為空！");

        // TODO 之後會用 redis 處理

        return JsonResult.ok();
    }

}
