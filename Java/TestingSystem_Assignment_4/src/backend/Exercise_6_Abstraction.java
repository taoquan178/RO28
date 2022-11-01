package backend;
import entity.*;
import java.util.Scanner;

public class Exercise_6_Abstraction {

    public void Question1(){
        VietnamesePhone vnPhone = new VietnamesePhone();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("===========================");
            System.out.println("Mời bạn nhập lựa chọn");
            System.out.println("1: Thêm Concact");
            System.out.println("2: Xoá Concact");
            System.out.println("3: Sửa Concact");
            System.out.println("4: Tìm kiếm Concact");
            System.out.println("5: Hiển thị Concact");
            System.out.println("6: Question 3");
            System.out.println("0: Thoát");
            System.out.println("===========================");
            System.out.print("Mời bạn nhập vào lựa chọn: ");

            int chon = scanner.nextInt();
            switch (chon){
                case 0:
                    return;
                case 1:
                    System.out.print("Mời bạn nhập vào tên: ");
                    String nhapTen = scanner.next();
                    System.out.print("Mời bạn nhập vào số điện thoại: ");
                    String nhapPhone = scanner.next();
                    vnPhone.insertContact(nhapTen,nhapPhone);
                    break;
                case 2:
                    System.out.print("Mời bạn nhập vào tên cần xoá: ");
                    String xoa = scanner.next();
                    vnPhone.removeContact(xoa);
                    break;
                case 3:
                    System.out.print("Mời bạn nhập vào tên cần sửa: ");
                    String suaTen = scanner.next();
                    System.out.print("Mời bạn nhập vào phone mới: ");
                    String suaPhone = scanner.next();
                    vnPhone.updateContact(suaTen,suaPhone);
                    break;
                case 4:
                    System.out.print("Mời bạn nhập vào tên cần tìm: ");
                    String timTen = scanner.next();
                    vnPhone.searchContact(timTen);
                    break;
                case 5:
                    vnPhone.showContact();
                    break;
                case 6:
                    Question3();
                    break;
                default:
                    System.out.println("Mời bạn nhập lại!");

            }
        }
    }

    public void  Question3(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("==================");
            System.out.println("1: Add Employee");
            System.out.println("2: Add Manager");
            System.out.println("3: Add Waiter");
            System.out.println("0: Quay lại");
            System.out.println("==================");
            System.out.print("Mời bạn nhập lựa chọn: ");
            int chon = scanner.nextInt();
            switch (chon){
                case 0:
                    return;
                case 1:
                    System.out.print("Nhập name Employee: ");
                    String nameEmployee = scanner.next();
                    System.out.print("Nhập name Employee: ");
                    double salaryRatioEmployee = scanner.nextDouble();
                    Employee employee = new Employee(nameEmployee,salaryRatioEmployee);
                    employee.displayInfor();
                    employee.calculatePay();
                    break;
                case 2:
                    System.out.print("Nhập name Manager: ");
                    String nameManager = scanner.next();
                    System.out.print("Nhập name Manager: ");
                    double salaryRatioManager = scanner.nextDouble();
                    Manager manager = new Manager(nameManager,salaryRatioManager);
                    manager.displayInfor();
                    manager.calculatePay();
                    break;
                case 3:
                    System.out.print("Nhập name Waiter: ");
                    String nameWaiter = scanner.next();
                    System.out.print("Nhập name Waiter: ");
                    double salaryRatioWaiter = scanner.nextDouble();
                    Waiter waiter = new Waiter(nameWaiter,salaryRatioWaiter);
                    waiter.displayInfor();
                    waiter.calculatePay();
                    break;
                default:
                    System.out.println("Mời bạn chọn lại");
            }
        }
    }
}
