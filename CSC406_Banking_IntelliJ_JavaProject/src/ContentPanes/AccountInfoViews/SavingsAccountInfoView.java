package ContentPanes.AccountInfoViews;

import ContentPanes.EzItems.EzLabel;
import ContentPanes.EzItems.EzText;
import DatabaseObjects.SavingAccount;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.text.DecimalFormat;

/**
 * Created by user on 11/28/2016.
 */
public class SavingsAccountInfoView extends GridPane {
    private static DecimalFormat format = new DecimalFormat(".00");

    public SavingsAccountInfoView(SavingAccount account) {
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(0, 25, 0, 25));
        EzText scenetitle = new EzText("Account # : " + account.getAccountID());
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        add(scenetitle, 0, 0, 4, 1);

        add(new EzLabel("Current Balance:"), 0, 1);
        add(new EzText("$"+format.format(account.getCurrentBalance())), 1, 1);
        add(new EzLabel("Interest Rate:"), 2, 1);
        add(new EzText(format.format(account.getInterestRate() * 100) + "%"), 3, 1);
        add(new EzLabel("Open Date:"), 4, 1);
        add(new EzText(account.getOpenDate()), 5, 1);
    }
}
