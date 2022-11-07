package backend.exercise3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Question11 {
    public static boolean Question11() throws MalformedURLException, IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào link: ");
        String link = scanner.next();
        System.out.println("Mời bạn nhập vào đường dẫn folder hoặc file theo định dạng: ");
        System.out.println("C:/Users/Trung Quan/Desktop/thumuc1");
        String folderSave = scanner.next();
        // if folder not Exist or not folder
        File file = new File(folderSave);
        if (!file.exists() || !file.isDirectory()){
            // show message error
            System.out.println("folder not exist or not folder");
            System.out.println("thư mục không tồn tại hoặc không phải là thư mục");
            return false;
        }
        // if folder exist
        // get name file
        String s[] = link.split("/");
        String name = s[s.length -1];
        folderSave = folderSave + "/" + name;
        //create connection to URL
        URL url = new URL(link);
        // open connection
        URLConnection connection = url.openConnection();
        // get size of file
        int size = connection.getContentLength();
        // read file use FileOutputStream
        InputStream in = connection.getInputStream();
        // save file use FileOutputStream
        FileOutputStream output = new FileOutputStream(folderSave);
        int byteDownloaded = 0;
        byte[] b = new byte[1024];
        // get length of file. If not read then length = -1
        int length = in.read(b);
        while (length != -1){
            byteDownloaded += length;
            // print % byte downloaded
            System.out.println(byteDownloaded * 100f / size + "%");
            // wirte content downloaded from position 0 -> length to output
            output.write(b,0,length);
            length = in.read(b);
        }
        // close
        output.close();
        in.close();
        // show message
        System.out.println("Dowload File Success");
        return true;
    }
}
