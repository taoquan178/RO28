package entity;

public class Position {
    private int    id;
    private PositionName positionName;

    public enum PositionName {
        DEV, TEST, SCRUM_MASTER, PM
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PositionName getPositionName() {
        return positionName;
    }

    public void setPositionName(PositionName positionName) {
        this.positionName = positionName;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", positionName=" + positionName +
                '}';
    }
}
