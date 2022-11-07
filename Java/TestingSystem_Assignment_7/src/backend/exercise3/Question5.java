package backend.exercise3;

import java.io.File;

public class Question5 {
    public static void Question5(String PATH){
        File file = new File(PATH);
//        System.out.println(file.isDirectory()? "Đây là folder" : "Đây là file");
        if (file.isDirectory()){
            System.out.println("Đây là folder");
        } else if (file.isFile()) {
            System.out.println("Đây là file");
        } else {
            System.out.println("Đây không phải folder và file");
        }
    }
}
