package pers.dc.bean.vo;

import java.util.List;

public class IndexSubCatVO {

    private long id;
    private String name;

    private List<IndexSubCat> subCatList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<IndexSubCat> getSubCatList() {
        return subCatList;
    }

    public void setSubCatList(List<IndexSubCat> subCatList) {
        this.subCatList = subCatList;
    }
}