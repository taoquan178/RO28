import Entity.*;

import java.util.NoSuchElementException;
import java.util.Scanner;

import static Entity.ScannerUtils.inputInt;
import static Entity.ScannerUtils1.inputInt1;

public class Main {
    public static void main(String[] args) {
        //Exercise 2: Exception
        //Question 1
//        System.out.println("Question 1 + 2");
//        try {
//            float result = divide(7,0);
//            System.out.println(result);
//        }catch (RuntimeException e ){
//            System.out.println("cannot divide 0");
//        }finally {
//            System.out.println("divide completed!");
//        }
//        System.out.println("Question 3");
//        try {
//        int[] numbers = {1,2,3};
//        System.out.println(numbers[10]);
//        }catch (IndexOutOfBoundsException e){
//            throw new IndexOutOfBoundsException("Không có data này trong mảng");
//        }
//        System.out.println("Question 4");
//        String[] departments = {"data1", "data2","data3"};
//        getIndex(departments);
//        System.out.println("Question 5");
//        try {
//            int aa = inputAge();
//            System.out.println(aa);
//        }catch (NoSuchElementException e){
//            System.out.println("wrong inputing! Please input an age as int, input again.");
//        }

//            System.out.println("Question 6");
//            while (true) {
//                try {
//                    int a = inputAge1();
//                    System.out.println(a);
//                    return;
//                } catch (NoSuchElementException e) {
//                    System.out.println("wrong inputing! Please input an age as int, input again.");
//                }
//            }
//        System.out.println("Question 7");
//        inputInt();

//        System.out.println("Question 8");
//        System.out.println("Nhập id: ");
//        int id = ScannerUtils1.inputInt1("id phải là 1 số, mời nhập lại: ");
//
//        System.out.println("id của bạn: " + id);
//
//        System.out.println("Nhập money: ");
//        float money = ScannerUtils1.inputFloat("money phải là 1 số thực, mời nhập lại: ");
//
//        System.out.println("Money của bạn: " + money);
//
//        System.out.println("Nhập tên: ");
//        String name = ScannerUtils1.inputString("Tên của bạn phải là 1 String khác rỗng, mời nhập lại: ");
//
//        System.out.println("Money của bạn: " + name);
//        System.out.println("Question 9");
//        // department
//        System.out.println("Nhập thông tin department: ");
//        Department department = new Department();
//        System.out.println(department);
//
//        // position
//        System.out.println("Nhập thông tin position: ");
//        Position position = new Position();
//        System.out.println(position);

        System.out.println("Question 10");
        // group
        System.out.println("Nhập thông tin group: ");
        Group group = new Group();
        System.out.println(group);

        System.out.println("Question 11 + 12");
        // account
        System.out.println("Nhập thông tin account: ");
        Account account = new Account();
        System.out.println(account);


    }
    static int inputAge1() throws NoSuchElementException{
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào 1 số: ");
        int motSo = scanner.nextInt();
        return motSo;
    }

    static int inputAge() throws NoSuchElementException{
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào 1 số: ");
        int motSo = scanner.nextInt();
        return motSo;
    }

    static void getIndex( String[] departments){
        try {
            for(int i = 0; i<= departments.length; i++){
                System.out.println(departments[i]);
            }
        }catch (IndexOutOfBoundsException e){
            System.out.println("Cannot find department.");
        }
    }
    public static float divide(int a, int b) throws RuntimeException {
        return a/b;
    }

}