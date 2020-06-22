package pers.dc.bean.vo;

public class IndexSubCat {

    String subName;
    long subId;

    public IndexSubCat() {}

    public IndexSubCat(String subName, long subId) {
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
}
