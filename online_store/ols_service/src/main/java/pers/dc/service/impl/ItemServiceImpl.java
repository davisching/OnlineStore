package pers.dc.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pers.dc.bean.Category;
import pers.dc.bean.vo.ItemInfoVO;
import pers.dc.bean.vo.SixItem;
import pers.dc.bean.vo.SixItemVO;
import pers.dc.dao.*;
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

    public ItemServiceImpl(ItemDao itemDao,
                           CategoryDao categoryDao,
                           ItemImgDao itemImgDao,
                           ItemSpecDao itemSpecDao, ItemParamDao itemParamDao) {
        this.itemDao = itemDao;
        this.categoryDao = categoryDao;
        this.itemImgDao = itemImgDao;
        this.itemSpecDao = itemSpecDao;
        this.itemParamDao = itemParamDao;
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
}
