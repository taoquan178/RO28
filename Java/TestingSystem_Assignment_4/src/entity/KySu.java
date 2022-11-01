package entity;

public class KySu extends CanBo {
    private String nganhDaoTao;

    public KySu(String name,int age,Gender gender, String hometown ,String nganhDaoTao) {
        super(name,age,gender,hometown);
        this.nganhDaoTao = nganhDaoTao;
    }
    public String getNganhDaoTao() {
        return nganhDaoTao;
    }

    public void setNganhDaoTao(String nganhDaoTao) {
        this.nganhDaoTao = nganhDaoTao;
    }

    @Override
    public String toString() {
        return( "Họ và tên :"+
                super.getName()+" Quê Quán: "+
                super.getHomeTown()+"  Tuổi: "+
                super.getAge() +"  Giới Tính "+
                super.getGender()+ " "+
                "KySu [" + "nganhdaotao='" + nganhDaoTao + '\'' +
                ']');
    }
}
