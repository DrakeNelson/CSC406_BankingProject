package ContentPanes.AccountOpener;

import ContentPanes.AccountInfoViews.CustomerInfoView;
import ContentPanes.EzItems.EzText;
import DatabaseObjects.CheckingAccount;
import DatabaseObjects.Customer;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import static ContentPanes.EzItems.TryParse.TryParseDouble;
import static Master.Main.database;

/**
 * "AccountID": "263748593021",
 * "CustomerSocial": 345653425,
 * "AccountType": "Gold",
 * "CurrentBalance": 1000.0,
 * "BackupAccountIDs": "null",
 * "OverdraftCount": 0,
 * "DateAccountOpened": "11/24/2016"
 * Created by user on 11/28/2016.
 */
public class CheckingAccountOpener extends VBox {
    private Customer thisCustomer;

    public CheckingAccountOpener(Customer customer) {
        thisCustomer = customer;
        getChildren().add(new CustomerInfoView(customer));
        getChildren().add(new newCheckingAccountForm());
    }

    private class newCheckingAccountForm extends GridPane {
        private newCheckingAccountForm() {
            setHgap(10);
            setVgap(10);
            setPadding(new Insets(25, 25, 25, 25));
            EzText title1 = new EzText("New Checking Account");
            title1.setFont(Font.font("Gabriola", FontWeight.NORMAL, 20));
            add(title1, 0, 0, 4, 1);

            EzText socialText = new EzText("New Checking Account Number: ");
            add(socialText, 0, 2);
            EzText newAccountNumberField = new EzText(Integer.toString(thisCustomer.getSocial()) + "2" +
                    Integer.toString(database.getCheckingAccountsBySSN(Integer.toString(thisCustomer.getSocial())).size() + 1));
            add(newAccountNumberField, 1, 2);

            EzText startingBalanceText = new EzText("Opening Balance: ");
            add(startingBalanceText, 0, 3);
            TextField startingBalanceField = new TextField();
            add(startingBalanceField, 1, 3);

            EzText BackupAccountIDText = new EzText("Backup Account: ");
            add(BackupAccountIDText, 0, 4);
            TextField BackupAccountIDField = new TextField();
            add(BackupAccountIDField, 1, 4);

            final Text actionTarget = new Text();
            add(actionTarget, 1, 5);

            Button signButton = new Button("Create New Checking Account");
            signButton.setFont(Font.font("Gabriola", FontWeight.NORMAL, 20));
            add(signButton, 0, 10, 4, 1);
            signButton.setOnAction(event -> {
                String openBal=startingBalanceField.getText();
                String backupAccount=BackupAccountIDField.getText();
                if(TryParseDouble(openBal)){
                    database.getCheckingAccounts().add(new CheckingAccount(thisCustomer.getSocial(),Double.parseDouble(openBal),backupAccount,newAccountNumberField.getText()));
                    actionTarget.setFill(Color.FIREBRICK);
                    actionTarget.setText("Checking Account Created");
                }else{
                    actionTarget.setFill(Color.FIREBRICK);
                    actionTarget.setText("invalid value in openBal");
                }
            });
        }
    }
}
