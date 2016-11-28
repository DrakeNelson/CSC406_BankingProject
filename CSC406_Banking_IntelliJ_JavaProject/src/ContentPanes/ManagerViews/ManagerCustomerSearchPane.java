package ContentPanes.ManagerViews;

import DatabaseObjects.Customer;
import Master.Main;
import Master.MasterController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * Created by Drake on 9/5/2016.
 * this page should be pretty much complete
 */
public class ManagerCustomerSearchPane extends GridPane {
    private String welcomeLine="Welcome Manager";
    ManagerCustomerSearchPane(String line){
        welcomeLine=line;
        initializePane(this);
    }

    public ManagerCustomerSearchPane() {
        initializePane(this);
    }

    private void initializePane(ManagerCustomerSearchPane managerCustomerSearchPane){
        managerCustomerSearchPane.setAlignment(Pos.CENTER);
        managerCustomerSearchPane.setHgap(10);
        managerCustomerSearchPane.setVgap(10);
        managerCustomerSearchPane.setPadding(new Insets(25, 25, 25, 25));

        Text sceneTitle = new Text(welcomeLine);
        sceneTitle.setFont(Font.font("Gabriola", FontWeight.NORMAL, 20));
        sceneTitle.setFill(Color.web("#B8D4EF",1.0));
        managerCustomerSearchPane.add(sceneTitle, 0, 0, 2, 1);

        Label customerSocial = new Label("Customer Social Security Number:");
        customerSocial.setTextFill(Color.web("#B8D4EF",1.0));

        managerCustomerSearchPane.add(customerSocial, 0, 1);

        TextField userTextField = new TextField();
        managerCustomerSearchPane.add(userTextField, 1, 1);

        Button btn = new Button("Search Customers");
        final Text actionTarget = new Text();
        managerCustomerSearchPane.add(actionTarget, 1, 6);
        btn.setOnAction(e -> {
            Customer cust = Main.database.getCustomerBySSN(userTextField.getText());
            if(cust==null){
                actionTarget.setFill(Color.FIREBRICK);
                actionTarget.setText("Customer: "+userTextField.getText()+" does not exist in our records.");
            }else{
                MasterController.ManagerSearchClick(cust);
            }
        });

        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        managerCustomerSearchPane.add(hbBtn, 1, 4);
    }
}
