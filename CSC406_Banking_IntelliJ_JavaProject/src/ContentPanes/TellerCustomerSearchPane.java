package ContentPanes;

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
public class TellerCustomerSearchPane extends GridPane {
    private String welcomeLine="Welcome Teller";
    TellerCustomerSearchPane(String line){
        welcomeLine=line;
        initializePane(this);
    }

    public TellerCustomerSearchPane() {
        initializePane(this);
    }

    private void initializePane(TellerCustomerSearchPane tellerCustomerSearchPane){
        tellerCustomerSearchPane.setAlignment(Pos.CENTER);
        tellerCustomerSearchPane.setHgap(10);
        tellerCustomerSearchPane.setVgap(10);
        tellerCustomerSearchPane.setPadding(new Insets(25, 25, 25, 25));

        Text scenetitle = new Text(welcomeLine);
        scenetitle.setFont(Font.font("Gabriola", FontWeight.NORMAL, 20));
        scenetitle.setFill(Color.web("#B8D4EF",1.0));
        tellerCustomerSearchPane.add(scenetitle, 0, 0, 2, 1);

        Label customerSocial = new Label("Customer Social Security Number:");
        customerSocial.setTextFill(Color.web("#B8D4EF",1.0));

        tellerCustomerSearchPane.add(customerSocial, 0, 1);

        TextField userTextField = new TextField();
        tellerCustomerSearchPane.add(userTextField, 1, 1);

        Button btn = new Button("Search Customers");
        final Text actiontarget = new Text();
        tellerCustomerSearchPane.add(actiontarget, 1, 6);
        btn.setOnAction(e -> {
            if(Main.database.getCustomerBySSN(userTextField.getText())==null){
                actiontarget.setFill(Color.FIREBRICK);
                actiontarget.setText("Customer: "+userTextField.getText()+" does not exist in our records.");
            }else{
                MasterController.TellerSearchClick(userTextField.getText());
            }
        });

        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        tellerCustomerSearchPane.add(hbBtn, 1, 4);
    }
}
