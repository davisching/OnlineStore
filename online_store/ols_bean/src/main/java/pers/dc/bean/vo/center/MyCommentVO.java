package pers.dc.bean.vo.center;

import java.util.Date;

public class MyCommentVO {
    private String itemImg;
    private String itemName;
    private String content;
    private String specName;
    private Date createdTime;

    public MyCommentVO(String itemImg, String itemName, String content, String specName, Date createdTime) {
        this.itemImg = itemImg;
        this.itemName = itemName;
        this.content = content;
        this.specName = specName;
        this.createdTime = createdTime;
    }

    public String getItemImg() {
        return itemImg;
    }

    public void setItemImg(String itemImg) {
        this.itemImg = itemImg;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}
