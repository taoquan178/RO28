import java.time.LocalDate;
import java.util.Arrays;


public class Account {
    int id;
    String  email;
    String  name;
    String  fullName;
    Department  department;
    Position    position;
    LocalDate    createDate;
    float luong;
    Group[] groups;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", department=" + department +
                ", position=" + position +
                ", createDate=" + createDate +
                ", luong=" + luong +
                ", groups=" + Arrays.toString(groups) +
                '}';
    }
}
