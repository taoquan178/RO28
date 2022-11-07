package backend.exercise3;

import java.io.File;

public class Question4 {
    public static void Question4(String PATH) throws Exception {
        Question1 q1 = new Question1();
        q1.checkFileDoesNotExist(PATH);
        File file = new File(PATH);
        if (file.delete()){
            System.out.println("Xoá thành công!");
        }else {
            System.out.println("Xoá thất bại!");
        }
    }
}
