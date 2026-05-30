package org.example.questions.atm.ATMroomComponent;

import org.example.questions.atm.enums.TransactionType;

public class ATMroom {
    ATM atm;
    User user;

    public static void main(String args[]){
        ATMroom atmRoom = new ATMroom();
        atmRoom.initialise();

        atmRoom.atm.printCurrentATMStatus();
        atmRoom.atm.getAtmState().insertCard(atmRoom.atm, atmRoom.user.getCard());
        atmRoom.atm.getAtmState().authenticatePin(atmRoom.atm, atmRoom.user.getCard(), 123145);
        atmRoom.atm.getAtmState().selectOperation(atmRoom.atm, atmRoom.user.getCard(), TransactionType.CASH_WITHDRAWAL);
        atmRoom.atm.getAtmState().cashWithdrawal(atmRoom.atm, atmRoom.user.getCard(), 2500);
        atmRoom.atm.printCurrentATMStatus();
        
    }
    private void initialise(){
        atm = ATM.getAtmObject();
        atm.setAtmBalance(3500, 1,2,1);
        this.user = createUser();
    }
    private User createUser(){
        User user = new User();
        user.setCard(createCard());
        return user;
    }
    private Card createCard(){
        Card card = new Card();
        card.setBankAccount(createBankAccount());
        return card;
    }
    private BankAccount createBankAccount(){
        BankAccount account = new BankAccount();
        account.setBalance(3000);
        return account;
    }
}
