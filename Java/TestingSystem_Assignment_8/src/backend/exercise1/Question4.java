package backend.exercise1;

import entity.StudentEx1Q3;

public class Question4 {
    public static void Question4(){
        StudentEx1Q3 studentEx1Q3 = new StudentEx1Q3();
        // Thêm Student
        studentEx1Q3.addStudentEx1Q3();
        // Show Student
        System.out.println("Student trước khi xoá lặp tên");
        studentEx1Q3.showStudentEx1Q3();
        // Remove Name Student Duplacation
        studentEx1Q3.studentEx1Q3Dissimilarity();
        // Show Student
        System.out.println("Student sau khi xoá lặp tên");
        studentEx1Q3.showStudentEx1Q3();
    }
}
