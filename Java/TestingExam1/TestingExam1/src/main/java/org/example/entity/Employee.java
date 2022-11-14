package org.example.entity;

public class Employee extends User {
    private String proSkill;

    public Employee(int id, String name, String email, String password) {
        super(id, name, email, password);
    }

    public Employee(String proSkill) {
        this.proSkill = proSkill;
    }

    public Employee(int id, String name, String email, String password, String proSkill) {
        super(id, name, email, password);
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
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", password='" + getPassword() + '\'' +
                '}'+ " Employee{" +
                "proSkill='" + proSkill + '\'' +
                '}';
    }
}
