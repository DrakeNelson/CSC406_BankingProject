package ContentPanes;

import ContentPanes.EzItems.EzLabel;
import ContentPanes.EzItems.EzText;
import DatabaseObjects.Customer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Created by user on 11/26/2016.
 */
public class CustomerInfoPane extends GridPane {
    public CustomerInfoPane(Customer customer) {
        setAlignment(Pos.CENTER);
        setHgap(10);
        setVgap(10);
        setPadding(new Insets(25, 25, 25, 25));
        EzText scenetitle = new EzText(customer.getFirstName() + " " + customer.getLastName());
        scenetitle.setFont(Font.font("Gabriola", FontWeight.BLACK, 24));
        add(scenetitle, 0, 0, 2, 1);

        add(new EzLabel("SSN:"), 0, 1);
        add(new EzText(Integer.toString(customer.getSocial())), 1, 1);
        add(new EzLabel("Address:"), 2, 1);
        add(new EzText(customer.getAddress()), 3, 1);
        add(new EzLabel("City:"), 0, 2);
        add(new EzText(customer.getCity()), 1, 2);
        add(new EzLabel("State:"), 2, 2);
        add(new EzText(customer.getState()), 3, 2);
        add(new EzLabel("ZipCode:"), 4, 2);
        add(new EzText(customer.getZip()), 5, 2);
    }
}
