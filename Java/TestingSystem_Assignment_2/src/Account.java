import java.util.Arrays;
import java.time.LocalDate;
import java.util.Date;


public class Account {
    int id;
    String  email;
    String  name;
    String  fullName;
    Department  department;
    Position    position;
    LocalDate    createDate;
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
                ", groups=" + Arrays.toString(groups) +
                '}';
    }
}
