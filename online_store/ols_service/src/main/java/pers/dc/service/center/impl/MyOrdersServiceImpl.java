package pers.dc.service.center.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pers.dc.bean.vo.center.OrderStatusCountVO;
import pers.dc.bean.vo.center.OrderTrendVO;
import pers.dc.dao.OrderDao;
import pers.dc.service.center.MyOrdersService;

@Service
public class MyOrdersServiceImpl implements MyOrdersService {

    final OrderDao orderDao;

    public MyOrdersServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
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
}
