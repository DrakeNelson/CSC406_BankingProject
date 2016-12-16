package ContentPanes.ManagerViews;

import ContentPanes.AccountInfoViews.CreditCardInfoView;
import ContentPanes.AccountInfoViews.CustomerInfoView;
import ContentPanes.AccountInfoViews.SavingsAccountInfoView;
import ContentPanes.AccountInfoViews.TermLoanInfoView;
import ContentPanes.EzItems.EzLabel;
import ContentPanes.EzItems.EzText;
import DatabaseObjects.*;
import Master.Main;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.text.DecimalFormat;
import java.util.List;

import static ContentPanes.EzItems.TryParse.TryParseDouble;
import static Master.Main.database;
import static Master.MasterController.ManagerSearchClick;

/*
 * Created by drake on 11/24/2016.
 * all of the buttons on this page have no functionality
 */
public class ManagerCustomerServicePane extends GridPane {
    private static DecimalFormat format = new DecimalFormat(".00");
    private Customer thisCustomer;
    final Text actionTarget = new Text();

    public ManagerCustomerServicePane(Customer searchedCustomer) {
        thisCustomer = searchedCustomer;
        //get all customer info
        List<SavingAccount> traditionalSavingsAccounts = Main.database.getTraditionalSavingsBySSN(Integer.toString(searchedCustomer.getSocial()));
        List<CheckingAccount> checkingAccounts = Main.database.getCheckingAccountsBySSN(Integer.toString(searchedCustomer.getSocial()));
        List<TermLoan> termLoans = Main.database.getTermLoansBySSN(Integer.toString(searchedCustomer.getSocial()));
        List<CreditCard> creditCards = Main.database.getCreditCardsBySSN(Integer.toString(searchedCustomer.getSocial()));
        List<SavingAccount> cdAccounts = Main.database.getCdBySSN(Integer.toString(searchedCustomer.getSocial()));

        //start working on interface stuff
        HBox custBox = new HBox();
        custBox.getChildren().addAll(new CustomerInfoView(searchedCustomer), new ManagerCustomerSearchPane("Search New Customer"));

        VBox outerBox = new VBox();
        outerBox.getChildren().add(actionTarget);
        outerBox.getChildren().add(custBox);
        outerBox.setAlignment(Pos.TOP_LEFT);

        // list savings accounts
        EzText savingsAccountListEzLabel = new EzText("Savings Accounts:");
        savingsAccountListEzLabel.setFont(Font.font("Gabriola", FontWeight.BLACK, 24));
        outerBox.getChildren().add(savingsAccountListEzLabel);
        for (SavingAccount account : traditionalSavingsAccounts) {
            outerBox.getChildren().add(new SavingsAccountInfoView(account));
            outerBox.getChildren().add(new customerSavingsAccountsManagerView(account));
        }
        // list CDs
        EzText cdAccountListEzLabel = new EzText("CDs:");
        cdAccountListEzLabel.setFont(Font.font("Gabriola", FontWeight.BLACK, 24));
        outerBox.getChildren().add(cdAccountListEzLabel);
        for (SavingAccount account : cdAccounts) {
            outerBox.getChildren().add(new customerCDsManagerView(account));
        }
        //list checking accounts
        EzText checkingAccountListEzLabel = new EzText("Checking Accounts:");
        checkingAccountListEzLabel.setFont(Font.font("Gabriola", FontWeight.BLACK, 24));
        outerBox.getChildren().add(checkingAccountListEzLabel);
        for (CheckingAccount account : checkingAccounts) {
            outerBox.getChildren().add(new CheckingAccountViewMan(account));
        }
        //list Loans
        EzText loanListEzLabel = new EzText("Term Loans:");
        loanListEzLabel.setFont(Font.font("Gabriola", FontWeight.BLACK, 24));
        outerBox.getChildren().add(loanListEzLabel);
        for (TermLoan loan : termLoans) {
            outerBox.getChildren().add(new TermLoanInfoView(loan));
            outerBox.getChildren().add(new customerTermLoansManagerView(loan));
        }
        //list creditCards
        EzText cardListEzLabel = new EzText("Credit Cards:");
        cardListEzLabel.setFont(Font.font("Gabriola", FontWeight.BLACK, 24));
        outerBox.getChildren().add(cardListEzLabel);
        for (CreditCard card : creditCards) {
            outerBox.getChildren().add(new CreditCardInfoView(card));
            outerBox.getChildren().add(new customerCreditCardManagerView(card));
        }

        getChildren().add(outerBox);
    }

    //this pane is a formatted view of each savings account first view under customer info
    private class customerSavingsAccountsManagerView extends GridPane {
        private customerSavingsAccountsManagerView(SavingAccount account) {
            setHgap(10);
            setVgap(10);
            setPadding(new Insets(0, 25, 25, 25));

            TextField depositTextField = new TextField();
            add(depositTextField, 0, 0);
            Button depositButton = new Button("Deposit");
            add(depositButton, 1, 0);
            depositButton.setOnAction(e -> {
                if (TryParseDouble(depositTextField.getText())) {
                    account.setCurrentBalance(account.getCurrentBalance() + Double.parseDouble(depositTextField.getText()));
                    ManagerSearchClick(thisCustomer);
                }else{
                    actionTarget.setFill(Color.FIREBRICK);
                    actionTarget.setText("Invalid amt");
                }

            });

            TextField withdrawTextField = new TextField();
            add(withdrawTextField, 2, 0);
            Button withdrawButton = new Button("Withdraw");
            add(withdrawButton, 3, 0);
            withdrawButton.setOnAction(e -> {
                if (TryParseDouble(withdrawTextField.getText())) {
                    account.withdraw(Double.parseDouble(withdrawTextField.getText()), account);
                    ManagerSearchClick(thisCustomer);
                    if (account.getCurrentBalance() == 0) {
                        System.out.println("Overdraft Protection Activated");
                    }
                } else {
                    actionTarget.setFill(Color.FIREBRICK);
                    actionTarget.setText("Invalid amt");
                }
            });

            TextField interestField = new TextField();
            add(interestField, 4, 0);
            Button interestButton = new Button("Set Interest");
            add(interestButton, 5, 0);
            interestButton.setOnAction(e -> {
                if (TryParseDouble(interestField.getText())) {
                    account.setInterestRate(account.getCurrentBalance() + Double.parseDouble(interestField.getText()));
                    ManagerSearchClick(thisCustomer);
                } else {
                    actionTarget.setFill(Color.FIREBRICK);
                    actionTarget.setText("Invalid amt");
                }
            });

            Button closeButton = new Button("Close Account");
            add(closeButton, 6, 0);
            closeButton.setOnAction(e -> {
                database.getSavingAccounts().remove(account);
                ManagerSearchClick(thisCustomer);
                System.out.println("Savings Account closed Pay Customer: $" + account.getCurrentBalance());

            });

        }
    }

    //formatted view of each TermLoan
    private class customerTermLoansManagerView extends GridPane {
        private customerTermLoansManagerView(TermLoan loan) {
            setHgap(10);
            setVgap(10);
            setPadding(new Insets(0, 25, 25, 25));

            TextField payField = new TextField();
            add(payField, 0, 0);
            Button payButton = new Button("Pay Amt");
            add(payButton, 1, 0);
            payButton.setOnAction(e -> {
                if(TryParseDouble(payField.getText())){
                    loan.setCurrentBalance(loan.getCurrentBalance()-Double.parseDouble(payField.getText()));
                    if(Double.parseDouble(payField.getText())>=loan.getCurrentPaymentDueAmt()){
                        loan.setCurrentPaymentDueAmt(0);
                    }else{
                        loan.setCurrentPaymentDueAmt(loan.getCurrentPaymentDueAmt()-Double.parseDouble(payField.getText()));
                    }
                    ManagerSearchClick(thisCustomer);
                }
            });
            TextField interestField = new TextField();
            add(interestField, 2, 0);
            Button setInterestButton = new Button("Set Interest");
            add(setInterestButton, 3, 0);
            setInterestButton.setOnAction(e -> {
                String interest=interestField.getText();
                loan.setFixedInterestRate(Double.parseDouble(interest));
                loan.setFixedPaymentAmount((.5*loan.getCurrentBalance())*(loan.getFixedInterestRate())/12);
                ManagerSearchClick(thisCustomer);
            });
            Button payFixedButton = new Button("Pay Fixed Amt");
            add(payFixedButton, 6, 0);
            payFixedButton.setOnAction(e -> {
                loan.setCurrentBalance(loan.getCurrentBalance()-loan.getCurrentPaymentDueAmt());
                loan.setCurrentPaymentDueAmt(0);
                ManagerSearchClick(thisCustomer);
            });

        }
    }

    //formatted view of each credit card
    private class customerCreditCardManagerView extends GridPane {
        private customerCreditCardManagerView(CreditCard card) {
            setHgap(10);
            setVgap(10);
            setPadding(new Insets(0, 25, 25, 25));


            TextField payField = new TextField();
            add(payField, 0, 0);
            Button payButton = new Button("Pay Amt");
            add(payButton, 1, 0);
            payButton.setOnAction(e -> {
                if(TryParseDouble(payField.getText())){
                    card.setCurrentBalance(card.getCurrentBalance()-Double.parseDouble(payField.getText()));
                    if(Double.parseDouble(payField.getText())>=card.getCurrentPaymentDueAmt()){
                        card.setCurrentPaymentDueAmt(0.);
                    }else{
                        card.setCurrentPaymentDueAmt(card.getCurrentPaymentDueAmt()-Double.parseDouble(payField.getText()));
                    }
                    ManagerSearchClick(thisCustomer);
                }
            });

            Button payFixedButton = new Button("Pay Fixed Amt");
            add(payFixedButton, 6, 0);
            payFixedButton.setOnAction(e -> {
                card.setCurrentBalance(card.getCurrentBalance()-card.getCurrentPaymentDueAmt());
                card.setCurrentPaymentDueAmt(0.0);
                ManagerSearchClick(thisCustomer);
            });

            TextField interestField = new TextField();
            add(interestField, 0, 1);
            Button setInterestButton = new Button("Set Interest");
            add(setInterestButton, 1, 1);
            setInterestButton.setOnAction(e -> {
                String interest=interestField.getText();
                card.setCurrentInterestRate(Double.parseDouble(interest));
                ManagerSearchClick(thisCustomer);
            });
            TextField limitField = new TextField();
            add(limitField, 3, 1);
            Button setLimitButton = new Button("Set Limit");
            add(setLimitButton, 4, 1);
            setLimitButton.setOnAction(e -> {
                String limit=limitField.getText();
                card.setCreditLimit(Double.parseDouble(limit));
                ManagerSearchClick(thisCustomer);
            });
            if (card.getMissedPaymentFlag() != 0) {
                Button removeFlagButton = new Button("Remove Flag");
                add(removeFlagButton, 6, 1);
                removeFlagButton.setOnAction(e -> {
                });
            }
        }
    }

    private class customerCDsManagerView extends GridPane {
        private customerCDsManagerView(SavingAccount account) {
            setHgap(10);
            setVgap(10);
            setPadding(new Insets(25, 25, 25, 25));
            EzText sceneTitle = new EzText("Account # : " + account.getAccountID());
            sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
            add(sceneTitle, 0, 0, 4, 1);

            add(new EzLabel("Current Balance:"), 0, 1);
            add(new EzText("$" + format.format(account.getCurrentBalance())), 1, 1);
            add(new EzLabel("Interest Rate:"), 2, 1);
            add(new EzText(format.format(account.getInterestRate() * 100) + "%"), 3, 1);
            add(new EzLabel("Open Date:"), 4, 1);
            add(new EzText(account.getOpenDate()), 5, 1);

            add(new EzLabel("Term Date:"), 4, 2);
            add(new EzText(account.getTermDate()), 5, 2);

            Button closeButton = new Button("Close Account");
            add(closeButton, 6, 3);
            closeButton.setOnAction(e -> {
                database.getSavingAccounts().remove(account);
                ManagerSearchClick(thisCustomer);
                System.out.println("CD closed Pay Customer: " + (account.getCurrentBalance()-75)+"after $75 penalty.");
            });
        }
    }

    private class CheckingAccountViewMan extends GridPane {
        private CheckingAccountViewMan(CheckingAccount account) {
            setHgap(10);
            setVgap(10);
            setPadding(new Insets(25, 25, 25, 25));
            EzText scenetitle = new EzText("Account # : " + account.getAccountID());
            scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
            add(scenetitle, 0, 0, 4, 1);

            add(new EzLabel("Current Balance:"), 0, 1);
            add(new EzText("$" + format.format(account.getCurrentBalance())), 1, 1);
            add(new EzLabel("Account Type:"), 2, 1);
            add(new EzText(account.getAccountType()), 3, 1);
            add(new EzLabel("Open Date:"), 4, 1);
            add(new EzText(account.getDateAccountOpened()), 5, 1);
            add(new EzLabel("Overdraft Count:"), 6, 1);
            add(new EzText(Integer.toString(account.getOverdraftCount())), 7, 1);
            add(new EzLabel("Backup Account:"), 0, 2);
            add(new EzText(account.getBackupAccount()), 1, 2);

            TextField depositTextField = new TextField();
            add(depositTextField, 0, 3);
            Button depositButton = new Button("Deposit");
            add(depositButton, 1, 3);
            depositButton.setOnAction(e -> {
                if (TryParseDouble(depositTextField.getText())) {
                    account.setCurrentBalance(account.getCurrentBalance() + Double.parseDouble(depositTextField.getText()));
                    ManagerSearchClick(thisCustomer);
                } else {
                    actionTarget.setFill(Color.FIREBRICK);
                    actionTarget.setText("Invalid amt");
                }
            });

            TextField withdrawlTextField = new TextField();
            add(withdrawlTextField, 3, 3);
            Button withdrawlButton = new Button("Withdrawl");
            add(withdrawlButton, 4, 3);
            withdrawlButton.setOnAction(e -> {
                if (TryParseDouble(withdrawlTextField.getText())) {
                    account.withdraw(Double.parseDouble(withdrawlTextField.getText()), account);
                    ManagerSearchClick(thisCustomer);
                    if (account.getCurrentBalance() == 0) {
                        System.out.println("Overdraft Protection Activated");
                    }
                } else {
                    actionTarget.setFill(Color.FIREBRICK);
                    actionTarget.setText("Invalid amt");
                }
            });

            Button closeButton = new Button("Close Account");
            add(closeButton, 6, 3);
            closeButton.setOnAction(e -> {
                database.getCheckingAccounts().remove(account);
                System.out.println("Checking Account closed Pay Customer: " + (account.getCurrentBalance()));
            });
        }
    }
}