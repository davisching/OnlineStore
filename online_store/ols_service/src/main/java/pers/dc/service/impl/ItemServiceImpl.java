package pers.dc.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pers.dc.bean.Category;
import pers.dc.bean.ItemsComments;
import pers.dc.bean.vo.*;
import pers.dc.dao.*;
import pers.dc.enums.CommentRanking;
import pers.dc.service.ItemService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    final CategoryDao categoryDao;
    final ItemDao itemDao;
    final ItemImgDao itemImgDao;
    final ItemSpecDao itemSpecDao;
    final ItemParamDao itemParamDao;
    final ItemCommentDao itemCommentDao;

    public ItemServiceImpl(ItemDao itemDao,
                           CategoryDao categoryDao,
                           ItemImgDao itemImgDao,
                           ItemSpecDao itemSpecDao,
                           ItemParamDao itemParamDao,
                           ItemCommentDao itemCommentDao) {
        this.itemDao = itemDao;
        this.categoryDao = categoryDao;
        this.itemImgDao = itemImgDao;
        this.itemSpecDao = itemSpecDao;
        this.itemParamDao = itemParamDao;
        this.itemCommentDao = itemCommentDao;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<SixItemVO> getSixNewItems(long rootCatId) {
        List<SixItemVO> res = new ArrayList<>();
        SixItemVO sixItemVO = new SixItemVO();
        Category c = categoryDao.findOneById(rootCatId);
        sixItemVO.setRootCatName(c.getName());
        sixItemVO.setSlogan(c.getSlogan());
        sixItemVO.setCatImage(c.getCatImage());
        List<SixItem> simpleItemList = new ArrayList<>();
        List<SixItem> items = itemDao.findSixByRootId(rootCatId);
        for (int i = 0; i < 6; i++)
            simpleItemList.add(items.get(i));
        sixItemVO.setSimpleItemList(simpleItemList);
        res.add(sixItemVO);
        return res;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public ItemInfoVO getItemInfoById(String id) {
        ItemInfoVO itemInfoVO = new ItemInfoVO();
        itemInfoVO.setItem(itemDao.getOne(id));
        itemInfoVO.setItemImgList(itemImgDao.findAllByItemId(id));
        itemInfoVO.setItemSpecList(itemSpecDao.findAllByItemId(id));
        itemInfoVO.setItemParams(itemParamDao.findByItemId(id));
        return itemInfoVO;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public CommentCountsVO getCommentCountsByItemId(String itemId) {
        CommentCountsVO res = new CommentCountsVO();
        int goodCounts = 0, normalCounts = 0, badCounts = 0;
        for (ItemsComments itemsComments : itemCommentDao.findAllByItemId(itemId)) {
            if (itemsComments.getCommentLevel() == CommentRanking.GOOD.getValue())
                goodCounts++;
            else if (itemsComments.getCommentLevel() == CommentRanking.NORMAL.getValue())
                normalCounts++;
            else if (itemsComments.getCommentLevel() == CommentRanking.BAD.getValue())
                badCounts++;
        }
        res.setGoodCounts(goodCounts);
        res.setNormalCounts(normalCounts);
        res.setBadCounts(badCounts);
        res.setTotalCounts(goodCounts + normalCounts + badCounts);
        return res;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Page<CommentRecordVO> getCommentsByItemId(String itemId, Long level, int page, int pageSize) {
        page -= 1;
        Page<CommentRecordVO> pages;
        if (level == null || level == 0)
            pages = itemCommentDao.findAllByItemId(itemId, PageRequest.of(page, pageSize));
        else
            pages = itemCommentDao.findAllByItemIdAndCommentLevel(itemId, level, PageRequest.of(page, pageSize));
        return pages;
    }

}