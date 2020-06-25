package pers.dc.service.center.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pers.dc.bean.vo.center.OrderStatusCountVO;
import pers.dc.bean.vo.center.OrderTrendVO;
import pers.dc.bean.vo.center.OrderVO;
import pers.dc.dao.OrderDao;
import pers.dc.dao.OrderItemsDao;
import pers.dc.service.center.MyOrdersService;

@Service
public class MyOrdersServiceImpl implements MyOrdersService {

    final OrderDao orderDao;
    final OrderItemsDao orderItemsDao;

    public MyOrdersServiceImpl(OrderDao orderDao, OrderItemsDao orderItemsDao) {
        this.orderDao = orderDao;
        this.orderItemsDao = orderItemsDao;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public OrderStatusCountVO getOrderStatusCount(String userId) {
        long waitPayCounts = 0, waitDeliverCounts = 0, waitReceiveCounts = 0, waitCommentCounts = 0;

        for (long status : orderDao.findStatusByUserId(userId)) {
            if (status == 10) waitPayCounts += 1;
            else if (status == 20) waitDeliverCounts += 1;
            else if (status == 30) waitReceiveCounts += 1;
            else waitCommentCounts += 1;
        }

        return new OrderStatusCountVO(waitPayCounts, waitDeliverCounts, waitReceiveCounts, waitCommentCounts);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Page<OrderTrendVO> getOrderTrends(String userId, int page, int pageSize) {
        return orderDao.findTrendByUserId(userId, PageRequest.of(--page, pageSize));
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Page<OrderVO> getOrderByUserIdAndStatus(String userId, Long orderStatus, int page, int pageSize) {
        Page<OrderVO> res;
        if (orderStatus == null || orderStatus == 0)
            res = orderDao.findOrdersByUserId(userId, PageRequest.of(--page, pageSize));
        else
            res = orderDao.findOrdersByUserIdWithOrderStatus(userId, orderStatus, PageRequest.of(--page, pageSize));
        res.forEach(order -> order.setSubOrderItemList(orderItemsDao.findAllByOrOrderId(order.getOrderId())));
        return res;
    }
}
