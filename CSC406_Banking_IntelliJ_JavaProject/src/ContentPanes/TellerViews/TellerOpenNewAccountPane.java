package ContentPanes.TellerViews;

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
public class TellerOpenNewAccountPane extends GridPane {
    public TellerOpenNewAccountPane(){
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(25, 25, 25, 25));
        EzText title1 = new EzText("Open a New Account");
        title1.setFont(Font.font("Gabriola", FontWeight.NORMAL, 20));
        add(title1, 0, 0, 4, 1);

        EzText userSSNText = new EzText("Customer SSN: ");
        add(userSSNText,0,2);
        TextField ssnField = new TextField();
        add(ssnField, 1, 2);
        final Text actionTarget = new Text();
        add(actionTarget,1,3);

        Button checkingButton = new Button("Open Checking");
        checkingButton.setFont(Font.font("Gabriola", FontWeight.NORMAL, 20));
        add(checkingButton, 0, 4, 3, 1);
        checkingButton.setOnAction(e -> {
            Customer cust = Main.database.getCustomerBySSN(ssnField.getText());
            if(cust==null){
                actionTarget.setFill(Color.FIREBRICK);
                actionTarget.setText("Customer: "+ssnField.getText()+" does not exist in our records.");
            }else{
                MasterController.OpenCheckingAccountClick(cust);
            }
        });

        Button signButton = new Button("Open Savings");
        signButton.setFont(Font.font("Gabriola", FontWeight.NORMAL, 20));
        add(signButton, 0, 5, 3, 1);
        signButton.setOnAction(e -> {
            Customer cust = Main.database.getCustomerBySSN(ssnField.getText());
            if(cust==null){
                actionTarget.setFill(Color.FIREBRICK);
                actionTarget.setText("Customer: "+ssnField.getText()+" does not exist in our records.");
            }else{
                MasterController.OpenTraditionalSavingsClick(cust);
            }
        });
    }
}
