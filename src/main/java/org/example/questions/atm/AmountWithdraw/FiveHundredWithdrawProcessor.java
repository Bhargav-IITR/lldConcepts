package org.example.questions.atm.AmountWithdraw;

import org.example.questions.atm.ATMroomComponent.ATM;

public class FiveHundredWithdrawProcessor extends CashWithdrawProcessor {
    public FiveHundredWithdrawProcessor(CashWithdrawProcessor nextProcessor){
        super(nextProcessor);
    }
    @Override
    public void withdraw(ATM atm, int remainingAmount){
        int requiredNotes = remainingAmount/500;
        int balance = remainingAmount%500;
        if(requiredNotes <= atm.getNoOfFiveHundredNotes()){
            atm.deductFiveHundredNotes(requiredNotes);
        }else{
            atm.deductFiveHundredNotes(atm.getNoOfFiveHundredNotes());
            balance = balance + (requiredNotes - atm.getNoOfFiveHundredNotes())*500;
        }
        if(balance != 0){
            super.withdraw(atm, balance);
        }
    }
}
