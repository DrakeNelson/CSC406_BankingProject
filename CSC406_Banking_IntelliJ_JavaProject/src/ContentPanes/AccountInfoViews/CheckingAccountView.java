package ContentPanes.AccountInfoViews;

import ContentPanes.EzItems.EzLabel;
import ContentPanes.EzItems.EzText;
import DatabaseObjects.CheckingAccount;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.text.DecimalFormat;

/**
 * Created by user on 11/26/2016.
 */
public class CheckingAccountView extends GridPane{
    private static DecimalFormat format = new DecimalFormat(".00");

    public CheckingAccountView(CheckingAccount account) {
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(25, 25, 25, 25));
        EzText scenetitle = new EzText("Account # : " + account.getAccountID());
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        add(scenetitle, 0, 0, 4, 1);

        add(new EzLabel("Current Balance:"), 0, 1);
        add(new EzText("$"+format.format(account.getCurrentBalance())), 1, 1);
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
