package org.example.entity;

public class Admin extends User{
    private int expInYear;

    public Admin(int id, String name, String email, String password) {
        super(id, name, email, password);
    }

    public Admin(int expInYear) {
        this.expInYear = expInYear;
    }

    public Admin(int id, String name, String email, String password, int expInYear) {
        super(id, name, email, password);
        this.expInYear = expInYear;
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", password='" + getPassword() + '\'' +
                '}'+ " Admin{" +
                "expInYear=" + expInYear +
                '}';
    }
}
