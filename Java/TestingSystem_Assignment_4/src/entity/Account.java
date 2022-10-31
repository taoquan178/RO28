package entity;

import java.time.LocalDate;
import java.util.Arrays;


public class Account {
    private int id;
    private String  email;
    private String  name;
    private String  fullName;
    private Department department;
    private Position position;
    private LocalDate    createDate;
    private Group[] groups;

    public Account(){

    }

    public Account(int id,String  email,String  name, String firstName, String lastName){
        this.id = id;
        this.email = email;
        this.name = name;
        this.fullName = firstName + lastName;

    }

    public Account(int id, String email, String name, String firstName, String lastName, Position position){
        this.id = id;
        this.email = email;
        this.name = name;
        this.fullName = firstName + lastName;
        this.position = position;
        this.createDate = LocalDate.now();
    }

    public Account(int id, String  email, String  name, String firstName, String lastName, Position position, LocalDate  createDate){
        this.id = id;
        this.email = email;
        this.name = name;
        this.fullName = firstName + " " +lastName;
        this.position = position;
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public Department getDepartment() {
        return department;
    }

    public Position getPosition() {
        return position;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public Group[] getGroups() {
        return groups;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public void setGroups(Group[] groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", department=" + department +
                ", position=" + position +
                ", createDate=" + createDate +
                ", groups=" + Arrays.toString(groups) +
                '}';
    }
}
