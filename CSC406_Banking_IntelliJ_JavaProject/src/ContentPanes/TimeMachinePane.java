package ContentPanes;

import ContentPanes.EzItems.EzText;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Created by user on 11/28/2016.
 */
public class TimeMachinePane extends GridPane {
    public TimeMachinePane(){
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
        changeDateButton.setOnAction(e -> {
        });
    }
}
