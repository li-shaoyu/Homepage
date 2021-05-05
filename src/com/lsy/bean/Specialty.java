package com.lsy.bean;

import java.util.Objects;

/**
 * @ClassName Specialty
 * @Description 特长实体类
 * @date 2021/5/5 9:32
 * @Param
 * @return
 */
public class Specialty {
    // ID
    private int id;
    // 用户编号
    private int userId;
    // 特长名称
    private String name;
    // 特长描述
    private String description;
    // 暂定：增加特长描述
    private Specialty next;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Specialty specialty = (Specialty) o;
        return id == specialty.id &&
                userId == specialty.userId &&
                Objects.equals(name, specialty.name) &&
                Objects.equals(description, specialty.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, name, description);
    }

    @Override
    public String toString() {
        return "Specialty{" +
                "id=" + id +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", next=" + next +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Specialty getNext() {
        return next;
    }

    public void setNext(Specialty next) {
        this.next = next;
    }
    // Specialty构造方法
    public Specialty() {
    }


    public Specialty(int id, int userId, String name, String description) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.description = description;
    }

    public Specialty(int userId, String name, String description) {
        this.userId = userId;
        this.name = name;
        this.description = description;
    }
}
