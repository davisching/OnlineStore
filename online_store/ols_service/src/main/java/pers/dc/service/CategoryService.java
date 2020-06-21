package pers.dc.service;

import pers.dc.bean.Category;
import pers.dc.bean.vo.IndexSubCatVO;

import java.util.List;

public interface CategoryService {
    List<Category> getAllHighestLevelCategory();
    List<IndexSubCatVO> getSubCatsWithFatherId(Long id);
}
