package pers.dc.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pers.dc.bean.Items;
import pers.dc.bean.vo.SearchResultVO;
import pers.dc.bean.vo.ShopCartVO;
import pers.dc.bean.vo.SixItem;

import java.util.List;

public interface ItemDao extends JpaRepository<Items, String> {

    @Query("select new pers.dc.bean.vo.SixItem(i.itemName, i.id, img.url) from Items i left join ItemsImg img on i.id = img.itemId where i.rootCatId = ?1 order by i.sellCounts")
    List<SixItem> findSixByRootId(long id);

    @Query("select new pers.dc.bean.vo.SearchResultVO(i.id, img.url, i.itemName, spec.priceDiscount, i.sellCounts) from Items i, ItemsSpec spec, ItemsImg img where i.id = spec.itemId and i.id = img.itemId and (i.itemName like %:keyword% or i.content like %:keyword%) order by i.updatedTime desc ")
    Page<SearchResultVO> findSearchResultSortByDefault(@Param("keyword") String keyword, Pageable pageable);

    @Query("select new pers.dc.bean.vo.SearchResultVO(i.id, img.url, i.itemName, spec.priceDiscount, i.sellCounts) from Items i, ItemsSpec spec, ItemsImg img where i.id = spec.itemId and i.id = img.itemId and (i.itemName like %:keyword% or i.content like %:keyword%) order by i.sellCounts desc")
    Page<SearchResultVO> findSearchResultSortBySellCounts(@Param("keyword") String keyword, Pageable pageable);

    @Query("select new pers.dc.bean.vo.SearchResultVO(i.id, img.url, i.itemName, spec.priceDiscount, i.sellCounts) from Items i, ItemsSpec spec, ItemsImg img where i.id = spec.itemId and i.id = img.itemId and (i.itemName like %:keyword% or i.content like %:keyword%) order by spec.priceDiscount asc ")
    Page<SearchResultVO> findSearchResultSortByPrice(@Param("keyword") String keyword, Pageable pageable);

    @Query("select new pers.dc.bean.vo.ShopCartVO(spec.itemId, img.url, items.itemName, spec.id, spec.name, spec.priceDiscount, spec.priceNormal) from ItemsSpec spec, ItemsImg img, Items items where spec.id = ?1 and spec.itemId = items.id and spec.itemId = img.itemId and img.isMain = 1")
    ShopCartVO findNewItemInfoForShopCartByItemSpecId(String itemSpecId);

    @Query("select new pers.dc.bean.vo.SearchResultVO(i.id, img.url, i.itemName, spec.priceDiscount, i.sellCounts) from Items i, ItemsSpec spec, ItemsImg img where i.id = spec.itemId and i.id = img.itemId and i.catId = ?1 order by i.updatedTime desc ")
    Page<SearchResultVO> findSearchResultByCatIdSortByDefault(long catId, Pageable pageable);

    @Query("select new pers.dc.bean.vo.SearchResultVO(i.id, img.url, i.itemName, spec.priceDiscount, i.sellCounts) from Items i, ItemsSpec spec, ItemsImg img where i.id = spec.itemId and i.id = img.itemId and i.catId = ?1 order by i.sellCounts desc")
    Page<SearchResultVO> findSearchResultByCatIdSortBySellCounts(long catId, Pageable pageable);

    @Query("select new pers.dc.bean.vo.SearchResultVO(i.id, img.url, i.itemName, spec.priceDiscount, i.sellCounts) from Items i, ItemsSpec spec, ItemsImg img where i.id = spec.itemId and i.id = img.itemId and i.catId = ?1 order by spec.priceDiscount asc ")
    Page<SearchResultVO> findSearchResultByCatIdSortByPrice(long catId, Pageable pageable);

    Items findOneById(String id);
}
