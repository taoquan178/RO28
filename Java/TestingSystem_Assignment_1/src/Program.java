import java.sql.Date;

public class Program {
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
        account1.createDate = new Date(2021,5,5);

        Account account2 = new Account();
        account2.id = 2;
        account2.email = "trunghieu88@gmail.com";
        account2.name = "Hiếu";
        account2.fullName = "Nguyễn Trung Hiếu";
        account2.department = department2;
        account2.position = position2;
        account2.createDate = new Date(2020,6,6);

        Account account3 = new Account();
        account3.id = 3;
        account3.email = "thutrang123@gmail.com";
        account3.name = "trang";
        account3.fullName = "Nguyễn Thu Trang";
        account3.department = department3;
        account3.position = position3;
        account3.createDate = new Date(2021,8,8);

        // Create Group
        Group group1 = new Group();
        group1.id = 1;
        group1.name = "Testing System";
        group1.creatorID = 1;
        group1.createDate = new Date(2019,3,5); // Date
        Account[] accountOfGroup1 = { account1, account2 }; // Array list Group
        group1.accounts = accountOfGroup1;

        Group group2 = new Group();
        group2.id = 2;
        group2.name = "Development";
        group2.creatorID = 2;
        group2.createDate = new Date(2020,3,7);
        Account[] accountOfGroup2 = { account1, account3 };
        group2.accounts = accountOfGroup2;

        Group group3 = new Group();
        group3.id = 3;
        group3.name = "VTI Sale 01";
        group3.creatorID = 1;
        group3.createDate = new Date(2020,3,9);
        Account[] accountOfGroup3 = { account2 };
        group3.accounts = accountOfGroup3;

        // Add Group array vào Account
        Group[] groupOfAccount1 = { group1, group2 };
        account1.groups = groupOfAccount1;

        Group[] groupOfAccount2 = { group1, group3 };
        account2.groups = groupOfAccount2;

        Group[] groupOfAccount3 = { group2 };
        account3.groups = groupOfAccount3;

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
        question1.createDate = new Date(2019,4,5);

        Question question2 = new Question();
        question2.id = 2;
        question2.content = "Cau hoi ve .NET";
        question2.categoryQuestion = categoryQuestion2;
        question2.typeQuestion = typeQuestion1;
        question2.creatorID = 2;
        question2.createDate = new Date(2019,4,8);

        Question question3 = new Question();
        question3.id = 3;
        question3.content = "Cau hoi ve POSTMAN";
        question3.categoryQuestion = categoryQuestion3;
        question3.typeQuestion = typeQuestion2;
        question3.creatorID = 3;
        question3.createDate = new Date(2019,4,10);

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
        exam1.createDate = new Date(2019,1,5);
        Question[] examOfQuestion1 = { question1, question3 };
        exam1.questions = examOfQuestion1;

        Exam exam2 = new Exam();
        exam2.id = 2;
        exam2.code = "VTI02";
        exam2.title = "De thi .NET";
        exam2.categoryQuestion = categoryQuestion2;
        exam2.duration = 60;
        exam2.creatorID = 2;
        exam2.createDate = new Date(2019,1,6);
        Question[] examOfQuestion2 = { question2, question3 };
        exam2.questions = examOfQuestion2;

        Exam exam3 = new Exam();
        exam3.id = 1;
        exam3.code = "VTI03";
        exam3.title = "De thi SQL";
        exam3.categoryQuestion = categoryQuestion3;
        exam3.duration = 60;
        exam3.creatorID = 3;
        exam3.createDate = new Date(2019,1,7);
        Question[] examOfQuestion3 = { question2 };
        exam3.questions = examOfQuestion3;

        // Add Exam array vào Question
        Exam[] questionOfExam1 = { exam1};
        question1.exams = questionOfExam1;

        Exam[] questionOfExam2 = { exam2, exam3};
        question2.exams = questionOfExam2;

        Exam[] questionOfExam3 = { exam1, exam2};
        question3.exams = questionOfExam3;

        // Question 3
        System.out.println("Thông tin Account 1");
        System.out.println("Họ tên: " + account1.fullName);
        System.out.println("Email: " + account1.email);
        System.out.println("Phòng ban: " + account1.department.name);
        System.out.println("Chức vụ: " + account1.position.positionName);

        for ( Group groups : account1.groups ){		// cách in array của account1
            System.out.println("Nhóm: " + groups.name);
        }
        System.out.println("\n-------------------------------\n");

        System.out.println("Thông tin Group 1");
        System.out.println("Tên nhóm: " + group1.name);
        for ( Account accounts : group1.accounts ){
            System.out.println("Thành viên: " + accounts.name);
        }
        System.out.println("\n-------------------------------\n");

        System.out.println("Thông tin Question 1");
        System.out.println("Câu hỏi: " + question1.content);
        System.out.println("Dạng đề: " + question1.typeQuestion.typeName);
        System.out.println("Loại câu hỏi: " + question1.categoryQuestion.categoryName);
        System.out.println("\n-------------------------------\n");

        System.out.println("Thông tin Answer 1");
        System.out.println("Câu hỏi: " + answer1.question.content);
        System.out.println("Câu trả lời: " + answer1.content);
        System.out.println("Đúng hay sai: " + answer1.isCorrect);
        System.out.println("\n-------------------------------\n");

        System.out.println("Thông tin Exam 1");
        System.out.println("Đề: " + exam1.title);
        System.out.println("Mã đề: " + exam1.code);
        System.out.println("Thời gian làm: " + exam1.duration);
        System.out.println("\n-------------------------------\n");

        System.out.println("Thông tin bảng Department");
        System.out.println(department1);
        System.out.println(department2);
        System.out.println(department3);
        System.out.println("\n-------------------------------\n");

        System.out.println("Thông tin bảng Position");
        System.out.println(position1);
        System.out.println(position2);
        System.out.println(position3);
        System.out.println(position4);
        System.out.println("\n-------------------------------\n");

    }
}