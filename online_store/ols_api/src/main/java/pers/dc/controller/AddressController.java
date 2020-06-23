package pers.dc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.dc.bean.UserAddress;
import pers.dc.bean.bo.AddressBO;
import pers.dc.service.AddressService;
import pers.dc.util.JsonResult;
import springfox.documentation.spring.web.json.Json;

@RestController
@RequestMapping("/address")
@Api(tags = "「訂單地址」相關接口")
public class AddressController {

    final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/list")
    @ApiOperation(value = "「根據用戶ID獲取訂單地址」接口", notes = "根據用戶ID獲取訂單地址")
    public JsonResult getAddressByUserId(String userId) {
        if (StringUtils.isBlank(userId))
            return JsonResult.errorMsg("id 不能為空");
        return JsonResult.ok(addressService.getAddressByUserId(userId));
    }

    @PostMapping("/add")
    @ApiOperation(value = "「新增訂單地址」接口", notes = "新增訂單地址")
    public JsonResult addAddress(@RequestBody UserAddress userAddress) {
        return JsonResult.ok(addressService.addAddress(userAddress));
    }

    @PostMapping("/update")
    @ApiOperation(value = "「修改訂單地址」接口", notes = "修改訂單地址")
    public JsonResult updateAddress(@RequestBody AddressBO addressBO) {
        return JsonResult.ok(addressService.updateAddress(addressBO));
    }

    @PostMapping("/delete")
    @ApiOperation(value = "「刪除訂單地址」接口", notes = "刪除訂單地址")
    public JsonResult deleteAddress(String userId, String addressId) {
        if (StringUtils.isBlank(userId) || StringUtils.isBlank(addressId))
            return JsonResult.errorMsg("輸入不能為空");
        addressService.deleteAddress(userId, addressId);
        return JsonResult.ok();
    }

    @PostMapping("/setDefalut")
    @ApiOperation(value = "「訂單地址設為默認」接口", notes = "訂單地址設為默認")
    public JsonResult setDefault(String userId, String addressId) {
        if (StringUtils.isBlank(userId) || StringUtils.isBlank(addressId))
            return JsonResult.errorMsg("輸入不能為空");
        addressService.setDefault(userId, addressId);
        return JsonResult.ok();
    }

}