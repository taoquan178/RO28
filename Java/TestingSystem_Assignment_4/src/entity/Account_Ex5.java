package entity;

public class Account_Ex5 extends Circle{
    String id;
    String name;
    int balance;

    public  Account_Ex5(String id, String name, int balance){
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public int Circle (int amount){
        return this.balance += amount;
    }

    public int Debit(int amount){
        return this.balance -= amount;
    }

    public void TranferTo(Account_Ex5 account, int amount){
        this.balance -= amount;
        account.balance += amount;
    }
}
