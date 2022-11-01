package entity;

public abstract class User {
    private String name;
    protected double salaryRatio;

    public User() {
    }

    public User(String name, double salaryRatio) {
        this.name = name;
        this.salaryRatio = salaryRatio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalaryRatio() {
        return salaryRatio;
    }

    public void setSalaryRatio(double salaryRatio) {
        this.salaryRatio = salaryRatio;
    }
    public abstract Double calculatePay();

    public void displayInfor(){
        System.out.println("Name: " + name);
        System.out.println("Ration Salary: " + salaryRatio);
        System.out.println("Lương chi trả: " + calculatePay());
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", salaryRatio=" + salaryRatio +
                '}';
    }
}
