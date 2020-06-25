package pers.dc.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pers.dc.bean.Orders;
import pers.dc.bean.vo.center.OrderTrendVO;

import java.util.List;

public interface OrderDao extends JpaRepository<Orders, String> {

    @Query("select s.orderStatus from Orders o, OrderStatus s where o.userId = ?1 and o.id = s.orderId")
    List<Long> findStatusByUserId(String userId);

    @Query("select new pers.dc.bean.vo.center.OrderTrendVO(o.id, s.orderStatus, s.payTime, s.deliverTime, s.successTime) from Orders o, OrderStatus s where o.userId = ?1 and o.id = s.orderId order by o.updatedTime desc")
    Page<OrderTrendVO> findTrendByUserId(String userId, Pageable pageable);
}
