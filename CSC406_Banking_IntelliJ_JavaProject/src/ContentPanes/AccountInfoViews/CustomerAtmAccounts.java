package ContentPanes.AccountInfoViews;

import ContentPanes.EzItems.EzLabel;
import ContentPanes.EzItems.EzText;
import DatabaseObjects.Account;
import DatabaseObjects.CheckingAccount;
import DatabaseObjects.Customer;
import DatabaseObjects.SavingAccount;
import Master.Main;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.text.DecimalFormat;
import java.util.List;

import static ContentPanes.EzItems.TryParse.TryParseDouble;
import static Master.MasterController.AtmSearchClick;

/**
 * Created by user on 12/10/2016.
 */
public class CustomerAtmAccounts extends VBox {
    private static Customer thisCustomer;

    public CustomerAtmAccounts(Customer customer) {
        thisCustomer = customer;
        getChildren().add(new CustomerInfoView(thisCustomer));

        List<SavingAccount> traditionalSavingsAccounts = Main.database.getTraditionalSavingsBySSN(Integer.toString(customer.getSocial()));
        List<CheckingAccount> checkingAccounts = Main.database.getCheckingAccountsBySSN(Integer.toString(customer.getSocial()));

        EzText savingsAccountListEzLabel = new EzText("Savings Accounts:");
        savingsAccountListEzLabel.setFont(Font.font("Gabriola", FontWeight.BLACK, 24));
        getChildren().add(savingsAccountListEzLabel);
        for (SavingAccount account : traditionalSavingsAccounts) {
            getChildren().add(new SavingsAccountInfoView(account));
            getChildren().add(new tempGrid(account));
        }
        //list checking accounts
        EzText checkingAccountListEzLabel = new EzText("Checking Accounts:");
        checkingAccountListEzLabel.setFont(Font.font("Gabriola", FontWeight.BLACK, 24));
        getChildren().add(checkingAccountListEzLabel);
        for (CheckingAccount account : checkingAccounts) {
            getChildren().add(new atmCheckingAccountView(account));
            getChildren().add(new tempGrid(account));
        }
    }

    private class tempGrid extends GridPane {
        public tempGrid(Account account) {
            setHgap(10);
            setVgap(10);
            setPadding(new Insets(25, 25, 25, 25));
            EzText title1 = new EzText("Make An ATM Withdrawal");
            title1.setFont(Font.font("Gabriola", FontWeight.NORMAL, 20));
            add(title1, 0, 0, 4, 1);

            EzText cardText = new EzText("bal: ");
            add(cardText, 0, 2);
            EzText cardField = new EzText(Double.toString(account.getCurrentBalance()));
            add(cardField, 1, 2);

            TextField payField = new TextField();
            add(payField, 0, 3);
            Button payButton = new Button("Withdraw");
            add(payButton, 1, 3);
            payButton.setOnAction(e -> {
                if (TryParseDouble(payField.getText())) {
                    double x = Double.parseDouble(payField.getText());
                    account.setCurrentBalance(account.getCurrentBalance() - x);
                    AtmSearchClick(thisCustomer);
                }
            });
        }
    }
    private static DecimalFormat format = new DecimalFormat(".00");

    private class atmCheckingAccountView extends GridPane {
        public atmCheckingAccountView(CheckingAccount account) {
            setHgap(10);
            setVgap(10);
            setPadding(new Insets(25, 25, 25, 25));
            EzText scenetitle = new EzText("Account # : " + account.getAccountID());
            scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
            add(scenetitle, 0, 0, 4, 1);

            add(new EzLabel("Current Balance:"), 0, 1);
            add(new EzText("$" + format.format(account.getCurrentBalance())), 1, 1);
            add(new EzLabel("Account Type:"), 2, 1);
            add(new EzText(account.getAccountType()), 3, 1);
            add(new EzLabel("Open Date:"), 4, 1);
            add(new EzText(account.getDateAccountOpened()), 5, 1);
            add(new EzLabel("Overdraft Count:"), 6, 1);
            add(new EzText(Integer.toString(account.getOverdraftCount())), 7, 1);
        }

    }
}
