package DatabaseObjects;

import Master.Main;

/**
 * Created by user on 12/10/2016.
 */
public abstract class Account {
    public double getCurrentBalance() {
        return currentBalance;
    }
    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }
    private double currentBalance;
    private String backupAccount;
    private int overdraftCount;
    public String getBackupAccount(){
        return backupAccount;
    }
    public void setBackupAccount(String backupAccount){
        this.backupAccount = backupAccount;
    }
    public void withdraw(double amt,Account account){
        if (amt < account.getCurrentBalance()) {
            setCurrentBalance(getCurrentBalance() - amt);
        }else{

            if (getBackupAccount().equals("")||getBackupAccount().isEmpty()|| getBackupAccount().equals(null)) {
                setCurrentBalance(getCurrentBalance() - amt - 20);
                setOverdraftCount(getOverdraftCount()+1);
            }else{
                double overdraftamt = amt - getCurrentBalance();
                Account acc = Main.database.getBackupByAccount(account.getBackupAccount());
                acc.setCurrentBalance(acc.getCurrentBalance() - overdraftamt);
                setCurrentBalance(0);
            }
        }

    }

    public int getOverdraftCount() {
        return overdraftCount;
    }

    public void setOverdraftCount(int overdraftCount) {
        this.overdraftCount = overdraftCount;
    }
}
