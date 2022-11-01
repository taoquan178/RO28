package entity;

public class CongNhan extends CanBo {
    private int bac;

    public CongNhan(String name,int age,Gender gender, String hometown ,int bac) {
        super(name,age,gender,hometown);
        this.bac = bac;
    }


    public int getBac() {
        return bac;
    }

    public void setBac(int bac) {
        this.bac = bac;
    }

    @Override
    public String toString() {
        return( "Họ và tên :"+
                super.getName()+" Quê Quán: "+
                super.getHomeTown()+"  Tuổi: "+
                super.getAge() +"  Giới Tính "+
                super.getGender()+ " "+
                "CongNhan [" + "Bậc =" + bac + ']');
    }
}
