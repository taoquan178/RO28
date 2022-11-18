package org.example.entity;

public class Admin extends User{
    private String expInYear;

    public Admin(String expInYear) {
        this.expInYear = expInYear;
    }

    public Admin(int id, String fullname, String email, String password, String typeUser, String expInYear) {
        super(id, fullname, email, password, typeUser);
        this.expInYear = expInYear;
    }

    public String getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(String expInYear) {
        this.expInYear = expInYear;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +
                ", fullname='" + getFullname() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", typeUser='" + getTypeUser() + '\'' +
                '}'+" Admin{" +
                "expInYear='" + expInYear + '\'' +
                '}';
    }
}
