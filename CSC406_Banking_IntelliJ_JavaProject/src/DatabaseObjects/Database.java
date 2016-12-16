package DatabaseObjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.stream.Collectors;

public class Database
{
    @SerializedName("GoldInterestRate")
    @Expose
    public double GOLDINTERESTRATE;
    @SerializedName("DiamondInterestRate")
    @Expose
    private final double DIAMONDINTERESTRATE =0.013;

    @SerializedName("Customers")
    @Expose
    public List<Customer> customers;
    @SerializedName("SavingAccounts")
    @Expose
    public List<SavingAccount> savingAccounts;
    @SerializedName("CheckingAccounts")
    @Expose
    public List<CheckingAccount> checkingAccounts;
    @SerializedName("CreditCards")
    @Expose
    public List<CreditCard> creditCards;
    @SerializedName("TermLoans")
    @Expose
    public List<TermLoan> termLoans;
    @SerializedName("DatabaseTime")
    @Expose
    public String databaseTime;
    @SerializedName("Checks")
    @Expose
    public List<Check> checks;
    @SerializedName("PurchasesThisMonth")
    @Expose
    public List<PurchasesThisMonth> purchasesThisMonth;

    public List<SavingAccount> getTraditionalSavingsBySSN(String SSN){
        return savingAccounts.stream().filter(account ->
                Integer.toString(account.getCustomerSocial()).equals(SSN)
                && account.getSavingsAccountType().equalsIgnoreCase("Traditional")).collect(Collectors.toList());
    }
    public List<SavingAccount> getCdBySSN(String SSN){
        return savingAccounts.stream().filter(account ->
                Integer.toString(account.getCustomerSocial()).equals(SSN) &&
                account.getSavingsAccountType().equalsIgnoreCase("CD")).collect(Collectors.toList());
    }

    public Customer getCustomerBySSN(String SSN){
        Customer result = null;
        for (Customer customer : customers){
            if(Integer.toString(customer.getSocial()).equals(SSN)){
                result = customer;
            }
        }
        return result;
    }
    public CreditCard getcardByNum(String CardNum){
        CreditCard result = null;
        for (CreditCard creditCards : creditCards){
            if(creditCards.getCreditCardID().equals(CardNum)){
                result = creditCards;
            }
        }
        return result;
    }
    public List<CheckingAccount> getCheckingAccountsBySSN(String SSN) {
        return checkingAccounts.stream().filter(account -> Integer.toString(account.getCustomerSocial()).equals(SSN)).collect(Collectors.toList());
    }
    public List<TermLoan> getTermLoansBySSN(String SSN) {
        return termLoans.stream().filter(loan -> Integer.toString(loan.getCustomerSocial()).equals(SSN)).collect(Collectors.toList());
    }
    public List<CreditCard> getCreditCardsBySSN(String SSN) {
        return creditCards.stream().filter(card -> Integer.toString(card.getCustomerSocial()).equals(SSN)).collect(Collectors.toList());
    }

    public List<TermLoan> getTermLoans() {
        return this.termLoans;
    }
    public void setTermLoans(List<TermLoan> termLoans) {
        this.termLoans = termLoans;
    }
    public List<CreditCard> getCreditCards() {
        return this.creditCards;
    }
    public void setCreditCards(List<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }
    public List<CheckingAccount> getCheckingAccounts() {
        return this.checkingAccounts;
    }
    public void setCheckingAccounts(List<CheckingAccount> checkingAccounts) {
        this.checkingAccounts = checkingAccounts;
    }
    public List<Check> getChecks() {
        return this.checks;
    }
    public void setChecks(List<Check> checks){
        this.checks= checks;
    }
    public List<PurchasesThisMonth> getpurchasesThisMonth() {
        return this.purchasesThisMonth;
    }
    public void setPurchasesThisMonth(List<PurchasesThisMonth> purchasesThisMonth){
        this.purchasesThisMonth= purchasesThisMonth;
    }
    public List<SavingAccount> getSavingAccounts() {
        return this.savingAccounts;
    }
    public void setSavingAccounts(List<SavingAccount> savingAccounts) {
        this.savingAccounts = savingAccounts;
    }
    public List<Customer> getCustomers() {
        return this.customers;
    }
    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}