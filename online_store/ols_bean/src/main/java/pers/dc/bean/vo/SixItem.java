package pers.dc.bean.vo;

public class SixItem {
    private String itemName;
    private String itemId;
    private String itemUrl;

    public SixItem(String itemName, String itemId, String itemUrl) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.itemUrl = itemUrl;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemUrl() {
        return itemUrl;
    }

    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }
}
