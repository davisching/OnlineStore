package pers.dc.service;

import pers.dc.bean.Stu;

public interface TestService {

    Stu getStuInfoById(Long id);
    void addStu(Stu stu);
    void updateStu(Stu stu);
    void deleteStu(Long id);
}
