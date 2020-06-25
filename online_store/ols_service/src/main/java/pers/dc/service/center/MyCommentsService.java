package pers.dc.service.center;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import pers.dc.bean.OrderItems;
import pers.dc.bean.vo.center.AddCommentBO;
import pers.dc.bean.vo.center.MyCommentVO;

import java.util.List;

public interface MyCommentsService {
    Page<MyCommentVO> getMyComments(String userId, int page, int pageSize);
    List<OrderItems> getPendingComment(String userId, String orderId);
    void addComment(String userId, String orderId, List<AddCommentBO> commentList);
}
