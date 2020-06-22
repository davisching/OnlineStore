package pers.dc.bean.vo;

public class CommentCountsVO {
    private int totalCounts;
    private int goodCounts;
    private int normalCounts;
    private int badCounts;

    public int getTotalCounts() {
        return totalCounts;
    }

    public void setTotalCounts(int totalCounts) {
        this.totalCounts = totalCounts;
    }

    public int getGoodCounts() {
        return goodCounts;
    }

    public void setGoodCounts(int goodCounts) {
        this.goodCounts = goodCounts;
    }

    public int getNormalCounts() {
        return normalCounts;
    }

    public void setNormalCounts(int normalCounts) {
        this.normalCounts = normalCounts;
    }

    public int getBadCounts() {
        return badCounts;
    }

    public void setBadCounts(int badCounts) {
        this.badCounts = badCounts;
    }
}
