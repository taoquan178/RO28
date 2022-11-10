package backend.exercise2;

import entity.exercise2.Student;

public class Question2 {
    public static void Question2Method() {
        Student student = new Student("Nguyễn Văn A");
        System.out.println("Student vừa tạo là: " + student);
        System.out.println("id của người đó là: ");
        System.out.println("sử dụng phương thức getId cũ: "+ student.getId());
        System.out.println("sử dụng phương thức getIdV2 mới: "+student.getIdV2());
    }
}
