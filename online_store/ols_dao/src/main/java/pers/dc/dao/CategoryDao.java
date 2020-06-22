package pers.dc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pers.dc.bean.Category;
import pers.dc.bean.vo.IndexSubCat;

import java.util.List;

public interface CategoryDao extends JpaRepository<Category, Long> {
    List<Category> findAllByType(long type);

    List<Category> findAllByFatherId(long fatherId);

    @Query("select new pers.dc.bean.vo.IndexSubCat(c.name, c.id) from Category c where c.fatherId = ?1")
    List<IndexSubCat> findSubCatByFatherId(long fatherId);
}