package entity;

public abstract class Student_Ex5 extends Person {
    private int id;

    public Student_Ex5() {
    }
    public Student_Ex5(int id, String name) {
        super(name);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student_Ex5{" +
                "id=" + id +
                '}';
    }
}
