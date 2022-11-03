package BackEnd;

import Entity.MyMath;

import java.util.Scanner;

public class Exercise_2_Polymorphism_Q4 {
    public static void Question4(){
        MyMath myMath = new MyMath();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("=============================");
            System.out.println("1: Chọn kiểu dữ liệu số: ");
            System.out.println("0: Thoát chương trình");
            System.out.println("=============================");
            System.out.print("Mời bạn nhập lựa chọn: ");
            int choice = scanner.nextInt();
            switch (choice){
                case 0:
                    return;
                case 1:
                    System.out.println("=============================");
                    System.out.println("Chọn kiểu dữ liệu số a");
                    System.out.println("1: Kiểu int");
                    System.out.println("2: Kiểu byte");
                    System.out.println("3: Kiểu fload");
                    System.out.println("=============================");
                    System.out.print("Mời bạn nhập lựa chọn: ");
                    int choice1 = scanner.nextInt();
                    switch (choice1){
                        case 1:
                            System.out.print("Nhập số a: ");
                            int a = scanner.nextInt();
                            System.out.println("=============================");
                            System.out.println("Chọn kiểu dữ liệu số b");
                            System.out.println("1: Kiểu int");
                            System.out.println("2: Kiểu byte");
                            System.out.println("3: Kiểu fload");
                            System.out.println("=============================");
                            System.out.print("Mời bạn nhập lựa chọn: ");
                            int choice2 = scanner.nextInt();
                            switch (choice2){
                                case 1:
                                    System.out.print("Nhập số b: ");
                                    int b = scanner.nextInt();
                                    System.out.println("Tổng của chúng là: "+myMath.getSum(a,b));
                                    break;
                                case 2:
                                    System.out.print("Nhập số b: ");
                                    byte b1 = scanner.nextByte();
                                    System.out.println("Tổng của chúng là: "+myMath.getSum(a,b1));
                                    break;
                                case 3:
                                    System.out.print("Nhập số b: ");
                                    float b2 = scanner.nextFloat();
                                    System.out.println("Tổng của chúng là: "+myMath.getSum(a,b2));
                                    break;
                                default:
                                    System.out.println("Mời bạn nhập lại");
                            }
                            break;
                        case 2:
                            System.out.print("Nhập số a: ");
                            byte aa = scanner.nextByte();
                            System.out.println("=============================");
                            System.out.println("Chọn kiểu dữ liệu số b");
                            System.out.println("1: Kiểu int");
                            System.out.println("2: Kiểu byte");
                            System.out.println("3: Kiểu fload");
                            System.out.println("=============================");
                            System.out.print("Mời bạn nhập lựa chọn: ");
                            int choice3 = scanner.nextInt();
                            switch (choice3){
                                case 1:
                                    System.out.print("Nhập số b: ");
                                    int bb = scanner.nextInt();
                                    System.out.println("Tổng của chúng là: "+myMath.getSum(aa,bb));
                                    break;
                                case 2:
                                    System.out.print("Nhập số b: ");
                                    byte bb1 = scanner.nextByte();
                                    System.out.println("Tổng của chúng là: "+myMath.getSum(aa,bb1));
                                    break;
                                case 3:
                                    System.out.print("Nhập số b: ");
                                    float bb2 = scanner.nextFloat();
                                    System.out.println("Tổng của chúng là: "+myMath.getSum((int) aa,bb2));
                                    break;
                                default:
                                    System.out.println("Mời bạn nhập lại");
                            }
                            break;
                        case 3:
                            System.out.print("Nhập số a: ");
                            float aaa = scanner.nextFloat();
                            System.out.println("=============================");
                            System.out.println("Chọn kiểu dữ liệu số b");
                            System.out.println("1: Kiểu int");
                            System.out.println("2: Kiểu byte");
                            System.out.println("3: Kiểu fload");
                            System.out.println("=============================");
                            System.out.print("Mời bạn nhập lựa chọn: ");
                            int choice4 = scanner.nextInt();
                            switch (choice4){
                                case 1:
                                    System.out.print("Nhập số b: ");
                                    int bbb = scanner.nextInt();
                                    myMath.getSum(aaa,bbb);
                                    System.out.println("Tổng của chúng là: "+myMath.getSum(aaa,bbb));
                                    break;
                                case 2:
                                    System.out.print("Nhập số b: ");
                                    byte bbb1 = scanner.nextByte();
                                    System.out.println("Tổng của chúng là: "+myMath.getSum(aaa, (int) bbb1));
                                    break;
                                case 3:
                                    System.out.print("Nhập số b: ");
                                    float bbb2 = scanner.nextFloat();
                                    System.out.println("Tổng của chúng là: "+myMath.getSum(aaa,bbb2));
                                    break;
                                default:
                                    System.out.println("Mời bạn nhập lại");
                            }
                            break;
                        default:
                            System.out.print("Mời bạn nhập lại");
                    }
                    break;
                default:
                    System.out.println("Mời bạn nhập lại");
            }
        }
    }
}
