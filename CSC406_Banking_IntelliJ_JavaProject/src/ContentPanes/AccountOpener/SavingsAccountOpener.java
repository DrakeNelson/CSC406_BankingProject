package ContentPanes.AccountOpener;

import ContentPanes.AccountInfoViews.CustomerInfoView;
import ContentPanes.EzItems.EzText;
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

import static ContentPanes.EzItems.TryParse.TryParseDouble;
import static ContentPanes.EzItems.TryParse.TryParseInt;
import static Master.Main.customer;
import static Master.Main.database;

/**
 * Created by user on 11/28/2016.
 */
public class SavingsAccountOpener extends VBox {
    private Customer thisCustomer;
    public SavingsAccountOpener(Customer customer) {
        thisCustomer=customer;
        getChildren().add(new CustomerInfoView(customer));
        getChildren().add(new newSavingsAccountForm());
    }
    private class newSavingsAccountForm extends GridPane{
        private newSavingsAccountForm(){
            setHgap(10);
            setVgap(10);
            setPadding(new Insets(25, 25, 25, 25));
            EzText title1 = new EzText("New Savings Account");
            title1.setFont(Font.font("Gabriola", FontWeight.NORMAL, 20));
            add(title1, 0, 0, 4, 1);

            EzText accountText = new EzText("New Savings Account Number: ");
            add(accountText,0,2);
            EzText accountField = new EzText(Integer.toString(thisCustomer.getSocial())+"1"+
                    Integer.toString(Main.database.getCreditCardsBySSN(Integer.toString(thisCustomer.getSocial())).size()+1));
            add(accountField, 1, 2);

            EzText interestText = new EzText("Interest Rate: ");
            add(interestText,0,3);
            TextField interestTextField = new TextField();
            add(interestTextField, 1, 3);

            EzText startText = new EzText("Starting Balance: ");
            add(startText,0,4);
            TextField startTextField = new TextField();
            add(startTextField, 1, 4);

            EzText backupText = new EzText("Backup Account: ");
            add(backupText,0,5);
            TextField backupTextField = new TextField();
            add(backupTextField, 1, 5);

            Button signButton = new Button("Create New Savings Account");
            signButton.setFont(Font.font("Gabriola", FontWeight.NORMAL, 20));
            add(signButton, 0, 7, 4, 1);
            signButton.setOnAction(e -> {
                String   openBal=startTextField.getText();
                String  interest=interestTextField.getText();
                if(TryParseDouble(openBal)&&TryParseDouble(interest)){
                    database.getSavingAccounts().add(new SavingAccount(thisCustomer.getSocial(),accountField.getText(),Double.parseDouble(openBal),Double.parseDouble(interest),backupText.getText()));
                }
            });
        }
    }
}
