package DatabaseObjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SavingAccount
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
}
