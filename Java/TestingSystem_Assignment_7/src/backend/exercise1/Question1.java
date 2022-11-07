package backend.exercise1;

import entity.StudentEx1;

public class Question1 {
    public void Question1(){
        System.out.println("Question 1");

        StudentEx1[] student = new StudentEx1[3];
        student[0] = new StudentEx1("Quân");
        student[1] = new StudentEx1("Hiếu");
        student[2] = new StudentEx1("Trang");
        for(StudentEx1 studentArray : student){
            System.out.println(studentArray);
        }
        StudentEx1.college = "Đại học công nghệ";
        for(StudentEx1 studentArray : student){
            System.out.println(studentArray);
        }




    }
}
