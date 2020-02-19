package edu.eci.arsw.exams.moneylaunderingapi.service;

import edu.eci.arsw.exams.moneylaunderingapi.model.SuspectAccount;

import java.util.List;

public interface MoneyLaunderingService {
    public void updateAccountStatus(SuspectAccount suspectAccount, String accountId) throws MoneyLaunderingException;
    SuspectAccount getAccountStatus(String accountId) throws MoneyLaunderingException;
    List<SuspectAccount> getSuspectAccounts();
    public void addSuspectAccount(SuspectAccount suspacc) throws MoneyLaunderingException;
}
