import java.time.LocalDate;

public class Exercise_2_Default_value {
    public static void main(String[] args) {
        /**
         * Exercise 2 (Optional): Default value
         * Question 1:
         * Không sử dụng data đã insert từ bài trước, tạo 1 array Account và khởi
         * tạo 5 phần tử theo cú pháp (sử dụng vòng for để khởi tạo):
         *  Email: "Email 1"
         *  Username: "User name 1"
         *  FullName: "Full name 1"
         *  CreateDate: now
         */
        System.out.println("Question 1:");
        Account[] AccountArrays = new Account[5];
        for (int i = 0; i < AccountArrays.length;i++){
            AccountArrays[i] = new Account();
            AccountArrays[i].email = "Email "+i;
            AccountArrays[i].name = "UserName"+i;
            AccountArrays[i].fullName = "FullName"+i;
            AccountArrays[i].createDate = LocalDate.now();
        }

        for (Account acc: AccountArrays) {
            System.out.println("Thông tin Account");
            System.out.println(acc.email);
            System.out.println(acc.name);
            System.out.println(acc.fullName);
            System.out.println(acc.createDate+"\n");
        }

    }
}
