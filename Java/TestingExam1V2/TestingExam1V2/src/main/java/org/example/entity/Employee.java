package org.example.entity;

public class Employee extends User {
    private String proSkill;

    public Employee(String proSkill) {
        this.proSkill = proSkill;
    }

    public Employee(int id, String fullName, String email, String password, String typeUser, String proSkill) {
        super(id, fullName, email, password, typeUser);
        this.proSkill = proSkill;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +
                ", fullName='" + getFullName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", typeUser=" + getTypeUser() +
                '}' + " Employee{" +
                "proSkill='" + proSkill + '\'' +
                '}';
    }
}
