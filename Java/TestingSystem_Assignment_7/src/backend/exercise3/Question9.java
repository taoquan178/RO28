package backend.exercise3;

import java.io.File;
import java.util.Scanner;

public class Question9 {
    public static void Question9() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập vào đường dẫn file theo định dạng: ");
        System.out.println("C:/Users/Trung Quan/Desktop/file1.txt");
        System.out.print("Mời bạn nhập: ");
        String source = CheckFile.CheckisFile();
        if (CheckFile.CheckIsExist(source) == false){
            throw new Exception("Error! File Not Exist.");
        }
        String url = "";
        String[] s = source.split("/");
        for (int i=0; i < s.length -1;i++){
            url += s[i]+"/";
        }
        System.out.print("Mời bạn nhập vào tên cần đổi: ");
        String newName = scanner.next();
        String newSource = url+ newName+".txt";
        if (CheckFile.CheckIsExist(newSource) == true){
            throw new Exception("Error! Name is Exist.");
        }
        File oldFile = new File(source);
        File newFile = new File(newSource);
        if (oldFile.renameTo(newFile)){
            System.out.println("Đổi tên thành công");
        }else {
            System.err.println("Đổi tên thất bại");
        }
    }
}
