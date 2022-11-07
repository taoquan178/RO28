package backend.exercise3;

import java.io.*;
import java.util.Scanner;

public class Question8 {
    public static void Question8() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập vào đường dẫn file theo định dạng: ");
        System.out.println("C:/Users/Trung Quan/Desktop/file1.txt");
        System.out.print("Mời bạn nhập: ");
        String source = CheckFile.CheckisFile(); // nhập vào và kiểm tra đường dẫn và file có tồn tại hay không
        File sourceFile = new File(source);

        String[] s = source.split("/"); // cắt đường dẫn file người dùng nhập vào vừa nãy
        String fileName = s[s.length - 1];  // cắt ra phần tên file
        System.out.println(fileName);

        System.out.println("Mời bạn nhập vào đích đến theo định dạng: ");
        System.out.println("C:/Users/Trung Quan/Desktop/Khoa_Hoc_Java-VTI");
        System.out.print("Mời bạn nhập đích cần chuyển file đến: ");
        String dest = CheckFile.CheckForlder(); // nhập vào và kiểm tra xem có phải folder hay không
        String fullDest = dest + "/" + fileName;   // gán tên file vào đích cần chuyển đến
        CheckFile.DeleteFile(fullDest); // kiểm tra xem file có tồn tại không, có thì xoá
        File destFile = new File(fullDest);

        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(sourceFile);
            out = new FileOutputStream(destFile);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer))>0){
                out.write(buffer, 0, length);
            }
            System.out.println("Chuyển file hoàn thành!");
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            in.close();
            out.close();
        }
        sourceFile.delete(); // xoá file cũ

    }
}
