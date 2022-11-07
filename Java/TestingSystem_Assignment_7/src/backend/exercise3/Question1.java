package backend.exercise3;

import java.io.File;

public class Question1 {

    public void Question1(String PATH) {
        File file = new File(PATH);
        boolean isFile = file.isFile();
        if (isFile) {
            System.out.println("Đường dẫn này là: " + isFile);
        }
        boolean result = file.exists();
        if (result){
            System.out.println("File đã tồn tại");
        }else {
            System.out.println("File chưa tồn tại");
        }
    }

    public void checkFileExists(String PATH) throws Exception {
        File file = new File(PATH);
        boolean isFile = file.isFile();
        if (isFile) {
            System.out.println("Đường dẫn này là: " + isFile);
        }
        boolean result = file.exists();
        if (result){
            System.out.println("File đã tồn tại");
            throw new Exception("Error! File Exist.");
        }else {
            System.out.println("File chưa tồn tại");
        }
    }

    public void checkFileDoesNotExist(String PATH) throws Exception {
        File file = new File(PATH);
        boolean isFile = file.isFile();
        if (isFile) {
            System.out.println("Đường dẫn này là: " + isFile);
        }
        boolean result = file.exists();
        if (result){
            System.out.println("File đã tồn tại");

        }else {
            System.out.println("File chưa tồn tại");
            throw new Exception("Error! File Exist.");
        }
    }
}
