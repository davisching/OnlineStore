package pers.dc.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pers.dc.bean.OrderStatus;
import pers.dc.bean.Orders;
import pers.dc.bean.vo.center.OrderTrendVO;
import pers.dc.bean.vo.center.OrderVO;

import java.util.List;

public interface OrderDao extends JpaRepository<Orders, String> {

    @Query("select s.orderStatus from Orders o, OrderStatus s where o.userId = ?1 and o.id = s.orderId and o.isDelete = 0")
    List<Long> findStatusByUserId(String userId);

    @Query("select new pers.dc.bean.vo.center.OrderTrendVO(o.id, s.orderStatus, s.payTime, s.deliverTime, s.successTime) from Orders o, OrderStatus s where o.userId = ?1 and o.id = s.orderId and (s.orderStatus = 20 or s.orderStatus = 30 or s.orderStatus = 40) order by o.updatedTime desc")
    Page<OrderTrendVO> findTrendByUserId(String userId, Pageable pageable);

    @Query("select new pers.dc.bean.vo.center.OrderVO(o.id, s.createdTime, o.payMethod, o.realPayAmount, o.postAmount, s.orderStatus, o.isComment) from Orders o, OrderStatus s where o.userId = ?1 and o.id = s.orderId and s.orderStatus = ?2 and o.isDelete = 0 order by o.updatedTime desc")
    Page<OrderVO> findOrdersByUserIdWithOrderStatus(String userId, long orderStatus, Pageable pageable);

    @Query("select new pers.dc.bean.vo.center.OrderVO(o.id, s.createdTime, o.payMethod, o.realPayAmount, o.postAmount, s.orderStatus, o.isComment) from Orders o, OrderStatus s where o.userId = ?1 and o.id = s.orderId and o.isDelete = 0 order by o.updatedTime desc")
    Page<OrderVO> findOrdersByUserId(String userId, Pageable pageable);

    Orders findOneById(String id);
}
