package ContentPanes;

import ContentPanes.EzItems.EzText;
import DatabaseObjects.*;
import Master.Main;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by user on 11/28/2016.
 */
public class TimeMachinePane extends GridPane {
    public TimeMachinePane() {
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(25, 25, 25, 25));
        EzText title1 = new EzText("Change Database Date");
        title1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        add(title1, 0, 0, 4, 1);

        TextField databaseDateField = new TextField();
        add(databaseDateField, 0, 1);
        Button changeDateButton = new Button("Change Date");
        add(changeDateButton, 1, 1);
        changeDateButton.setOnAction((ActionEvent event) -> {
            String databaseStringDate = databaseDateField.getText();
            DateFormat df;
            List<SavingAccount> CDAccountsToRemove = new ArrayList<>();
            df = new SimpleDateFormat("MM/dd/yyyy");
            Date newDatabaseDate;
            try {
                newDatabaseDate = df.parse(databaseStringDate);
                String newFormattedDate = df.format(newDatabaseDate);
                Main.database.databaseTime = newFormattedDate;
                System.out.println("Date changed to: " + newFormattedDate + ".");
                for (SavingAccount account : Main.database.getSavingAccounts()) {
                    Date FormattedLastIntPaidDate ;
                    FormattedLastIntPaidDate = df.parse(account.getLastInterestPaidDate());
                    Calendar cal = Calendar.getInstance();
                    cal.clear();
                    cal.setTime(FormattedLastIntPaidDate);
                    cal.add(Calendar.MONTH, 1);
                    Calendar cal2 = Calendar.getInstance();
                    cal2.setTime(newDatabaseDate);

                    if (account.getSavingsAccountType().equalsIgnoreCase("CD")) {
                        Date FormattedTermDate = df.parse(account.getTermDate());
                        Calendar cal3;
                        cal3 = Calendar.getInstance();
                        cal3.setTime(FormattedTermDate);
                        if (cal3.before(cal2)) {
                            System.out.println(account.getSavingsAccountType() + " Account #: " + account.getAccountID() + " has come to term. Customer paid: $" + account.getCurrentBalance() + " and account closed.");
                        }
                    }
                    if (cal2.compareTo(cal) > 0) {
                        account.setCurrentBalance(account.getCurrentBalance() * (1 + account.getInterestRate()));
                        account.setLastInterestPaidDate(newFormattedDate);
                        System.out.println(account.getSavingsAccountType() + " Account #: " + account.getAccountID() + " Last interest paid date updated to: " + databaseStringDate + ". New account balance is $" + account.getCurrentBalance());
                    }
                }

                for (CheckingAccount account : Main.database.getCheckingAccounts()) {

                    if (account.getAccountType().equalsIgnoreCase("GOLD/DIAMOND")) {
                        Date FormattedLastIntPaidDate = null;
                        FormattedLastIntPaidDate = df.parse(account.getLastInterestPaidDate());
                        Calendar cal = Calendar.getInstance();
                        cal.clear();
                        cal.setTime(FormattedLastIntPaidDate);
                        cal.add(Calendar.MONTH, 1);
                        Calendar cal2 = Calendar.getInstance();
                        cal2.setTime(newDatabaseDate);
                        if (cal2.compareTo(cal) > 0) {
                            account.setCurrentBalance(account.getCurrentBalance() * (1 + Main.database.GOLDINTERESTRATE));
                            account.setLastInterestPaidDate(newFormattedDate);
                            System.out.println(account.getAccountType() + " Account #: " + account.getAccountID() + " last interest paid date updated to: " + databaseStringDate + ". New account balance is $" + account.getCurrentBalance());
                        }
                    }
                }
                for (Check check : Main.database.getChecks()) {
                    Date FormattedCheckDate;
                    FormattedCheckDate = df.parse(check.getDate());
                    Calendar cal = Calendar.getInstance();
                    cal.clear();
                    cal.setTime(FormattedCheckDate);
                    cal.add(Calendar.DATE, 7);
                    Calendar cal2 = Calendar.getInstance();
                    cal2.setTime(newDatabaseDate);
                    if (cal2.compareTo(cal) > 0) {
                        for (CheckingAccount account : Main.database.getCheckingAccounts()) {
                            if (account.getAccountID().equals(check.getAccountID()) && account.getCurrentBalance()>check.getAmt()) {
//                                account.setCurrentBalance(account.getCurrentBalance() - check.getAmt());
                                account.withdraw(check.getAmt(), account);
                                System.out.println("Check: # " + check.getCheckNum() + " Written by Account: # " + check.getAccountID() + " for Amount: $" + check.getAmt() + " processed.");
                            }
                        }
                    }
                }
                for (TermLoan termLoan : Main.database.getTermLoans()){
                    Date FormattedPaymentDueDate;
                    FormattedPaymentDueDate = df.parse(termLoan.getDatePaymentDue());
                    Calendar cal = Calendar.getInstance();
                    cal.clear();
                    cal.setTime(FormattedPaymentDueDate);
                    Calendar cal2 = Calendar.getInstance();
                    cal2.setTime(newDatabaseDate);
                    if(cal2.after(cal)){
                        cal.add(Calendar.MONTH,1);
                        FormattedPaymentDueDate = cal.getTime();
                        termLoan.setDatePaymentDue(df.format(FormattedPaymentDueDate));
                        termLoan.setCurrentPaymentDueAmt(((.5*termLoan.getCurrentBalance())*((termLoan.getFixedInterestRate())/12))+termLoan.getCurrentPaymentDueAmt()+75);
                        termLoan.setMissedPaymentFlag(termLoan.getMissedPaymentFlag()+1);
                        System.out.println(termLoan.getTermLoanType() + " Account: " + termLoan.getLoanID() + " current loan balance: $" + termLoan.getCurrentBalance() +  " current payment due: $" + termLoan.getCurrentPaymentDueAmt() + " flag count: " + termLoan.getMissedPaymentFlag() + " next payment due: " + termLoan.getDatePaymentDue());

                    }
                }
                for (CreditCard creditCard : Main.database.getCreditCards()){
                    Date FormattedPaymentDueDate;
                    FormattedPaymentDueDate = df.parse(creditCard.getDatePaymentDue());
                    Calendar cal = Calendar.getInstance();
                    cal.clear();
                    cal.setTime(FormattedPaymentDueDate);
                    Calendar cal2 = Calendar.getInstance();
                    cal2.setTime(newDatabaseDate);
                    if(cal2.after(cal)){
                        cal.add(Calendar.MONTH,1);
                        FormattedPaymentDueDate = cal.getTime();
                        creditCard.setDatePaymentDue(df.format(FormattedPaymentDueDate));
                        creditCard.setCurrentPaymentDueAmt(((creditCard.getCurrentBalance()*creditCard.getCurrentInterestRate())/12)+creditCard.getCurrentBalance());
                        creditCard.setMissedPaymentFlag(creditCard.getMissedPaymentFlag()+1);
                        System.out.println("Credit Card Account: " +creditCard.getCreditCardID() + " current balance: $" + creditCard.getCurrentBalance() +  " current payment due: $" + creditCard.getCurrentPaymentDueAmt() + " flag count: " + creditCard.getMissedPaymentFlag() + " next payment due: " + creditCard.getDatePaymentDue());

                    }
                }
            } catch (ParseException e) {
                System.out.print("Incorrect Date Format. The Correct Date Format is: 'MM/dd/yyyy'. ");
            }
        });
    }
}