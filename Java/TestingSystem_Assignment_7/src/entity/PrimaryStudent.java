package entity;

import java.util.ArrayList;

public class PrimaryStudent {
    private int id;

    private String name;

    public static int COUNT = 0;

    private ArrayList<PrimaryStudent> primaryStudentList;

    public PrimaryStudent(){
        primaryStudentList = new ArrayList<>();
    }

    public PrimaryStudent( String name) {
        COUNT++;
        this.id = COUNT;
        this.name = name;
    }

    public void addPrimaryStudent(String name){
        PrimaryStudent primaryStudent = new PrimaryStudent(name);
        primaryStudentList.add(primaryStudent);
    }

    public int showPrimaryStudent(){
        int a =0;
        for (PrimaryStudent ps1 : primaryStudentList){
            System.out.println(ps1);
            a++;
        }
        System.out.println("Tổng số lượng PrimaryStudent đã tạo là: "+ a);
        return a;

    }

    @Override
    public String toString() {
        return "PrimaryStudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
