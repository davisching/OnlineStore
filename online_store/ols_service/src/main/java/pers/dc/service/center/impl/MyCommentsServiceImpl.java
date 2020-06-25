package pers.dc.service.center.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pers.dc.bean.vo.center.MyCommentVO;
import pers.dc.dao.ItemCommentDao;
import pers.dc.service.center.MyCommentsService;

@Service
public class MyCommentsServiceImpl implements MyCommentsService {

    final ItemCommentDao itemCommentDao;

    public MyCommentsServiceImpl(ItemCommentDao itemCommentDao) {
        this.itemCommentDao = itemCommentDao;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Page<MyCommentVO> getMyComments(String userId, int page, int pageSize) {
        return itemCommentDao.findMyComment(userId, PageRequest.of(--page, pageSize));
    }
}
