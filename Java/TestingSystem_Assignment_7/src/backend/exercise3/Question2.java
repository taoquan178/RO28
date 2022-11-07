package backend.exercise3;

import java.io.File;

public class Question2 {
    public static boolean Question2(String PATH, String fileName) throws Exception {
        File file = new File(PATH +"/"+ fileName+".txt");
        Question1 Ex3 = new Question1();
        Ex3.checkFileExists(String.valueOf(file));
        if (file.createNewFile()){
            System.out.println("Tạo file thành công!");
            return true;
        }else {
            System.out.println("Tạo file thất bại!");
            return false;
        }
    }

}
