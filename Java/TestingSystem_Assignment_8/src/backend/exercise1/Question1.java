package backend.exercise1;

import entity.ScannerUtils;
import entity.Student;

import java.util.*;

public class Question1 {
    private static Scanner scanner = new Scanner(System.in);
    public static void List(){
        List<Student> studentsList = new ArrayList<>();
        studentsList.add(new Student("Quân"));
        studentsList.add(new Student("Quân"));
        studentsList.add(new Student("Quân"));
        studentsList.add(new Student("Cường"));
        studentsList.add(new Student("Minh"));
        studentsList.add(new Student("Cường"));

        for(Student student : studentsList){
            System.out.println("ID: "+student.getId() + " - Name: "+student.getName());
        }

        System.out.println("Tổng số phần tử có trong list là: " + studentsList.size());
        System.out.println("\nPhần tử thứ 4 trong list là: "+ studentsList.get(3));
        int lastStudentList = studentsList.size();
        System.out.println("\nPhần tử đầu và phần tử cuối trong list là: \n"
                +"Student đầu: " +studentsList.get(0)
                + "\nStudent cuối: "+ studentsList.get(lastStudentList-1));
        studentsList.add(0,new Student("Trang"));
        System.out.println("\nThêm 1 phần tử vào vị trí đầu: " + studentsList.get(0));
        System.out.println("Thêm 1 phần tử vào vị trí cuối: " + studentsList.add(new Student("Hiếu")));

        for(Student student : studentsList){
            System.out.println("ID: "+student.getId() + " - Name: "+student.getName());
        }

        System.out.println("Đảo ngược vị trí của list: ");
        Collections.reverse(studentsList);
        System.out.println("Sau khi đảo");
        for(Student student : studentsList){
            System.out.println("ID: "+student.getId() + " - Name: "+student.getName());
        }

        SearchIDStudentList(studentsList);
        SearchNameStudentList(studentsList);
        nameStudentDuplicate(studentsList);

        System.out.println("\nXoá tên Student có id = 2");
        for(Student student : studentsList){
            if (student.getId() == 2){
                student.setName(null);
            }
        }
        for(Student student : studentsList){
            System.out.println(student);
        }

        System.out.println("\nXoá Student có id = 5");
        for (int i=0;i<studentsList.size();i++){
            if(studentsList.get(i).getId() == 5){
                studentsList.remove(i);
            }
        }
        for(Student student : studentsList){
            System.out.println(student);
        }

        System.out.println("Tạo 1 ArrayList tên là studentCopies và add tất cả students vào studentCopies ");
        ArrayList<Student> studentCopies = new ArrayList<>();
//        studentCopies = (ArrayList<Student>) ((ArrayList<Student>) studentsList).clone();
//        for (Student student : studentCopies){
//            System.out.println(student);
//        }
        Collections.copy(studentsList, studentCopies);
        for (Student student : studentCopies){
            System.out.println(student);
        }

    }

    public static void SearchIDStudentList(List<Student> studentsList){
        System.out.println("Nhập vào id Student bạn muốn tìm: ");
        int searchID = ScannerUtils.InputInt("Bạn phải nhập vào số!");
        if ( searchID >= 0 && searchID < studentsList.size()-1){
            for(Student student : studentsList){
                if (searchID == student.getId()){
                    System.out.println(student);
                }
            }
        }else {
            System.err.println("Không có Student nào có ID bằng "+ searchID+"!");
        }
    }

    public static void SearchNameStudentList(List<Student> studentsList){
        System.out.println("Nhập vào name Student bạn muốn tìm: ");
        String searchName = ScannerUtils.InputString("Bạn phải nhập vào chuỗi!");

        for(Student student : studentsList){
            if (searchName.equals(student.getName())){
                System.out.println(student);
            }
        }
    }

    public static void nameStudentDuplicate(List<Student> studentsList){
        for(int i=0; i<studentsList.size() ;i++){
            for (int j =i+1 ; j < studentsList.size();j++){
                if (studentsList.get(i).getName().equals(studentsList.get(j).getName())){
                    System.out.println(studentsList.get(i));
                }
            }
        }
    }
}
