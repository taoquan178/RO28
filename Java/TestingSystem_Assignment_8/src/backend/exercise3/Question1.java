package backend.exercise3;

import entity.StudentEx3;

public class Question1 {
    public static void genericClass(){
        StudentEx3<Integer> student1 = new StudentEx3<Integer>(1,"Quân");
        StudentEx3<Float> student2 = new StudentEx3<Float>(2.5f,"Linh");
        StudentEx3<Double> student3 = new StudentEx3<Double>(3.3d,"Trang");

        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);

    }
}
