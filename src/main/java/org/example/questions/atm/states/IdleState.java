package org.example.questions.atm.states;

import org.example.questions.atm.ATMroomComponent.ATM;
import org.example.questions.atm.ATMroomComponent.Card;

public class IdleState  extends ATMState{
    @Override
    public void insertCard(ATM atm, Card card){
        System.out.println("Card is inserted");
        atm.setAtmState(new HasCardState());
    }
}
