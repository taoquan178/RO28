package Entity;

public class HinhChuNhat {

    private Float a;
    private Float b;

    public HinhChuNhat(Float a, Float b) {
        this.a = a;
        this.b = b;
    }

    public void TinhChuVi() {
       float c = 2 * (a + b);
        System.out.println("Chu vi là: "+ c);
    }

    public void TinhDienTich() {
        float c = a*b;
        System.out.println("Diện tích là: "+ c);
    }
}
