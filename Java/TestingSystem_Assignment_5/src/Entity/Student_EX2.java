package Entity;

import java.util.ArrayList;
import java.util.Scanner;

public class Student_EX2 implements IStudent {
    //id, name, group(int)
    private int id;
    private  String name;
    private int group;
    private ArrayList<Student_EX2> student_EX2_List;
    public static int COUNT =0;

    public Student_EX2() {
        student_EX2_List = new ArrayList<>();
    }

    public Student_EX2(String name, int group) {
        COUNT++;
        this.id = COUNT;
        this.name = name;
        this.group = group;
    }

    public void addStudent_Ex2(String name, int group){
            Student_EX2 student_ex2 = new Student_EX2(name, group);
            student_EX2_List.add(student_ex2);
    }

    @Override
    public void DiemDanh() {
        for(Student_EX2 student : student_EX2_List){
            System.out.println(student.name + " Điểm Danh");
        }
    }

    @Override
    public void HocBai() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Gọi nhóm nào đi học bài: ");
        int choice = scanner.nextInt();
        switch(choice){
            case 1:
                for(Student_EX2 student : student_EX2_List){
                    if (student.group == 1){
                        System.out.println(student.name + " đang học bài");
                    }
                }
                break;
            case 2:
                for(Student_EX2 student : student_EX2_List){
                    if (student.group == 2){
                        System.out.println(student.name + " đang học bài");
                    }
                }
                break;
            case 3:
                for(Student_EX2 student : student_EX2_List){
                    if (student.group == 3){
                        System.out.println(student.name + " đang học bài");
                    }
                }
                break;
            default:
                System.out.println("Mời bạn nhập lại");
        }
    }

    @Override
    public void DiDonVeSinh() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Gọi nhóm nào đi dọn vệ sinh: ");
        int choice = scanner.nextInt();
        switch(choice){
            case 1:
                for(Student_EX2 student : student_EX2_List){
                    if (student.group == 1){
                        System.out.println(student.name + " đang dọn vệ sinh");
                    }
                }
                break;
            case 2:
                for(Student_EX2 student : student_EX2_List){
                    if (student.group == 2){
                        System.out.println(student.name + " đang dọn vệ sinh");
                    }
                }
                break;
            case 3:
                for(Student_EX2 student : student_EX2_List){
                    if (student.group == 3){
                        System.out.println(student.name + " đang dọn vệ sinh");
                    }
                }
                break;
            default:
                System.out.println("Mời bạn nhập lại");
        }
    }
}
