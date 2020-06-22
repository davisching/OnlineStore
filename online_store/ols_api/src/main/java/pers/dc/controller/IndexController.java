package pers.dc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.dc.service.CarouselService;
import pers.dc.service.CategoryService;
import pers.dc.service.ItemService;
import pers.dc.util.JsonResult;

@RestController
@RequestMapping("/index")
@Api(tags = "「首頁」相關接口")
public class IndexController {

    final CarouselService carouselService;
    final CategoryService categoryService;
    final ItemService itemService;

    public IndexController(CarouselService carouselService,
                           CategoryService categoryService,
                           ItemService itemService) {
        this.carouselService = carouselService;
        this.categoryService = categoryService;
        this.itemService = itemService;
    }

    @GetMapping("/carousel")
    @ApiOperation(value = "「獲取所有輪播圖」接口", notes = "獲取所有輪播圖")
    public JsonResult getAllCarousels() {
        return JsonResult.ok(carouselService.getAll());
    }

    @GetMapping("/cats")
    @ApiOperation(value = "「獲取所有大分類」接口", notes = "獲取所有大分類")
    public JsonResult getAllHighestCategory() {
        return JsonResult.ok(categoryService.getAllHighestLevelCategory());
    }

    @GetMapping("/subCat/{rootCatId}")
    @ApiOperation(value = "「根據大分類ID獲取所有小分類」接口", notes = "根據大分類ID獲取所有小分類")
    public JsonResult getSubCategoryByRootCategoryId(@PathVariable long rootCatId) {
        return JsonResult.ok(categoryService.getSubCatsWithFatherId(rootCatId));
    }

    @GetMapping("/sixNewItems/{rootCatId}")
    @ApiOperation(value = "「根據大分類ID獲取六件推薦商品」接口", notes = "根據大分類ID獲取六件推薦商品")
    public JsonResult getSixNewItems(@PathVariable long rootCatId) {
        return JsonResult.ok(itemService.getSixNewItems(rootCatId));
    }

}