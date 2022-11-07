package entity;

import java.util.ArrayList;

public class SecondaryStudent {
    private int id;

    private String name;

    public static int COUNT = 0;

    private ArrayList<SecondaryStudent> secondaryStudentsList;

    public SecondaryStudent(){
        secondaryStudentsList = new ArrayList<>();
    }

    public SecondaryStudent( String name) {
        COUNT++;
        this.id = COUNT;
        this.name = name;
    }

    public void addSecondaryStudent(String name){
        SecondaryStudent secondaryStudent = new SecondaryStudent(name);
        secondaryStudentsList.add(secondaryStudent);
    }

    public int showSecondaryStudent(){
        int a=0;
        for (SecondaryStudent ss1 : secondaryStudentsList){
            System.out.println(ss1);
            a++;
        }
        System.out.println("Tổng số lượng PrimaryStudent đã tạo là: "+ a);
        return a;
    }

    @Override
    public String toString() {
        return "SecondaryStudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

