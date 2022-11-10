package entity.exercise2;

public class Student {
    private int id;
    private String name;
    private  static int COUNT = 0;

    public Student() {
    }

    public Student( String name) {
        COUNT++;
        this.id = COUNT;
        this.name = name;
    }

    /**
     *
     * @return id
     * @Deprecated replaced by {@link #getIdV2()}
     */
    @Deprecated
    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public String getIdV2() {
        return "MSV: " + id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
