import java.time.LocalDate;
import java.util.Random;
public class Exercise_4_Random_Number {
    public static void main(String[] args) {
        // Question 1:
        //In ngẫu nhiên ra 1 số nguyên
        System.out.println("\n Question 1");
        System.out.println("In ngẫu nhiên ra 1 số nguyên");
        Random random = new Random();
        int x = random.nextInt();
        System.out.println(x);

        //Question 2:
        //In ngẫu nhiên ra 1 số thực
        System.out.println("\n Question 2");
        System.out.println("In ngẫu nhiên ra 1 số thực");
        float x1 = random.nextInt();
        System.out.println(x1);

        //Question 3:
        //Khai báo 1 array bao gồm các tên của các bạn trong lớp, sau đó in ngẫu nhiên ra tên của 1 bạn
        System.out.println("\n Question 3");
        System.out.println("Khai báo 1 array bao gồm các tên của các bạn trong lớp, sau đó in ngẫu nhiên ra tên của 1 bạn");
        String[] x2Array = {"Trung Quân","Văn Hiếu","Thu Trang","Văn Hậu","Minh Hà"};
        int x2 = random.nextInt(x2Array.length);
        System.out.println(x2Array[x2]);

        //Question 4:
        //Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 24-07-1995 tới ngày 20-12-1995
        System.out.println("\n Question 4");
        System.out.println("Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 24-07-1995 tới ngày 20-12-1995");
        int minDay = (int) LocalDate.of(1995,7,24).toEpochDay();
        int maxDay = (int) LocalDate.of(1995,12,20).toEpochDay();
        long randomInt =minDay + random.nextInt(maxDay-minDay);
        LocalDate randomDay = LocalDate.ofEpochDay(randomInt);
        System.out.println(minDay);
        System.out.println(maxDay);
        System.out.println(randomDay);

        //Question 5:
        //Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 1 năm trở lại đây
        System.out.println("\n Question 5");
        System.out.println("Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 1 năm trở lại đây");
        int now = (int) LocalDate.now().toEpochDay();
        int randomDate = now - random.nextInt(365);
        LocalDate reusultDate = LocalDate.ofEpochDay(randomDate);
        System.out.println(reusultDate);

        //Question 6:
        //Lấy ngẫu nhiên 1 ngày trong quá khứ
        System.out.println("\n Question 6");
        System.out.println("Lấy ngẫu nhiên 1 ngày trong quá khứ");
        int dateNow = (int) LocalDate.now().toEpochDay();
        long randomDate1 = random.nextInt(dateNow);
        System.out.println(randomDate1);
        LocalDate reusultDate1 = LocalDate.ofEpochDay(randomDate1);
        System.out.println(reusultDate1);

        //Question 7:
        //Lấy ngẫu nhiên 1 số có 3 chữ số
        System.out.println("\n Question 7");
        System.out.println("Lấy ngẫu nhiên 1 số có 3 chữ số");
        int x7 = random.nextInt(1000);
        if ( 1000 > x7 || x7 >= 100 ){
            System.out.println(x7);
        }





    }
}
