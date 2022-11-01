package entity;

public class HighSchoolStudent extends  Student_Ex5{
    private String clazz;
    private String desiredUniversity;

    public HighSchoolStudent() {
    }

    public HighSchoolStudent(int id, String name, String clazz, String desiredUniversity) {
        super(id, name);
        this.clazz = clazz;
        this.desiredUniversity = desiredUniversity;
    }

    @Override
    public String toString() {
        return "Student_Ex5{" +
                "id=" + super.getId() +
                '}'+
                "Person{" +
                "name='" + super.getName() + '\'' +
                '}'+
                "HighSchoolStudent{" +
                "clazz='" + clazz + '\'' +
                ", desiredUniversity='" + desiredUniversity + '\'' +
                '}';
    }
}
