package pers.dc.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pers.dc.dao.StuDao;
import pers.dc.service.TestService;
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
    @Transactional
    public void addStu(Stu stu) {
        stuDao.save(stu);
    }

    @Override
    @Transactional
    public void updateStu(Stu stu) {
        stuDao.save(stu);
    }

    @Override
    @Transactional
    public void deleteStu(Long id) {
        stuDao.deleteById(id);
    }
}
