package com.lsy.bean;

import java.util.Objects;

/**
 * @ClassName Info
 * @Description ⽤户简历信息实体类
 * @date 2021/5/5 17:59
 * @Param
 * @return
 */
public class Info {
    private User user;
    private Edu edu;
    private Skill skill;
    private Work work;
    private Specialty specialty;

    public Info(User user, Edu edu, Skill skill, Work work, Specialty specialty) {
        this.user = user;
        this.edu = edu;
        this.skill = skill;
        this.work = work;
        this.specialty = specialty;
    }

    public Info() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Info info = (Info) o;
        return Objects.equals(user, info.user) &&
                Objects.equals(edu, info.edu) &&
                Objects.equals(skill, info.skill) &&
                Objects.equals(work, info.work) &&
                Objects.equals(specialty, info.specialty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, edu, skill, work, specialty);
    }

    @Override
    public String toString() {
        return "Info{" +
                "user=" + user +
                ", edu=" + edu +
                ", skill=" + skill +
                ", work=" + work +
                ", specialty=" + specialty +
                '}';
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Edu getEdu() {
        return edu;
    }

    public void setEdu(Edu edu) {
        this.edu = edu;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }
}
