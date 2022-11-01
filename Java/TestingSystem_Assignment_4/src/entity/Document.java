package entity;

public class Document {
    private int id;
    private String imprint;
    private int releaseNumber;

    public Document() {
    }

    public Document(int id, String imprint, int releaseNumber) {
        this.id = id;
        this.imprint = imprint;
        this.releaseNumber = releaseNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImprint() {
        return imprint;
    }

    public void setImprint(String imprint) {
        this.imprint = imprint;
    }

    public int getReleaseNumber() {
        return releaseNumber;
    }

    public void setReleaseNumber(int releaseNumber) {
        this.releaseNumber = releaseNumber;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", imprint='" + imprint + '\'' +
                ", releaseNumber=" + releaseNumber +
                '}';
    }
}
