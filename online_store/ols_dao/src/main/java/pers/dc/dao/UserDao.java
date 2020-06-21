package pers.dc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pers.dc.bean.Users;

public interface UserDao extends JpaRepository<Users, String> {
       Users findOneByUsername(String username);
       Users findByUsernameAndPassword(String username, String password);
}