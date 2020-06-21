package pers.dc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pers.dc.bean.Users;

@Repository
public interface UserDao extends JpaRepository<Users, String> {
       Users findOneByUsername(String username);
}