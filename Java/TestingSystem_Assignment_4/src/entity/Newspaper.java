package entity;

import java.time.LocalDate;

public class Newspaper extends Document{
    private LocalDate releaseDate;

    public Newspaper(){

    }

    public Newspaper(int id, String author, int issueNumber, LocalDate releaseDate) {
        super(id, author, issueNumber);
        this.releaseDate = releaseDate;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Newspaper{" +
                "releaseDate=" + releaseDate +
                '}'+
                "id="+ getId() +
                ", imprint='" + getImprint() + '\'' +
                ", releaseNumber=" + getReleaseNumber() +
                '}';
    }
}
