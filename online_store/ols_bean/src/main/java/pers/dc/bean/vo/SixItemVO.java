package pers.dc.bean.vo;

import java.util.List;

public class SixItemVO {
    private String rootCatName;
    private String slogan;
    private String catImage;
    private List<SixItem> simpleItemList;

    public String getRootCatName() {
        return rootCatName;
    }

    public void setRootCatName(String rootCatName) {
        this.rootCatName = rootCatName;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getCatImage() {
        return catImage;
    }

    public void setCatImage(String catImage) {
        this.catImage = catImage;
    }

    public List<SixItem> getSimpleItemList() {
        return simpleItemList;
    }

    public void setSimpleItemList(List<SixItem> simpleItemList) {
        this.simpleItemList = simpleItemList;
    }


}