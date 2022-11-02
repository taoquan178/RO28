package Entity;

public class Student extends ClazzA_B_C{
    private int code;
    private String name;
    private String homeTown;
    private int priority;

    public static int Count = 0;

    public Student( String name, String homeTown, int priority,String clazzName) {
        super(clazzName);
        Count++;
        this.code = Count;
        this.name = name;
        this.homeTown = homeTown;
        this.priority = priority;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Student{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", homeTown='" + homeTown + '\'' +
                ", priority=" + priority +
                '}'+ "ClazzA_B_C{" +
                "clazzName='" + super.getClazz() + '\'' +
                ", clazz='" + super.getClazzName() + '\'' +
                '}';
    }
}
