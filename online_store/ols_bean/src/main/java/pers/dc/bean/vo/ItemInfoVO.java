package pers.dc.bean.vo;

import pers.dc.bean.Items;
import pers.dc.bean.ItemsImg;
import pers.dc.bean.ItemsParam;
import pers.dc.bean.ItemsSpec;

import java.util.List;

public class ItemInfoVO {
    Items item;
    List<ItemsImg> itemImgList;
    List<ItemsSpec> itemSpecList;
    ItemsParam itemParams;

    public Items getItem() {
        return item;
    }

    public void setItem(Items item) {
        this.item = item;
    }

    public List<ItemsImg> getItemImgList() {
        return itemImgList;
    }

    public void setItemImgList(List<ItemsImg> itemImgList) {
        this.itemImgList = itemImgList;
    }

    public List<ItemsSpec> getItemSpecList() {
        return itemSpecList;
    }

    public void setItemSpecList(List<ItemsSpec> itemSpecList) {
        this.itemSpecList = itemSpecList;
    }

    public ItemsParam getItemParams() {
        return itemParams;
    }

    public void setItemParams(ItemsParam itemParams) {
        this.itemParams = itemParams;
    }
}
