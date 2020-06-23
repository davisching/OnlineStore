package pers.dc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pers.dc.bean.OrderItems;

public interface OrderItemsDao extends JpaRepository<OrderItems, String> {
}
