package DatabaseObjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import static Master.Main.database;

public class CheckingAccount extends Account{
    @SerializedName("AccountID")
    @Expose
    String accountID;
    @SerializedName("CustomerSocial")
    @Expose
    int customerSocial;
    @SerializedName("AccountType")
    @Expose
    String accountType;
    @SerializedName("CurrentBalance")
    @Expose
    double currentBalance;
    @SerializedName("BackupAccount")
    @Expose
    String backupAccount;
    @SerializedName("OverdraftCount")
    @Expose
    int overdraftCount;
    @SerializedName("DateAccountOpened")
    @Expose
    String dateAccountOpened;

    public String getLastInterestPaidDate() {
        return lastInterestPaidDate;
    }

    public void setLastInterestPaidDate(String lastInterestPaidDate) {
        this.lastInterestPaidDate = lastInterestPaidDate;
    }

    @SerializedName("LastInterestPaidDate")
    @Expose
    String lastInterestPaidDate;

    public CheckingAccount(int cust, double openbal, String backup, String AccountID) {
        this.accountID = AccountID;
        this.customerSocial = cust;
        this.currentBalance = openbal;
        this.backupAccount = backup;
        this.overdraftCount = 0;
        dateAccountOpened = database.databaseTime;
        this.accountType = getAccountTypeCalculator(openbal);
        this.lastInterestPaidDate = database.databaseTime;
    }

    private String getAccountTypeCalculator(double balance) {
        String result;
        if (balance >= 1000) {
            result = "gold";
        } else {
            result = "tmb";
        }
        return result;
    }

    public String getDateAccountOpened() {
        return this.dateAccountOpened;
    }

    public void setDateAccountOpened(String dateAccountOpened) {
        this.dateAccountOpened = dateAccountOpened;
    }
    @Override
    public int getOverdraftCount() {
        return this.overdraftCount;
    }
    @Override
    public void setOverdraftCount(int overdraftCount) {
        this.overdraftCount = overdraftCount;
    }
    @Override
    public String getBackupAccount() {
        return this.backupAccount;
    }
    @Override
    public void setBackupAccount(String backupAccount) {
        this.backupAccount = backupAccount;
    }
    @Override
    public double getCurrentBalance() {
        return this.currentBalance;
    }
    @Override
    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String getAccountType() {
        return this.accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public int getCustomerSocial() {
        return this.customerSocial;
    }

    public void setCustomerSocial(int customerSocial) {
        this.customerSocial = customerSocial;
    }

    public String getAccountID() {
        return this.accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }
}
