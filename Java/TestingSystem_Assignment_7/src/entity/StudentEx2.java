package entity;

public class StudentEx2 {
     public final int ID = 1;
     public String name;

    public StudentEx2() {
    }

    public StudentEx2(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void study(){
         System.out.println("Đang học bài...");
     }

    @Override
    public String toString() {
        return "Student_Ex2{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                '}';
    }

}
