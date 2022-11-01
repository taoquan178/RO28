package entity;

public class Book extends Document{
    private String author;
    private int numberOfPages;

    public Book(){

    }

    public Book(int id, String author, int issueNumber, String author1, int numberOfPages) {
        super(id, author, issueNumber);
        this.author = author1;
        this.numberOfPages = numberOfPages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", numberOfPages=" + numberOfPages +
                '}'+"Document{" +
                "id=" + getId() +
                ", imprint='" + getImprint() + '\'' +
                ", releaseNumber=" + getReleaseNumber() +
                '}';
    }
}
