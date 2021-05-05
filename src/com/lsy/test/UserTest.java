package com.lsy.test;

import com.lsy.bean.User;
import com.lsy.dao.BaseDao;
import com.lsy.dao.UserDaoImp;

/**
 * @ClassName UserTest
 * @Description TODO
 * @date 2021/5/5 19:33
 * @Param
 * @return
 */
public class UserTest {
    public static void main(String[] args) {
        BaseDao<User> dao = new UserDaoImp();
        User user = new User("测试四", 24, "广东", "dasda", "dasda", "dsada", "dsada", "dsadas", "dsada", "dasda", "dsad");
        int id = dao.insert(user);
        System.out.println(id);
    }
}
