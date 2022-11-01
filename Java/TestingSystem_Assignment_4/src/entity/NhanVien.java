package entity;

public class NhanVien extends CanBo {
    private String congViec;

    public NhanVien(String name,int age,Gender gender, String hometown ,String congViec) {
        super(name,age,gender,hometown);
        this.congViec = congViec;
    }

    public String getCongViec() {
        return congViec;
    }

    public void setCongViec(String congViec) {
        this.congViec = congViec;
    }

    @Override
    public String toString() {
        return ("Họ và tên :"+
                super.getName()+" Quê Quán: "+
                super.getHomeTown()+"  Tuổi: "+
                super.getAge() +"  Giới Tính "+
                super.getGender()+ " "+
                "NhanVien{" + "congviec='" + congViec + '\'' +
                '}');
    }
}
