package backend.exercise1;

import entity.ScannerUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Question6AndQuestion7 implements Comparable<Question6AndQuestion7> {
    private static int COUNT = 1;
    public static void Map(){
        Scanner scanner = new Scanner(System.in);
        Map<Integer,String> mapStudent = new HashMap<>();
        Set<Integer> set = mapStudent.keySet();
        while (true){
            System.out.println("========================");
            System.out.println("1: In ra các key của students");
            System.out.println("2: In ra value của students");
            System.out.println("3: In ra danh sách students được sắp xếp theo tên của student");
            System.out.println("4: Chuyển đổi map students sang set");
            System.out.println("5: Add students");
            System.out.println("0: Thoát chương trình");
            System.out.println("==========================");
            System.out.println("Mời bạn nhập lựa chọn");
            int choice = ScannerUtils.InputInt("Bạn phải nhập vào dữ liệu là số");
            switch (choice){
                case 0:
                    return;
                case 1:
                    for(Integer key : set){
                        System.out.println("Key id của student là: "+key);
                    }
                    break;
                case 2:
                    for(Integer key : set){
                        System.out.println("value của student là: "+ mapStudent.get(key));
                    }
                    break;
                case 3:
                    System.out.println("chưa xong");
                    break;
                case 4:
                    System.out.println("chưa xong");
                    break;
                case 5:
                    System.out.println("Mời bạn nhập vào số lượng Students cần add:");
                    int numberStudents = ScannerUtils.InputInt("Bạn phải nhập vào dữ liệu là số");
                    for (int i=0;i< numberStudents;i++){
                        System.out.println("Mời bạn nhập nào Name student");
                        String nameMapStudent = ScannerUtils.InputString("Bạn phải nhập vào 1 chuỗi");
                        mapStudent.put(COUNT++,nameMapStudent);
                        System.out.println("Nhập thành công student!" + COUNT);
                    }
                    for(Integer key : set){
                        System.out.println(key + " "+ mapStudent.get(key));
                    }
                    break;
                default:
                    System.out.println("mời bạn nhập lại");
            }
        }


    }

    @Override
    public int compareTo(Question6AndQuestion7 o) {
        return 0;
    }
}
