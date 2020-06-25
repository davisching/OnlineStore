package pers.dc.bean.vo.center;

import java.util.Date;

public class OrderTrendVO {

    private String orderId;
    private long orderStatus;
    private Date payTime;
    private Date deliverTime;
    private Date successTime;

    public OrderTrendVO(String orderId, long orderStatus, Date payTime, Date deliverTime, Date successTime) {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.payTime = payTime;
        this.deliverTime = deliverTime;
        this.successTime = successTime;
    }

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
}
