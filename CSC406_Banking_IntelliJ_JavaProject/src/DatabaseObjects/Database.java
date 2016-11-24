package DatabaseObjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Database
{

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

    public Customer getCustomerBySSN(String SSN){
        Customer result = null;
        for (Customer customer : customers){
            if(Integer.toString(customer.getSocial()).equals(SSN)){
                return customer;
            }
        }
        return result;
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