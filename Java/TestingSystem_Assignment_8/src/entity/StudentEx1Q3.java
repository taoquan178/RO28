package entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StudentEx1Q3 implements Comparable<StudentEx1Q3> {
    Scanner scanner = new Scanner(System.in);
    private int id;
    private String name;
    private static int COUNT = 0;
    private List<StudentEx1Q3> studentEx1Q3s; ;


    public StudentEx1Q3() {
        studentEx1Q3s = new ArrayList<>();
    }

    public StudentEx1Q3(String name) {
        COUNT++;
        this.id = COUNT;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addStudentEx1Q3(){
        System.out.println("Nhập vào số Student bạn muốn thêm: ");
        int Number = ScannerUtils.InputInt("Bạn phải nhập vào số");
        for (int i = 0; i < Number;i++){
            System.out.println("Mời bạn nhập vào tên Student: ");
            String nameStudent = ScannerUtils.InputString("Bạn phải nhập vào chuỗi");
            StudentEx1Q3 studentEx1Q3 = new StudentEx1Q3(nameStudent);
            studentEx1Q3s.add(studentEx1Q3);
            System.out.println("Thêm thành công Student "+ (i+1));
        }
    }

    public void showStudentEx1Q3(){
        for (int i =0;i<studentEx1Q3s.size();i++){
            System.out.println(studentEx1Q3s.get(i));
        }
    }

    public void studentEx1Q3Dissimilarity(){
        List<StudentEx1Q3> dissimilarityStudent = new ArrayList<>();
        for (int i =0;i< studentEx1Q3s.size();i++ ){
            if (!dissimilarityStudent.contains(studentEx1Q3s.get(i))){
                dissimilarityStudent.add(studentEx1Q3s.get(i));
            }
        }

        for(int i=0; i<dissimilarityStudent.size() ;i++){

            for (int j =i+1 ; j < dissimilarityStudent.size();j++){

                if (dissimilarityStudent.get(i).getName().equals(dissimilarityStudent.get(j).getName())){
                    dissimilarityStudent.remove(j);
                }
            }
        }

        studentEx1Q3s.clear();
        studentEx1Q3s.addAll(dissimilarityStudent);
    }

    public void sortNamedStudent(){
        Collections.sort(studentEx1Q3s);
    }
    public void totalElement(){
        System.out.println("Tổng số phần tử: "+ studentEx1Q3s.size());
    }
    @Override
    public String toString() {
        return "StudentEx1Q3{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(StudentEx1Q3 o) {
        return this.name.compareTo(o.getName());
    }
}
