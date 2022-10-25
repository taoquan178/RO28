import java.time.LocalDate;
import java.util.Date;
import java.util.Arrays;

public class Exam {
    int id;
    String  code;
    String  title;
    CategoryQuestion categoryQuestion;
    int   duration;
    int     creatorID;
    LocalDate    createDate;
    Question[]  questions;

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", categoryQuestion=" + categoryQuestion +
                ", duration=" + duration +
                ", creatorID=" + creatorID +
                ", createDate=" + createDate +
                ", questions=" + Arrays.toString(questions) +
                '}';
    }
}
