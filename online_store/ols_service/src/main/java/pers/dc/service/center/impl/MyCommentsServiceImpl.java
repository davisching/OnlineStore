package pers.dc.service.center.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pers.dc.bean.ItemsComments;
import pers.dc.bean.OrderItems;
import pers.dc.bean.Orders;
import pers.dc.bean.vo.center.AddCommentBO;
import pers.dc.bean.vo.center.MyCommentVO;
import pers.dc.dao.ItemCommentDao;
import pers.dc.dao.OrderDao;
import pers.dc.dao.OrderItemsDao;
import pers.dc.service.center.MyCommentsService;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class MyCommentsServiceImpl implements MyCommentsService {

    final ItemCommentDao itemCommentDao;
    final OrderItemsDao orderItemsDao;
    final OrderDao orderDao;

    public MyCommentsServiceImpl(ItemCommentDao itemCommentDao, OrderItemsDao orderItemsDao, OrderDao orderDao) {
        this.itemCommentDao = itemCommentDao;
        this.orderItemsDao = orderItemsDao;
        this.orderDao = orderDao;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Page<MyCommentVO> getMyComments(String userId, int page, int pageSize) {
        return itemCommentDao.findMyComment(userId, PageRequest.of(--page, pageSize));
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<OrderItems> getPendingComment(String userId, String orderId) {
        return orderItemsDao.findAllByOrOrderId(orderId);
    }

    @Override
    @Transactional
    public void addComment(String userId, String orderId, List<AddCommentBO> commentList) {
        for (AddCommentBO comment : commentList) {
            ItemsComments itemsComments = new ItemsComments();
            itemsComments.setId(UUID.randomUUID().toString());
            itemsComments.setUserId(userId);
            itemsComments.setItemId(comment.getItemId());
            itemsComments.setItemName(comment.getItemName());
            itemsComments.setItemSpecId(comment.getItemSpecId());
            itemsComments.setSepcName(comment.getItemSpecName());
            itemsComments.setCommentLevel(comment.getCommentLevel());
            itemsComments.setContent(comment.getContent());
            itemsComments.setCreatedTime(new Date());
            itemsComments.setUpdatedTime(new Date());
            itemCommentDao.save(itemsComments);
        }

        Orders order = orderDao.findOneById(orderId);
        order.setIsComment(1);
        order.setUpdatedTime(new Date());
        orderDao.save(order);
    }

}
