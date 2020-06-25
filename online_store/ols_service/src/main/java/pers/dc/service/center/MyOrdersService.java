package pers.dc.service.center;

import org.springframework.data.domain.Page;
import pers.dc.bean.vo.center.OrderStatusCountVO;
import pers.dc.bean.vo.center.OrderTrendVO;
import pers.dc.bean.vo.center.OrderVO;

public interface MyOrdersService {
    OrderStatusCountVO getOrderStatusCount(String userId);
    Page<OrderTrendVO> getOrderTrends(String userId, int page, int pageSize);
    Page<OrderVO> getOrderByUserIdAndStatus(String userId, Long orderStatus, int page, int pageSize);
}
