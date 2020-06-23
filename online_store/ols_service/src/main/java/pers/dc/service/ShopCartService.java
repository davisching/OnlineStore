package pers.dc.service;

import pers.dc.bean.bo.ShopCartBO;
import pers.dc.bean.vo.ShopCartVO;

import java.util.List;

public interface ShopCartService {
    void addToShopCart(String userId, ShopCartBO shopCartBO);
    List<ShopCartVO> refresh(String itemSpecIds);
}
