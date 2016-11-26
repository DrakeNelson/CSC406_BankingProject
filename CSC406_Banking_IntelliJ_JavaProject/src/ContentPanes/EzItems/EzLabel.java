package ContentPanes.EzItems;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;

//couple custom items to save space
public class EzLabel extends Label {
    public EzLabel(String x) {
        setText(x);
        setTextFill(Color.web("#B8D4EF", 1.0));
        setStyle("-fx-font-weight: bold");
    }
}
