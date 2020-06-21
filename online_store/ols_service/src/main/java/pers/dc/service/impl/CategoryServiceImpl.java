package pers.dc.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pers.dc.bean.Category;
import pers.dc.bean.vo.IndexSubCatVO;
import pers.dc.dao.CategoryDao;
import pers.dc.service.CategoryService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    final CategoryDao categoryDao;

    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Category> getAllHighestLevelCategory() {
        return categoryDao.findAllByType(1);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<IndexSubCatVO> getSubCatsWithFatherId(Long id) {
        List<IndexSubCatVO> res = new ArrayList<>();
        for (Category c : categoryDao.findAllByFatherId(id)) {
            IndexSubCatVO indexSubCatVO = new IndexSubCatVO();
            indexSubCatVO.setName(c.getName());
            indexSubCatVO.setSubCatList(categoryDao.findAllByFatherIdIntoSubCat(c.getId()));
            res.add(indexSubCatVO);
        }
        return res;
    }
}