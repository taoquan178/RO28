package com.tn;

import com.tn.entity.Person;
import com.tn.repository.PersonRepositoryBTVN;
import com.tn.utils.ScannerUtils;

import java.util.List;

public class BTVN {
    public static void main(String[] args) {
        PersonRepositoryBTVN btvn = new PersonRepositoryBTVN();

        while (true) {
            System.out.println("==============Menu Application============");
            System.out.println("1: add person                            |");
            System.out.println("2: Get person by id                      |");
            System.out.println("3: Get all data person                   |");
            System.out.println("4: Delete person by id                   |");
            System.out.println("5: Update person by id                   |");
            System.out.println("0: Exit application                      |");
            System.out.println("==========================================");
            System.out.println("Mời bạn nhập lựa chọn: ");
            int choice = ScannerUtils.inputInt();
            switch (choice) {
                case 0:
                    return;
                case 1:
                    System.out.println("Nhập user name: ");
                    String name = ScannerUtils.inputStringFullName();
                    System.out.println("Nhập password: ");
                    String password = ScannerUtils.inputStringPassword();
                    System.out.println("Nhập fullName: ");
                    String fullName = ScannerUtils.inputStringFullName();
                    System.out.println("Nhập email: ");
                    String email = ScannerUtils.inputStringEmail();
                    System.out.println("Chọn type 1: EMPLOYEE - 2: MANAGER ");
                    int personType = 0;
                    int type = ScannerUtils.inputInt();
                    switch (type){
                        case 1:
                            personType = 1;
                            break;
                        case 2:
                            personType = 2;
                            break;
                        default:
                            System.err.println("Bạn nhập vào sai! Mời bạn nhập lại cho đúng");
                    }
                    btvn.addPerson(name,password,fullName,email,personType);
                    break;
                case 2:
                    System.out.println("Nhập id cần tìm: ");
                    int id = ScannerUtils.inputInt();
                    btvn.getPersonById(id);
                    break;
                case 3:
                    // lấy all data Person
                    List<Person> personList = btvn.getListPerson();
                    for (Person person : personList) {
                        System.out.println(person);
                    }
                    break;
                case 4:
                    System.out.println("Nhập id cần xoá: ");
                    int id1 = ScannerUtils.inputInt();
                    btvn.deletePersonById(id1);
                    break;
                case 5:
                    System.out.println("Nhập id cần update: ");
                    int id2 = ScannerUtils.inputInt();
                    System.out.println("Nhập user name mới: ");
                    String name1 = ScannerUtils.inputStringFullName();
                    System.out.println("Nhập password mới: ");
                    String password1 = ScannerUtils.inputStringPassword();
                    System.out.println("Nhập fullName mới: ");
                    String fullName1 = ScannerUtils.inputStringFullName();
                    System.out.println("Nhập email mới: ");
                    String email1 = ScannerUtils.inputStringEmail();
                    System.out.println("Chọn type 1: EMPLOYEE - 2: MANAGER ");
                    int personType1 = 0;
                    int type1 = ScannerUtils.inputInt();
                    switch (type1){
                        case 1:
                            personType1 = 1;
                            break;
                        case 2:
                            personType1 = 2;
                            break;
                        default:
                            System.err.println("Bạn nhập vào sai! Mời bạn nhập lại cho đúng");
                    }
                    btvn.updatePersonById(id2,name1,password1,fullName1,email1,personType1);
                    break;
                default:
                    System.err.println("Bạn nhập vào sai! Mời bạn nhập lại cho đúng");
            }
        }
    }
}
