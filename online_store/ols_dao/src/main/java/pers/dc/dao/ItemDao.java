package pers.dc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pers.dc.bean.Items;
import pers.dc.bean.vo.SixItem;

import java.util.List;

public interface ItemDao extends JpaRepository<Items, String> {

    @Query("select new pers.dc.bean.vo.SixItem(i.itemName, i.id, img.url) from Items i left join ItemsImg img on i.id = img.itemId where i.rootCatId = ?1 order by i.sellCounts")
    List<SixItem> findSixByRootId(long id);
}
