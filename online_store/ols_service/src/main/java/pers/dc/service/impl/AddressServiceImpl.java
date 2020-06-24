package pers.dc.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pers.dc.bean.UserAddress;
import pers.dc.bean.bo.AddressBO;
import pers.dc.dao.AddressDao;
import pers.dc.service.AddressService;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class AddressServiceImpl implements AddressService {

    final AddressDao addressDao;

    public AddressServiceImpl(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<UserAddress> getAddressByUserId(String userId) {
        return addressDao.findAllByUserId(userId);
    }

    @Override
    @Transactional
    public UserAddress addAddress(UserAddress userAddress) {
        userAddress.setId(UUID.randomUUID().toString());
        userAddress.setCreatedTime(new Date());
        userAddress.setUpdatedTime(new Date());
        UserAddress defaultOne = addressDao.findByUserIdAndIsDefault(userAddress.getUserId(), 1);
        if (defaultOne == null)
            userAddress.setIsDefault(1);
        else
            userAddress.setIsDefault(0);
        return addressDao.save(userAddress);
    }

    @Override
    @Transactional
    public UserAddress updateAddress(AddressBO addressBO) {
        UserAddress userAddress = addressDao.getOne(addressBO.getAddressId());
        userAddress.setUserId(addressBO.getUserId());
        userAddress.setReceiver(addressBO.getReceiver());
        userAddress.setMobile(addressBO.getMobile());
        userAddress.setProvince(addressBO.getProvince());
        userAddress.setCity(addressBO.getCity());
        userAddress.setDistrict(addressBO.getDistrict());
        userAddress.setDetail(addressBO.getDetail());
        userAddress.setUpdatedTime(new Date());
        return addressDao.save(userAddress);
    }

    @Override
    @Transactional
    public void deleteAddress(String userId, String addressId) {
        addressDao.deleteByUserIdAndId(userId, addressId);
    }

    @Override
    @Transactional
    public void setDefault(String userId, String addressId) {
        UserAddress defaultOne = addressDao.findByUserIdAndIsDefault(userId, 1);
        if (defaultOne != null) {
            defaultOne.setIsDefault(0);
            defaultOne.setUpdatedTime(new Date());
            addressDao.save(defaultOne);
        }
        UserAddress userAddress = addressDao.getOne(addressId);
        userAddress.setIsDefault(1);
        userAddress.setUpdatedTime(new Date());
        addressDao.save(userAddress);
    }
}
