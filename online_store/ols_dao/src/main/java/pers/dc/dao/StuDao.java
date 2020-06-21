package pers.dc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pers.dc.bean.Stu;

@Repository
public interface StuDao extends JpaRepository<Stu, Long> {

}
