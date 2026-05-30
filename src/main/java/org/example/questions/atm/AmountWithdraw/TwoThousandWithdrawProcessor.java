package org.example.questions.atm.AmountWithdraw;

import org.example.questions.atm.ATMroomComponent.ATM;

public class TwoThousandWithdrawProcessor extends CashWithdrawProcessor{
    public TwoThousandWithdrawProcessor(CashWithdrawProcessor nextCashWithdrawProcessor){
        super(nextCashWithdrawProcessor);
    }
    @Override
    public void withdraw(ATM atm, int remainingAmount){
        int requiredNotes = remainingAmount/2000;
        int balance = remainingAmount%2000;
        if(requiredNotes <= atm.getNoOfTwoThousandNotes()){
            atm.deductTwoThousandNotes(requiredNotes);
        }else{
            atm.deductTwoThousandNotes(atm.getNoOfTwoThousandNotes());
            balance = balance + (requiredNotes - atm.getNoOfTwoThousandNotes())*2000;
        }
        if(balance != 0){
            super.withdraw(atm, balance);
        }
    }
}
