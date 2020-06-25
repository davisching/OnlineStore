package pers.dc.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Orders {

  @Id
  private String id;
  private String userId;
  private String receiverName;
  private String receiverMobile;
  private String receiverAddress;
  private long totalAmount;
  private long realPayAmount;
  private long postAmount;
  private long payMethod;
  private String leftMsg;
  private String extand;
  private long isComment;
  private long isDelete;
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


  public String getReceiverName() {
    return receiverName;
  }

  public void setReceiverName(String receiverName) {
    this.receiverName = receiverName;
  }


  public String getReceiverMobile() {
    return receiverMobile;
  }

  public void setReceiverMobile(String receiverMobile) {
    this.receiverMobile = receiverMobile;
  }


  public String getReceiverAddress() {
    return receiverAddress;
  }

  public void setReceiverAddress(String receiverAddress) {
    this.receiverAddress = receiverAddress;
  }


  public long getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(long totalAmount) {
    this.totalAmount = totalAmount;
  }


  public long getRealPayAmount() {
    return realPayAmount;
  }

  public void setRealPayAmount(long realPayAmount) {
    this.realPayAmount = realPayAmount;
  }


  public long getPostAmount() {
    return postAmount;
  }

  public void setPostAmount(long postAmount) {
    this.postAmount = postAmount;
  }


  public long getPayMethod() {
    return payMethod;
  }

  public void setPayMethod(long payMethod) {
    this.payMethod = payMethod;
  }


  public String getLeftMsg() {
    return leftMsg;
  }

  public void setLeftMsg(String leftMsg) {
    this.leftMsg = leftMsg;
  }


  public String getExtand() {
    return extand;
  }

  public void setExtand(String extand) {
    this.extand = extand;
  }


  public long getIsComment() {
    return isComment;
  }

  public void setIsComment(long isComment) {
    this.isComment = isComment;
  }


  public long getIsDelete() {
    return isDelete;
  }

  public void setIsDelete(long isDelete) {
    this.isDelete = isDelete;
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
    return "Orders{" +
            "id='" + id + '\'' +
            ", userId='" + userId + '\'' +
            ", receiverName='" + receiverName + '\'' +
            ", receiverMobile='" + receiverMobile + '\'' +
            ", receiverAddress='" + receiverAddress + '\'' +
            ", totalAmount=" + totalAmount +
            ", realPayAmount=" + realPayAmount +
            ", postAmount=" + postAmount +
            ", payMethod=" + payMethod +
            ", leftMsg='" + leftMsg + '\'' +
            ", extand='" + extand + '\'' +
            ", isComment=" + isComment +
            ", isDelete=" + isDelete +
            ", createdTime=" + createdTime +
            ", updatedTime=" + updatedTime +
            '}';
  }
}
