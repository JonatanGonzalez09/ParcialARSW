package edu.eci.arsw.exams.moneylaunderingapi.service;

import edu.eci.arsw.exams.moneylaunderingapi.model.SuspectAccount;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Service;

@Service
public class MoneyLaunderingServiceStub implements MoneyLaunderingService {
    List<SuspectAccount> suspectAccountList;

    public MoneyLaunderingServiceStub(){
        suspectAccountList = new CopyOnWriteArrayList<>();
        SuspectAccount sAccount1 = new SuspectAccount();
        SuspectAccount sAccount2 = new SuspectAccount();
        SuspectAccount sAccount3 = new SuspectAccount();

        sAccount1.setAccountId("1");
        sAccount1.getAmountOfSmallTransactions(25);
        sAccount1.getAmountOfSmallTransactions();

        sAccount2.setAccountId("2");
        sAccount1.getAmountOfSmallTransactions(30);
        sAccount2.getAmountOfSmallTransactions();

        sAccount3.setAccountId("3");
        sAccount1.getAmountOfSmallTransactions(50);
        sAccount3.getAmountOfSmallTransactions();

        suspectAccountList.add(sAccount1);
        suspectAccountList.add(sAccount2);
        suspectAccountList.add(sAccount3);

    }
    @Override
    public void updateAccountStatus(SuspectAccount suspectAccount, String accountId) throws MoneyLaunderingException {
        for (SuspectAccount sa : suspectAccountList){
            if(sa.getAccountId().equals(suspectAccount.getAccountId())){
                sa = suspectAccount;
            }
        }

    }

    @Override
    public SuspectAccount getAccountStatus(String accountId) throws MoneyLaunderingException {
        for (SuspectAccount sa : suspectAccountList) {
            if (sa.getAccountId().equals(accountId)) {
                return sa;
            }
        }
        throw new MoneyLaunderingException("Primo no econtrado");
    }

    @Override
    public List<SuspectAccount> getSuspectAccounts() {
        return suspectAccountList;
    }

    @Override
    public void addSuspectAccount(SuspectAccount suspacc) throws MoneyLaunderingException {
        for (SuspectAccount f : suspectAccountList) {
            if (suspacc.equals(suspacc)){
                throw new MoneyLaunderingException("Ya se encuentra la cuenta");
            }
        }
        suspectAccountList.add(suspacc);
    }
}
