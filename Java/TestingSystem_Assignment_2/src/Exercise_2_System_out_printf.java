import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Exercise_2_System_out_printf {
    public static void main(String[] args) {
        // Question 1:
        //Khai báo 1 số nguyên = 5 và sử dụng lệnh System out printf để in ra số nguyên đó
        System.out.println("\n Question 1:");
        System.out.println("Khai báo 1 số nguyên = 5 và sử dụng lệnh System out printf để in ra số nguyên đó");
        int Question1 = 5;
        System.out.println("Số nguyên đó = " + Question1);

        // Question 2:
        //Khai báo 1 số nguyên = 100 000 000 và sử dụng lệnh System out printf để in
        //ra số nguyên đó thành định dạng như sau: 100,000,000
        System.out.println("\n Question 2:");
        System.out.println("Khai báo 1 số nguyên = 100 000 000 và sử dụng lệnh System out printf để in " +
                "\n ra số nguyên đó thành định dạng như sau: 100,000,000");

        Locale localeEN = new Locale("en", "EN");
        NumberFormat en = NumberFormat.getInstance(localeEN);
        long longNumber1 = 100000000;
        String str2 = en.format(longNumber1);
        System.out.println("Số " + longNumber1 + " sau khi định dạng = " + str2);

        // Question 3:
        //Khai báo 1 số thực = 5,567098 và sử dụng lệnh System out printf để in ra số
        //thực đó chỉ bao gồm 4 số đằng sau
        System.out.println("\n Question 3:");
        System.out.println("Khai báo 1 số thực = 5,567098 và sử dụng lệnh System out printf để in ra số " +
                "\n thực đó chỉ bao gồm 4 số đằng sau");
        double doubleNumber1 = 5.567098;
        System.out.printf("Đổi 5.567098 thành %5.4f", 5.567098);

        // Question 4:
        //Khai báo Họ và tên của 1 học sinh và in ra họ và tên học sinh đó theo định dạng như sau:
        // Họ và tên: "Nguyễn Văn A" thì sẽ in ra trên console như sau:
        //Tên tôi là "Nguyễn Văn A" và tôi đang độc thân.
        System.out.println("\n Question 4:");
        String HoTen = "Nguyễn Trung Quân";
        System.out.println("Tên tôi là " + HoTen + " và tôi đang độc thân.");

        // Question 5:
        //Lấy thời gian bây giờ và in ra theo định dạng sau:
        //24/04/2020 11h:16p:20s
        System.out.println("\n Question 5:");
        System.out.println("Lấy thời gian bây giờ và in ra theo định dạng sau: 24/04/2020 11h:16p:20s");
        Date date = new Date();
        System.out.printf("%tm/%td/%tY ",date,date,date);
        System.out.printf("%tHh:%tMp:%tSs",date,date,date);

        // Question 6:
        //In ra thông tin account (như Question 8 phần FOREACH) theo định dạng
        //table (giống trong Database)
        // Create Department
        Department department1 = new Department();
        department1.id = 1;
        department1.name = "Sale";

        Department department2 = new Department();
        department2.id = 2;
        department2.name = "Marketing";

        Department department3 = new Department();
        department3.id = 3;
        department3.name = "Bảo Vệ";

        // Create Position
        Position position1 = new Position();
        position1.id = 1;
        position1.positionName = Position.PositionName.PM;

        Position position2 = new Position();
        position2.id = 2;
        position2.positionName = Position.PositionName.DEV;

        Position position3 = new Position();
        position3.id = 3;
        position3.positionName = Position.PositionName.TEST;

        Position position4 = new Position();
        position4.id = 4;
        position4.positionName = Position.PositionName.SCRUM_MASTER;

        // Create Account
        Account account1 = new Account();
        account1.id = 1;
        account1.email = "taoquan178@gmail.com";
        account1.name = "Quân";
        account1.fullName = "Nguyễn Trung Quân";
        account1.department = department1;
        account1.position = position1;
        account1.createDate = LocalDate.of(2021,5,5);

        Account account2 = new Account();
        account2.id = 2;
        account2.email = "trunghieu88@gmail.com";
        account2.name = "Hiếu";
        account2.fullName = "Nguyễn Trung Hiếu";
        account2.department = department2;
        account2.position = position2;
        account2.createDate = LocalDate.of(2020,6,6);

        Account account3 = new Account();
        account3.id = 3;
        account3.email = "thutrang123@gmail.com";
        account3.name = "trang";
        account3.fullName = "Nguyễn Thu Trang";
        account3.department = department3;
        account3.position = position3;
        account3.createDate = LocalDate.of(2021,8,8);

        System.out.println("\n Question 6");
        System.out.println("In ra thông tin account (như Question 8 phần FOREACH) theo định dạng\n" +
                "table (giống trong Database)");
        Account[] accounts = {account1, account2, account3};
        System.out.printf("%s %6s %21s %12s %18s %11s %13s %n", "ID","Email","Name","FullName","Department","Position","CreateDate");
        for (Account account : accounts) {
            System.out.println(account.id+"   "+account.email+"   "+account.name+"   "+account.fullName+"   "+account.department.id+"           "+account.position.id+"          "+account.createDate);
        }

    }
}
