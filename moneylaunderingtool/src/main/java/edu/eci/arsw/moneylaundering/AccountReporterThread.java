package edu.eci.arsw.moneylaundering;

import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AccountReporterThread extends Thread {

    private List<File> files;
    private TransactionReader transactionReader;
    private TransactionAnalyzer transactionAnalyzer;
    private AtomicInteger amountOfFilesProcessed;
    private static Object object = new Object();

    public AccountReporterThread(TransactionReader transactionReader, TransactionAnalyzer transactionAnalyzer, List<File> files, AtomicInteger amountOfFilesProcessed) {
        this.files = files;
        this.transactionAnalyzer = transactionAnalyzer;
        this.transactionReader = transactionReader;
        this.amountOfFilesProcessed = amountOfFilesProcessed;
    }

    @Override
    public void run(){
        for (File transactionFile : files) {
            List<Transaction> transacciones = transactionReader.readTransactionsFromFile(transactionFile);
            for (Transaction trans : transacciones) {
                transactionAnalyzer.addTransaction(trans);
            }
            amountOfFilesProcessed.incrementAndGet();
        }
    }
}