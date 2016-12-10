package DatabaseObjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import static Master.Main.database;

import java.util.ArrayList;
import java.util.Collection;
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
    Double currentPaymentDueAmt;
    @SerializedName("DateLastPaymentMade")
    @Expose
    String dateLastPaymentMade;
    @SerializedName("MissedPaymentFlag")
    @Expose
    int missedPaymentFlag;
    @SerializedName("CreditLimit")
    @Expose
    double creditLimit;
    @SerializedName("PurchasesThisMonth")
    @Expose
    List<PurchasesThisMonth> purchasesThisMonth;

    public CreditCard(int social,String account, double interest, String dueDate, String noteDate, double creditLimit){
        this.customerSocial=social;
        this.creditCardID=account;
        this.currentInterestRate=interest;
        this.datePaymentDue=dueDate;
        this.dateNotifiedOfPayment=noteDate;
        this.creditLimit=creditLimit;
        currentPaymentDueAmt=0.0;
        dateLastPaymentMade=database.databaseTime;
        purchasesThisMonth=new ArrayList<>();
    }

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
    public Double getCurrentPaymentDueAmt() {
        return this.currentPaymentDueAmt;
    }
    public void setCurrentPaymentDueAmt(Double currentPaymentDueAmt) {
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
