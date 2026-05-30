package org.example.questions.atm.ATMroomComponent;

public class BankAccount {
    int balance;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    public void withdrawBalance(int amount){
        balance = balance - amount;
    }
}
