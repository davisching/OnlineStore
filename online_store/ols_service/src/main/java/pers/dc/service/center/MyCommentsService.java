package pers.dc.service.center;

import org.springframework.data.domain.Page;
import pers.dc.bean.vo.center.MyCommentVO;

public interface MyCommentsService {
    Page<MyCommentVO> getMyComments(String userId, int page, int pageSize);
}
