package pers.dc.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pers.dc.bean.Category;
import pers.dc.bean.vo.SixItem;
import pers.dc.bean.vo.SixItemVO;
import pers.dc.dao.CategoryDao;
import pers.dc.dao.ItemDao;
import pers.dc.service.ItemService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    final ItemDao itemDao;
    final CategoryDao categoryDao;

    public ItemServiceImpl(ItemDao itemDao, CategoryDao categoryDao) {
        this.itemDao = itemDao;
        this.categoryDao = categoryDao;
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
}
