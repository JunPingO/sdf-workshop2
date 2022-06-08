package vttp2022.workshop.day2;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class BankAccount {
    //bank account
    private String name ="";

    //random generated UUID from java.util
    private String acctID = UUID.randomUUID()
                                    .toString()
                                    .substring(0,8);
    // holds account balance
    private float balance = 0f;

    //list of transaction events to bank account
    private List<String> transaction = new LinkedList<>();

    //boolean for account closed or not
    private boolean isClosed = false;

    //Account creation and closing date
    private LocalDateTime accountCreationDate;
    private LocalDateTime accountClosingDate;

    protected float withdraw(String withdrawAmt) {
        Float withdrawAmtF = null;
        try {
            Float withdrawAmtF = Float.parseFloat(withdrawAmt);
            if (withdrawAmtF.floatValue()<= 0){
                throw new IllegalArgumentException("Amount cannot be negative");
            }

            if (this.isClosed()){
                throw new IllegalArgumentException("Account is closed");
            }

            //update the balance amount
            this.balance -= withdrawAmtF.floatValue();

            // Construct transaction history event log
            StringBuilder txnStrBld = new StringBuilder();
            txnStrBld.append("Withdraw $");
            txnStrBld.append(withdrawAmtF.floatValue());
            txnStrBld.append("at");
            txnStrBld.append(LocalDateTime.now());
            System.out.println(txnStrBld.toString());
            //save the event log into txn LinkedList
            transaction.add(txnStrBld.toString());

        } catch (NumberFormatException e) {
            System.err.print(e);
            throw new IllegalArgumentException("Inavlid deposit amount");
        }
        
        return withdrawAmtF.floatValue();
    }

    protected void deposit(String depositAmt){
        try {
            Float depositAmtF = Float.parseFloat(depositAmt);
            if (depositAmtF.floatValue()<= 0){
                throw new IllegalArgumentException("Amount cannot be negative");
            }

            if (this.isClosed()){
                throw new IllegalArgumentException("Account is closed");
            }

            //update the balance amount
            this.balance += depositAmtF.floatValue();

            // Construct transaction history event log
            StringBuilder txnStrBld = new StringBuilder();
            txnStrBld.append("Deposit $");
            txnStrBld.append(depositAmtF.floatValue());
            txnStrBld.append("at");
            txnStrBld.append(LocalDateTime.now());
            System.out.println(txnStrBld.toString());
            //save the event log into txn LinkedList
            transaction.add(txnStrBld.toString());

        } catch (NumberFormatException e) {
            System.err.print(e);
            throw new IllegalArgumentException("Inavlid deposit amount");
        }
    }
    
    // constructor with bank account name
    public BankAccount(String name){
        this.name = name;
    }

    // 2nd constructor with name and balance
    public BankAccount(String name, float initialBal){
        this.name = name;
        this.balance = initialBal;
    }

    //Getter and Setter for other properties
    public String getName() {
        return name;
    }

    public String getAcctID() {
        return acctID;
    }

    public float getBalance() {
        return balance;
    }

    public List<String> getTransaction() {
        return transaction;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAcctID(String acctID) {
        this.acctID = acctID;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void setTransaction(List<String> transaction) {
        this.transaction = transaction;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public LocalDateTime getAccountCreationDate() {
        return accountCreationDate;
    }

    public LocalDateTime getAccountClosingDate() {
        return accountClosingDate;
    }

    public void setClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }

    public void setAccountCreationDate(LocalDateTime accountCreationDate) {
        this.accountCreationDate = accountCreationDate;
    }

    public void setAccountClosingDate(LocalDateTime accountClosingDate) {
        this.accountClosingDate = accountClosingDate;
    }


}
