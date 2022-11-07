package backend.exercise1;

import entity.Circle;
import entity.Rectangle;
import entity.ScannerUltis;

public class Question8 {
    public void Question8() throws Exception{
        System.out.println("Tạo 4 hình Rectangle.");
        Rectangle[] rectangleRectangle = new Rectangle[4];
        for (int i = 0; i < 4; i++){
            System.out.println("Hình Rectangle " + (i + 1) + ":");
            System.out.println("Cạnh a: ");
            Float a = ScannerUltis.inputFloat("Nhập vào số, mời bạn nhập lại");
            System.out.println("Cạnh b: ");
            Float b = ScannerUltis.inputFloat("Nhập vào số, mời bạn nhập lại");

            Rectangle rectangle = new Rectangle(a, b);
            System.out.println("Chu vi: "+ rectangle.perimeterCalculation(a,b));
            System.out.println("Diện tích: "+ rectangle.theArea(a,b));
            rectangleRectangle[i] = rectangle;
        }

        System.out.println("Tạo hình Circle 1, nhập vào bán kính ");
        Float circle = ScannerUltis.inputFloat("Nhập vào số, mời bạn nhập lại");
        Circle circle1 = new Circle(circle, circle);
        System.out.println("Chu vi: "+ circle1.perimeterCalculation(circle, circle));
        System.out.println("Chu vi: "+ circle1.theArea(circle, circle));

        System.out.println("Tạo hình Circle 2, nhập vào bán kính ");
        Float circle2 = ScannerUltis.inputFloat("Nhập vào số, mời bạn nhập lại");
        Circle circle3 = new Circle(circle2, circle2);
        System.out.println("Chu vi: "+ circle3.perimeterCalculation(circle2, circle2));
        System.out.println("Chu vi: "+ circle3.theArea(circle2, circle2));

    }
}
