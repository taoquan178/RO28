package org.example.entity;

public class Admin extends User {
    private String expInYear;

    public Admin(String expInYear) {
        this.expInYear = expInYear;
    }

    public Admin(int id, String fullName, String email, String password, String typeUser, String expInYear) {
        super(id, fullName, email, password, typeUser);
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
                ", fullName='" + getFullName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", typeUser=" + getTypeUser() +
                '}' + " Admin{" +
                "expInYear='" + expInYear + '\'' +
                '}';
    }
}
