package org.example.entity;

public class Employee extends User{
    private int projectId;
    private String proSkill;

    public Employee(int id, String fullName, String email, String password, String typeUser, int projectId, String proSkill) {
        super(id, fullName, email, password, typeUser);
        this.projectId = projectId;
        this.proSkill = proSkill;
    }

    public Employee(int projectId, String proSkill) {
        this.projectId = projectId;
        this.proSkill = proSkill;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
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
                ", typeUser='" + getTypeUser() + '\'' +
                '}'+" Employee{" +
                "projectId=" + projectId +
                ", proSkill='" + proSkill + '\'' +
                '}';
    }
}
