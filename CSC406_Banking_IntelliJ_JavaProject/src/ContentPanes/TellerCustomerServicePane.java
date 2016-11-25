package ContentPanes;

import DatabaseObjects.CheckingAccount;
import DatabaseObjects.Customer;
import DatabaseObjects.SavingAccount;
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
        customer = searchedCustomer;
        List<SavingAccount> traditionalSavingsAccounts = Main.database.getTraditionalSavingsBySSN(Integer.toString(customer.getSocial()));
        List<CheckingAccount> checkingAccounts = Main.database.getCheckingAccountsBySSN(Integer.toString(customer.getSocial()));
        HBox custBox = new HBox();
        custBox.getChildren().add(new customerInfoTellerView());
        custBox.getChildren().add(new TellerCustomerSearchPane("Search New Customer"));

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
}
