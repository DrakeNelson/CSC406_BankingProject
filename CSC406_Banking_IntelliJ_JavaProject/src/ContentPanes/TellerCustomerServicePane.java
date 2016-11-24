package ContentPanes;

import DatabaseObjects.Customer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 * Created by user on 11/24/2016.
 */
public class TellerCustomerServicePane extends GridPane {
    private Customer customer;
    public TellerCustomerServicePane(Customer searchedCustomer) {
        customer = searchedCustomer;
        HBox custBox = new HBox();
        custBox.getChildren().add(new customerInfoTellerView());
        custBox.getChildren().add(new TellerCustomerSearchPane("New Customer"));
        VBox outerBox = new VBox();
        outerBox.getChildren().add(custBox);

        getChildren().add(outerBox);

    }

    private class customerInfoTellerView extends GridPane {
        private customerInfoTellerView(){
            setAlignment(Pos.CENTER);
            setHgap(10);
            setVgap(10);
            setPadding(new Insets(25, 25, 25, 25));
            Text scenetitle = new Text(customer.getFirstName() + " " + customer.getLastName());
            scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
            scenetitle.setFill(Color.web("#B8D4EF",1.0));
            add(scenetitle, 0, 0, 2, 1);
            Label customerSocial = new Label("SSN:");
            customerSocial.setTextFill(Color.web("#B8D4EF",1.0));
            add(customerSocial, 0, 1);
            Text social = new Text(Integer.toString(customer.getSocial()));
            social.setFill(Color.web("#B8D4EF",1.0));
            add(social, 1, 1);
            Label customerAddress = new Label("Address:");
            customerAddress.setTextFill(Color.web("#B8D4EF",1.0));
            add(customerAddress, 2, 1);
            Text address = new Text(customer.getAddress());
            address.setFill(Color.web("#B8D4EF",1.0));
            add(address, 3, 1);
            Label customerCity = new Label("City:");
            customerCity.setTextFill(Color.web("#B8D4EF",1.0));
            add(customerCity, 0, 2);
            Text city = new Text(customer.getCity());
            city.setFill(Color.web("#B8D4EF",1.0));
            add(city, 1, 2);
            Label customerState = new Label("State:");
            customerState.setTextFill(Color.web("#B8D4EF",1.0));
            add(customerState, 2, 2);
            Text state = new Text(customer.getState());
            state.setFill(Color.web("#B8D4EF",1.0));
            add(state, 3, 2);
            Label customerZip = new Label("ZipCode:");
            customerZip.setTextFill(Color.web("#B8D4EF",1.0));
            add(customerZip, 4, 2);
            Text zip = new Text(customer.getZip());
            zip.setFill(Color.web("#B8D4EF",1.0));
            add(zip, 5, 2);
        }
    }
}
