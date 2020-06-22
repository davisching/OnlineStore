package pers.dc.enums;

public enum CommentRanking {
    GOOD(1),
    NORMAL(2),
    BAD(3);

    final long value;

    CommentRanking(int value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }
}
