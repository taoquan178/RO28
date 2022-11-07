package backend.exercise3;

import java.io.File;
import java.util.Scanner;

public class CheckFile {
    private static Scanner scanner = new Scanner(System.in);

    public static boolean CheckIsExist(String PATH){
        File file = new File(PATH);
        if (file.exists()){
            System.out.println("File có tồn tại");
            return true;
        } else {
            System.out.println("File chưa tồn tại");
            return false;
        }
    }

    public static void DeleteFile(String PATH){
        File file = new File(PATH);
        if (CheckIsExist(PATH) == true){
            if (file.delete()){
                System.out.println("Xoá file thành công!");
            }else {
                System.err.println("Xoá file thất bại!");
            }
        }
    }

    public static String CheckisFile(){
        while (true){
            String inputPATH = scanner.nextLine();
            File file = new File(inputPATH);
            if (file.isFile()){
                CheckIsExist(inputPATH);
                return inputPATH;
           }else {
                System.err.println("Đường dẫn này sai!");
                System.out.print("Mời bạn nhập lại: ");
            }
        }
    }

    public static String CheckForlder(){
        while (true){
            String inputPATH = scanner.nextLine().trim();
            File file = new File(inputPATH);
            if (file.isDirectory()){
                return inputPATH;
            }else {
                System.err.println("Đây không phải folder");
                System.out.print("Mời bạn nhập lại: ");
            }
        }
    }



}
