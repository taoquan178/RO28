package Entity;

import java.util.Scanner;

public class Student_EX2_Q2 extends Person {
    private int id;
    private float gradeAvg;
    private String email;

    public int getId() {
        return id;
    }

    public float getGradeAvg() {
        return gradeAvg;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public void inputInfo() {
        Scanner sc = new Scanner(System.in);
        super.inputInfo();
        System.out.println("ID: ");
        this.id = sc.nextInt();
        System.out.println("GradeAvg: ");
        this.gradeAvg = sc.nextFloat();
        System.out.println("Email: ");
        this.email = sc.next();
    }
    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println(" id= " + getId() + ", gradeAvg=" + getGradeAvg() + ", email=" + getEmail() + "]");
    }
    public void Scholarship() {
        if (gradeAvg > 8){
            System.out.println("Student này có được học bổng");
        }else {
            System.out.println("Student này không được học bổng");
        }
    }

}
