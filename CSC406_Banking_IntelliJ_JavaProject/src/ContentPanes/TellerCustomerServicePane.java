package ContentPanes;

import DatabaseObjects.*;
import Master.Main;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.List;

/*
 * Created by drake on 11/24/2016.
 * all of the buttons on this page have no functionality
 */
public class TellerCustomerServicePane extends GridPane {

    private Customer customer;

    public TellerCustomerServicePane(Customer searchedCustomer) {
        //get all customer info
        customer = searchedCustomer;
        List<SavingAccount> traditionalSavingsAccounts = Main.database.getTraditionalSavingsBySSN(Integer.toString(customer.getSocial()));
        List<CheckingAccount> checkingAccounts = Main.database.getCheckingAccountsBySSN(Integer.toString(customer.getSocial()));
        List<TermLoan> termLoans = Main.database.getTermLoansBySSN(Integer.toString(customer.getSocial()));
        List<CreditCard> creditCards = Main.database.getCreditCardsBySSN(Integer.toString(customer.getSocial()));

        //start working on interface stuff
        HBox custBox = new HBox();
        custBox.getChildren().addAll(new customerInfoTellerView(),new TellerCustomerSearchPane("Search New Customer"));

        VBox outerBox = new VBox();
        outerBox.getChildren().add(custBox);
        outerBox.setAlignment(Pos.TOP_LEFT);

        // list savings accounts
        EzText savingsAccountListEzLabel = new EzText("Savings Accounts:");
        savingsAccountListEzLabel.setFont(Font.font("Gabriola", FontWeight.BLACK, 24));
        outerBox.getChildren().add(savingsAccountListEzLabel);
        for (SavingAccount account : traditionalSavingsAccounts) {
            outerBox.getChildren().add(new customerSavingsAccountsTellerView(account));
        }
        //list checking accounts
        EzText checkingAccountListEzLabel = new EzText("Checking Accounts:");
        checkingAccountListEzLabel.setFont(Font.font("Gabriola", FontWeight.BLACK, 24));
        outerBox.getChildren().add(checkingAccountListEzLabel);
        for (CheckingAccount account : checkingAccounts) {
            outerBox.getChildren().add(new customerCheckingAccountsTellerView(account));
        }
        //list Loans
        EzText loanListEzLabel = new EzText("Term Loans:");
        loanListEzLabel.setFont(Font.font("Gabriola", FontWeight.BLACK, 24));
        outerBox.getChildren().add(loanListEzLabel);
        for (TermLoan loan : termLoans) {
            outerBox.getChildren().add(new customerTermLoansTellerView(loan));
        }
        //list creditCards
        EzText cardListEzLabel = new EzText("Credit Cards:");
        cardListEzLabel.setFont(Font.font("Gabriola", FontWeight.BLACK, 24));
        outerBox.getChildren().add(cardListEzLabel);
        for (CreditCard card : creditCards) {
            outerBox.getChildren().add(new customerCreditCardTellerView(card));
        }

        getChildren().add(outerBox);
        setStyle("-fx-background-color: #000000");
    }

    //couple custom items to save space
    private class EzLabel extends Label {
        EzLabel(String x) {
            setText(x);
            setTextFill(Color.web("#B8D4EF", 1.0));
            setStyle("-fx-font-weight: bold");
        }
    }
    private class EzText extends Text {
        EzText(String x) {
            setText(x);
            setFill(Color.web("#B8D4EF", 1.0));
        }
    }

    //this pane is a formatted view of each savings account first view under customer info
    private class customerSavingsAccountsTellerView extends GridPane {
        private customerSavingsAccountsTellerView(SavingAccount account) {
            setHgap(10);
            setVgap(10);
            setPadding(new Insets(25, 25, 25, 25));
            EzText scenetitle = new EzText("Account # : " + account.getAccountID());
            scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
            add(scenetitle, 0, 0, 4, 1);

            add(new EzLabel("Current Balance:"), 0, 1);
            add(new EzText(Double.toString(account.getCurrentBalance())), 1, 1);
            add(new EzLabel("Interest Rate:"), 2, 1);
            add(new EzText(Double.toString(account.getInterestRate() * 100) + "%"), 3, 1);
            add(new EzLabel("Open Date:"), 4, 1);
            add(new EzText(account.getOpenDate()), 5, 1);

            TextField depositTextField = new TextField();
            add(depositTextField, 0, 2);
            Button depositButton = new Button("Deposit");
            add(depositButton, 1, 2);
            depositButton.setOnAction(e -> {
            });

            TextField withdrawlTextField = new TextField();
            add(withdrawlTextField, 3, 2);
            Button withdrawlButton = new Button("Withdrawl");
            add(withdrawlButton, 4, 2);
            withdrawlButton.setOnAction(e -> {
            });

            Button closeButton = new Button("Close Account");
            add(closeButton, 6, 2);
            closeButton.setOnAction(e -> {
            });

        }
    }
    //this pane shows the basic customer information in the uppler left
    private class customerInfoTellerView extends GridPane {
        private customerInfoTellerView() {
            setAlignment(Pos.CENTER);
            setHgap(10);
            setVgap(10);
            setPadding(new Insets(25, 25, 25, 25));
            EzText scenetitle = new EzText(customer.getFirstName() + " " + customer.getLastName());
            scenetitle.setFont(Font.font("Gabriola", FontWeight.BLACK, 24));
            add(scenetitle, 0, 0, 2, 1);

            add(new EzLabel("SSN:"), 0, 1);
            add(new EzText(Integer.toString(customer.getSocial())), 1, 1);
            add(new EzLabel("Address:"), 2, 1);
            add(new EzText(customer.getAddress()), 3, 1);
            add(new EzLabel("City:"), 0, 2);
            add(new EzText(customer.getCity()), 1, 2);
            add(new EzLabel("State:"), 2, 2);
            add(new EzText(customer.getState()), 3, 2);
            add(new EzLabel("ZipCode:"), 4, 2);
            add(new EzText(customer.getZip()), 5, 2);
        }
    }
    //formatted view of each checking account
    private class customerCheckingAccountsTellerView extends GridPane {
        private customerCheckingAccountsTellerView(CheckingAccount account) {
            setHgap(10);
            setVgap(10);
            setPadding(new Insets(25, 25, 25, 25));
            EzText scenetitle = new EzText("Account # : " + account.getAccountID());
            scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
            add(scenetitle, 0, 0, 4, 1);

            add(new EzLabel("Current Balance:"), 0, 1);
            add(new EzText(Double.toString(account.getCurrentBalance())), 1, 1);
            add(new EzLabel("Account Type:"), 2, 1);
            add(new EzText(account.getAccountType()), 3, 1);
            add(new EzLabel("Open Date:"), 4, 1);
            add(new EzText(account.getDateAccountOpened()), 5, 1);
            add(new EzLabel("Overdraft Count:"), 6, 1);
            add(new EzText(Integer.toString(account.getOverdraftCount())), 7, 1);

            TextField depositTextField = new TextField();
            add(depositTextField, 0, 2);
            Button depositButton = new Button("Deposit");
            add(depositButton, 1, 2);
            depositButton.setOnAction(e -> {
            });

            TextField withdrawlTextField = new TextField();
            add(withdrawlTextField, 3, 2);
            Button withdrawlButton = new Button("Withdrawl");
            add(withdrawlButton, 4, 2);
            withdrawlButton.setOnAction(e -> {
            });

            Button closeButton = new Button("Close Account");
            add(closeButton, 6, 2);
            closeButton.setOnAction(e -> {
            });
        }
    }
    //formatted view of each TermLoan
    private class customerTermLoansTellerView extends GridPane {
        private customerTermLoansTellerView(TermLoan loan) {
            setHgap(10);
            setVgap(10);
            setPadding(new Insets(25, 25, 25, 25));
            EzText scenetitle = new EzText("Account # : " + loan.getLoanID());
            scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
            add(scenetitle, 0, 0, 4, 1);

            add(new EzLabel("Current Balance:"), 0, 1);
            add(new EzText(Double.toString(loan.getCurrentBalance())), 1, 1);
            add(new EzLabel("Interest Rate:"), 2, 1);
            add(new EzText(Double.toString(loan.getFixedInterestRate() * 100) + "%"), 3, 1);
            add(new EzLabel("Payment Due:"), 4, 1);
            add(new EzText(loan.getDatePaymentDue()), 5, 1);
            add(new EzLabel("Length Of Loan:"), 6, 1);
            add(new EzText(loan.getTermLoanType()), 7, 1);

            add(new EzLabel("Flag:"), 0, 2);
            add(new EzText(Double.toString(loan.getMissedPaymentFlag())), 1, 2);
            add(new EzLabel("Last Paid:"), 2, 2);
            add(new EzText(loan.getDateLastPaymentMade()), 3, 2);
            add(new EzLabel("Payment Due:"), 4, 2);
            add(new EzText(Double.toString(loan.getCurrentPaymentDueAmt())), 5, 2);
            add(new EzLabel("Fixed Payment:"), 6, 2);
            add(new EzText(Double.toString(loan.getFixedPaymentAmount())), 7, 2);

            TextField payField = new TextField();
            add(payField, 0, 3);
            Button payButton = new Button("Pay Amt");
            add(payButton, 1, 3);
            payButton.setOnAction(e -> {
            });

            Button payFixedButton = new Button("Pay Fixed Amt");
            add(payFixedButton, 6, 2);
            payFixedButton.setOnAction(e -> {
            });

        }
    }
    //formatted view of each credit card
    private class customerCreditCardTellerView extends GridPane {
        private customerCreditCardTellerView(CreditCard card) {
            setHgap(10);
            setVgap(10);
            setPadding(new Insets(25, 25, 25, 25));
            EzText scenetitle = new EzText("Account # : " + card.getCreditCardID());
            scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
            add(scenetitle, 0, 0, 4, 1);

            add(new EzLabel("Current Balance:"), 0, 1);
            add(new EzText(Double.toString(card.getCurrentBalance())), 1, 1);
            add(new EzLabel("Interest Rate:"), 2, 1);
            add(new EzText(Double.toString(card.getCurrentInterestRate() * 100) + "%"), 3, 1);
            add(new EzLabel("Payment Due:"), 4, 1);
            add(new EzText(card.getDatePaymentDue()), 5, 1);
            add(new EzLabel("Flag:"), 6, 1);
            add(new EzText(Integer.toString(card.getMissedPaymentFlag())), 7, 1);

            add(new EzLabel("Credit Limit:"), 0, 2);
            add(new EzText(Double.toString(card.getCreditLimit())), 1, 2);
            add(new EzLabel("Interest Rate:"), 2, 2);
            add(new EzText(card.getDateLastPaymentMade()), 3, 2);
            add(new EzLabel("Due amt:"), 4, 2);
            add(new EzText(card.getCurrentPaymentDueAmt()), 5, 2);
            EzLabel recentPurchasesText = new EzLabel("Recent Purchases: ");

            add(recentPurchasesText,0,3);
            int i=4;
            for (PurchasesThisMonth purchase : card.getPurchasesThisMonth()) {
                add(new EzLabel("ID:"), 0, i);
                add(new EzText(purchase.getPurchaseID()), 1, i);
                add(new EzLabel("Title:"), 2, i);
                add(new EzText(purchase.getPurchaseTitle()), 3, i);
                add(new EzLabel("Location:"), 4, i);
                add(new EzText(purchase.getPurchaseLocation()), 5, i);
                add(new EzLabel("Purchase Amt:"), 6, i);
                add(new EzText(Double.toString(purchase.getPurchaseAmt())), 7, i);
                i++;
            }

            TextField payField = new TextField();
            add(payField, 0, i);
            Button payButton = new Button("Pay Amt");
            add(payButton, 1, i);
            payButton.setOnAction(e -> {
            });

            Button payFixedButton = new Button("Pay Fixed Amt");
            add(payFixedButton, 6, i);
            payFixedButton.setOnAction(e -> {
            });
        }
    }
}
