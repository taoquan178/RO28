package backend.exercise2;

import java.util.Date;

public class Question1 {
    private Date date;

    @Deprecated
    public static void Question1Deprecated(){
        Question1 question1 = new Question1();
        question1.date = new Date(2020,5,18);
    }
}
