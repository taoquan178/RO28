import java.util.Scanner;

public class Exercise_4_String {
    public static void main(String[] args) {
        /**
         * Exercise 4: String
         * Question 1:
         * Nhập một xâu kí tự, đếm số lượng các từ trong xâu kí tự đó (các từ có
         * thể cách nhau bằng nhiều khoảng trắng );
         */
        System.out.println("Question 1");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Mời bạn nhập vào 1 xâu kí tự: ");
        String xauKiTu = scanner.nextLine();
        System.out.println("Số lượng các từ trong xâu kí tự: " + xauKiTu.length());
        /**
         * Question 2:
         * Nhập hai xâu kí tự s1, s2 nối xâu kí tự s2 vào sau xâu s1;
         */
        System.out.println("\n Question 2");
        System.out.println("Nhập 2 xâu kí tự s1 và s2");
        System.out.print("Nhập xâu s1: ");
        String xauKiTuS1 = scanner.nextLine();
        System.out.print("Nhập xâu s2: ");
        String xauKiTuS2 = scanner.nextLine();
        xauKiTuS1 +=  xauKiTuS2;
        System.out.println(xauKiTuS1);
        /**
         * Question 3:
         * Viết chương trình để người dùng nhập vào tên và kiểm tra, nếu tên chư
         * viết hoa chữ cái đầu thì viết hoa lên
         */
        System.out.println("\n Question 3");
        System.out.print("Nhập vào tên: ");
        String nhapTen = scanner.nextLine();
        if (nhapTen.charAt(0)<91){ // so sánh với bảng mã ascii
            nhapTen = nhapTen.toUpperCase();
            System.out.println(nhapTen);
        }else {
            nhapTen = nhapTen.toLowerCase();
            System.out.println(nhapTen);
        }
        /**
         * Question 4:
         * Viết chương trình để người dùng nhập vào tên in từng ký tự trong tên
         * của người dùng ra
         * VD:
         * Người dùng nhập vào "Nam", hệ thống sẽ in ra
         * "Ký tự thứ 1 là: N"
         * "Ký tự thứ 1 là: A"
         * "Ký tự thứ 1 là: M"
         */
        System.out.println("\n Question 4");
        System.out.print("Nhập vào tên: ");
        String nhapTen1 = scanner.next();
        for (int i = 0 ; i <nhapTen1.length();i++ ){
            nhapTen1 = nhapTen1.toUpperCase();
            System.out.println("ký tự "+ (i+1) +" là: "+ nhapTen1.charAt(i));
        }
        /**
         * Question 5:
         * Viết chương trình để người dùng nhập vào họ, sau đó yêu cầu người
         * dùng nhập vào tên và hệ thống sẽ in ra họ và tên đầy đủ
         */
        System.out.println("\n Question 5");
        System.out.println("Nhập vào họ của bạn: ");
        String nhapHo = scanner.next();
        System.out.println("Nhập vào tên của bạn: ");
        String nhapTen2 = scanner.next();
        System.out.println("Họ và tên đầy đủ của bạn là: "+ nhapHo+" "+ nhapTen2);
        /**
         * Question 6:
         * Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và
         * sau đó hệ thống sẽ tách ra họ, tên , tên đệm
         * VD:
         * Người dùng nhập vào "Nguyễn Văn Nam"
         * Hệ thống sẽ in ra
         * "Họ là: Nguyễn"
         * "Tên đệm là: Văn"
         * "Tên là: Nam"
         */
        System.out.println("\n Question 6");
        System.out.println("Nhập họ tên đầy đủ của bạn: ");
        scanner.nextLine(); // fix lỗi scanner
        String nhapFullName = scanner.nextLine();
        String fullName = nhapFullName.trim();

        String[] fullNameArrays = fullName.split(" ");

        String ho = fullNameArrays[0];
        String tenDem = "";
        String ten = fullNameArrays[fullNameArrays.length -1];

        for(int i=1; i <= fullNameArrays.length -2;i++){
            tenDem += fullNameArrays[i] + " ";
        }
        System.out.println("Họ của bạn là: "+ho);
        System.out.println("Tên đệm của bạn là: "+tenDem);
        System.out.println("Tên của bạn là: "+ten);

        /**
         * Question 7:
         * Viết chương trình yêu cầu người dùng nhập vào họ và tên đầy đủ và
         * chuẩn hóa họ và tên của họ như sau:
         * a) Xóa dấu cách ở đầu và cuối và giữa của chuỗi người dùng nhập
         * vào3
         * VD: Nếu người dùng nhập vào " nguyễn văn nam " thì sẽ
         * chuẩn hóa thành "nguyễn văn nam"
         * b) Viết hoa chữ cái mỗi từ của người dùng
         * VD: Nếu người dùng nhập vào " nguyễn văn nam " thì sẽ
         * chuẩn hóa thành "Nguyễn Văn Nam"
         */
        System.out.println("\n Question 7");
        System.out.println("Nhập họ tên đầy đủ của bạn: ");
        String nhapFullName1 = scanner.nextLine();
        String fullName1 = nhapFullName1.trim();
        String tenDayDu = "";
        String[] fullNameArrays1 = fullName1.split(" ");
        for(int i=0; i < fullNameArrays1.length;i++){
            tenDayDu += fullNameArrays1[i].substring(0,1).toUpperCase()+fullNameArrays1[i].substring(1)+" ";
        }
        System.out.println(tenDayDu);
        /**
         * Question 8:
         * In ra tất cả các group có chứa chữ "Java"
         */
        System.out.println("\n Question 8");
        String[] groupChuaKiTuJava = new String[]{"Tôi đang học Java", "Tôi đang đi chơi", "Bài tập Java"};
        for (int i = 0; i < groupChuaKiTuJava.length; i++) {
            if (groupChuaKiTuJava[i].indexOf("Java") > 0){
                System.out.println(groupChuaKiTuJava[i]);
            }
        }
        /**
         * Question 9:
         * In ra tất cả các group "Java"
         */
        System.out.println("\n Question 9");
        String[] groupChuaKiTuJava1 = new String[]{"Java", "C++", "SQL","Python","JavaScript","Ruby"};
        for (int i = 0; i < groupChuaKiTuJava1.length; i++) {
            if (groupChuaKiTuJava1[i].equals("Java")){
                System.out.println(groupChuaKiTuJava1[i]);
            }

        }
        /**
         * Question 10 (Optional):
         * Kiểm tra 2 chuỗi có là đảo ngược của nhau hay không.
         * Nếu có xuất ra “OK” ngược lại “KO”.
         * Ví dụ “word” và “drow” là 2 chuỗi đảo ngược nhau.
         */
        System.out.println("\n Question 10");
        String nhapChuoi="quan";
        String nhapChuoiNguoc = "nauq";
        String chuoiDaoNguoc = new StringBuffer(nhapChuoiNguoc).reverse().toString();
        System.out.println(nhapChuoi);
        System.out.println(nhapChuoiNguoc);
        if (nhapChuoi.equals(chuoiDaoNguoc)){
            System.out.println("OK");
        }else {
            System.out.println("KO");
        }
        /**
         * Question 11 (Optional): Count special Character
         * Tìm số lần xuất hiện ký tự "a" trong chuỗi
         */
        System.out.println("\n Question 11");
        String nhapChuoi1="Tôi thích ca hát a và a";
        System.out.println(nhapChuoi1);
        String catChuoi = "";
        int tongSoLan = 0;
        for (int i = 0; i < nhapChuoi1.length();i++){
            catChuoi += nhapChuoi1.charAt(i) +" ";
        }
        System.out.println(catChuoi);
        String[] aArray = catChuoi.split(" ");
        for (int i = 0; i < aArray.length;i++){

            if (aArray[i].equals("a")){
                tongSoLan++;
                System.out.println(aArray[i]);
            }
        }
        System.out.println("Tổng số lần ký tự a xuất hiện trong chuỗi là: "+tongSoLan);
        /**
         * Question 12 (Optional): Reverse String
         * Đảo ngược chuỗi sử dụng vòng lặp
         */
        System.out.println("\n Question 12");
        String chuoi2 = "quan";
        System.out.println("Chuỗi ban đầu: "+ chuoi2);
        int doDaiChuoi2= chuoi2.length();
        String daoNguocChuoi2 = "";
        for (int i = 0; i < chuoi2.length(); i++) {
            doDaiChuoi2--;
            daoNguocChuoi2 +=  chuoi2.charAt(doDaiChuoi2);
        }
        System.out.println("Sau khi đảo qua vòng for: "+daoNguocChuoi2);
        /**
         * Question 13 (Optional): String not contains digit
         * Kiểm tra một chuỗi có chứa chữ số hay không, nếu có in ra false ngược
         * lại true.
         * Ví dụ:
         * "abc" => true
         * "1abc", "abc1", "123", "a1bc", null => false
         */
        System.out.println("\n Question 13");
        String chuoi3 = "as1da23ab";
        for (int i = 0; i < chuoi3.length(); i++) {
            if (chuoi3.charAt(i) >= '1' && chuoi3.charAt(i) <= '9'){
                System.out.println("false");
                return;
            }
        }
        System.out.println(true);
        /**
         Question 14 (Optional): Replace character
         Cho một chuỗi str, chuyển các ký tự được chỉ định sang một ký tự khác
         cho trước.
         Ví dụ:
         "VTI Academy" chuyển ký tự 'e' sang '*' kết quả " VTI Acad*my"
         */
        System.out.println("\n Question 14");
        String chuoi4 = "VTI Academy";
        System.out.println("chuỗi ban đầu: "+chuoi4);
        System.out.println("Chuyển ký tự e sang *: " + chuoi4.replace("e","*"));
        /**
         Question 15 (Optional): Revert string by word
         Đảo ngược các ký tự của chuỗi cách nhau bởi dấu cách mà không dùng
         thư viện.
         Ví dụ: " I am developer " => "developer am I".
         Các ký tự bên trong chỉ cách nhau đúng một dấu khoảng cách.
         Gợi ý: Các bạn cần loại bỏ dấu cách ở đầu và cuối câu, thao tác cắt
         chuỗi theo dấu cách
         */
        System.out.println("\n Question 15");
        System.out.print("Mời bạn nhập vào 1 chuỗi: ");
        String nhapChuoi5 = scanner.nextLine();
        String chuoi5 = nhapChuoi5.trim();
        String inChuoi5 ="";
        String[] chuoi5Array = chuoi5.split(" ");
        int d = chuoi5Array.length;
        for (int i =0; i< chuoi5Array.length; i++){
            d--;
            inChuoi5 += chuoi5Array[d] + " ";
        }
        System.out.println(inChuoi5);
        /**
         Question 16 (Optional):4
         Cho một chuỗi str và số nguyên n >= 0. Chia chuỗi str ra làm các phần
         bằng nhau với n ký tự. Nếu chuỗi không chia được thì xuất ra màn
         hình “KO”.
         */
        System.out.println("\n Question 16");
        System.out.print("Mời bạn nhập vào 1 chuỗi: ");
        String chuoi7 = scanner.next();
        System.out.print("Mời bạn nhập vào số phần để chia: ");
        int n = scanner.nextInt();
        String inChuoi7 = "";

        if((chuoi7.length() % n) == 0 ){
            int ii =0;
            int jj =0;
            for (int i = 0; i < chuoi7.length();i++){
                jj +=n;
                inChuoi7 += chuoi7.substring(ii,jj)+" ";
                ii += n;
                if(jj == chuoi7.length()){
                    System.out.println("Chia chuỗi theo n: "+inChuoi7);
                    return;
                }
            }

        }else {
            System.out.println("KO");
        }



        scanner.close();
    }
}
