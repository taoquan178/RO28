package Entity;

public class ClazzA_B_C {
    private String clazzName;
    private String clazz;

    public ClazzA_B_C(String clazzName){
        this.clazzName = clazzName;
    }

    public String getClazz() {
       switch (this.clazzName){
           case "A":
               this.clazz = "Toán, Lý, Hóa";
               break;
           case "B":
               this.clazz = "Toán, Hóa, Sinh";
               break;
           case "C":
               this.clazz = "Văn, Sử, Địa";
               break;
       }
       return this.clazz;
    }

    public String getClazzName() {
        return clazzName;
    }

    @Override
    public String toString() {
        return "ClazzA_B_C{" +
                "clazzName='" + clazzName + '\'' +
                ", clazz='" + clazz + '\'' +
                '}';
    }
}
