package pers.dc.enums;

public enum Gender {
    FEMALE(0), MALE(1), SECRET(2);

    private final int VALUE;

    Gender(int i) {
        VALUE = i;
    }

    public int getValue() {
        return VALUE;
    }
}
