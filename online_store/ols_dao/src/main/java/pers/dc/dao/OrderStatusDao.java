package pers.dc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pers.dc.bean.OrderStatus;

public interface OrderStatusDao extends JpaRepository<OrderStatus, String> {
    OrderStatus findByOrderId(String orderId);
}