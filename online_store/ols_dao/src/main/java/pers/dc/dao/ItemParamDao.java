package pers.dc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pers.dc.bean.ItemsParam;

import java.util.List;

public interface ItemParamDao extends JpaRepository<ItemsParam, String> {
    ItemsParam findByItemId(String itemId);
}
