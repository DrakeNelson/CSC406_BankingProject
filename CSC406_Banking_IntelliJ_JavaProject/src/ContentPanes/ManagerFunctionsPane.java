package ContentPanes;

import ContentPanes.EzItems.EzText;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Created by user on 11/28/2016.
 */
public class ManagerFunctionsPane extends GridPane {
    public ManagerFunctionsPane(){
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(25, 25, 25, 25));
        EzText title1 = new EzText("Change Gold/Diamond Interest Rates");
        title1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        add(title1, 0, 0, 4, 1);

        TextField goldInterestRate = new TextField();
        add(goldInterestRate, 0, 1);
        Button changeGoldButton = new Button("Change Gold Interest Rate");
        add(changeGoldButton, 1, 1);
        changeGoldButton.setOnAction(e -> {
        });
        TextField diamondInterestRate = new TextField();
        add(diamondInterestRate, 2, 1);
        Button changeDiamondButton = new Button("Change Diamond Interest Rate");
        add(changeDiamondButton, 3, 1);
        changeDiamondButton.setOnAction(e -> {
        });

        EzText title2 = new EzText("Send RollOver Notifications");
        title2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        add(title2, 0, 2, 4, 1);

        Button rollOverButton = new Button("Send");
        add(rollOverButton, 0, 3);
        rollOverButton.setOnAction(e -> {
        });

        EzText title3 = new EzText("Send Billing Notifications");
        title3.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        add(title3, 0, 4, 4, 1);

        Button billingButton = new Button("Send");
        add(billingButton, 0, 5);
        billingButton.setOnAction(e -> {
        });
    }
}