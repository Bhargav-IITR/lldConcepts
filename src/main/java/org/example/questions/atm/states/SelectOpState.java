package org.example.questions.atm.states;


import org.example.questions.atm.ATMroomComponent.ATM;
import org.example.questions.atm.ATMroomComponent.Card;
import org.example.questions.atm.enums.TransactionType;

public class SelectOpState extends ATMState {
    @Override
    public void selectOperation(ATM atm, Card card, TransactionType txnType){
        switch (txnType) {
            case CASH_WITHDRAWAL:
                atm.setAtmState(new CashWithdrawState());
                break;
            case BALANCE_CHECK:
                atm.setAtmState(new CheckBalanceState());
                break;
            default: {
                System.out.println("Invalid Option");
                exit(atm);
            }
        }
    }

    @Override
    public void exit(ATM atmObject) {
        returnCard();
        atmObject.setAtmState(new IdleState());
        System.out.println("Exit happens");
    }

    @Override
    public void returnCard() {
        System.out.println("Please collect your card");
    }
}
