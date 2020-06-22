package pers.dc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pers.dc.bean.ItemsSpec;

import java.util.List;

public interface ItemSpecDao extends JpaRepository<ItemsSpec, String> {
    List<ItemsSpec> findAllByItemId(String itemId);
}
