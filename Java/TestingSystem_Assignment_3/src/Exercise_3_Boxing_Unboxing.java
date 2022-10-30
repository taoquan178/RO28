public class Exercise_3_Boxing_Unboxing {
    public static void main(String[] args) {
        /**
         * Exercise 3(Optional): Boxing & Unboxing
         * Question 1:
         * Khởi tạo lương có datatype là Integer có giá trị bằng 5000.
         * Sau đó convert lương ra float và hiển thị lương lên màn hình (với số
         * float có 2 số sau dấu thập phân)
         */
        System.out.println("Question 1:");
        Integer luong = 5000;
        float catingLuong = (float) luong;
        System.out.printf("%4.2f",catingLuong);
        /**
         * Question 2:
         * Khai báo 1 String có value = "1234567"
         * Hãy convert String đó ra số int
         */
        System.out.println("\n Question 2:");
        String stringDaySo = "1234567";
        Integer intDaySo = (Integer.parseInt(stringDaySo));
        System.out.println(intDaySo);
        /**
         * Question 3:
         * Khởi tạo 1 số Integer có value là chữ "1234567"
         * Sau đó convert số trên thành datatype int
         */
        System.out.println("\n Question 3:");
        Integer daySo = Integer.valueOf("1234567");
        System.out.println(daySo);


    }
}
