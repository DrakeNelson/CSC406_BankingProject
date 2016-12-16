package ContentPanes.AccountOpener;

import ContentPanes.EzItems.EzText;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import DatabaseObjects.Customer;
import javafx.scene.text.Text;

import static Master.Main.database;

/**
 * Created by user on 11/28/2016.
 * DONE
 */
public class CustomerCreator extends GridPane {
    public CustomerCreator(String ssn) {
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(25, 25, 25, 25));
        EzText title1 = new EzText("Create a Customer");
        title1.setFont(Font.font("Gabriola", FontWeight.NORMAL, 20));
        add(title1, 0, 0, 4, 1);

        EzText socialText = new EzText("SSN: ");
        add(socialText,0,2);
        EzText socialField = new EzText(ssn);
        add(socialField, 1, 2);

        EzText addressText = new EzText("Address: ");
        add(addressText,0,3);
        TextField addressField = new TextField();
        add(addressField, 1, 3);

        EzText cityText = new EzText("City: ");
        add(cityText,0,4);
        TextField cityField = new TextField();
        add(cityField, 1, 4);

        EzText stateText = new EzText("State: ");
        add(stateText,0,5);
        TextField stateField = new TextField();
        add(stateField, 1, 5);

        EzText zipText = new EzText("Zip: ");
        add(zipText,0,6);
        TextField zipField = new TextField();
        add(zipField, 1, 6);

        EzText firstNameText = new EzText("First Name: ");
        add(firstNameText,0,7);
        TextField firstNameField = new TextField();
        add(firstNameField, 1, 7);

        EzText lastNameText = new EzText("Last Name: ");
        add(lastNameText,0,8);
        TextField lastNameField = new TextField();
        add(lastNameField, 1, 8);

        final Text actionTarget = new Text();
        add(actionTarget, 1, 9);

        Button signButton = new Button("Create New Customer");
        signButton.setFont(Font.font("Gabriola", FontWeight.NORMAL, 20));
        add(signButton, 0, 10, 4, 1);
        signButton.setOnAction(e -> {
            database.getCustomers().add(new Customer(Integer.parseInt(socialField.getText()),addressField.getText(),cityField.getText(),stateField.getText(),zipField.getText(),firstNameField.getText(),lastNameField.getText()));
            actionTarget.setFill(Color.FIREBRICK);
            actionTarget.setText("Customer Created");
        });
    }
}
