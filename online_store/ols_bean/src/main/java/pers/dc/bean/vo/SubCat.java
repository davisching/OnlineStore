package pers.dc.bean.vo;

import pers.dc.bean.Category;

import javax.persistence.Entity;
import javax.persistence.Id;

public class SubCat extends Category {

    String subName;
    long subId;

    public SubCat() {}

    public SubCat(String subName, long subId) {
        this.subName = subName;
        this.subId = subId;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public long getSubId() {
        return subId;
    }

    public void setSubId(long subId) {
        this.subId = subId;
    }

    @Override
    public String toString() {
        return "SubCat{" +
                "subName='" + subName + '\'' +
                ", subId='" + subId + '\'' +
                '}';
    }
}
