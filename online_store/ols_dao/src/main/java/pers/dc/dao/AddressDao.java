package pers.dc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pers.dc.bean.UserAddress;

import java.util.List;

public interface AddressDao extends JpaRepository<UserAddress, String> {
    List<UserAddress> findAllByUserId(String userId);
    void deleteByUserIdAndId(String userId, String id);
    UserAddress findByUserIdAndIsDefault(String userId, long isDefault);
}
