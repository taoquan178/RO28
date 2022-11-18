package org.example.entity;

public class Admin extends User{
    public Admin() {
    }

    public Admin(int id, String fullName, String email, String password, String typeUser) {
        super(id, fullName, email, password, typeUser);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +
                ", fullName='" + getFullName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", typeUser='" + getTypeUser() + '\'' +
                '}';
    }
}
