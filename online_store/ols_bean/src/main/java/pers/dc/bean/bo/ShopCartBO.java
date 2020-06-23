package pers.dc.bean.bo;

public class ShopCartBO {
    private String itemId;
    private String itemImgUrl;
    private String itemName;
    private String specId;
    private String specName;
    private long buyCounts;
    private long priceDiscount;
    private long priceNormal;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemImgUrl() {
        return itemImgUrl;
    }

    public void setItemImgUrl(String itemImgUrl) {
        this.itemImgUrl = itemImgUrl;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getSpecId() {
        return specId;
    }

    public void setSpecId(String specId) {
        this.specId = specId;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public long getBuyCounts() {
        return buyCounts;
    }

    public void setBuyCounts(long buyCounts) {
        this.buyCounts = buyCounts;
    }

    public long getPriceDiscount() {
        return priceDiscount;
    }

    public void setPriceDiscount(long priceDiscount) {
        this.priceDiscount = priceDiscount;
    }

    public long getPriceNormal() {
        return priceNormal;
    }

    public void setPriceNormal(long priceNormal) {
        this.priceNormal = priceNormal;
    }
}
