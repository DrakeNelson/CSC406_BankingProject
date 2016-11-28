package Master;
/*
* NAVIGATION CLASS HOLDS METHODS FOR NAVIGATION THROUGHOUT THE SYSTEM
 * Controller for the MasterContentPane
 * contains methods used to set the MasterContentPane with a new Pane from the ContentPanes package
 * methods are set to click events for the menu bar in menu.fxml
 * Created by Drake Nelson 11/13/2016
 */

import ContentPanes.AccountOpener.*;
import ContentPanes.*;
import ContentPanes.CustomerViews.CustomerAtmWithdraw;
import ContentPanes.CustomerViews.CustomerCheckWriterPane;
import ContentPanes.CustomerViews.CustomerCreditCardPurchase;
import ContentPanes.ManagerViews.ManagerCustomerSearchPane;
import ContentPanes.ManagerViews.ManagerCustomerServicePane;
import ContentPanes.ManagerViews.ManagerFunctionsPane;
import ContentPanes.ManagerViews.ManagerOpenNewAccountPane;
import ContentPanes.TellerViews.TellerCustomerSearchPane;
import ContentPanes.TellerViews.TellerCustomerServicePane;
import ContentPanes.TellerViews.TellerOpenNewAccountPane;
import DatabaseObjects.Customer;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class MasterController extends Master.Main {

    public BorderPane MasterBorderPane;
    public VBox MasterTitleVBox;
    public Label MasterLabel;
    public Label MasterProjectChoiceLabel;
    public MenuBar MasterMenuBar;

//    //This is just a test of the controller to make sure my menu items are working properly
//    public void TestPaneClick() {
//        //reinitialize the master content pane so a new window can be set to it
//        MasterContentPane = new ScrollPane();
//        //change the title of the window set background color
//        window.setTitle("TestPaneTest");
//        MasterContentPane.setStyle("-fx-background: rgb(0,0,0);");
//        //add the new window to the mastercontentpane
//        MasterContentPane.setContent(new TestPane());
//        //set it to the correct position
//        root.setCenter(MasterContentPane);
//    }
    public void TellerMainPaneClick() {
        landing();
    }
    public static void TellerSearchClick(Customer searchedCustomer) {
        MasterContentPane = new ScrollPane();
        MasterContentPane.setStyle("-fx-background: rgb(0,0,0);");
        window.setTitle("Teller");
        MasterContentPane.setContent(new TellerCustomerServicePane(searchedCustomer));
        root.setCenter(MasterContentPane);
    }
    static void landing() {
        MasterContentPane = new ScrollPane();
        MasterContentPane.setStyle("-fx-background: rgb(0,0,0);");
        window.setTitle("Teller");
        MasterContentPane.setContent(new TellerCustomerSearchPane());
        root.setCenter(MasterContentPane);
    }
    public  void ManagerMainPaneClick() {
        MasterContentPane = new ScrollPane();
        MasterContentPane.setStyle("-fx-background: rgb(0,0,0);");
        window.setTitle("Manager");
        MasterContentPane.setContent(new ManagerCustomerSearchPane());
        root.setCenter(MasterContentPane);
    }
    public static void ManagerSearchClick(Customer searchedCustomer) {
        MasterContentPane = new ScrollPane();
        MasterContentPane.setStyle("-fx-background: rgb(0,0,0);");
        window.setTitle("Manager");
        MasterContentPane.setContent(new ManagerCustomerServicePane(searchedCustomer));
        root.setCenter(MasterContentPane);
    }

    public void ManagerFunctionPaneClick() {
        MasterContentPane = new ScrollPane();
        MasterContentPane.setStyle("-fx-background: rgb(0,0,0);");
        window.setTitle("Manager");
        MasterContentPane.setContent(new ManagerFunctionsPane());
        root.setCenter(MasterContentPane);
    }

    public void TimeMachineClick() {
        MasterContentPane = new ScrollPane();
        MasterContentPane.setStyle("-fx-background: rgb(0,0,0);");
        window.setTitle("T.A.R.D.I.S.");
        MasterContentPane.setContent(new TimeMachinePane());
        root.setCenter(MasterContentPane);
    }

    public void CheckWriteClick() {
        MasterContentPane = new ScrollPane();
        MasterContentPane.setStyle("-fx-background: rgb(0,0,0);");
        window.setTitle("Customer");
        MasterContentPane.setContent(new CustomerCheckWriterPane());
        root.setCenter(MasterContentPane);
    }

    public void PurchaseClick() {
        MasterContentPane = new ScrollPane();
        MasterContentPane.setStyle("-fx-background: rgb(0,0,0);");
        window.setTitle("Customer");
        MasterContentPane.setContent(new CustomerCreditCardPurchase());
        root.setCenter(MasterContentPane);
    }

    public void AtmClick() {
        MasterContentPane = new ScrollPane();
        MasterContentPane.setStyle("-fx-background: rgb(0,0,0);");
        window.setTitle("Customer");
        MasterContentPane.setContent(new CustomerAtmWithdraw());
        root.setCenter(MasterContentPane);
    }

    public void TellerAccountOpenClick() {
        MasterContentPane = new ScrollPane();
        MasterContentPane.setStyle("-fx-background: rgb(0,0,0);");
        window.setTitle("Teller");
        MasterContentPane.setContent(new TellerOpenNewAccountPane());
        root.setCenter(MasterContentPane);
    }

    public static void OpenCheckingAccountClick(Customer cust) {
        MasterContentPane = new ScrollPane();
        MasterContentPane.setStyle("-fx-background: rgb(0,0,0);");
        window.setTitle("Open Checking Account");
        MasterContentPane.setContent(new CheckingAccountOpener(cust));
        root.setCenter(MasterContentPane);
    }

    public static void OpenTraditionalSavingsClick(Customer cust) {
        MasterContentPane = new ScrollPane();
        MasterContentPane.setStyle("-fx-background: rgb(0,0,0);");
        window.setTitle("Open Savings Account");
        MasterContentPane.setContent(new SavingsAccountOpener(cust));
        root.setCenter(MasterContentPane);
    }

    public void ManagerAccountOpenClick() {
        MasterContentPane = new ScrollPane();
        MasterContentPane.setStyle("-fx-background: rgb(0,0,0);");
        window.setTitle("Manager");
        MasterContentPane.setContent(new ManagerOpenNewAccountPane());
        root.setCenter(MasterContentPane);
    }

    public static void OpenCreditCard(Customer cust) {
        MasterContentPane = new ScrollPane();
        MasterContentPane.setStyle("-fx-background: rgb(0,0,0);");
        window.setTitle("Open Credit Card");
        MasterContentPane.setContent(new CreditCardOpener(cust));
        root.setCenter(MasterContentPane);
    }

    public static void OpenTermLoan(Customer cust) {
        MasterContentPane = new ScrollPane();
        MasterContentPane.setStyle("-fx-background: rgb(0,0,0);");
        window.setTitle("Open Term Loan");
        MasterContentPane.setContent(new TermLoanOpener(cust));
        root.setCenter(MasterContentPane);
    }

    public static void NewCustomerClick(String ssn) {
        MasterContentPane = new ScrollPane();
        MasterContentPane.setStyle("-fx-background: rgb(0,0,0);");
        window.setTitle("Open Term Loan");
        MasterContentPane.setContent(new CustomerCreator(ssn));
        root.setCenter(MasterContentPane);
    }
}
