package pers.dc.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class ItemsComments {

  @Id
  private String id;
  private String userId;
  private String itemId;
  private String itemName;
  private String itemSpecId;
  private String sepcName;
  private long commentLevel;
  private String content;
  private Date createdTime;
  private Date updatedTime;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }


  public String getItemId() {
    return itemId;
  }

  public void setItemId(String itemId) {
    this.itemId = itemId;
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


  public String getSepcName() {
    return sepcName;
  }

  public void setSepcName(String sepcName) {
    this.sepcName = sepcName;
  }


  public long getCommentLevel() {
    return commentLevel;
  }

  public void setCommentLevel(long commentLevel) {
    this.commentLevel = commentLevel;
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

  @Override
  public String toString() {
    return "ItemsComments{" +
            "id='" + id + '\'' +
            ", userId='" + userId + '\'' +
            ", itemId='" + itemId + '\'' +
            ", itemName='" + itemName + '\'' +
            ", itemSpecId='" + itemSpecId + '\'' +
            ", sepcName='" + sepcName + '\'' +
            ", commentLevel=" + commentLevel +
            ", content='" + content + '\'' +
            ", createdTime=" + createdTime +
            ", updatedTime=" + updatedTime +
            '}';
  }
}
