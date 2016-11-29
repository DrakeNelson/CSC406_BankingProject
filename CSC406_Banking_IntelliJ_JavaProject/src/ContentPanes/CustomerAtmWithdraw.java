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
public class CustomerAtmWithdraw extends GridPane {
    public CustomerAtmWithdraw(){
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(25, 25, 25, 25));
        EzText title1 = new EzText("Make An ATM Withdrawal");
        title1.setFont(Font.font("Gabriola", FontWeight.NORMAL, 20));
        add(title1, 0, 0, 4, 1);

        EzText cardText = new EzText("Account #: ");
        add(cardText,0,2);
        TextField cardField = new TextField();
        add(cardField, 1, 2);

        EzText amtText = new EzText("Withdraw amt: ");
        add(amtText,0,3);
        TextField amtField = new TextField();
        add(amtField, 1, 3);

        Button signButton = new Button("Withdraw");
        signButton.setFont(Font.font("Gabriola", FontWeight.NORMAL, 20));
        add(signButton, 0, 5, 4, 1);
    }
}
