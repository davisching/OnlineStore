package pers.dc.bean;


public class ItemsImg {

  private String id;
  private String itemId;
  private String url;
  private long sort;
  private long isMain;
  private java.sql.Timestamp createdTime;
  private java.sql.Timestamp updatedTime;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getItemId() {
    return itemId;
  }

  public void setItemId(String itemId) {
    this.itemId = itemId;
  }


  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }


  public long getSort() {
    return sort;
  }

  public void setSort(long sort) {
    this.sort = sort;
  }


  public long getIsMain() {
    return isMain;
  }

  public void setIsMain(long isMain) {
    this.isMain = isMain;
  }


  public java.sql.Timestamp getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(java.sql.Timestamp createdTime) {
    this.createdTime = createdTime;
  }


  public java.sql.Timestamp getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(java.sql.Timestamp updatedTime) {
    this.updatedTime = updatedTime;
  }

}
