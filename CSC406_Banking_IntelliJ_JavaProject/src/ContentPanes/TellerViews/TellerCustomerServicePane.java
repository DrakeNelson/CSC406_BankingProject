package ContentPanes.TellerViews;

import ContentPanes.AccountInfoViews.*;
import ContentPanes.EzItems.EzText;
import DatabaseObjects.*;
import Master.Main;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.List;

import static ContentPanes.EzItems.TryParse.TryParseDouble;
import static Master.Main.database;
import static Master.MasterController.TellerSearchClick;

/*
 * Created by drake on 11/24/2016.
 * all of the buttons on this page have no functionality
 */
public class TellerCustomerServicePane extends GridPane {

    public static Customer customer=Main.customer;

    public TellerCustomerServicePane(Customer searchedCustomer) {
        //get all customer info
        customer = searchedCustomer;
        List<SavingAccount> traditionalSavingsAccounts = Main.database.getTraditionalSavingsBySSN(Integer.toString(customer.getSocial()));
        List<CheckingAccount> checkingAccounts = Main.database.getCheckingAccountsBySSN(Integer.toString(customer.getSocial()));
        List<TermLoan> termLoans = Main.database.getTermLoansBySSN(Integer.toString(customer.getSocial()));
        List<CreditCard> creditCards = Main.database.getCreditCardsBySSN(Integer.toString(customer.getSocial()));

        //start working on interface stuff
        HBox custBox = new HBox();
        custBox.getChildren().addAll(new CustomerInfoView(customer),new TellerCustomerSearchPane("Search New Customer"));

        VBox outerBox = new VBox();
        outerBox.getChildren().add(custBox);
        outerBox.setAlignment(Pos.TOP_LEFT);

        // list savings accounts
        EzText savingsAccountListEzLabel = new EzText("Savings Accounts:");
        savingsAccountListEzLabel.setFont(Font.font("Gabriola", FontWeight.BLACK, 24));
        outerBox.getChildren().add(savingsAccountListEzLabel);
        for (SavingAccount account : traditionalSavingsAccounts) {
            outerBox.getChildren().add(new SavingsAccountInfoView(account));
            outerBox.getChildren().add(new customerSavingsAccountsTellerView(account));
        }
        //list checking accounts
        EzText checkingAccountListEzLabel = new EzText("Checking Accounts:");
        checkingAccountListEzLabel.setFont(Font.font("Gabriola", FontWeight.BLACK, 24));
        outerBox.getChildren().add(checkingAccountListEzLabel);
        for (CheckingAccount account : checkingAccounts) {
            outerBox.getChildren().add(new CheckingAccountView(account));
        }
        //list Loans
        EzText loanListEzLabel = new EzText("Term Loans:");
        loanListEzLabel.setFont(Font.font("Gabriola", FontWeight.BLACK, 24));
        outerBox.getChildren().add(loanListEzLabel);
        for (TermLoan loan : termLoans) {
            outerBox.getChildren().add(new TermLoanInfoView(loan));
            outerBox.getChildren().add(new customerTermLoansTellerView(loan));
        }
        //list creditCards
        EzText cardListEzLabel = new EzText("Credit Cards:");
        cardListEzLabel.setFont(Font.font("Gabriola", FontWeight.BLACK, 24));
        outerBox.getChildren().add(cardListEzLabel);
        for (CreditCard card : creditCards) {
            outerBox.getChildren().add(new CreditCardInfoView(card));
            outerBox.getChildren().add(new customerCreditCardTellerView(card));
        }

        getChildren().add(outerBox);
    }

    //this pane is a formatted view of each savings account first view under customer info
    private class customerSavingsAccountsTellerView extends GridPane {
        private customerSavingsAccountsTellerView(SavingAccount account) {
            setHgap(10);
            setVgap(10);
            setPadding(new Insets(0, 25, 25, 25));

            TextField depositTextField = new TextField();
            add(depositTextField, 0, 2);
            Button depositButton = new Button("Deposit");
            add(depositButton, 1, 2);
            depositButton.setOnAction(e -> {
                if(TryParseDouble(depositTextField.getText())){
                    account.setCurrentBalance(account.getCurrentBalance()+Double.parseDouble(depositTextField.getText()));
                    TellerSearchClick(customer);
                }
            });

            TextField withdrawlTextField = new TextField();
            add(withdrawlTextField, 3, 2);
            Button withdrawlButton = new Button("Withdrawl");
            add(withdrawlButton, 4, 2);
            withdrawlButton.setOnAction(e -> {
                if(TryParseDouble(withdrawlTextField.getText())){
                    account.withdraw(Double.parseDouble(withdrawlTextField.getText()),account);
                    TellerSearchClick(customer);
                }
            });

            Button closeButton = new Button("Close Account");
            add(closeButton, 6, 2);
            closeButton.setOnAction(e -> {
                database.getSavingAccounts().remove(account);
                TellerSearchClick(customer);
            });

        }
    }
    //formatted view of each TermLoan
    private class customerTermLoansTellerView extends GridPane {
        private customerTermLoansTellerView(TermLoan loan) {
            setHgap(10);
            setVgap(10);
            setPadding(new Insets(0, 25, 25, 25));

            TextField payField = new TextField();
            add(payField, 0, 3);
            Button payButton = new Button("Pay Amt");
            add(payButton, 1, 3);
            payButton.setOnAction(e -> {
                //dostuff
            });

            Button payFixedButton = new Button("Pay Fixed Amt");
            add(payFixedButton, 6, 3);
            payFixedButton.setOnAction(e -> {
            });

        }
    }
    //formatted view of each credit card
    private class customerCreditCardTellerView extends GridPane {
        private customerCreditCardTellerView(CreditCard card) {
            setHgap(10);
            setVgap(10);
            setPadding(new Insets(0, 25, 25, 25));

            TextField payField = new TextField();
            add(payField, 0, 0);
            Button payButton = new Button("Pay Amt");
            add(payButton, 1, 0);
            payButton.setOnAction(e -> {
            });

            Button payFixedButton = new Button("Pay Fixed Amt");
            add(payFixedButton, 6, 0);
            payFixedButton.setOnAction(e -> {
            });
        }
    }
}
