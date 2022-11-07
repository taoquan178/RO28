package backend.exercise3;

import java.io.File;
import java.util.Scanner;

public class Question10 {
    public static void Question10(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập vào đường dẫn folder theo định dạng: ");
        System.out.println("C:/Users/Trung Quan/Desktop");
        System.out.print("Mời bạn nhập: ");
        String sourcefolder = CheckFile.CheckForlder();
        System.out.print("Mời bạn nhập vào tên folder muốn tạo: ");
        String folderName = scanner.next();
        String createFolder = sourcefolder+ "/" + folderName;
        File file = new File(createFolder);
        if (!file.exists()){
            if (file.mkdir()){
                System.out.println("Tạo thư mục thành công");
            }else {
                System.out.println("Tạo thư mục thất bại");
            }
        }
    }

}
