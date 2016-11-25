package DatabaseObjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CreditCard
{
    @SerializedName("CreditCardID")
    @Expose
    String creditCardID;
    public int getCustomerSocial() {
        return this.customerSocial;
    }
    @SerializedName("CustomerSocial")
    @Expose
    int customerSocial;
    @SerializedName("CurrentBalance")
    @Expose
    double currentBalance;
    @SerializedName("CurrentInterestRate")
    @Expose
    double currentInterestRate;
    @SerializedName("DatePaymentDue")
    @Expose
    String datePaymentDue;
    @SerializedName("DateNotifiedOfPayment")
    @Expose
    String dateNotifiedOfPayment;
    @SerializedName("CurrentPaymentDueAmt")
    @Expose
    String currentPaymentDueAmt;
    @SerializedName("DateLastPaymentMade")
    @Expose
    String dateLastPaymentMade;
    @SerializedName("MissedPaymentFlag")
    @Expose
    int missedPaymentFlag;
    @SerializedName("CreditLimit")
    @Expose
    double creditLimit;
    @SerializedName("Database.PurchasesThisMonth")
    @Expose
    List<PurchasesThisMonth> purchasesThisMonth;

    public void setCustomerSocial(int customerSocial) {
        this.customerSocial = customerSocial;
    }
    public List<PurchasesThisMonth> getPurchasesThisMonth() {
        return this.purchasesThisMonth;
    }
    public void setPurchasesThisMonth(List<PurchasesThisMonth> purchasesThisMonth) {
        this.purchasesThisMonth = purchasesThisMonth;
    }
    public double getCreditLimit() {
        return this.creditLimit;
    }
    public void setCreditLimit(double creditLimit) {
        this.creditLimit = creditLimit;
    }
    public int getMissedPaymentFlag() {
        return this.missedPaymentFlag;
    }
    public void setMissedPaymentFlag(int missedPaymentFlag) {
        this.missedPaymentFlag = missedPaymentFlag;
    }
    public String getDateLastPaymentMade() {
        return this.dateLastPaymentMade;
    }
    public void setDateLastPaymentMade(String dateLastPaymentMade) {
        this.dateLastPaymentMade = dateLastPaymentMade;
    }
    public String getCurrentPaymentDueAmt() {
        return this.currentPaymentDueAmt;
    }
    public void setCurrentPaymentDueAmt(String currentPaymentDueAmt) {
        this.currentPaymentDueAmt = currentPaymentDueAmt;
    }
    public String getDateNotifiedOfPayment() {
        return this.dateNotifiedOfPayment;
    }
    public void setDateNotifiedOfPayment(String dateNotifiedOfPayment) {
        this.dateNotifiedOfPayment = dateNotifiedOfPayment;
    }
    public String getDatePaymentDue() {
        return this.datePaymentDue;
    }
    public void setDatePaymentDue(String datePaymentDue) {
        this.datePaymentDue = datePaymentDue;
    }
    public double getCurrentInterestRate() {
        return this.currentInterestRate;
    }
    public void setCurrentInterestRate(double currentInterestRate) {
        this.currentInterestRate = currentInterestRate;
    }
    public String getCreditCardID() {
        return this.creditCardID;
    }
    public void setCreditCardID(String creditCardID) {
        this.creditCardID = creditCardID;
    }
    public double getCurrentBalance() {
        return this.currentBalance;
    }
    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }
}
