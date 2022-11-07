package entity;

import java.io.Serializable;
import java.util.ArrayList;

public class StudentEx1 implements Serializable {
    private int id;

    private String name;

    public static String college;

    public static int moneyGroup = 0;

    public static int COUNT = 0;


    public StudentEx1() {

    }

    public StudentEx1( String name) {
        COUNT++;
        this.id = COUNT;
        this.name = name;
        college = "Đại học bách khoa";
    }

    public void payClass(int money){
            moneyGroup += money;
    }

    public void minusClassFund(int money){
        moneyGroup = moneyGroup - money;
        System.out.println("Tổng tiền quỹ lớp: "+moneyGroup);
    }


    public static String getCollege() {
        return college;
    }

    public  void setCollege(String college) {
        this.college = college;
    }

    public String getName() {
        return name;
    }

    public static int getMoneyGroup() {
        return moneyGroup;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name='" + name + ", college='" + college +'\'' + '}';
    }
}
