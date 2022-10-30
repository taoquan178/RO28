import java.util.Scanner;

public class ATest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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

    }

}
