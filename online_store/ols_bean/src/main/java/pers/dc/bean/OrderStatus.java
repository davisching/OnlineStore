package pers.dc.bean;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class OrderStatus {

  @Id
  private String orderId;
  private long orderStatus;
  private Date createdTime;
  private Date payTime;
  private Date deliverTime;
  private Date successTime;
  private Date closeTime;
  private Date commentTime;

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }


  public long getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(long orderStatus) {
    this.orderStatus = orderStatus;
  }

  public Date getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(Date createdTime) {
    this.createdTime = createdTime;
  }

  public Date getPayTime() {
    return payTime;
  }

  public void setPayTime(Date payTime) {
    this.payTime = payTime;
  }

  public Date getDeliverTime() {
    return deliverTime;
  }

  public void setDeliverTime(Date deliverTime) {
    this.deliverTime = deliverTime;
  }

  public Date getSuccessTime() {
    return successTime;
  }

  public void setSuccessTime(Date successTime) {
    this.successTime = successTime;
  }

  public Date getCloseTime() {
    return closeTime;
  }

  public void setCloseTime(Date closeTime) {
    this.closeTime = closeTime;
  }

  public Date getCommentTime() {
    return commentTime;
  }

  public void setCommentTime(Date commentTime) {
    this.commentTime = commentTime;
  }
}
