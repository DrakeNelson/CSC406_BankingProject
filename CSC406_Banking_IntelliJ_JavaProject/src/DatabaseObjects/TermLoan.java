package DatabaseObjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TermLoan
{

    @SerializedName("LoanID")
    @Expose
    String loanID;
    @SerializedName("TermLoanType")
    @Expose
    String termLoanType;
    @SerializedName("CustomerSocial")
    @Expose
    int customerSocial;
    @SerializedName("CurrentBalance")
    @Expose
    double currentBalance;
    @SerializedName("FixedInterestRate")
    @Expose
    double fixedInterestRate;
    @SerializedName("FixedPaymentAmount")
    @Expose
    double fixedPaymentAmount;
    @SerializedName("DatePaymentDue")
    @Expose
    String datePaymentDue;
    @SerializedName("DateNotifiedOfPayment")
    @Expose
    String dateNotifiedOfPayment;
    @SerializedName("CurrentPaymentDueAmt")
    @Expose
    double currentPaymentDueAmt;
    @SerializedName("DateLastPaymentMade")
    @Expose
    String dateLastPaymentMade;
    @SerializedName("MissedPaymentFlag")
    @Expose
    int missedPaymentFlag;
    @SerializedName("OpenDate")
    @Expose
    String openDate;


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
    public double getCurrentPaymentDueAmt() {
        return this.currentPaymentDueAmt;
    }
    public void setCurrentPaymentDueAmt(double currentPaymentDueAmt) {
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
    public double getFixedPaymentAmount() {
        return this.fixedPaymentAmount;
    }
    public void setFixedPaymentAmount(double fixedPaymentAmount) {
        this.fixedPaymentAmount = fixedPaymentAmount;
    }
    public double getFixedInterestRate() {
        return this.fixedInterestRate;
    }
    public void setFixedInterestRate(double fixedInterestRate) {
        this.fixedInterestRate = fixedInterestRate;
    }
    public double getCurrentBalance() {
        return this.currentBalance;
    }
    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }
    public int getCustomerSocial() {
        return this.customerSocial;
    }
    public void setCustomerSocial(int customerSocial) {
        this.customerSocial = customerSocial;
    }
    public String getTermLoanType() {
        return this.termLoanType;
    }
    public void setTermLoanType(String termLoanType) {
        this.termLoanType = termLoanType;
    }
    public String getLoanID() {
        return this.loanID;
    }
    public void setLoanID(String loanID) {
        this.loanID = loanID;
    }
    public String getOpenDate() {
        return openDate;
    }
    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }
}
