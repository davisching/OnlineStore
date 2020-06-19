package pers.dc.bean;


public class Carousel {

  private String id;
  private String imageUrl;
  private String backgroundColor;
  private String itemId;
  private String catId;
  private long type;
  private long sort;
  private long isShow;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }


  public String getBackgroundColor() {
    return backgroundColor;
  }

  public void setBackgroundColor(String backgroundColor) {
    this.backgroundColor = backgroundColor;
  }


  public String getItemId() {
    return itemId;
  }

  public void setItemId(String itemId) {
    this.itemId = itemId;
  }


  public String getCatId() {
    return catId;
  }

  public void setCatId(String catId) {
    this.catId = catId;
  }


  public long getType() {
    return type;
  }

  public void setType(long type) {
    this.type = type;
  }


  public long getSort() {
    return sort;
  }

  public void setSort(long sort) {
    this.sort = sort;
  }


  public long getIsShow() {
    return isShow;
  }

  public void setIsShow(long isShow) {
    this.isShow = isShow;
  }


  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }


  public java.sql.Timestamp getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(java.sql.Timestamp updateTime) {
    this.updateTime = updateTime;
  }

}
