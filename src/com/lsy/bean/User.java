package com.lsy.bean;

import java.util.Objects;

/**
 * @ClassName User
 * @Description 用户实体类bean，打包数据
 * @date 2021/5/1 10:18
 * @Version 1.0
 */
public class User {
    // 用户Id
    private int id;
    // 用户名称
    private String name;
    // 用户年龄
    private int age;
    // 用户城市
    private String city;
    // 用户地址
    private String address;
    // 用户邮箱
    private String email;
    // 用户电话
    private String phone;
    // 用户牛客网
    private String niuke;
    // 用户github
    private String github;
    // 用户CSDN
    private String CSDN;
    // 用户性别
    private String sex;
    // 个人介绍
    private String description;

    // 全参构造方法
    public User(int id, String name, int age, String city, String address, String email, String phone, String niuke, String github, String CSDN, String sex, String description) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.city = city;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.niuke = niuke;
        this.github = github;
        this.CSDN = CSDN;
        this.sex = sex;
        this.description = description;
    }

    // 无参构造方法
    public User() {
    }

    // 前端传来的参数,无ID
    public User(String name, int age, String city, String address, String email, String phone, String niuke, String github, String CSDN, String sex, String description) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.niuke = niuke;
        this.github = github;
        this.CSDN = CSDN;
        this.sex = sex;
        this.description = description;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", niuke='" + niuke + '\'' +
                ", github='" + github + '\'' +
                ", CSDN='" + CSDN + '\'' +
                ", sex='" + sex + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                age == user.age &&
                Objects.equals(name, user.name) &&
                Objects.equals(city, user.city) &&
                Objects.equals(address, user.address) &&
                Objects.equals(email, user.email) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(niuke, user.niuke) &&
                Objects.equals(github, user.github) &&
                Objects.equals(CSDN, user.CSDN) &&
                Objects.equals(sex, user.sex) &&
                Objects.equals(description, user.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, city, address, email, phone, niuke, github, CSDN, sex, description);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getniuke() {
        return niuke;
    }

    public void setniuke(String niuke) {
        this.niuke = niuke;
    }

    public String getgithub() {
        return github;
    }

    public void setgithub(String github) {
        this.github = github;
    }

    public String getCSDN() {
        return CSDN;
    }

    public void setCSDN(String CSDN) {
        this.CSDN = CSDN;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

