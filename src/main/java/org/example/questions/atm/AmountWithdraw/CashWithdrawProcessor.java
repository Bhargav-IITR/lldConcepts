package org.example.questions.atm.AmountWithdraw;

import org.example.questions.atm.ATMroomComponent.ATM;

public abstract class CashWithdrawProcessor {
    CashWithdrawProcessor nextCashWithdrawProcessor;
    CashWithdrawProcessor (CashWithdrawProcessor processor){
        this.nextCashWithdrawProcessor = processor;
    }
    public void withdraw(ATM atm, int remainingAmount){
        if (nextCashWithdrawProcessor != null) {
            nextCashWithdrawProcessor.withdraw(atm, remainingAmount);
        }
    }
}
