package entity;

public class MyMath {
    public static final float PI = 3.14f;

    public double sumPi(int a){
//        pi = 3.15; không thay đổi được
        return a + PI;
    }

    public static int max(int a, int b) {
        if(a < b){
            return b;
        }else {
            return a;
        }
    }
    public static int min(int a, int b) {
        if(a < b){
            return a;
        }else {
            return b;
        }
    }
    public static int sum(int a, int b) {
        return a+b;
    }

}
