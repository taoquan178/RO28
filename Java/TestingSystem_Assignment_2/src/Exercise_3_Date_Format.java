import java.text.ParseException;
import java.time.LocalDate;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class Exercise_3_Date_Format {
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

/**
 *         Question 1:
 *         In ra thông tin Exam thứ 1 và property create date sẽ được format theo định
 *         dạng vietnamese
 */
        System.out.println("\n Question 1");
//        Locale localeVN = new Locale("vi", "VN");
//        DateFormat dateformat = DateFormat.getDateInstance(DateFormat.DEFAULT, localeVN);
//        String date = dateformat.format(exam1.createDate);
//        System.out.println("Create Date: " + date);

        LocalDate myDateObj = exam1.createDate;
        System.out.println("Định dạng ban đầu: " + myDateObj);
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = myDateObj.format(myFormatObj);
        System.out.println("Định dạng vietnamese: " + formattedDate);

/**
 *          Question 2:
 *          In ra thông tin: Exam đã tạo ngày nào theo định dạng
 *          Năm – tháng – ngày – giờ – phút – giây
 */
        System.out.println("\n Quetion 2");
        System.out.println("In ra thông tin: Exam đã tạo ngày nào theo định dạng \n" +
                "Năm – tháng – ngày – giờ – phút – giây");
        Exam[] examsArray ={exam1,exam2,exam3};
        for (Exam exams : examsArray){
            LocalDateTime myDateObj1 = exams.createDate.atStartOfDay();
            DateTimeFormatter myFormatObj1 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formattedDate1 = myDateObj1.format(myFormatObj1);
            System.out.println("Thông tin ngày tạo Exam " + exams.id);
            System.out.println("id: " + exams.id);
            System.out.println("Create Date: " + formattedDate1);
        }
/**
 *         Question 3:
 *         Chỉ in ra năm của create date property trong Question 2
 */
        System.out.println("\n Quetion 3");
        System.out.println("Chỉ in ra năm của create date property trong Question 2");
        LocalDate localDate = question2.createDate;
        int year = localDate.getYear();
        System.out.println("năm của create date: " + year);
/**
 *         Question 4:
 *         Chỉ in ra tháng và năm của create date property trong Question 2
 */
        System.out.println("\n Quetion 4");
        System.out.println("Chỉ in ra tháng và năm của create date property trong Question 2");
//        String parent4 = "MM-yyyy";
//        SimpleDateFormat simpleDateFormat4 = new SimpleDateFormat(parent4);
//        String  date4 = simpleDateFormat4.format(question2.createDate);
//        System.out.println("Tháng và Năm: "+ date4);

        Month month1 = localDate.getMonth();
        int year1 = localDate.getYear();
        System.out.println("Tháng: " + month1 + " Năm: " + year1);

        //Question 5:
        //Chỉ in ra "MM-DD" của create date trong Question 2
        System.out.println("\n Quetion 5");
        System.out.println("Chỉ in ra \"MM-DD\" của create date trong Question 2");
//        String parent5 = "MM-dd";
//        SimpleDateFormat simpleDateFormat5 = new SimpleDateFormat(parent5);
//        String  date5 = simpleDateFormat5.format(question2.createDate);
//        System.out.println("Tháng và Ngày: "+ date5);

        Month month2 = localDate.getMonth();
        int day = localDate.getDayOfMonth();
        System.out.println("Tháng: " + month2 + " Ngày: " + day);

    }
}
