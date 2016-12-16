package ContentPanes.AccountInfoViews;

import ContentPanes.EzItems.EzLabel;
import ContentPanes.EzItems.EzText;
import ContentPanes.TellerViews.TellerCustomerServicePane;
import DatabaseObjects.CheckingAccount;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.text.DecimalFormat;

import static ContentPanes.EzItems.TryParse.TryParseDouble;
import static Master.Main.database;
import static Master.MasterController.TellerSearchClick;

/**
 * Created by user on 11/26/2016.
 * DONE
 */
public class CheckingAccountView extends GridPane {
    private static DecimalFormat format = new DecimalFormat(".00");

    public CheckingAccountView(CheckingAccount account) {
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
        add(new EzLabel("Backup Account:"), 0, 2);
        add(new EzText(account.getBackupAccount()), 1, 2);
        final Text actionTarget = new Text();
        add(actionTarget, 4, 2);

        TextField depositTextField = new TextField();
        add(depositTextField, 0, 3);
        Button depositButton = new Button("Deposit");
        add(depositButton, 1, 3);
        depositButton.setOnAction(e -> {
            if (TryParseDouble(depositTextField.getText())) {
                account.setCurrentBalance(account.getCurrentBalance() + Double.parseDouble(depositTextField.getText()));
                TellerSearchClick(TellerCustomerServicePane.customer);
                actionTarget.setFill(Color.FIREBRICK);
                actionTarget.setText("Deposited");
            } else {
                actionTarget.setFill(Color.FIREBRICK);
                actionTarget.setText("Invalid amt");
            }
        });

        TextField withdrawlTextField = new TextField();
        add(withdrawlTextField, 3, 3);
        Button withdrawlButton = new Button("Withdrawl");
        add(withdrawlButton, 4, 3);
        withdrawlButton.setOnAction(e -> {
            if (TryParseDouble(withdrawlTextField.getText())) {
                account.withdraw(Double.parseDouble(withdrawlTextField.getText()), account);
                TellerSearchClick(TellerCustomerServicePane.customer);
            } else {
                actionTarget.setFill(Color.FIREBRICK);
                actionTarget.setText("Invalid amt");
            }
        });

        Button closeButton = new Button("Close Account");
        add(closeButton, 6, 3);
        closeButton.setOnAction(e -> {
            System.out.println("Checking account closed pay customer: $" + format.format(account.getCurrentBalance()));
            database.getCheckingAccounts().stream().filter(acc -> acc.getBackupAccount().equals(account.getAccountID())).forEach(acc -> acc.setBackupAccount(""));
            database.getSavingAccounts().stream().filter(acc -> acc.getBackupAccount().equals(account.getAccountID())).forEach(acc -> acc.setBackupAccount(""));
            database.getCheckingAccounts().remove(account);
            TellerSearchClick(TellerCustomerServicePane.customer);
        });
    }
}
