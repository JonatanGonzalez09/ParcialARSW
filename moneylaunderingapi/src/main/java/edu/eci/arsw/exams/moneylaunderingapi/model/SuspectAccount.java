package edu.eci.arsw.exams.moneylaunderingapi.model;

public class SuspectAccount {
    public String accountId;
    public int amountOfSmallTransactions;

    public SuspectAccount(){

    }

    public String getAccountId(){
        return accountId;
    }

    public void setAccountId(String accountId){
        this.accountId = accountId;
    }

    public int getAmountOfSmallTransactions(){
        return amountOfSmallTransactions;
    }

    public void getAmountOfSmallTransactions(int amountOfSmallTransactions){
        this.amountOfSmallTransactions = amountOfSmallTransactions;
    }
}
