package pers.dc.service.center;

import org.springframework.data.domain.Page;
import pers.dc.bean.vo.center.OrderStatusCountVO;
import pers.dc.bean.vo.center.OrderTrendVO;

public interface MyOrdersService {
    OrderStatusCountVO getOrderStatusCount(String userId);
    Page<OrderTrendVO> getOrderTrends(String userId, int page, int pageSize);
}
