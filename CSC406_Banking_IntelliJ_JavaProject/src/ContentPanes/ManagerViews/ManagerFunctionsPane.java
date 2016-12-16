package ContentPanes.ManagerViews;

import ContentPanes.EzItems.EzText;
import DatabaseObjects.SavingAccount;
import DatabaseObjects.TermLoan;
import Master.Main;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import DatabaseObjects.CheckingAccount;
import static Master.Main.database;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import DatabaseObjects.CreditCard;

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
            database.GOLDINTERESTRATE=Double.parseDouble(goldInterestRate.getText());
            System.out.println("changed");
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



                try {
                    for(SavingAccount account: Main.database.getSavingAccounts()) {
                        DateFormat df;
                        df = new SimpleDateFormat("MM/dd/yyyy");
                        Date newDataBaseDate;
                        Date FormattedTermDate;

                        if (account.getSavingsAccountType().equalsIgnoreCase("CD")){
                        newDataBaseDate = df.parse(database.databaseTime);
                        FormattedTermDate = df.parse(account.getTermDate());
                        Calendar cal = Calendar.getInstance();
                        cal.clear();
                        cal.setTime(FormattedTermDate);
                        cal.add(Calendar.DATE,-7);
                        Calendar cal2=Calendar.getInstance();
                        cal2.setTime(newDataBaseDate);
                       // System.out.println(FormattedTermDate);
                        if(cal2.compareTo(cal)>0) {
                            System.out.println("Account number " +account.getAccountID()+ " your CD will come due on "+account.getTermDate()+" ,and your current balance is $"+account.getCurrentBalance()+".");
                        }
                        }
                    }
                } catch (ParseException e1) {
                    e1.printStackTrace();
                }




        });

        EzText title3 = new EzText("Send Billing Notifications");
        title3.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        add(title3, 0, 4, 4, 1);

        Button billingButton = new Button("Send");
        add(billingButton, 0, 5);
        billingButton.setOnAction(e -> {
            try {
                for(CreditCard card: Main.database.getCreditCards()) {
                    DateFormat df;
                    df = new SimpleDateFormat("MM/dd/yyyy");
                    Date newDataBaseDate;
                    Date FormattedTermDate;


                        newDataBaseDate = df.parse(database.databaseTime);
                        FormattedTermDate = df.parse(card.getDatePaymentDue());
                        Calendar cal = Calendar.getInstance();
                        cal.clear();
                        cal.setTime(FormattedTermDate);
                        cal.add(Calendar.DATE,-7);
                        Calendar cal2=Calendar.getInstance();
                        cal2.setTime(newDataBaseDate);
                        // System.out.println(FormattedTermDate);
                        if(cal2.compareTo(cal)>0) {
                            System.out.println("CREDIT CARD: "+"Account number " +card.getCreditCardID()+ " your credit card bill  will be due on "+card.getDatePaymentDue()+" ,and your current balance is $"+card.getCurrentBalance()+".");
                        }
                    }
                for(TermLoan termLoan: Main.database.getTermLoans()) {
                    DateFormat df;
                    df = new SimpleDateFormat("MM/dd/yyyy");
                    Date newDataBaseDate;
                    Date FormattedTermDate;


                    newDataBaseDate = df.parse(database.databaseTime);
                    FormattedTermDate = df.parse(termLoan.getDatePaymentDue());
                    Calendar cal = Calendar.getInstance();
                    cal.clear();
                    cal.setTime(FormattedTermDate);
                    cal.add(Calendar.DATE,-7);
                    Calendar cal2=Calendar.getInstance();
                    cal2.setTime(newDataBaseDate);
                    // System.out.println(FormattedTermDate);
                    if(cal2.compareTo(cal)>0) {
                        System.out.println("TERM LOAN: "+"Account number " +termLoan.getLoanID()+ " your term loan bill  will be due on "+termLoan.getDatePaymentDue()+" ,and your current balance is $"+termLoan.getCurrentBalance()+".");
                    }
                }
            } catch (ParseException e1) {
                e1.printStackTrace();
            }
        });
    }
}
