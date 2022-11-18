package org.example.entity;

public class Manager extends User{
    private int expInYear;
    private int projectId;

    public Manager(int id, String fullName, String email, String password, String typeUser, int expInYear, int projectId) {
        super(id, fullName, email, password, typeUser);
        this.expInYear = expInYear;
        this.projectId = projectId;
    }

    public Manager(int expInYear, int projectId) {
        this.expInYear = expInYear;
        this.projectId = projectId;
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + getId() +
                ", fullName='" + getFullName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", typeUser='" + getTypeUser() + '\'' +
                '}'+"Manager{" +
                "expInYear=" + expInYear +
                ", projectId=" + projectId +
                '}';
    }
}
