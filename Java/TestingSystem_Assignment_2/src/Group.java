import java.time.LocalDate;
import java.util.Date;
import java.util.Arrays;

public class Group {
    int id;
    String  name;
    int creatorID;
    LocalDate    createDate;
    Account[]   accounts;

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creatorID=" + creatorID +
                ", createDate=" + createDate +
                ", accounts=" + Arrays.toString(accounts) +
                '}';
    }
}
