package pers.dc.service;

import org.springframework.data.domain.Page;
import pers.dc.bean.ItemsComments;
import pers.dc.bean.vo.CommentCountsVO;
import pers.dc.bean.vo.CommentRecordVO;
import pers.dc.bean.vo.ItemInfoVO;
import pers.dc.bean.vo.SixItemVO;

import java.util.List;

public interface ItemService {
    List<SixItemVO> getSixNewItems(long rootCatId);
    ItemInfoVO getItemInfoById(String id);
    CommentCountsVO getCommentCountsByItemId(String itemId);
    Page<CommentRecordVO> getCommentsByItemId(String itemId, Long level, int page, int pageSize);
}
