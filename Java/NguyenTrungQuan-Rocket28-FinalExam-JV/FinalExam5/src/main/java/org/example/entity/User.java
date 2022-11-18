package org.example.entity;

public class User {
    private int id;
    private String fullName;
    private String email;
    private String password;
    private String typeUser;

    public User(int id, String fullName, String email, String password, String typeUser) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.typeUser = typeUser;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(String typeUser) {
        this.typeUser = typeUser;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", typeUser='" + typeUser + '\'' +
                '}';
    }
}
