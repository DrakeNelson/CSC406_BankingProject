package ContentPanes.AccountInfoViews;

import ContentPanes.EzItems.EzLabel;
import ContentPanes.EzItems.EzText;
import DatabaseObjects.TermLoan;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.text.DecimalFormat;

/**
 * Created by user on 11/28/2016.
 * DONE
 */
public class TermLoanInfoView extends GridPane {
    private static DecimalFormat format = new DecimalFormat(".00");

    public TermLoanInfoView(TermLoan loan) {
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(0, 25, 25, 25));
        EzText scenetitle = new EzText("Loan # : " + loan.getLoanID());
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        add(scenetitle, 0, 0, 4, 1);

        add(new EzLabel("Current Balance:"), 0, 1);
        add(new EzText("$"+format.format(loan.getCurrentBalance())), 1, 1);
        add(new EzLabel("Interest Rate:"), 2, 1);
        add(new EzText(format.format(loan.getFixedInterestRate() * 100.0) + "%"), 3, 1);
        add(new EzLabel("Payment Due:"), 4, 1);
        add(new EzText(loan.getDatePaymentDue()), 5, 1);
        add(new EzLabel("Length Of Loan:"), 6, 1);
        add(new EzText(loan.getTermLoanType()), 7, 1);

        add(new EzLabel("Flag:"), 0, 2);
        add(new EzText(format.format(loan.getMissedPaymentFlag())), 1, 2);
        add(new EzLabel("Last Paid:"), 2, 2);
        add(new EzText(loan.getDateLastPaymentMade()), 3, 2);
        add(new EzLabel("Payment Due:"), 4, 2);
        add(new EzText("$"+format.format(loan.getCurrentPaymentDueAmt())), 5, 2);
        add(new EzLabel("Fixed Payment:"), 6, 2);
        add(new EzText("$"+format.format(loan.getFixedPaymentAmount())), 7, 2);

        add(new EzLabel("Loan Opened:"), 0, 3);
        add(new EzText(loan.getOpenDate()), 1, 3);
    }
}
