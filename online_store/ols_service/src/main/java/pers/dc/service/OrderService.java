package pers.dc.service;

import pers.dc.bean.bo.OrderBO;

public interface OrderService {
    String createOrder(OrderBO orderBO);
    void deliveryReceived();
}
