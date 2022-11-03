package Entity;
import Entity.ScannerUtils1;

public class Position {
    private int id;
    private String name;

    public Position() {
        input();
    }

    public Position(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private void input() {
        System.out.println("Nhập id : ");
        id = ScannerUtils1.inputInt1("Please input a id as int, please input again.");

        System.out.println("Nhập tên : ");
        name = ScannerUtils1.inputString("Please input a name, please input again.");
    }

    @Override
    public String toString() {
        return "Position{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
