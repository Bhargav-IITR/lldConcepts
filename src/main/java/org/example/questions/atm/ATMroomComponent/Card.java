package org.example.questions.atm.ATMroomComponent;

public class Card {
    static int PIN_NUMBER = 12345;
    private int cardNumber;
    private int cvv;
    private int expiry;
    private int holderId;

    private BankAccount bankAccount;

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public boolean isCorrectPINEntered(int pin) {
        return pin == PIN_NUMBER;
    }

    public int getBankBalance() {
        return bankAccount.getBalance();
    }

    public void deductBankBalance(int amount) {
        bankAccount.withdrawBalance(amount);
    }

}
