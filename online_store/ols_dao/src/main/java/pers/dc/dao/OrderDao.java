package pers.dc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pers.dc.bean.Orders;

import java.util.List;

public interface OrderDao extends JpaRepository<Orders, String> {

    @Query("select s.orderStatus from Orders o, OrderStatus s where o.userId = ?1 and o.id = s.orderId")
    List<Long> findStatusByUserId(String userId);
}
