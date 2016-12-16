package ContentPanes.AccountInfoViews;

import ContentPanes.EzItems.EzLabel;
import ContentPanes.EzItems.EzText;
import DatabaseObjects.CreditCard;
import DatabaseObjects.PurchasesThisMonth;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.text.DecimalFormat;

public class CreditCardInfoView extends GridPane {
    private static DecimalFormat format = new DecimalFormat(".00");

    public CreditCardInfoView(CreditCard card){
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(0, 25, 25, 25));
        EzText scenetitle = new EzText("Card # : " + card.getCreditCardID());
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        add(scenetitle, 0, 0, 4, 1);

        add(new EzLabel("Current Balance:"), 0, 1);
        add(new EzText("$"+format.format(card.getCurrentBalance())), 1, 1);
        add(new EzLabel("Interest Rate:"), 2, 1);
        add(new EzText(format.format(card.getCurrentInterestRate() * 100) + "%"), 3, 1);
        add(new EzLabel("Payment Due:"), 4, 1);
        add(new EzText(card.getDatePaymentDue()), 5, 1);
        add(new EzLabel("Flag:"), 6, 1);
        add(new EzText(Integer.toString(card.getMissedPaymentFlag())), 7, 1);

        add(new EzLabel("Credit Limit:"), 0, 2);
        add(new EzText("$"+format.format(card.getCreditLimit())), 1, 2);
        add(new EzLabel("Last Paid:"), 2, 2);
        add(new EzText(card.getDateLastPaymentMade()), 3, 2);
        add(new EzLabel("Due amt:"), 4, 2);
        add(new EzText("$"+format.format(card.getCurrentPaymentDueAmt())), 5, 2);
        EzLabel recentPurchasesText = new EzLabel("Recent Purchases: ");

        add(recentPurchasesText,0,3);
        int i=4;
        for (PurchasesThisMonth purchase : card.getPurchasesThisMonth()) {
            add(new EzLabel("ID:"), 0, i);
            add(new EzText(purchase.getPurchaseID()), 1, i);
            add(new EzLabel("Title:"), 2, i);
            add(new EzText(purchase.getPurchaseTitle()), 3, i);
            add(new EzLabel("Location:"), 4, i);
            add(new EzText(purchase.getPurchaseLocation()), 5, i);
            add(new EzLabel("Purchase Amt:"), 6, i);
            add(new EzText("$"+format.format(purchase.getPurchaseAmt())), 7, i);
            i++;
        }

    }
}
