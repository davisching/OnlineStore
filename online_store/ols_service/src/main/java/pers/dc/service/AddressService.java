package pers.dc.service;

import pers.dc.bean.UserAddress;
import pers.dc.bean.bo.AddressBO;

import java.util.List;

public interface AddressService {
    List<UserAddress> getAddressByUserId(String userId);
    UserAddress addAddress(UserAddress userAddress);
    UserAddress updateAddress(AddressBO addressBO);
    void deleteAddress(String userId, String addressId);
    void setDefault(String userId, String addressId);
}
