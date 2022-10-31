package entity;

import java.time.LocalDate;
import java.util.Arrays;

public class Group {
    private int id;
    private String  name;
    private int creatorID;
    private LocalDate    createDate;
    private Account[]   accounts;

    public Group(){

    }
    /**
     * Question 3:
     * Tạo constructor cho Group:
     * a) không có parameters
     * b) Có các parameter là GroupName, Creator, array Account[]
     * accounts, CreateDate
     * c) Có các parameter là GroupName, Creator, array String[]
     * usernames , CreateDate
     * Với mỗi username thì sẽ khởi tạo 1 Account (chỉ có thông tin
     * username, các thông tin còn lại = null).
     * Khởi tạo 1 Object với mỗi constructor ở trên
     */
    public Group (String  name, int creatorID, Account[]   accounts, LocalDate createDate){
        this.name = name;
        this.creatorID = creatorID;
        this.accounts = accounts;
        this.createDate = createDate;
    }
    public Group (String  name, int creatorID, String[] usernames , LocalDate createDate){
        this.name = name;
        this.creatorID = creatorID;
        Account[]   accounts = new Account[usernames.length];
         for (int i = 0; i < usernames.length; i++){
             accounts[i].getName();
        }

                this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCreatorID() {
        return creatorID;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreatorID(int creatorID) {
        this.creatorID = creatorID;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creatorID=" + creatorID +
                ", createDate=" + createDate +
                ", accounts=" + Arrays.toString(accounts) +
                '}';
    }
}
