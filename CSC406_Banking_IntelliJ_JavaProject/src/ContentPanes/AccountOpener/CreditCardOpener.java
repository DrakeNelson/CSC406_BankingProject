package ContentPanes.AccountOpener;

import ContentPanes.AccountInfoViews.CustomerInfoView;
import ContentPanes.EzItems.EzText;
import DatabaseObjects.Customer;
import Master.Main;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Created by user on 11/28/2016.
 */
public class CreditCardOpener extends VBox {
    private Customer thisCustomer;
    public CreditCardOpener(Customer customer) {
        thisCustomer=customer;
        getChildren().add(new CustomerInfoView(customer));
        getChildren().add(new newCreditCardForm());
    }
    private class newCreditCardForm extends GridPane{
        private newCreditCardForm(){
            setHgap(10);
            setVgap(10);
            setPadding(new Insets(25, 25, 25, 25));
            EzText title1 = new EzText("New Credit Card");
            title1.setFont(Font.font("Gabriola", FontWeight.NORMAL, 20));
            add(title1, 0, 0, 4, 1);

            EzText socialText = new EzText("New Credit Card Number: ");
            add(socialText,0,2);
            EzText socialField = new EzText(Integer.toString(thisCustomer.getSocial())+"3"+
                    Integer.toString(Main.database.getCreditCardsBySSN(Integer.toString(thisCustomer.getSocial())).size()+1));
            add(socialField, 1, 2);

            EzText interestText = new EzText("Interest Rate: ");
            add(interestText,0,3);
            TextField interestTextField = new TextField();
            add(interestTextField, 1, 3);

            EzText payDueText = new EzText("Date Payment Due: ");
            add(payDueText,0,4);
            TextField payDueTextField = new TextField();
            add(payDueTextField, 1, 4);

            EzText NotificationDateText = new EzText("Notifications Sent on: ");
            add(NotificationDateText,0,5);
            TextField NotificationDateTextField = new TextField();
            add(NotificationDateTextField, 1, 5);

            EzText CreditLimitText = new EzText("Credit Limit: ");
            add(CreditLimitText,0,5);
            TextField CreditLimitTextField = new TextField();
            add(CreditLimitTextField, 1, 5);

            Button signButton = new Button("Create New Checking Account");
            signButton.setFont(Font.font("Gabriola", FontWeight.NORMAL, 20));
            add(signButton, 0, 10, 4, 1);
            signButton.setOnAction(e -> {

            });
        }
    }
}
