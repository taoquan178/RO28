import java.time.LocalDate;
import java.util.Scanner;

public class Exercise_5_Question_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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

        /**
         * Question 9:
         *         Viết method cho phép người dùng thêm group vào account theo flow sau:
         *         Bước 1:
         *         In ra tên các usernames của user cho người dùng xem
         *         Bước 2:
         *         Yêu cầu người dùng nhập vào username của account
         *         Bước 3:
         *         In ra tên các group cho người dùng xem
         *         Bước 4:
         *         Yêu cầu người dùng nhập vào tên của group
         *         Bước 5:
         *         Dựa vào username và tên của group người dùng vừa chọn, hãy
         *         thêm account vào group đó .
         */
        Account[] accountsArray = { account1, account2,account3};
        Group[] groupsArray = { group1, group2, group3};
        Question9(accountsArray,groupsArray);

    }

    public static void Question9(Account[] accArray, Group[] groupArray){
        Scanner scanner = new Scanner(System.in);
        for(int i = 0;i < accArray.length;i++){
            System.out.println("User Names: "+ accArray[i].name);
        }
        System.out.println("Mời bạn nhập vào tên 1 User bên trên!");
        String userName = scanner.next();

        for(int i = 0;i < groupArray.length;i++){
            System.out.println("User Names: "+ groupArray[i].name);
        }
        System.out.println("Mời bạn nhập vào tên 1 Group bên trên!");
        scanner.nextLine(); // thêm scanner.nextLine(); vào đây để sử lý trôi câu lệnh của scanner thường gặp
        String groupName = scanner.nextLine();

        int indexAccount = -1;
        for (int j = 0; j < accArray.length; j++) {
            if (accArray[j].name.equals(userName)) {
                indexAccount = j;
            }
        }
        int indexGroup = -1;
        for (int i = 0; i < groupArray.length; i++) {
            if (groupArray[i].name.equals(groupName)) {
                indexGroup = i;

            }
        }
        System.out.println("indexAccount: "+indexAccount  +" "+ accArray[indexAccount].name);
        System.out.println("indexGroup: "+indexGroup +" "+ accArray[indexAccount].groups[0].name);
        if (indexAccount < 0 || indexGroup < 0) {
            System.out.println("Tên hoặc Nhóm không trùng. Mời bạn nhập lại!");
        } else {
            for (int j = 0; j < accArray.length; j++) {
                if (accArray[j].name.equals(userName)) {
                    accArray[j].groups = new Group[]{groupArray[indexGroup]};
                    System.out.println("Bạn vừa thêm Group: " + accArray[indexAccount].groups[0].name
                            + " cho Account: " + accArray[indexAccount].name);
                }
            }




        }

    }
}
