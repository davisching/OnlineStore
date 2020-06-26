package pers.dc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pers.dc.bean.OrderStatus;

import java.util.List;

public interface OrderStatusDao extends JpaRepository<OrderStatus, String> {
    OrderStatus findByOrderId(String orderId);
    List<OrderStatus> findByOrderStatus(long orderStatus);
}