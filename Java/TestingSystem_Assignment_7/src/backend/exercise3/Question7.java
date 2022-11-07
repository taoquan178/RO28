package backend.exercise3;

import java.io.*;
import java.util.Scanner;

public class Question7 {
    public static void Question7() throws Exception {
//        Question1 q1 = new Question1();
//        System.out.print("file outDest: ");
//        q1.checkFileDoesNotExist(source);
//        System.out.print("file dest: ");
//        q1.checkFileExists(dest);
//        File sourceFile = new File(source);
//        File destFile = new File(dest);

//        File.copy(sourceFile.toPath(), destFile.toPath());

        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập vào đường dẫn file theo định dạng: ");
        System.out.println("C:/Users/Trung Quan/Desktop/file1.txt");
        System.out.print("Mời bạn nhập URL file cần copy: ");
        String source = CheckFile.CheckisFile(); // nhập vào và kiểm tra đường dẫn và file có tồn tại hay không
        File sourceFile = new File(source);

        String[] s = source.split("/"); // cắt đường dẫn file người dùng nhập vào vừa nãy
        String fileName = s[s.length - 1];  // cắt ra phần tên file
        System.out.println(fileName);

        System.out.println("Mời bạn nhập vào đích đến theo định dạng: ");
        System.out.println("C:/Users/Trung Quan/Desktop/Khoa_Hoc_Java-VTI");
        System.out.print("Mời bạn nhập đích cần copy file đến: ");
        String dest = CheckFile.CheckForlder(); // nhập vào và kiểm tra xem có phải folder hay không
        String fullDest = dest + "/" + fileName;   // gán tên file vào đích cần chuyển đến
        String copyFullDest = null;
        if (CheckFile.CheckIsExist(fullDest) == true){
             copyFullDest = dest + "/"+"Copy-"+ fileName;
            System.out.println("tự động change lại tên file!");
        } else {
             copyFullDest = dest + "/" + fileName;
        }
        File destFile = new File(copyFullDest);


        InputStream inSource = null;
        OutputStream outDest =null;
        try {
            inSource = new FileInputStream(sourceFile);
            outDest = new FileOutputStream(destFile);

            byte[] buffer = new byte[1024];
            int length;

            while ((length = inSource.read(buffer)) > 0){
                outDest.write(buffer, 0, length);
            }
            System.out.println("Copy file thành công!");
        }catch (IOException e){
            e.printStackTrace();
        } finally {
            inSource.close();
            outDest.close();
        }



    }
}
