package Entity;

import java.util.ArrayList;
import java.util.Scanner;

public class TuyenSinh implements ITuyenSinh {
    private ArrayList<Student> studentList;
    public TuyenSinh(){
        studentList = new ArrayList<Student>();
    }
    @Override
    public void AddStudent(String name, String homeTown, int priority,String clazzName) {

        Student student = new Student(name, homeTown, priority, clazzName);
        studentList.add(student);
    }

    @Override
    public void ShowStudentAndClazz() {
        for ( Student student : studentList ){
            System.out.println(student);
        }
    }

    @Override
    public void SearchStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập code cần tìm: ");
        int code1 = scanner.nextInt();
        for ( Student student : studentList ){
            if (student.getCode() == code1){
                System.out.println(student);
            }
        }

    }

    @Override
    public String toString() {
        return "TuyenSinh{" +
                "studentList=" + studentList +
                '}';
    }
}
