package org.example.vti.menu;

import org.example.vti.controller.DepartmentController;
import org.example.vti.entity.Department;
import org.example.vti.repository.DepartmentRepository;
import org.example.vti.service.impl.DepartmentServiceImpl;
import org.example.vti.util.ScannerUtils;

import java.util.List;

public class MenuDepartment {
    public static void menuDepartment(){
        DepartmentRepository dRepository = new DepartmentRepository();
        DepartmentServiceImpl dService = new DepartmentServiceImpl(dRepository);
        DepartmentController dController = new DepartmentController(dService);
        while (true){
            System.out.println("================Department================");
            System.out.println("1: Show department                       |");
            System.out.println("2: Create department                     |");
            System.out.println("3: Update department                     |");
            System.out.println("4: Delete department                     |");
            System.out.println("5: Get department by id                  |");
            System.out.println("6: Check department exists               |");
            System.out.println("7: deleteDepartmentUsingProcedure        |");
            System.out.println("0: Exit department                       |");
            System.out.println("==========================================");
            System.out.println("Mời bạn nhập lựa chọn: ");
            int choice = ScannerUtils.inputInt();
            switch (choice){
                case 0:
                    return;
                case 1:
                    System.out.println("==========Danh Sách Department==========");
                    List<Department> departments = dController.getListDepartment();
                    for (Department department : departments){
                        System.out.println(department);
                    }
                    break;
                case 2:
                    Department requestD = new Department();
                    System.out.println("Mời bạn nhập vào tên department cần tạo: ");
                    String departmentName = ScannerUtils.inputString();
                    requestD.setName(departmentName);
                    dController.addDepartment(requestD);
                    break;
                case 3:
                    System.out.println("Mời bạn nhập vào department id: ");
                    int dpartmentID = ScannerUtils.inputInt();
                    System.out.println("Mời bạn nhập vào tên department bạn muốn sửa: ");
                    String departmentName1 = ScannerUtils.inputString();
                    Department requestDUpdate = new Department();
                    requestDUpdate.setId(dpartmentID);
                    requestDUpdate.setName(departmentName1);
                    dController.updateDepartment(requestDUpdate);
                    break;
                case 4:
                    System.out.println("Mời bạn nhập vào department id cần xoá");
                    int dpartmentID1 = ScannerUtils.inputInt();
                    Department requestDDelete = new Department();
                    requestDDelete.setId(dpartmentID1);
                    dController.deleteDepartment(requestDDelete);
                    break;
                case 5:
                    System.out.println("Mời bạn nhập id cần tìm: ");
                    int searchID = ScannerUtils.inputInt();
                    dController.searchDepartmentID(searchID);
                    break;
                case 6:
                    System.out.println("Mời bạn nhập vào tên department cần kiểm tra: ");
                    String checkDepartmentName = ScannerUtils.inputString();
                    dController.checkDataExists(checkDepartmentName);
                    break;
                case 7:
                    System.out.println("Mời bạn nhập vào id cần xoá: ");
                    int id = ScannerUtils.inputInt();
                    dController.deleteDepartmentUsingProcedure(id);
                    break;
                default:
                    System.err.println("Bạn nhập vào sai! Mời bạn nhập lại cho đúng");
            }
        }
    }
}
