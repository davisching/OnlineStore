package pers.dc.bean;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderItems {

  @Id
  private String id;
  private String orderId;
  private String itemId;
  private String itemImg;
  private String itemName;
  private String itemSpecId;
  private String itemSpecName;
  private long price;
  private long buyCounts;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }


  public String getItemId() {
    return itemId;
  }

  public void setItemId(String itemId) {
    this.itemId = itemId;
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


  public String getItemSpecId() {
    return itemSpecId;
  }

  public void setItemSpecId(String itemSpecId) {
    this.itemSpecId = itemSpecId;
  }


  public String getItemSpecName() {
    return itemSpecName;
  }

  public void setItemSpecName(String itemSpecName) {
    this.itemSpecName = itemSpecName;
  }


  public long getPrice() {
    return price;
  }

  public void setPrice(long price) {
    this.price = price;
  }


  public long getBuyCounts() {
    return buyCounts;
  }

  public void setBuyCounts(long buyCounts) {
    this.buyCounts = buyCounts;
  }

}
