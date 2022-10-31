package entity;

import java.time.LocalDate;

public class InserData {
    public static void main(String[] args){
        // Create Department
        Department department1 = new Department();
        department1.setId(1);
        department1.setName("Sale");

        Department department2 = new Department();
        department2.setId(2);
        department2.setName("Marketing");

        Department department3 = new Department();
        department3.setId(3);
        department3.setName("Bảo Vệ");

        // Create Position
        Position position1 = new Position();
        position1.setId(1);
        position1.setPositionName(Position.PositionName.PM);

        Position position2 = new Position();
        position2.setId(2);
        position2.setPositionName(Position.PositionName.DEV);

        Position position3 = new Position();
        position3.setId(3);
        position3.setPositionName(Position.PositionName.TEST);

        Position position4 = new Position();
        position4.setId(4);
        position4.setPositionName(Position.PositionName.SCRUM_MASTER);

        // Create Account
        Account account1 = new Account();
        account1.setId(1);
        account1.setEmail("taoquan178@gmail.com");
        account1.setName("Quân");
        account1.setFullName("Nguyễn Trung Quân");
        account1.setDepartment(department1);
        account1.setPosition(position1);
        account1.setCreateDate(LocalDate.of(2021,5,5));

        Account account2 = new Account();
        account2.setId(2);
        account2.setEmail("trunghieu88@gmail.com");
        account2.setName("Hiếu");
        account2.setFullName("Nguyễn Trung Hiếu");
        account2.setDepartment(department2);
        account2.setPosition(position2);
        account2.setCreateDate(LocalDate.of(2020,6,6));

        Account account3 = new Account();
        account3.setId(3);
        account3.setEmail("thutrang123@gmail.com");
        account3.setName("trang");
        account3.setFullName("Nguyễn Thu Trang");
        account3.setDepartment(department3);
        account3.setPosition(position3);
        account3.setCreateDate(LocalDate.of(2021,8,8));

        // Create Group
        Group group1 = new Group();
        group1.setId(1);
        group1.setName("Testing System");
        group1.setCreatorID(1);
        group1.setCreateDate(LocalDate.of(2019,3,5));
        Account[] accounts1 = new  Account[5];
        accounts1[0] = account1;
        accounts1[1] = account2;
        group1.setAccounts(accounts1);

        Group group2 = new Group();
        group2.setId(2);
        group2.setName("Development");
        group2.setCreatorID(2);
        group2.setCreateDate(LocalDate.of(2020,3,7));
        Account[] accounts2 = new  Account[5];
        accounts2[0] = account1;
        accounts2[1] = account3;
        group2.setAccounts(accounts2);

        Group group3 = new Group();
        group3.setId(3);
        group3.setName("VTI Sale 01");
        group3.setCreatorID(3);
        group3.setCreateDate(LocalDate.of(2020,3,9));
        Account[] accounts3 = new  Account[5];
        accounts3[0] = account2;
        group3.setAccounts(accounts3);

        // Add Group array vào Account

        Group[] groups1 = new Group[5];
        groups1[0] = group1;
        groups1[1] = group2;
        account1.setGroups(groups1);

        Group[] groups2 = new Group[5];
        groups2[0] = group1;
        groups2[1] = group3;
        account2.setGroups(groups2);

        Group[] groups3 = new Group[5];
        groups3[0] = group2;
        account3.setGroups(groups3);

        // Create TypeQuestion
        TypeQuestion typeQuestion1 = new TypeQuestion();
        typeQuestion1.setId(1);
        typeQuestion1.setTypeName(TypeQuestion.TypeName.ESSAY);

        TypeQuestion typeQuestion2 = new TypeQuestion();
        typeQuestion2.setId(2);
        typeQuestion2.setTypeName(TypeQuestion.TypeName.MULTIPLE_CHOICE);

        // Create CategoryQuestion
        CategoryQuestion categoryQuestion1 = new CategoryQuestion();
        categoryQuestion1.setId(1);
        categoryQuestion1.setCategoryName(CategoryQuestion.CategoryName.JAVA);

        CategoryQuestion categoryQuestion2 = new CategoryQuestion();
        categoryQuestion2.setId(2);
        categoryQuestion2.setCategoryName(CategoryQuestion.CategoryName.NET);

        CategoryQuestion categoryQuestion3 = new CategoryQuestion();
        categoryQuestion3.setId(3);
        categoryQuestion3.setCategoryName(CategoryQuestion.CategoryName.POSTMAN);

        CategoryQuestion categoryQuestion4 = new CategoryQuestion();
        categoryQuestion4.setId(4);
        categoryQuestion4.setCategoryName(CategoryQuestion.CategoryName.RUBY);

        CategoryQuestion categoryQuestion5 = new CategoryQuestion();
        categoryQuestion5.setId(5);
        categoryQuestion5.setCategoryName(CategoryQuestion.CategoryName.SQL);

        // Create Question
        Question question1 = new Question();
        question1.setId(1);
        question1.setContent("Cau hoi ve Java");
        question1.setCategoryQuestion(categoryQuestion1);
        question1.setTypeQuestion(typeQuestion1);
        question1.setCreatorID(1);
        question1.setCreateDate(LocalDate.of(2019,4,5));

        Question question2 = new Question();
        question2.setId(2);
        question2.setContent("Cau hoi ve .NET");
        question2.setCategoryQuestion(categoryQuestion2);
        question2.setTypeQuestion(typeQuestion1);
        question2.setCreatorID(2);
        question2.setCreateDate(LocalDate.of(2019,4,8));

        Question question3 = new Question();
        question3.setId(3);
        question3.setContent("Cau hoi ve POSTMAN");
        question3.setCategoryQuestion(categoryQuestion3);
        question3.setTypeQuestion(typeQuestion2);
        question3.setCreatorID(3);
        question3.setCreateDate(LocalDate.of(2019,4,10));

        // Create Answer
        Answer answer1 = new Answer();
        answer1.setId(1);
        answer1.setContent("Cau tra loi 1");
        answer1.setQuestion(question1);
        answer1.setCorrect(true);

        Answer answer2 = new Answer();
        answer2.setId(2);
        answer2.setContent("Cau tra loi 2");
        answer2.setQuestion(question2);
        answer2.setCorrect(false);

        Answer answer3 = new Answer();
        answer3.setId(3);
        answer3.setContent("Cau tra loi 3");
        answer3.setQuestion(question3);
        answer3.setCorrect(true);

        // Create Exam
        Exam exam1 = new Exam();
        exam1.setId(1);
        exam1.setCode("VTI01");
        exam1.setTitle("De thi Java");
        exam1.setCategoryQuestion(categoryQuestion1);
        exam1.setDuration(60);
        exam1.setCreatorID(1);
        exam1.setCreateDate(LocalDate.of(2019,1,5));
        Question[] questions1 = new Question[5];
        questions1[0] = question1;
        questions1[1] = question3;
        exam1.setQuestions(questions1);

        Exam exam2 = new Exam();
        exam2.setId(2);
        exam2.setCode("VTI02");
        exam2.setTitle("De thi .NET");
        exam2.setCategoryQuestion(categoryQuestion2);
        exam2.setDuration(60);
        exam2.setCreatorID(2);
        exam2.setCreateDate(LocalDate.of(2019,1,6));
        Question[] questions2 = new Question[5];
        questions2[0] = question2;
        questions2[1] = question3;
        exam2.setQuestions(questions2);

        Exam exam3 = new Exam();
        exam3.setId(3);
        exam3.setCode("VTI03");
        exam3.setTitle("De thi SQL");
        exam3.setCategoryQuestion(categoryQuestion3);
        exam3.setDuration(60);
        exam3.setCreatorID(3);
        exam3.setCreateDate(LocalDate.of(2019,1,7));
        Question[] questions3 = new Question[5];
        questions3[0] = question2;
        exam3.setQuestions(questions3);

        // Add Exam array vào Question
        Exam[] exams1 = new Exam[5];
        exams1[0] = exam1;
        question1.setExams(exams1);

        Exam[] exams2 = new Exam[5];
        exams2[0] = exam2;
        exams2[1] = exam3;
        question2.setExams(exams2);

        Exam[] exams3 = new Exam[5];
        exams3[0] = exam1;
        exams3[1] = exam2;
        question3.setExams(exams3);



    }
}
