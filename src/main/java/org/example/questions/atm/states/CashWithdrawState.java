package org.example.questions.atm.states;

import org.example.questions.atm.ATMroomComponent.ATM;
import org.example.questions.atm.ATMroomComponent.Card;
import org.example.questions.atm.AmountWithdraw.CashWithdrawProcessor;
import org.example.questions.atm.AmountWithdraw.FiveHundredWithdrawProcessor;
import org.example.questions.atm.AmountWithdraw.OneHundredWithdrawProcessor;
import org.example.questions.atm.AmountWithdraw.TwoThousandWithdrawProcessor;

public class CashWithdrawState extends ATMState{
    public CashWithdrawState() {
        System.out.println("Please enter the Withdrawal Amount");
    }

    @Override
    public void cashWithdrawal(ATM atmObject, Card card, int withdrawalAmountRequest){
        if (atmObject.getAtmBalance() < withdrawalAmountRequest) {
            System.out.println("Insufficient fund in the ATM Machine");
            exit(atmObject);
        } else if (card.getBankBalance() < withdrawalAmountRequest) {
            System.out.println("Insufficient fund in the your Bank Account");
            exit(atmObject);
        } else {
            card.deductBankBalance(withdrawalAmountRequest);
            atmObject.deductATMBalance(withdrawalAmountRequest);
            CashWithdrawProcessor processor = new TwoThousandWithdrawProcessor(new FiveHundredWithdrawProcessor(new OneHundredWithdrawProcessor(null)));
            processor.withdraw(atmObject, withdrawalAmountRequest);
            exit(atmObject);
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
