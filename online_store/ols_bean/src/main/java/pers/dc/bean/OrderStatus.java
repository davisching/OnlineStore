package pers.dc.bean;


public class OrderStatus {

  private String orderId;
  private long orderStatus;
  private java.sql.Timestamp createdTime;
  private java.sql.Timestamp payTime;
  private java.sql.Timestamp deliverTime;
  private java.sql.Timestamp successTime;
  private java.sql.Timestamp closeTime;
  private java.sql.Timestamp commentTime;


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


  public java.sql.Timestamp getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(java.sql.Timestamp createdTime) {
    this.createdTime = createdTime;
  }


  public java.sql.Timestamp getPayTime() {
    return payTime;
  }

  public void setPayTime(java.sql.Timestamp payTime) {
    this.payTime = payTime;
  }


  public java.sql.Timestamp getDeliverTime() {
    return deliverTime;
  }

  public void setDeliverTime(java.sql.Timestamp deliverTime) {
    this.deliverTime = deliverTime;
  }


  public java.sql.Timestamp getSuccessTime() {
    return successTime;
  }

  public void setSuccessTime(java.sql.Timestamp successTime) {
    this.successTime = successTime;
  }


  public java.sql.Timestamp getCloseTime() {
    return closeTime;
  }

  public void setCloseTime(java.sql.Timestamp closeTime) {
    this.closeTime = closeTime;
  }


  public java.sql.Timestamp getCommentTime() {
    return commentTime;
  }

  public void setCommentTime(java.sql.Timestamp commentTime) {
    this.commentTime = commentTime;
  }

}
