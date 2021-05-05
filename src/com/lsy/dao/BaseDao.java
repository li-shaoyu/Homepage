package com.lsy.dao;

/**
 * @ClassName BaseDao
 * @Description 用于定义数据操作对象的 存取标准
 * @date 2021/5/1 10:36
 * @Version 1.0
 * @Param <T> 操作的数据类型：用户的基本信息、学历信息、工作经验、特长、技能列表
 */
public interface BaseDao<T> {

    /**
     * @author lsy
     * @description:  用于规范存储
     * @date: 2021/5/1 14:23
     * @param:  t  要存储的数据
     * @return:  存储的结果，大于0表示成功
     * @version 1.0
     */
    int insert(T t);

    /**
     * @author lsy
     * @description:  用于规范获取
     * @date: 2021/5/1 14:24
     * @param:  userId  基于用户的编号，查询数据
     * @return:  基于用户的编号，查询到的数据：用户基本信息、学历信息等
     * @version 1.0
     */
    T findByUserId(int userId);
}
