package entity;

public class Student {
    private int id;
    private String name;
    private String homeTown;
    private float diemHocLuc;

    public Student(String name, String homeTown) {
        this.name = name;
        this.homeTown = homeTown;
        this.diemHocLuc = 0;
    }

    public void setDiemHocLuc(float diemHocLuc) {
        this.diemHocLuc = diemHocLuc;
    }

    public void setCongDiemHocLuc(float diemHocLuc) {
        if ((this.diemHocLuc = this.diemHocLuc+diemHocLuc)<= 10){
            this.diemHocLuc = this.diemHocLuc;
            return;
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public float getDiemHocLuc() {
        return diemHocLuc;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", homeTown='" + homeTown + '\'' +
                ", diemHocLuc=" + diemHocLuc +
                '}';
    }
}
