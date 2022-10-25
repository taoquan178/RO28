import java.time.LocalDate;
import java.util.Date;
import java.util.Arrays;

public class Question {
    int id;
    String  content;
    CategoryQuestion    categoryQuestion;
    TypeQuestion    typeQuestion;
    int creatorID;
    LocalDate    createDate;
    Exam[]  exams;

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", categoryQuestion=" + categoryQuestion +
                ", typeQuestion=" + typeQuestion +
                ", creatorID=" + creatorID +
                ", createDate=" + createDate +
                ", exams=" + Arrays.toString(exams) +
                '}';
    }
}
