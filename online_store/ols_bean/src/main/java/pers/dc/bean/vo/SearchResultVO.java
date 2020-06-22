package pers.dc.bean.vo;

public class SearchResultVO {
    private String itemId;
    private String imgUrl;
    private String itemName;
    private long price;
    private long sellCounts;

    public SearchResultVO(String itemId, String imgUrl, String itemName, long price, long sellCounts) {
        this.itemId = itemId;
        this.imgUrl = imgUrl;
        this.itemName = itemName;
        this.price = price;
        this.sellCounts = sellCounts;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getSellCounts() {
        return sellCounts;
    }

    public void setSellCounts(long sellCounts) {
        this.sellCounts = sellCounts;
    }
}
