package pers.dc.bean.vo.center;

public class AddCommentBO {

    private String commentId;
    private String itemId;
    private String itemName;
    private String itemSpecName;
    private String itemSpecId;
    private long commentLevel;
    private String content;

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemSpecName() {
        return itemSpecName;
    }

    public void setItemSpecName(String itemSpecName) {
        this.itemSpecName = itemSpecName;
    }

    public String getItemSpecId() {
        return itemSpecId;
    }

    public void setItemSpecId(String itemSpecId) {
        this.itemSpecId = itemSpecId;
    }

    public long getCommentLevel() {
        return commentLevel;
    }

    public void setCommentLevel(long commentLevel) {
        this.commentLevel = commentLevel;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "AddCommentBO{" +
                "commentId='" + commentId + '\'' +
                ", itemId='" + itemId + '\'' +
                ", itemName='" + itemName + '\'' +
                ", itemSpecName='" + itemSpecName + '\'' +
                ", itemSpecId='" + itemSpecId + '\'' +
                ", commentLevel=" + commentLevel +
                ", content='" + content + '\'' +
                '}';
    }
}
