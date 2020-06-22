package pers.dc.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class ItemsSpec {

  @Id
  private String id;
  private String itemId;
  private String name;
  private long stock;
  private double discounts;
  private long priceDiscount;
  private long priceNormal;
  private Date createdTime;
  private Date updatedTime;

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


  public Date getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
  }

  public Date getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }
}
