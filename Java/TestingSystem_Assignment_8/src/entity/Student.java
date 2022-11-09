package entity;

public class Student implements Comparable<Student>  {
    private int id;
    private String name;
    private static int COUNT = 1;

    public Student(String name) {
        this.id = COUNT;
        this.name = name;
        COUNT++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return 0;
    }
}
