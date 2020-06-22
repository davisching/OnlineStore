package pers.dc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.dc.service.ItemService;
import pers.dc.util.JsonResult;

@RequestMapping("/items")
@RestController
@Api(tags = "「商品」相關接口")
public class ItemController {

    final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/info/{itemId}")
    @ApiOperation(value = "「獲取商品詳情信息」接口", notes = "獲取商品詳情信息")
    public JsonResult getItemInfo(@PathVariable String itemId) {
        return JsonResult.ok(itemService.getItemInfoById(itemId));
    }
}
