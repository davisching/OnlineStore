package pers.dc.bean.vo.center;

public class OrderStatusCountVO {

    private long waitPayCounts, waitDeliverCounts, waitReceiveCounts, waitCommentCounts;

    public long getWaitPayCounts() {
        return waitPayCounts;
    }

    public void setWaitPayCounts(long waitPayCounts) {
        this.waitPayCounts = waitPayCounts;
    }

    public long getWaitDeliverCounts() {
        return waitDeliverCounts;
    }

    public void setWaitDeliverCounts(long waitDeliverCounts) {
        this.waitDeliverCounts = waitDeliverCounts;
    }

    public long getWaitReceiveCounts() {
        return waitReceiveCounts;
    }

    public void setWaitReceiveCounts(long waitReceiveCounts) {
        this.waitReceiveCounts = waitReceiveCounts;
    }

    public long getWaitCommentCounts() {
        return waitCommentCounts;
    }

    public void setWaitCommentCounts(long waitCommentCounts) {
        this.waitCommentCounts = waitCommentCounts;
    }

    public OrderStatusCountVO(long waitPayCounts, long waitDeliverCounts, long waitReceiveCounts, long waitCommentCounts) {
        this.waitPayCounts = waitPayCounts;
        this.waitDeliverCounts = waitDeliverCounts;
        this.waitReceiveCounts = waitReceiveCounts;
        this.waitCommentCounts = waitCommentCounts;
    }
}
