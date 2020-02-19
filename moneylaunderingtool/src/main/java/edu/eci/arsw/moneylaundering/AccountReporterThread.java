package edu.eci.arsw.moneylaundering;

public class AccountReporterThread extends Thread{

    private String account;
    private int amountOfSuspectTransactions;

    public AccountReporterThread(String account, int cantidad) {
        this.account = account;
        this.amountOfSuspectTransactions = cantidad;
    }
    @Override
    public void run(){
        AccountReporter.report(account, amountOfSuspectTransactions);
    }
}