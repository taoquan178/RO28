package backend.exercise2;

import entity.PrimaryStudentEx2;
import entity.SecondaryStudentEx2;

public class Question3 {
    public static void Question3(){
        PrimaryStudentEx2 primaryStudentEx2 = new PrimaryStudentEx2("Quân1");
        SecondaryStudentEx2 secondaryStudentEx2 = new SecondaryStudentEx2("Quân2");
        System.out.println("PrimaryStudentEx2 "+primaryStudentEx2);
        PrimaryStudentEx2.study();
        System.out.println("SecondaryStudentEx2 "+secondaryStudentEx2);
        SecondaryStudentEx2.study();
    }
}
