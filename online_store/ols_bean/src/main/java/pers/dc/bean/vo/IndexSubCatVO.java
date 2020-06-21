package pers.dc.bean.vo;

import pers.dc.bean.Category;

import javax.persistence.*;
import java.util.List;


public class IndexSubCatVO {

    private long id;
    private String name;

    private List<SubCat> subCatList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubCat> getSubCatList() {
        return subCatList;
    }

    public void setSubCatList(List<SubCat> subCatList) {
        this.subCatList = subCatList;
    }

    @Override
    public String toString() {
        return "IndexSubCatVO{" +
                "name='" + name + '\'' +
                ", subCatList=" + subCatList +
                '}';
    }
}