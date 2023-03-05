package tn.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_Account")
public class Account {
    @Column(name ="accountID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name ="user_Name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "full_Name" )
    private String fullName;

    @Column(name = "Account_Type" )
    private AccountType accountType;

    public enum AccountType {
        ADMIN, USER
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Account.AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(Account.AccountType accountType) {
        accountType = accountType;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", AccountType=" + accountType +
                '}';
    }
}
