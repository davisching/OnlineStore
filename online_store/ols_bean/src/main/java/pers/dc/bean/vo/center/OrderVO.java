package pers.dc.bean.vo.center;

import pers.dc.bean.OrderItems;

import java.util.Date;
import java.util.List;

public class OrderVO {
    private String orderId;
    private Date createdTime;
    private long payMethod;
    private long realPayAmount;
    private long postAmount;
    private long orderStatus;
    private long isComment;
    private List<OrderItems> subOrderItemList;

    public OrderVO(String orderId, Date createdTime, long payMethod, long realPayAmount, long postAmount, long orderStatus, long isComment) {
        this.orderId = orderId;
        this.createdTime = createdTime;
        this.payMethod = payMethod;
        this.realPayAmount = realPayAmount;
        this.postAmount = postAmount;
        this.orderStatus = orderStatus;
        this.isComment = isComment;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public long getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(long payMethod) {
        this.payMethod = payMethod;
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

    public long getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(long orderStatus) {
        this.orderStatus = orderStatus;
    }

    public long getIsComment() {
        return isComment;
    }

    public void setIsComment(long isComment) {
        this.isComment = isComment;
    }

    public List<OrderItems> getSubOrderItemList() {
        return subOrderItemList;
    }

    public void setSubOrderItemList(List<OrderItems> subOrderItemList) {
        this.subOrderItemList = subOrderItemList;
    }
}
