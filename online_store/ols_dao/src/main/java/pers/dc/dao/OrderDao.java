package pers.dc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pers.dc.bean.Orders;

public interface OrderDao extends JpaRepository<Orders, String> {
}
