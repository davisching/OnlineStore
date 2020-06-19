package pers.dc.bean;


public class ItemsSpec {

  private String id;
  private String itemId;
  private String name;
  private long stock;
  private double discounts;
  private long priceDiscount;
  private long priceNormal;
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


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getStock() {
    return stock;
  }

  public void setStock(long stock) {
    this.stock = stock;
  }


  public double getDiscounts() {
    return discounts;
  }

  public void setDiscounts(double discounts) {
    this.discounts = discounts;
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
