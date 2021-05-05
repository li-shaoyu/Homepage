package com.lsy.bean;

import java.util.Objects;

/**
 * @ClassName Skill
 * @Description 技能实体类
 * @date 2021/5/5 17:51
 * @Param
 * @return
 */
public class Skill {
    // id
    private int id;
    // 用户编号
    private int userId;
    // 技能关键字
    private String keyWords;

    public Skill() {
    }

    public Skill(int userId, String keyWords) {
        this.userId = userId;
        this.keyWords = keyWords;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skill skill = (Skill) o;
        return id == skill.id &&
                userId == skill.userId &&
                Objects.equals(keyWords, skill.keyWords);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, keyWords);
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", userId=" + userId +
                ", keyWords='" + keyWords + '\'' +
                '}';
    }

    public Skill(int id, int userId, String keyWords) {
        this.id = id;
        this.userId = userId;
        this.keyWords = keyWords;
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

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }
}
