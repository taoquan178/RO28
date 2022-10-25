import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;
public class Exercise_5_Input_from_console {
    public static void main(String[] args) throws ParseException {
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

        // Create Group
        Group group1 = new Group();
        group1.id = 1;
        group1.name = "Testing System";
        group1.creatorID = 1;
        group1.createDate = LocalDate.of(2019,3,5); // Date
        group1.accounts = new  Account[5];
        group1.accounts[0] = account1;
        group1.accounts[1] = account2;

        Group group2 = new Group();
        group2.id = 2;
        group2.name = "Development";
        group2.creatorID = 2;
        group2.createDate = LocalDate.of(2020,3,7);
        group2.accounts = new  Account[5];
        group2.accounts[0] = account1;
        group2.accounts[1] = account3;

        Group group3 = new Group();
        group3.id = 3;
        group3.name = "VTI Sale 01";
        group3.creatorID = 1;
        group3.createDate = LocalDate.of(2020,3,9);
        group3.accounts = new  Account[5];
        group3.accounts[0] = account2;

        // Add Group array vào Account

        account1.groups = new Group[5];
        account1.groups[0] = group1;
        account1.groups[1] = group1;

        account2.groups = new Group[5];
        account2.groups[0] = group1;
        account2.groups[1] = group3;

        account3.groups = new Group[5];
        account3.groups[0] = group2;

        //Question 1:
        //Viết lệnh cho phép người dùng nhập 3 số nguyên vào chương trình
        System.out.println("\n Question 1");
        System.out.println("Viết lệnh cho phép người dùng nhập 3 số nguyên vào chương trình");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập vào 3 số nguyên");
        int so1 = scanner.nextInt();
        int so2 = scanner.nextInt();
        int so3 = scanner.nextInt();
        System.out.println("số vừa nhập vào là: "+so1+" , "+so2+" , "+so3);

        //Question 2:
        //Viết lệnh cho phép người dùng nhập 2 số thực vào chương trình
        System.out.println("\n Question 2");
        System.out.println("Viết lệnh cho phép người dùng nhập 2 số thực vào chương trình");
        float so4 = scanner.nextFloat();
        float so5 = scanner.nextFloat();
        System.out.println("số vừa nhập vào là: "+so4+" , "+so5);

        //Question 3:
        //Viết lệnh cho phép người dùng nhập họ và tên
        System.out.println("\n Question 3");
        System.out.println("Viết lệnh cho phép người dùng nhập họ và tên");
        System.out.print("Nhập họ: ");
        String ho = scanner.next();
        System.out.print("Nhập tên: ");
        String ten = scanner.next();
        System.out.println("Họ và tên đã nhập: "+ ho +" "+ten);

/**
 *         Question 4:
 *         Viết lệnh cho phép người dùng nhập vào ngày sinh nhật của họ
 */
        System.out.println("\n Question 4");
        System.out.println("Viết lệnh cho phép người dùng nhập vào ngày sinh nhật của họ");
        System.out.println("Nhập theo định dạng: 29-05-2001");
        String ngaySinh = scanner.next();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = simpleDateFormat.parse(ngaySinh);
        System.out.println("Ngày sinh đã nhập: "+ date);

/**
 *         Question 5:
 *         Viết lệnh cho phép người dùng tạo account (viết thành method)
 *         Đối với property Position, Người dùng nhập vào 1 2 3 4 5 và vào
 *         chương trình sẽ chuyển thành Position.Dev, Position.Test,
 *         Position.ScrumMaster, Position.PM
 */
        System.out.println("\n Question 5");
        Question5();

/**
 *         Question 6:
 *         Viết lệnh cho phép người dùng tạo department (viết thành method)
 */
        System.out.println("\n Question 6");
        System.out.println("Viết lệnh cho phép người dùng tạo department (viết thành method)");
        Question6();

/**
 *         Question 7:
 *         Nhập số chẵn từ console
 */
        System.out.println("\n Question 7");
        System.out.println("Nhập số chẵn từ console)");
        while (true) {
            System.out.println("Hãy nhập vào 1 số chẵn: ");
            int a = scanner.nextInt();
            if (a % 2 == 0) {
                System.out.println("Số bạn vừa nhập:" + a);
                break;
            } else {
                System.out.println("Mời bạn nhập lại");
            }
        }

/**
 *         Question 8:
 *         Viết chương trình thực hiện theo flow sau:
 *         Bước 1:
 *         Chương trình in ra text "mời bạn nhập vào chức năng muốn sử
 *         dụng"
 *         Bước 2:
 *         Nếu người dùng nhập vào 1 thì sẽ thực hiện tạo account
 *         Nếu người dùng nhập vào 2 thì sẽ thực hiện chức năng tạo
 *         department
 *         Nếu người dùng nhập vào số khác thì in ra text "Mời bạn nhập
 *         lại" và quay trở lại bước 1
 */
        System.out.println("\n Question 8");
        do {
            System.out.println("-----------------------");
            System.out.println("1: tạo Account");
            System.out.println("2: tạo Department");
            System.out.println("3: Exit");
            System.out.println("-----------------------");
            System.out.print("mời bạn nhập lựa chọn: ");
            int chon = scanner.nextInt();
            switch(chon){
                case 1:
                    Question5();
                    break;
                case 2:
                    Question6();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Mời bạn nhập lại");
            }
        }while(true);


    }


    public static void Question5(){
        Scanner scanner = new Scanner(System.in);
        Account account4 = new Account();
        System.out.println("Thêm thông tin Account");

        System.out.print("Nhập id: ");
        account4.id = scanner.nextInt();

        System.out.print("Nhập Email: ");
        account4.email = scanner.next();

        System.out.print("Nhập Name: ");
        account4.name = scanner.next();

        scanner.nextLine(); // thêm scanner.nextLine(); vào đây để sử lý trôi câu lệnh của scanner thường gặp
        System.out.print("Nhập FullName: ");
        account4.fullName = scanner.nextLine();

        System.out.print("Nhập department: ");
        int departmentSwitch = scanner.nextInt();
        switch(departmentSwitch){
            case 1:
                Department department1 = new Department();
                department1.id = 1;
                department1.name = "Sale";
                account4.department = department1;
                break;
            case 2:
                Department department2 = new Department();
                department2.id = 2;
                department2.name = "Marketing";
                account4.department = department2;
                break;
            case 3:
                Department department3 = new Department();
                department3.id = 3;
                department3.name = "Bảo Vệ";
                account4.department = department3;
                break;
            default:
                System.out.println("mời bạn nhập lại");
        }

        System.out.print("Nhập position: ");
        int positionSwitch = scanner.nextInt();
        switch(positionSwitch){
            case 1:
                Position position1 = new Position();
                position1.id = 1;
                position1.positionName = Position.PositionName.PM;
                account4.position = position1;
                break;
            case 2:
                Position position2 = new Position();
                position2.id = 2;
                position2.positionName = Position.PositionName.DEV;
                account4.position = position2;
                break;
            case 3:
                Position position3 = new Position();
                position3.id = 3;
                position3.positionName = Position.PositionName.TEST;
                account4.position = position3;
                break;
            case 4:
                Position position4 = new Position();
                position4.id = 4;
                position4.positionName = Position.PositionName.SCRUM_MASTER;
                account4.position = position4;
            default:
                System.out.println("mời bạn nhập lại");
        }

        account4.createDate = LocalDate.now();
        System.out.println("Thông tin Account vừa nhập: ");
        System.out.println("id: "+account4.id);
        System.out.println("email: "+account4.email);
        System.out.println("name: "+account4.name);
        System.out.println("fullName: "+account4.fullName);
        System.out.println("department: "+account4.department.name);
        System.out.println("position: "+account4.position.positionName);
        System.out.println("createDate: "+account4.createDate);
    }

    public static void Question6(){
        Scanner scanner = new Scanner(System.in);
        Department department5 = new Department();
        System.out.println("Tạo Department");
        System.out.print("Nhập id: ");
        department5.id = scanner.nextInt();
        System.out.print("Nhập Name: ");
        department5.name = scanner.next();
        System.out.println("Thông tin Department vừa nhập là");
        System.out.println("id: " + department5.id);
        System.out.println("name: "+ department5.name);
    }



}
