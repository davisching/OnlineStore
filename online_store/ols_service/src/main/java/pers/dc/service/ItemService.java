package pers.dc.service;

import pers.dc.bean.vo.SixItemVO;

import java.util.List;

public interface ItemService {
    List<SixItemVO> getSixNewItems(long rootCatId);
}
