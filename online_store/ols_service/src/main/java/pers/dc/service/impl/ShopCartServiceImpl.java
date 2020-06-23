package pers.dc.service.impl;

import org.springframework.stereotype.Service;
import pers.dc.bean.bo.ShopCartBO;
import pers.dc.bean.vo.ShopCartVO;
import pers.dc.dao.ItemDao;
import pers.dc.service.ShopCartService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopCartServiceImpl implements ShopCartService {

    final ItemDao itemDao;

    public ShopCartServiceImpl(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    @Override
    public void addToShopCart(String userId, ShopCartBO shopCartBO) {

    }

    @Override
    public List<ShopCartVO> refresh(String itemSpecIds) {
        List<ShopCartVO> res = new ArrayList<>();
        for (String specId : itemSpecIds.split(","))
            res.add(itemDao.findNewItemInfoForShopCartByItemSpecId(specId));
        return res;
    }
}
