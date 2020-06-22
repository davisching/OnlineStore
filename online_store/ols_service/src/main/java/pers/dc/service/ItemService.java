package pers.dc.service;

import org.springframework.data.domain.Page;
import pers.dc.bean.ItemsComments;
import pers.dc.bean.vo.*;

import java.util.List;

public interface ItemService {
    List<SixItemVO> getSixNewItems(long rootCatId);
    ItemInfoVO getItemInfoById(String id);
    CommentCountsVO getCommentCountsByItemId(String itemId);
    Page<CommentRecordVO> getCommentsByItemId(String itemId, Long level, int page, int pageSize);
    Page<SearchResultVO> getSearchResult(String keywords, String sort, int page, int pageSize);
}
