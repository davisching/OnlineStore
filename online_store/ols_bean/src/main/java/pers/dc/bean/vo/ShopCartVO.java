package pers.dc.bean.vo;

import pers.dc.bean.bo.ShopCartBO;

public class ShopCartVO extends ShopCartBO {

    public ShopCartVO(String itemId, String itemImgUrl, String itemName, String specId, String specName, long priceDiscount, long priceNormal) {
        this.setItemId(itemId);
        this.setItemImgUrl(itemImgUrl);
        this.setItemName(itemName);
        this.setSpecId(specId);
        this.setSpecName(specName);
        this.setPriceDiscount(priceDiscount);
        this.setPriceNormal(priceNormal);
    }
}
