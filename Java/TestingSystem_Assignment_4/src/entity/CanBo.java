package entity;

import java.util.ArrayList;

public class CanBo {
    private String name;
    private int age;
    private Gender gender;
    private String homeTown;

    public enum Gender{
        NAM , NU, UNKNOWN
    }
    public CanBo(String name, int age, Gender gender, String homeTown) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.homeTown = homeTown;
    }

    public CanBo(){

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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    @Override
    public String toString() {
        return "CanBo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", homeTown='" + homeTown + '\'' +
                '}';
    }
}
