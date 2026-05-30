package org.example.questions.atm.states;

import org.example.questions.atm.ATMroomComponent.ATM;
import org.example.questions.atm.ATMroomComponent.Card;

public class HasCardState extends ATMState{
    @Override
    public void authenticatePin(ATM atm, Card card, int pin){
        boolean isCorrectPin = card.isCorrectPINEntered(pin);
        if(isCorrectPin){
            atm.setAtmState(new SelectOpState());
        }else{
            System.out.println("Invalid pin");
            exit(atm);
        }
    }

    @Override
    public void exit(ATM atm) {
        returnCard();
        atm.setAtmState(new IdleState());
        System.out.println("Exit happens");
    }

    @Override
    public void returnCard() {
        System.out.println("Please collect your card");
    }
}
