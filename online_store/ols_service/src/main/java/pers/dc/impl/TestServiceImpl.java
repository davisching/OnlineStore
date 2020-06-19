package pers.dc.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pers.dc.StuDao;
import pers.dc.TestService;
import pers.dc.bean.Stu;

@Service
public class TestServiceImpl implements TestService {

    final StuDao stuDao;

    public TestServiceImpl(StuDao stuDao) {
        this.stuDao = stuDao;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Stu getStuInfoById(Long id) {
        return stuDao.getOne(id);
    }

    @Override
    public void addStu(Stu stu) {

    }

    @Override
    public void updateStu(Stu stu) {

    }

    @Override
    public void deleteStu(Long id) {

    }
}
