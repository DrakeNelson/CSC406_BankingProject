package ContentPanes.CustomerViews;

import ContentPanes.EzItems.EzText;
import DatabaseObjects.Customer;
import Master.Main;
import Master.MasterController;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * Created by user on 11/28/2016.
 * DONE
 */
public class CustomerAtmWithdraw extends GridPane {
    public CustomerAtmWithdraw(){

        setHgap(10);
        setVgap(10);
        setPadding(new Insets(25, 25, 25, 25));
        EzText title1 = new EzText("Make An ATM Withdrawal");
        title1.setFont(Font.font("Gabriola", FontWeight.NORMAL, 20));
        add(title1, 0, 0, 4, 1);

        EzText cardText = new EzText("SWIPE CARD (enter Customer #): ");
        add(cardText,0,2);
        TextField cardField = new TextField();
        add(cardField, 1, 2);

        final Text actionTarget = new Text();
        add(actionTarget, 1, 6);

        Button signButton = new Button("View Accounts");
        signButton.setFont(Font.font("Gabriola", FontWeight.NORMAL, 20));
        add(signButton, 0, 5, 4, 1);
        signButton.setOnAction(e -> {
            Customer cust = Main.database.getCustomerBySSN(cardField.getText());
            if(cust==null){
                actionTarget.setFill(Color.FIREBRICK);
                actionTarget.setText("Customer: "+cardField.getText()+" does not exist in our records.");
            }else{
                MasterController.AtmSearchClick(cust);
            }
        });
    }
}
