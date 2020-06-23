package pers.dc.enums;

public enum OrderStatusEnum {
    WAIT_PAY(10), PAID(20), DELIVERED(30), SUCCESS(40), CLOSED(50);
    final long value;
    OrderStatusEnum(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }
}
