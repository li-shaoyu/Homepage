package com.lsy.test;

import com.lsy.bean.Specialty;
import com.lsy.bean.User;
import com.lsy.dao.BaseDao;
import com.lsy.dao.SpecialtyDaoImp;
import com.lsy.dao.UserDaoImp;

/**
 * @ClassName SpecialtyTest
 * @Description TODO
 * @date 2021/5/5 14:15
 * @Param
 * @return
 */
public class SpecialtyTest {
    public static void main(String[] args) {
        BaseDao<Specialty> dao = new SpecialtyDaoImp();
        Specialty specialty = new Specialty(100,"测试一","特长测试");
        dao.insert(specialty);

    }
}
