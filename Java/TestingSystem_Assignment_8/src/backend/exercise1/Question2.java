package backend.exercise1;

import entity.ScannerUtils;
import entity.Student;

import java.util.*;

public class Question2 {
    public static void StackAndQueue(){
        Scanner scanner = new Scanner(System.in);
        Stack<Student> stackStudent = new Stack<>();
        Queue<Student> queueStudent = new LinkedList<>();
        System.out.println("Nhập vào số Student cần tạo");
        int numberStudent = ScannerUtils.InputInt("Bạn phải nhập vào là số");
        for (int i = 0; i < numberStudent; i++){
            System.out.print("Nhập vào tên Student: ");
            String studentName = ScannerUtils.InputString("Bạn phải nhập vào 1 chuỗi");
            stackStudent.add(new Student(studentName));
            queueStudent.add(new Student(studentName));
            System.out.println("Tạo thành công Student " + (i+1));
        }

        System.out.println("\nThứ tự tới của các học sinh theo thứ tự từ muộn nhất tới sớm nhất (gợi ý dùng Stack)");
        StackStudentMethod(stackStudent);

        System.out.println("\nThứ tự tới của các học sinh theo thứ tự sớm nhất tới muộn nhất (gợi ý dùng Queue)");
        QueueStudentMethod(queueStudent);
    }
    public static void StackStudentMethod(Stack<Student> stackStudent){
        System.out.println("=========================");
        int lengthStackStudent = stackStudent.size();
        for (int i = 0; i < lengthStackStudent; i++){
            System.out.println("Student: "+ stackStudent.pop());
        }
    }

    public static void QueueStudentMethod(Queue<Student> queueStudent){
        System.out.println("=========================");
        int lengthQueueStudent = queueStudent.size();
        for (int i = 0; i < lengthQueueStudent; i++){
            System.out.println("Student: "+ queueStudent.poll());
        }
    }

}
