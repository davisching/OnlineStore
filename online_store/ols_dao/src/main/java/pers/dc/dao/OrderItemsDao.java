package pers.dc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pers.dc.bean.OrderItems;

import java.util.List;

public interface OrderItemsDao extends JpaRepository<OrderItems, String> {
    List<OrderItems> findAllByOrOrderId(String orderId);
}
