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
public class CustomerCheckWriterPane extends GridPane {
    public CustomerCheckWriterPane(){
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(25, 25, 25, 25));
        EzText title1 = new EzText("Write a Check");
        title1.setFont(Font.font("Gabriola", FontWeight.NORMAL, 20));
        add(title1, 0, 0, 4, 1);

        EzText dateText = new EzText("Date: ");
        add(dateText,0,2);
        TextField dateField = new TextField();
        add(dateField, 1, 2);

        EzText orderOfText = new EzText("Order Of: ");
        add(orderOfText,0,3);
        TextField orderOfField = new TextField();
        add(orderOfField, 1, 3);

        EzText ammountText = new EzText("Amt: ");
        add(ammountText,0,4);
        TextField ammountField = new TextField();
        add(ammountField, 1, 4);

        EzText accountNumText = new EzText("Account Num: ");
        add(accountNumText,0,5);
        TextField accountNumField = new TextField();
        add(accountNumField, 1, 5);

        EzText checkNumText = new EzText("Check Num: ");
        add(checkNumText,0,6);
        TextField checkNumField = new TextField();
        add(checkNumField, 1, 6);

        EzText forText = new EzText("For: ");
        add(forText,0,7);
        TextField forField = new TextField();
        add(forField, 1, 7);

        Button signButton = new Button("Sign and send Check");
        signButton.setFont(Font.font("Gabriola", FontWeight.NORMAL, 20));
        add(signButton, 0, 9, 4, 1);
    }
}
