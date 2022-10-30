import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class Exercise_1_Datatype_Casting {
    public static void main(String[] args) {

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
        account1.luong =  5240.5f;
        account1.createDate = LocalDate.of(2021,5,5);

        Account account2 = new Account();
        account2.id = 2;
        account2.email = "trunghieu88@gmail.com";
        account2.name = "Hiếu";
        account2.fullName = "Nguyễn Trung Hiếu";
        account2.department = department2;
        account2.position = position2;
        account2.luong = 10970.055f;
        account2.createDate = LocalDate.of(2020,6,6);

        Account account3 = new Account();
        account3.id = 3;
        account3.email = "thutrang123@gmail.com";
        account3.name = "trang";
        account3.fullName = "Nguyễn Thu Trang";
        account3.department = department3;
        account3.position = position3;
        account3.luong = 1282.54f;
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
        account1.groups[1] = group2;

        account2.groups = new Group[5];
        account2.groups[0] = group1;
        account2.groups[1] = group3;

        account3.groups = new Group[5];
        account3.groups[0] = group2;

        // Create TypeQuestion
        TypeQuestion typeQuestion1 = new TypeQuestion();
        typeQuestion1.id = 1;
        typeQuestion1.typeName = TypeQuestion.TypeName.ESSAY;

        TypeQuestion typeQuestion2 = new TypeQuestion();
        typeQuestion2.id = 2;
        typeQuestion2.typeName = TypeQuestion.TypeName.MULTIPLE_CHOICE;

        // Create CategoryQuestion
        CategoryQuestion categoryQuestion1 = new CategoryQuestion();
        categoryQuestion1.id = 1;
        categoryQuestion1.categoryName = CategoryQuestion.CategoryName.JAVA;

        CategoryQuestion categoryQuestion2 = new CategoryQuestion();
        categoryQuestion2.id = 2;
        categoryQuestion2.categoryName = CategoryQuestion.CategoryName.NET;

        CategoryQuestion categoryQuestion3 = new CategoryQuestion();
        categoryQuestion3.id = 3;
        categoryQuestion3.categoryName = CategoryQuestion.CategoryName.POSTMAN;

        CategoryQuestion categoryQuestion4 = new CategoryQuestion();
        categoryQuestion4.id = 4;
        categoryQuestion4.categoryName = CategoryQuestion.CategoryName.RUBY;

        CategoryQuestion categoryQuestion5 = new CategoryQuestion();
        categoryQuestion5.id = 5;
        categoryQuestion5.categoryName = CategoryQuestion.CategoryName.SQL;

        // Create Question
        Question question1 = new Question();
        question1.id = 1;
        question1.content = "Cau hoi ve Java";
        question1.categoryQuestion = categoryQuestion1;
        question1.typeQuestion = typeQuestion1;
        question1.creatorID = 1;
        question1.createDate = LocalDate.of(2019,4,5);

        Question question2 = new Question();
        question2.id = 2;
        question2.content = "Cau hoi ve .NET";
        question2.categoryQuestion = categoryQuestion2;
        question2.typeQuestion = typeQuestion1;
        question2.creatorID = 2;
        question2.createDate = LocalDate.of(2019,4,8);

        Question question3 = new Question();
        question3.id = 3;
        question3.content = "Cau hoi ve POSTMAN";
        question3.categoryQuestion = categoryQuestion3;
        question3.typeQuestion = typeQuestion2;
        question3.creatorID = 3;
        question3.createDate = LocalDate.of(2019,4,10);


        /**
         * Exercise 1 (Optional): Datatype Casting
         * Question 1:
         * Khai báo 2 số lương có kiểu dữ liệu là float.
         * Khởi tạo Lương của Account 1 là 5240.5 $
         * Khởi tạo Lương của Account 2 là 10970.055$
         * Khai báo 1 số int để làm tròn Lương của Account 1 và in số int đó ra
         * Khai báo 1 số int để làm tròn Lương của Account 2 và in số int đó ra
         */
        System.out.println("Question 1:");
        float luongAccount1 = account1.luong;
        float luongAccount2 = account2.luong;
        int catingLuongAccount1 = (int) luongAccount1;
        int catingLuongAccount2 = (int) luongAccount2;
        System.out.println("tròn Lương của Account 1: "+ catingLuongAccount1 + "$");
        System.out.println("tròn Lương của Account 2: "+ catingLuongAccount2 + "$");

         /**
         * Question 2:
         * Lấy ngẫu nhiên 1 số có 5 chữ số (những số dưới 5 chữ số thì sẽ thêm
         * có số 0 ở đầu cho đủ 5 chữ số)
         */
        System.out.println("\n Question 2:");
        Random rand = new Random();
        int a = rand.nextInt(99999 );
        String CatingA = a + "";
        if ( CatingA.length()<2){
             CatingA = "0000" +a ;
        } else if(CatingA.length()<3){
            CatingA = "000" +a ;
        } else if(CatingA.length()<4){
            CatingA = "00" +a ;
        } else if(CatingA.length()<5){
            CatingA = "0" +a ;
        }
        System.out.println("Số ngẫu nhiên: " + CatingA);
        /**
         * Question 3:
         * Lấy 2 số cuối của số ở Question 2 và in ra.
         * Gợi ý:
         * Cách 1: convert số có 5 chữ số ra String, sau đó lấy 2 số cuối
         * Cách 2: chia lấy dư số đó cho 100
         */
        System.out.println("\n Question 3:");
        System.out.println("2 số cuối của số ngẫu nhiên: "+ CatingA.substring(3));
        /**
         * Question 4:
         * Viết 1 method nhập vào 2 số nguyên a và b và trả về thương của chúng
         */
        System.out.println("\n Question 4:");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Mời bạn nhập vào số A: ");
        int soA = scanner.nextInt();
        System.out.print("Mời bạn nhập vào số B: ");
        int soB = scanner.nextInt();
        Question4(soA,soB);


    }
    public static void Question4(int a, int b){
        int c = a / b;
        System.out.print("Thương của chúng là: "+ c);
    }
}