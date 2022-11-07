package fontend;
import backend.exercise2.Question1;
import entity.PrimaryStudentEx2;
import entity.SecondaryStudent;
import entity.SecondaryStudentEx2;
import entity.StudentEx2;

import static backend.exercise2.Question2.Question2;
import static backend.exercise2.Question3.Question3;
import static backend.exercise2.Question4.Question4;

public class Program2 {
    public static void main(String[] args) {
        System.out.println("Question 1");
        Question1 Ex2 = new Question1();
//        pi = 3.15; không thay đổi được
        Ex2.Question1();

        System.out.println("Question 2");
        Question2();

        System.out.println("Question 3");
        Question3();

        System.out.println("Question 4");
        Question4();

    }
}
