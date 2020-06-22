package pers.dc.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Items {

  @Id
  private String id;
  private String itemName;
  private long catId;
  private long rootCatId;
  private long sellCounts;
  private long onOffStatus;
  private String content;
  private Date createdTime;
  private Date updatedTime;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }


  public long getCatId() {
    return catId;
  }

  public void setCatId(long catId) {
    this.catId = catId;
  }


  public long getRootCatId() {
    return rootCatId;
  }

  public void setRootCatId(long rootCatId) {
    this.rootCatId = rootCatId;
  }


  public long getSellCounts() {
    return sellCounts;
  }

  public void setSellCounts(long sellCounts) {
    this.sellCounts = sellCounts;
  }


  public long getOnOffStatus() {
    return onOffStatus;
  }

  public void setOnOffStatus(long onOffStatus) {
    this.onOffStatus = onOffStatus;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
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
