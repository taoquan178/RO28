package backend.exercise3;

import entity.exercise3.CPU;

public class Question1 {
    public static void Question1InnerClass(){
        CPU cpu1 = new CPU();
        CPU.Processor processor1 = cpu1.new Processor();
        CPU.Ram ram1 = cpu1.new Ram();

        Float cache = processor1.getCache();
        Float clockSpeed = ram1.getClockSpeed();

        System.out.println(cache);
        System.out.println(clockSpeed);


    }
}
