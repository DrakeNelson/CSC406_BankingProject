package ContentPanes.AccountInfoViews;

import ContentPanes.EzItems.EzLabel;
import DatabaseObjects.Customer;
import javafx.scene.layout.VBox;

/**
 * Created by user on 12/15/2016.
 * DONE
 */
public class CustomerAtmCloser extends VBox {
    public CustomerAtmCloser(Customer customer) {
        getChildren().add(new EzLabel("thank you "+customer.getFirstName()+" "+customer.getLastName()+ " remove card"));
    }
}
