package frontend;
import entity.*;
import backend.*;
import static backend.Exercise_4_Encapsulation.*;
public class Program3 {
    public static void main(String[] args) {
        /**
         * Question 1:
         * Tạo Object Student có các property id, name, hometown, điểm học lực
         * a) Tất cả các property sẽ để là private để các class khác không
         * chỉnh sửa hay nhìn thấy
         * b) Tạo constructor cho phép khi khởi tạo mỗi student thì người
         * dùng sẽ nhập vào tên, hometown và có điểm học lực = 0
         * c) Tạo 1 method cho phép set điểm vào
         * d) Tạo 1 method cho phép cộng thêm điểm
         * e) Tạo 1 method để in ra thông tin của sinh viên bao gồm có tên,
         * điểm học lực ( nếu điểm <4.0 thì sẽ in ra là Yếu, nếu điểm >
         * 4.0 và < 6.0 thì sẽ in ra là trung bình, nếu điểm > 6.0 và < 8.0
         * thì sẽ in ra là khá, nếu > 8.0 thì in ra là Giỏi)
         * Demo các chức năng trên bằng class ở front-end.
         */
        System.out.println("Question 1");
        Student student1 = new Student("Nguyễn Trung Quân","Thạch Thất");
        System.out.println("\nTạo 1 method cho phép set điểm vào");
        Question1c(student1,5);
        System.out.println("\nTạo 1 method cho phép cộng thêm điểm");
        Question1d(student1,2);
        System.out.println("\n In thông tin tên và điểm the. < 4 yếu,4>6 trung bình, 6>8 khá,>8 giỏi ");
        Question1e(student1);

        //Question 2 (Optional):
        Date date1 = new Date(20,5,2022);
        date1.isLeapYear();

    }
}
