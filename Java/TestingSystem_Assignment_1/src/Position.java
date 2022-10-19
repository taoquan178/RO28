public class Position {
    int    id;
    PositionName positionName;

    public enum PositionName {
        DEV, TEST, SCRUM_MASTER, PM
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", positionName=" + positionName +
                '}';
    }
}
