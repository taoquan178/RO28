package backend.exercise3;

import entity.exercise3.Car;

public class Question2 {
    public static void Question2Ex3method(){
        Car car = new Car("Mazda", "8WWD");
        Car.Engine engine = car.new Engine("Crysler");
        System.out.println("Thông tin xe: " + car);
        System.out.println("Thông tin động cơ: " + engine);
    }
}
