package backend.exercise3;

import java.io.File;

public class Question6 {
    public static void Question6(String PATH){
        File file = new File(PATH);
        for (String nameFile : file.list()){
            System.out.println(nameFile);
        }
//        if (file.list().length > 0){
//            for (String nameFile : file.list()){
//                System.out.println(nameFile);
//            }
//        }

    }
}
