package DatabaseObjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import static Master.Main.database;

public class CheckingAccount {
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
    @SerializedName("BackupAccountIDs")
    @Expose
    String backupAccountIDs;
    @SerializedName("OverdraftCount")
    @Expose
    int overdraftCount;
    @SerializedName("DateAccountOpened")
    @Expose
    String dateAccountOpened;

    public CheckingAccount(int cust, double openbal, String backup, String AccountID) {
        this.accountID = AccountID;
        this.customerSocial = cust;
        this.currentBalance = openbal;
        this.backupAccountIDs = backup;
        this.overdraftCount = 0;
        dateAccountOpened = database.databaseTime;
        this.accountType = getAccountTypeCalculator(openbal);
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

    public int getOverdraftCount() {
        return this.overdraftCount;
    }

    public void setOverdraftCount(int overdraftCount) {
        this.overdraftCount = overdraftCount;
    }

    public String getBackupAccountIDs() {
        return this.backupAccountIDs;
    }

    public void setBackupAccountIDs(String backupAccountIDs) {
        this.backupAccountIDs = backupAccountIDs;
    }

    public double getCurrentBalance() {
        return this.currentBalance;
    }

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
