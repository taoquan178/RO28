import java.sql.Date;
import java.time.LocalDate;

public class Exercise_6_Method {

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

        //Question 1:
        //Tạo method để in ra các số chẵn nguyên dương nhỏ hơn 10
        System.out.println("\n Question 1");
        System.out.println("Tạo method để in ra các số chẵn nguyên dương nhỏ hơn 10");
        Question1();

        //Question 2:
        //Tạo method để in thông tin các account
        System.out.println("\n Question 2");
        System.out.println("Tạo method để in thông tin các account");
        Account[] accountsArray ={account1,account2,account3};
        Question2(accountsArray);

        //Question 3:
        //Tạo method để in ra các số nguyên dương nhỏ hơn 10
        System.out.println("\n Question 3");
        System.out.println("Tạo method để in ra các số nguyên dương nhỏ hơn 10");
        Question3();

    }

    public static void Question1(){
    for(int i =0; i <10;i++){
        if (i%2 == 0){
            System.out.print(i+", ");
        }
    }
    }

    public static void Question2(Account[] accA){
        for (int i= 0; i <accA.length; i++){
            System.out.println("Thông tin Accont "+ (i+1) + ":");
            System.out.println("ID: "+accA[i].id);
            System.out.println("Full Name: "+accA[i].fullName);
            System.out.println("Email : "+accA[i].email);
            System.out.println("Phòng Ban: "+accA[i].department.name);
            System.out.println("Chức vụ: "+accA[i].position.positionName +"\n");
        }
    }

    public static void Question3(){
        for(int i =0; i <10;i++){
            System.out.print(i+", ");
        }
    }

}

