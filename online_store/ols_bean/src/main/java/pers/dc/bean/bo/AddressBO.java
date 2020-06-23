package pers.dc.bean.bo;

import pers.dc.bean.UserAddress;

public class AddressBO extends UserAddress {
    private String addressId;

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }
}
