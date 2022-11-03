package Entity;
import Entity.ScannerUtils1;

public class Department {
    private int id;
    private String name;

    public Department() {
        input();
    }

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Question 9
    private void input() {
        System.out.println("Nhập id : ");
        id = ScannerUtils1.inputInt1("Please input a id as int, please input again.");

        System.out.println("Nhập tên : ");
        name = ScannerUtils1.inputString("Please input a name, please input again.");
    }

    @Override
    public String toString() {
        return "Department{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
