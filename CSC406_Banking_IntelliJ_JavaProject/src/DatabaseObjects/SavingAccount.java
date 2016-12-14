package DatabaseObjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import static Master.Main.database;

public class SavingAccount extends Account
{
    @SerializedName("AccountID")
    @Expose
    String accountID;
    @SerializedName("CustomerSocial")
    @Expose
    int customerSocial;
    @SerializedName("SavingsAccountType")
    @Expose
    String savingsAccountType;
    @SerializedName("CurrentBalance")
    @Expose
    double currentBalance;
    @SerializedName("InterestRate")
    @Expose
    double interestRate;
    @SerializedName("OpenDate")
    @Expose
    String openDate;
    @SerializedName("TermDate")
    @Expose
    String termDate;
    @SerializedName("BackupAccount")
    @Expose
    String backupAccount;
    @SerializedName("LastInterestPaidDate")
    @Expose
    String lastInterestPaidDate;

    @Override
    public int getOverdraftCount() {
        return overdraftCount;
    }

    @Override
    public void setOverdraftCount(int overdraftCount) {
        this.overdraftCount = overdraftCount;
    }

    @SerializedName("OverdraftCount")
    @Expose
    int overdraftCount;

    //for traditionals
    public SavingAccount(int social,String account, double openBal, double interest, String backup, String lastIntPaidDate) {
        customerSocial=social;
        accountID=account;
        currentBalance=openBal;
        interestRate=interest;
        backupAccount=backup;
        savingsAccountType="Traditional";
        openDate=database.databaseTime;
        termDate="";
        lastInterestPaidDate=lastIntPaidDate;
    }
    @Override
    public String getBackupAccount(){
        return backupAccount;
    }
    @Override
    public void setBackupAccount(String backupAccount){
        this.backupAccount = backupAccount;
    }
    public String getTermDate() {
        return this.termDate;
    }
    public void setTermDate(String termDate) {
        this.termDate = termDate;
    }
    public String getOpenDate() {
        return this.openDate;
    }
    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }
    public double getInterestRate() {
        return this.interestRate;
    }
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
    public double getCurrentBalance() {
        return this.currentBalance;
    }
    @Override
    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }
    public String getSavingsAccountType() {
        return this.savingsAccountType;
    }
    public void setSavingsAccountType(String savingsAccountType) {
        this.savingsAccountType = savingsAccountType;
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
    public String getLastInterestPaidDate() {return lastInterestPaidDate;}
    public void setLastInterestPaidDate(String lastInterestPaidDate) {this.lastInterestPaidDate = lastInterestPaidDate;}
}
