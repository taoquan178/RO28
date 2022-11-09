package backend.exercise4;

import backend.exercise3.CheckFile;
import backend.exercise3.Question2;
import backend.exercise3.Question4;
import entity.StudentEx1;

import java.io.*;
import java.util.Scanner;

public class IOManager {
    public static void readFile(String pathFile) throws Exception {

        File file = new File(pathFile);
        if (!file.exists()){
            throw new Exception("Error! File Not Exist.");
        }

        FileInputStream in = new FileInputStream(pathFile);
        byte[] b = new byte[1024]; // khai báo read 1 kb

        // convert 1kb to length of string
        int length = in.read(b); // read() là đọc tất - nhưng chỉ nên đọc 1024 byte để tránh đơ máy

        while (length > -1){ // length sẽ = -1 khi không còn data nữa
            // vị trí b là đọc 1 kb , từ vị trí số 0 đến cuối length
            String content = new String(b,0,length);
            System.out.println(content);

            length = in.read(b); // làm mới lại length
        }
        in.close(); // đóng FileInputStream
    }

    public static void writeFile(String pathFile,boolean isContinuing , String content) throws Exception {
        File file = new File(pathFile);
        if (!file.exists()){
            throw new Exception("Error! File Not Exist.");
        }
        // isContinuing = true thì ghi tiếp,  false thì ghi đè nội dung cũ
        FileOutputStream fileOutputStream = new FileOutputStream(pathFile,isContinuing);
        fileOutputStream.write(content.getBytes()); // ghi nội dung vào file, convert theo kiểu byte
        System.out.println("ADD CONTENT TO FILE SUCCESS");
        fileOutputStream.close();
    }

    public static void readFileScanner(String PATH) {
        // cách read file sử dụng scanner
        try {
            // pass the path to the file as a parameter
            File file = new File(PATH);
            // Sử dụng constructor của Scanner
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) System.out.println(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Quá trình đọc file bị lỗi");
        }
    }

    public static void writeObject(Object object, String path, String fileName) throws Exception {
        if (object == null){
            throw new Exception("Error! Object is Null.");
        }

        File filepath = new File(path);
        if (!filepath.exists()){
            if (filepath.mkdirs()){
                System.out.println("Tạo thư mục thành công");
            }else {
                System.out.println("Tạo thư mục thất bại");
            }
        }
        String file = path +"/"+ fileName+".txt";
        boolean a = CheckFile.CheckIsExist(file);
        if (a){
            Question4.Question4(file);
            Question2.Question2(path,fileName);
        } else {
            Question2.Question2(path,fileName);
        }

        FileOutputStream inputStream = new FileOutputStream(file);
        ObjectOutputStream outputStream = new ObjectOutputStream(inputStream);
        outputStream.writeObject(object);
        System.out.println("Write Object thành công");
        outputStream.close();
    }

//    public static Object readObject(Object object ,String filePath) throws IOException, ClassNotFoundException {
//        FileInputStream fileInputStream = new FileInputStream(filePath);
//        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//        Object obj = objectInputStream.readObject();
//
//        objectInputStream.close();
//        StudentEx1 studentEx1 = (StudentEx1) obj;
//        System.out.println(studentEx1.getName());
//        System.out.println(studentEx1);
//        fileInputStream.close();
//        System.out.println("WRITE_FILE_SUCCESS");
//        System.out.println(obj);
//        return obj;
//    }

    public static void readObject(Object object ,String filePath,boolean isContinuing) {
        try {
            //mở luồng kết nối đến file để ghi dữ liệu
            FileOutputStream fos = new FileOutputStream(filePath,isContinuing);
            //ghi dữ liệu ra file
            fos.write(object.toString().getBytes());
            //đóng luồng kết nối lại
            fos.close();
            System.out.println("ghi dữ liệu ra file thành công");
        }catch (Exception e){
            System.out.println("file không tồn tại");
        }
    }
}
