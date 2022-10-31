package backend;
import entity.*;
public class Exercise_4_Encapsulation {
    public static void Question1c(Student student1,int diem ){
        student1.setDiemHocLuc(diem);
        System.out.println("set điểm vào Student1: \n"+student1);
    }
    public static void Question1d(Student student1,int congDiem ){
        student1.setCongDiemHocLuc(congDiem);
        System.out.println("Cộng thêm điểm cho Student1: \n"+student1);
    }
    public static void Question1e(Student student1 ){
        if(student1.getDiemHocLuc() < 4.0){
            System.out.println( "Tên SV: "+student1.getName()+"\n Điểm học lực: "+student1.getDiemHocLuc()+" Yếu");
        } else if (student1.getDiemHocLuc() >= 4.0 && student1.getDiemHocLuc() <6.0) {
            System.out.println( "Tên SV: "+student1.getName()+"\n Điểm học lực: "+student1.getDiemHocLuc()+" Trung Bình");

        } else if (student1.getDiemHocLuc() >= 6.0 && student1.getDiemHocLuc() < 8.0) {
            System.out.println( "Tên SV: "+student1.getName()+"\n Điểm học lực: "+student1.getDiemHocLuc()+" Khá");

        } else if (student1.getDiemHocLuc() >= 8.0) {
            System.out.println( "Tên SV: "+student1.getName()+"\n Điểm học lực: "+student1.getDiemHocLuc()+" Giỏi");

        }
    }

}
