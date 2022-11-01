package entity;
import java.time.LocalDate;

public class Magazine extends Document{
    private int issueNumber;
    private LocalDate issueMonth;

    public Magazine(){

    }
    public Magazine(int id, String author, int issueNumber, int issueNumber1, LocalDate issueMonth) {
        super(id, author, issueNumber);
        this.issueNumber = issueNumber1;
        this.issueMonth = issueMonth;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    public LocalDate getIssueMonth() {
        return issueMonth;
    }

    public void setIssueMonth(LocalDate issueMonth) {
        this.issueMonth = issueMonth;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "issueNumber=" + issueNumber +
                ", issueMonth=" + issueMonth +
                '}'+
                "id="+ getId() +
                ", imprint='" + getImprint() + '\'' +
                ", releaseNumber=" + getReleaseNumber() +
                '}';
    }
}
