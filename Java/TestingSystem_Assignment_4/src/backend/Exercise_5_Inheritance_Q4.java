package backend;
import entity.*;
import java.time.LocalDate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise_5_Inheritance_Q4 {
//    public static void main(String[] args) {
//     QLTV();
//    }

    public static void QLTV() {
        ArrayList<Document>  documentList;
        documentList = new ArrayList<Document>();
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("===============================");
            System.out.println("1: Thêm tài liệu");
            System.out.println("2: Xoá tài liệu");
            System.out.println("3: Hiển thị thông tin tài liệu");
            System.out.println("4: Tìm kiếm tài liệu");
            System.out.println("0: Thoát");
            System.out.println("===============================");
            System.out.print("Mời bạn nhập lựa chọn :");
            int chon = scanner.nextInt();
            switch (chon){
                case 0:
                    return;
                case 1:
                    AddDocument(documentList);
                    break;
                case 2:
                    System.out.print("Nhập id tài liệu cần xoá: ");
                    int nhapID = scanner.nextInt();
                    documentList.removeIf(Document -> Document.getId() == nhapID);
                    for (Document documentArray : documentList){
                        System.out.println(documentArray);
                    }
                    break;
                case 3:
                    for (Document documentArray : documentList){
                        System.out.println(documentArray);
                    }
                    break;
                case 4:
                    Search(documentList);
                    break;
                default:
                    System.out.println("Mời bạn nhập lại");
            }

        }

    }

    private static void Search(ArrayList<Document>  documentList) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("==========================");
            System.out.println("Mời bạn chọn loại tìm kiếm");
            System.out.println("1: Tìm kiếm theo sách");
            System.out.println("2: Tìm kiếm theo tạp trí");
            System.out.println("3: Tìm kiếm theo báo");
            System.out.println("0: Quay lại");
            System.out.println("==========================");
            System.out.print("Mời bạn nhập lựa chọn: ");
            int chon1 = scanner.nextInt();
            switch(chon1){
                case 0:
                    return;
                case 1:
                    for (Document documentArray : documentList){
                        if (documentArray instanceof Book){
                            System.out.println(documentArray);
                        }
                    }
                    break;
                case 2:
                    for (Document documentArray : documentList){
                        if (documentArray instanceof Magazine){
                            System.out.println(documentArray);
                        }
                    }
                    break;
                case 3:
                    for (Document documentArray : documentList){
                        if (documentArray instanceof Newspaper){
                            System.out.println(documentArray);
                        }
                    }
                    break;
                default:
                    System.out.println("Mời bạn nhập lại");
            }
        }
    }

    private static void AddDocument(ArrayList<Document>  documentList) {
        Scanner scanner = new Scanner(System.in);
        int id = 0;
        while(true){
            System.out.println("===============================");
            System.out.println("Bạn chọn thêm tài liệu");
            System.out.println("1: Thêm sách");
            System.out.println("2: Thêm tạp chí");
            System.out.println("3: Thêm báo");
            System.out.println("0: Quay lại");
            System.out.println("===============================");
            int chon = scanner.nextInt();
            switch (chon){
                case 0:
                    return;
                case 1:
                    System.out.print("Nhập vào tên nhà xuất bản: ");
                    String imprint = scanner.next();
                    System.out.print("Nhập vào số bản phát hành: ");
                    int releaseNumber = scanner.nextInt();
                    System.out.print("Nhập vào tên tác giả: ");
                    String author = scanner.next();
                    System.out.print("Nhập vào số trang: ");
                    int numberOfPages = scanner.nextInt();
                    Document book = new Book(id,imprint,releaseNumber,author,numberOfPages);
                    documentList.add(book);
                    id++;
                    break;
                case 2:
                    System.out.print("Nhập vào tên nhà xuất bản: ");
                    String imprint1 = scanner.next();
                    System.out.print("Nhập vào số bản phát hành: ");
                    int releaseNumber1 = scanner.nextInt();
                    System.out.print("Nhập vào số phát hành: ");
                    int issueNumber = scanner.nextInt();
                    System.out.print("Nhập vào ngày phát hành: ");
                    int dayMagazine = scanner.nextInt();
                    System.out.print("Nhập vào tháng phát hành: ");
                    int monthMagazine = scanner.nextInt();
                    System.out.print("Nhập vào năm phát hành: ");
                    int yearMagazine = scanner.nextInt();
                    LocalDate issueMonth = LocalDate.of(yearMagazine,monthMagazine,dayMagazine);
                    Document magazine = new Magazine(id,imprint1,releaseNumber1,issueNumber,issueMonth);
                    documentList.add(magazine);
                    id++;
                    break;
                case 3:
                    System.out.print("Nhập vào tên nhà xuất bản: ");
                    String imprint2 = scanner.next();
                    System.out.print("Nhập vào số bản phát hành: ");
                    int releaseNumber2 = scanner.nextInt();
                    System.out.print("Nhập vào ngày phát hành: ");
                    int dayNewspaper = scanner.nextInt();
                    System.out.print("Nhập vào tháng phát hành: ");
                    int monthNewspaper = scanner.nextInt();
                    System.out.print("Nhập vào năm phát hành: ");
                    int yearNewspaper = scanner.nextInt();
                    LocalDate releaseDate = LocalDate.of(yearNewspaper,monthNewspaper,dayNewspaper);
                    Document newspaper = new Newspaper(id,imprint2,releaseNumber2,releaseDate);
                    documentList.add(newspaper);
                    id++;
                    break;
                default:
                    System.out.println("Mời bạn nhập lại");
            }

        }
    }


}
