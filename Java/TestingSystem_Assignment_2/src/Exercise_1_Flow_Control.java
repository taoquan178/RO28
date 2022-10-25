import java.time.LocalDate;
import java.sql.Date;

public class Exercise_1_Flow_Control {
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

        // Create Answer
        Answer answer1 = new Answer();
        answer1.id = 1;
        answer1.content = "Cau tra loi 1";
        answer1.question = question1;
        answer1.isCorrect = true;

        Answer answer2 = new Answer();
        answer2.id = 2;
        answer2.content = "Cau tra loi 2";
        answer2.question = question2;
        answer2.isCorrect = false;

        Answer answer3 = new Answer();
        answer3.id = 3;
        answer3.content = "Cau tra loi 3";
        answer3.question = question3;
        answer3.isCorrect = true;

        // Create Exam
        Exam exam1 = new Exam();
        exam1.id = 1;
        exam1.code = "VTI01";
        exam1.title = "De thi Java";
        exam1.categoryQuestion = categoryQuestion1;
        exam1.duration = 60;
        exam1.creatorID = 1;
        exam1.createDate = LocalDate.of(2019,1,5);
        exam1.questions = new Question[5];
        exam1.questions[0] = question1;
        exam1.questions[1] = question3;

        Exam exam2 = new Exam();
        exam2.id = 2;
        exam2.code = "VTI02";
        exam2.title = "De thi .NET";
        exam2.categoryQuestion = categoryQuestion2;
        exam2.duration = 60;
        exam2.creatorID = 2;
        exam2.createDate = LocalDate.of(2019,1,6);
        exam2.questions = new Question[5];
        exam2.questions[0] = question2;
        exam2.questions[1] = question3;

        Exam exam3 = new Exam();
        exam3.id = 1;
        exam3.code = "VTI03";
        exam3.title = "De thi SQL";
        exam3.categoryQuestion = categoryQuestion3;
        exam3.duration = 60;
        exam3.creatorID = 3;
        exam3.createDate = LocalDate.of(2019,1,7);
        exam3.questions = new Question[5];
        exam3.questions[0] = question2;


        // Add Exam array vào Question
        question1.exams = new Exam[5];
        question1.exams[0] = exam1;
        question2.exams = new Exam[5];
        question2.exams[0] = exam2;
        question2.exams[1] = exam3;
        question3.exams = new Exam[5];
        question3.exams[0] = exam1;
        question3.exams[1] = exam2;

        // Exercise 1 (Optional): Flow Control
        // Question 1:
        System.out.println("Exercise 1 (Optional): Flow Control");
        System.out.println("Question 1");
        if (account2.department == null){
            System.out.println("Nhân viên này chưa có phòng ban");
        } else {
            System.out.println("Phòng ban của nhân viên này là: " + account2.department.name);
        }

        // Question 2:
        System.out.println("\n Question 2");
        if (account2.groups == null) {
            System.out.println("Nhân viên này chưa có group");
        } else if (account2.groups.length == 1 || account2.groups.length == 2) {
            System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
        } else if (account2.groups.length == 3) {
            System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
        } else {
            System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
        }

        // Question 3:
        //Sử dụng toán tử ternary để làm Question 1
        System.out.println("\n Question 3");
        System.out.println(account2.groups == null ? ("Nhân viên này chưa có phòng ban") : ("Phòng ban của nhân viên này là: " + account2.department.name));

        //Question 4:
        //Sử dụng toán tử ternary để làm yêu cầu sau:
        //Kiểm tra Position của account thứ 1
        //Nếu Position = Dev thì in ra text "Đây là Developer"
        //Nếu không phải thì in ra text "Người này không phải là Developer"
        System.out.println("\n Question 4");
        System.out.println(account1.position.positionName == Position.PositionName.DEV ? "Đây là Developer" : "Người này không phải là Developer");

        // Question 5:
        System.out.println("\n Question 5");
        switch (group1.accounts.length){
            case 1:
                System.out.println("Nhóm có một thành viên");
                break;
            case 2:
                System.out.println("Nhóm có hai thành viên");
                break;
            case 3:
                System.out.println("Nhóm có ba thành viên");
                break;
            default:
                System.out.println("Nhóm có nhiều thành viên");
        }

        // Question 6:
        //Sử dụng switch case để làm lại Question 2
        System.out.println("\n Question 6");
        System.out.println("Sử dụng switch case để làm lại Question 2");
        if (account2.groups == null){
            System.out.println("Nhân viên này chưa có group");
        } else{ switch (account2.groups.length){
            case 1:
            case 2:
                System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
                break;
            case 3:
                System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
                break;
            default:
                System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
            }
        }
        // Question 7:
        //Sử dụng switch case để làm lại Question 4
        System.out.println("\n Question 7");
        System.out.println("Sử dụng switch case để làm lại Question 4");
        switch (account1.position.id){
            case 1:
                System.out.println("Đây là Developer");
                break;
            default:
                System.out.println("Người này không phải là Developer");
        }

        // FOREACH
        //Question 8:
        //In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ
        System.out.println("\n Question 8");
        System.out.println("In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ");
        for (Account account : new Account[]{account1, account2, account3}) {
            System.out.println("Email: "+account.email);
            System.out.println("Full Name: "+account.fullName);
            System.out.println("Phòng Ban: "+account.department.name);
        }

        // Question 9: FOR EACH
        //In ra thông tin các phòng ban bao gồm: id và name
        System.out.println("\n Question 9");
        System.out.println("In ra thông tin các phòng ban bao gồm: id và name");
        for (Department department : new Department[]{department1, department2, department3}) {
            System.out.println("ID: " + department.id);
            System.out.println("Name; " + department.name);
        }

        // Question 10: FOR
        // In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của
        //họ theo định dạng như sau:
        System.out.println("\n Question 10");
        System.out.println("In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ theo định dạng như sau:");
        Account[] accArray = { account1, account2, account3 };
        for (int i = 0; i < accArray.length; i++){
            System.out.println("Thông tin account thứ "+ (i+1) +" là:");
            System.out.println("Email: "+ accArray[i].email);
            System.out.println("Full Name: "+accArray[i].fullName);
            System.out.println("Phòng Ban: "+accArray[i].department.name);
        }

        // Question 11:
        //In ra thông tin các phòng ban bao gồm: id và name theo định dạng sau:
        System.out.println("\n Question 11");
        System.out.println("In ra thông tin các phòng ban bao gồm: id và name theo định dạng sau:");
        Department[] departmentsArray = {department1, department2, department3};
        for (int i = 0; i < departmentsArray.length; i++){
            System.out.println("Thông tin department thứ "+ (i+1) +" là:");
            System.out.println("ID: "+ departmentsArray[i].id);
            System.out.println("Name: "+ departmentsArray[i].name);
        }

        // Question 12:
        //Chỉ in ra thông tin 2 department đầu tiên theo định dạng như Question 10
        System.out.println("\n Question 12");
        System.out.println("Chỉ in ra thông tin 2 department đầu tiên theo định dạng như Question 10");
        for (int i = 0; i < 2; i++){
            System.out.println("Thông tin department thứ "+ (i+1) +" là:");
            System.out.println("ID: "+ departmentsArray[i].id);
            System.out.println("Name: "+ departmentsArray[i].name);
        }

        // Question 13:
        //In ra thông tin tất cả các account ngoại trừ account thứ 2
        System.out.println("\n Question 13");
        System.out.println("In ra thông tin tất cả các account ngoại trừ account thứ 2");
        for (int i = 0; i < accArray.length; i++){
            if (accArray[i].id != 2){
                System.out.println("Thông tin account thứ "+ (i+1) +" là:");
                System.out.println("Email: "+ accArray[i].email);
                System.out.println("Full Name: "+accArray[i].fullName);
                System.out.println("Phòng Ban: "+accArray[i].department.name);
            }
        }

        // Question 14:
        //In ra thông tin tất cả các account có id < 4
        System.out.println("\n Question 14");
        System.out.println("In ra thông tin tất cả các account có id < 4");
        for (int i = 0; i < accArray.length; i++){
            if (accArray[i].id < 4){
                System.out.println("Thông tin account thứ "+ (i+1) +" là:");
                System.out.println("Email: "+ accArray[i].email);
                System.out.println("Full Name: "+accArray[i].fullName);
                System.out.println("Phòng Ban: "+accArray[i].department.name);
            }
        }

        // Question 15:
        //In ra các số chẵn nhỏ hơn hoặc bằng 20
        System.out.println("\n Question 15");
        System.out.println("In ra các số chẵn nhỏ hơn hoặc bằng 20");
        for (int i = 0; i <=20; i++){
            if ( i%2 == 0 ){
                System.out.println("Số: " + i);
            }
        }

        // Question 16:
        //Làm lại các Question ở phần FOR bằng cách sử dụng WHILE kết hợp với lệnh break, continue
        System.out.println("\n Question 16");
        System.out.println("Làm lại các Question ở phần FOR bằng cách sử dụng WHILE kết hợp với lệnh break, continue");
        System.out.println("\n WHILE 10:");
        int i0 = 0;
        while (i0 < accArray.length){
            System.out.println("Thông tin account thứ "+ (i0+1) +" là:");
            System.out.println("Email: "+ accArray[i0].email);
            System.out.println("Full Name: "+accArray[i0].fullName);
            System.out.println("Phòng Ban: "+accArray[i0].department.name);
            i0++;
        }

        System.out.println("\n WHILE 11:");
        int i1 = 0;
        while (i1 < departmentsArray.length){
            System.out.println("Thông tin department thứ "+ (i1+1) +" là:");
            System.out.println("ID: "+ departmentsArray[i1].id);
            System.out.println("Name: "+ departmentsArray[i1].name);
            i1++;
        }

        System.out.println("\n WHILE 12:");
        int i2 = 0;
        while (i2 < 2){
            System.out.println("Thông tin department thứ "+ (i2+1) +" là:");
            System.out.println("ID: "+ departmentsArray[i2].id);
            System.out.println("Name: "+ departmentsArray[i2].name);
            i2++;
        }

        System.out.println("\n WHILE 13:");
        int i3= 0;
        while (i3 < accArray.length){
            if (accArray[i3].id != 2){
                System.out.println("Thông tin account thứ "+ (i3+1) +" là:");
                System.out.println("Email: "+ accArray[i3].email);
                System.out.println("Full Name: "+accArray[i3].fullName);
                System.out.println("Phòng Ban: "+accArray[i3].department.name);
            }
            i3++;
        }

        System.out.println("\n WHILE 14:");
        int i4=0;
        while ( i4 < accArray.length){
            if (accArray[i4].id < 4){
                System.out.println("Thông tin account thứ "+ (i4+1) +" là:");
                System.out.println("Email: "+ accArray[i4].email);
                System.out.println("Full Name: "+accArray[i4].fullName);
                System.out.println("Phòng Ban: "+accArray[i4].department.name);
            }
            i4++;
        }

        System.out.println("\n WHILE 15:");
        System.out.println("In ra các số chẵn nhỏ hơn hoặc bằng 20");
        double i5 =0;
        while (i5 <=100){
            if ( i5%2 == 0.5 ){
                continue;
            } else if (i5%2 == 0) {
                System.out.println("Số: " + i5);
            } else if (i5 > 20) {
                break;
            }
            i5 ++;
        }

        // DO-WHILE
        //Question 17:
        //Làm lại các Question ở phần FOR bằng cách sử dụng DO-WHILE kết hợp với
        //lệnh break, continue
        System.out.println("\n Question 17");
        System.out.println("Làm lại các Question ở phần FOR bằng cách sử dụng DO-WHILE kết hợp với lệnh break, continue");
        System.out.println("\n DO WHILE 10:");
        int iD0 = 0;
        do {
            System.out.println("Thông tin account thứ "+ (iD0+1) +" là:");
            System.out.println("Email: "+ accArray[iD0].email);
            System.out.println("Full Name: "+accArray[iD0].fullName);
            System.out.println("Phòng Ban: "+accArray[iD0].department.name);
            iD0++;
        }while (iD0 < accArray.length);

        System.out.println("\n DO WHILE 11:");
        int iD1 = 0;
        do {
            System.out.println("Thông tin department thứ "+ (iD1+1) +" là:");
            System.out.println("ID: "+ departmentsArray[iD1].id);
            System.out.println("Name: "+ departmentsArray[iD1].name);
            iD1++;
        }while (iD1 < departmentsArray.length);

        System.out.println("\n DO WHILE 12:");
        int iD2 = 0;
        do {
            System.out.println("Thông tin department thứ "+ (iD2+1) +" là:");
            System.out.println("ID: "+ departmentsArray[iD2].id);
            System.out.println("Name: "+ departmentsArray[iD2].name);
            iD2++;
        }while (iD2 < 2);

        System.out.println("\n DO WHILE 13:");
        int iD3= 0;
        do {
            if (accArray[iD3].id != 2){
                System.out.println("Thông tin account thứ "+ (iD3+1) +" là:");
                System.out.println("Email: "+ accArray[iD3].email);
                System.out.println("Full Name: "+accArray[iD3].fullName);
                System.out.println("Phòng Ban: "+accArray[iD3].department.name);
            }
            iD3++;
        }while (iD3 < accArray.length);

        System.out.println("\n DO WHILE 14:");
        int iD4=0;
        do {
            if (accArray[iD4].id < 4){
                System.out.println("Thông tin account thứ "+ (iD4+1) +" là:");
                System.out.println("Email: "+ accArray[iD4].email);
                System.out.println("Full Name: "+accArray[iD4].fullName);
                System.out.println("Phòng Ban: "+accArray[iD4].department.name);
            }
            iD4++;
        }while ( iD4 < accArray.length);

        System.out.println("\n DO WHILE 15:");
        System.out.println("In ra các số chẵn nhỏ hơn hoặc bằng 20");
        double iD5 =0;
        do {
            if ( iD5%2 == 0.5 ){
                continue;
            } else if (iD5%2 == 0) {
                System.out.println("Số: " + iD5);
            } else if (iD5 > 20) {
                break;
            }
            iD5 ++;
        }while (iD5 <=100);

    }

}