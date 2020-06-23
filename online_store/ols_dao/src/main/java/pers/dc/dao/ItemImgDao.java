package pers.dc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pers.dc.bean.ItemsImg;

import java.util.List;

public interface ItemImgDao extends JpaRepository<ItemsImg, String> {
    List<ItemsImg> findAllByItemId(String itemId);
    ItemsImg findByItemIdAndIsMain(String itemId, long isMain);
}
